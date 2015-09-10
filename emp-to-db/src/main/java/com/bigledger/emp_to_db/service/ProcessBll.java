package com.bigledger.emp_to_db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.bigledger.emp_to_db.entity.AppMessageEventEntity;
import com.bigledger.emp_to_db.entity.AppMessageStoreEntity;
import com.bigledger.emp_to_db.entity.EmpAuditEntity;
import com.bigledger.emp_to_db.entity.InvStockDeltaEntity;
import com.bigledger.emp_to_db.entity.mapper.EmpAuditRowMapper;
import com.bigledger.emp_to_db.util.EntityReference;
import com.bigledger.emp_to_db.util.ExtendedBeanPropertyRowMapper;
import com.bigledger.emp_to_db.util.SQLStatement;
import com.bigledger.emp_to_db.util.TimeFormat;
import com.bigledger.emp_to_db.util.UniqueIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProcessBll {

	@Autowired
	@Qualifier("emp_db")
	DriverManagerDataSource empDataSource;

	@Autowired
	@Qualifier("staging_db")
	DriverManagerDataSource stagingDbDataSource;

	public void getEmpData()
	{
		System.out.println( "===> Emp Datasource URL: " + empDataSource.getUrl() );
		System.out.println( "===> Staging Datasource URL: " + stagingDbDataSource.getUrl() );

		List<EmpAuditEntity> list = getEmpAuditList();
		System.out.println("=> Size of list ==" + list.size());

	}

	private List<EmpAuditEntity> getEmpAuditList()
	{
		List<EmpAuditEntity> list = new ArrayList<EmpAuditEntity>();
		String sql = SQLStatement.TableEmpAuditQueries.GetSQLSelectAll();

		// RowMapper is not supported in queryForList() method, you need to map it manually.
		// So list of EmpAuditRowMapper object cannot be directly filled here.
		// list = getJdbcTemplate().queryForList( sql ); This won't work....

		// BeanPropertyRowMapper can be used for auto mapping but need to be careful regarding the filled values and data. 
		// list = getJdbcTemplate().query( sql, new BeanPropertyRowMapper<EmpAuditEntity>( EmpAuditEntity.class) );

		// This is the best solution as query method has many overloaded functions, so we can provide our own custom mapper
		list = getJdbcTemplate( empDataSource ).query( sql, new EmpAuditRowMapper() );
		System.out.println( "=> The emp_audit table size: " + list.size());
		processList(list);

		return list;
	}

	private void processList( List<EmpAuditEntity> list )
	{
		for(EmpAuditEntity iEntity : list) {

			processByCase( iEntity );
		}
	}

	private void processByCase( EmpAuditEntity entity ) {

		ObjectMapper mapper = new ObjectMapper();
		String tableName = entity.getTableName();
		String sql = SQLStatement.TableEmpAuditQueries.GetSQLSelectByGuidAndPkid( tableName, entity.getTableGuid(), entity.getTablePkId() );
		System.out.println("=> Sql statement: " + sql);
		System.out.println("=> Read from: " + tableName + " table");

		switch(tableName) 
		{
		case EntityReference.TableInvStockDelta.TABLE_NAME:			

			List<InvStockDeltaEntity> entityList = getJdbcTemplate( empDataSource ).query( sql, new ExtendedBeanPropertyRowMapper<InvStockDeltaEntity>( InvStockDeltaEntity.class ) );
			for( InvStockDeltaEntity iItem : entityList ) {

				AppMessageEventEntity eventMsg = new AppMessageEventEntity();
				AppMessageStoreEntity storeMsg = new AppMessageStoreEntity();

				try {
					storeMsg.setGuid( UniqueIdGenerator.generateGuid() );
					storeMsg.setDocumentJson( mapper.writeValueAsString( iItem ) );
					storeMsg.setLocalLoginGuid("");
					storeMsg.setLocalStatus("");
					storeMsg.setLocalTimeCreate( TimeFormat.getCurrentDateAndTime() );
					//storeMsg.setLocalTimeDelete();
					//storeMsg.setLocalTimeMessage();
					//storeMsg.setLocalTimeUpdate();
					//storeMsg.setPriority();
					storeMsg.setRemarks("created for migration");
					//storeMsg.setRemoteDocumentId();
					storeMsg.setRemoteGuidMessage( UniqueIdGenerator.generateGuid() );
					//storeMsg.setRemoteGuidUser();
					//storeMsg.setRemoteIdDevice();
					storeMsg.setRemoteIdUser( entity.getUserId() );
					storeMsg.setRemoteTimeCreate( TimeFormat.getCurrentDateAndTime() );
					storeMsg.setStatus( entity.getStatus() );
					storeMsg.setTriggerKey( entity.getOperation() );
					storeMsg.setType( entity.getTableName() );

					eventMsg = getEventMessageObject( storeMsg );
					
					insertInQueue( storeMsg, eventMsg );
					
				} 
				catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			break;

		default:
			System.out.println( "Invalid table name" );
			break;
		}
	}
	
	// This function will create the a message record in the staging db for both tables (app_message_event and app_message_store)
	// The input parameters are AppMessageStoreEntity and AppMessageEventEntity objects.
	private void insertInQueue( AppMessageStoreEntity store, AppMessageEventEntity event ) {
		
		getJdbcTemplate( stagingDbDataSource ).update( SQLStatement.TableAppMessageStoreQueries.GetInsertSQL(), 
				new Object[]{ 
				store.getDocumentJson(), store.getGuid(), store.getLocalTimeCreate(), store.getLocalTimeDelete(), store.getLocalLoginGuid(), 
				store.getLocalTimeMessage(), store.getLocalStatus(), store.getLocalTimeUpdate(), store.getPriority(), store.getRemarks(), 
				store.getRemoteTimeCreate(), store.getRemoteIdDevice(), store.getRemoteDocumentId(), store.getRemoteGuidMessage(), 
				store.getRemoteGuidUser(), store.getRemoteIdUser(), store.getStatus(), store.getTriggerKey(), store.getType() 
				});
		
		getJdbcTemplate( stagingDbDataSource ).update( SQLStatement.TableAppMessageEventQueries.GetInsertSQL(), 
				new Object[]{ 
				event.getDocumentJson(), event.getGuid(), event.getLocalTimeCreate(), event.getLocalTimeDelete(), event.getLocalLoginGuid(), 
				event.getLocalTimeMessage(), event.getLocalStatus(), event.getLocalTimeUpdate(), event.getMessageStoreGuid(), 
				event.getPriority(), event.getRemarks(), event.getRemoteTimeCreate(), event.getRemoteIdDevice(), event.getRemoteDocumentId(),
				event.getRemoteGuidMessage(), event.getRemoteGuidUser(), event.getRemoteIdUser(), event.getStatus(), event.getTriggerKey(), event.getType() 
				});
	}
	
	//Conversion function to get AppMessageEventEntity Object. The input paramter is AppMessageStoreEntity object.
	private AppMessageEventEntity getEventMessageObject(AppMessageStoreEntity store) {
		
		AppMessageEventEntity eventMsg = new AppMessageEventEntity();
		eventMsg.setGuid( UniqueIdGenerator.generateGuid() );
		eventMsg.setDocumentJson( store.getDocumentJson() );
		eventMsg.setLocalLoginGuid( store.getLocalLoginGuid() );
		eventMsg.setLocalStatus( store.getLocalStatus() );
		eventMsg.setLocalTimeCreate( store.getLocalTimeCreate() );
		//eventMsg.setLocalTimeDelete();
		//eventMsg.setLocalTimeMessage();
		//eventMsg.setLocalTimeUpdate();
		//eventMsg.setPriority();
		eventMsg.setRemarks( store.getRemarks() );
		//eventMsg.setRemoteDocumentId();
		eventMsg.setRemoteGuidMessage( store.getRemoteGuidMessage() );
		//eventMsg.setRemoteGuidUser();
		//eventMsg.setRemoteIdDevice();
		eventMsg.setRemoteIdUser( store.getRemoteIdUser() );
		eventMsg.setRemoteTimeCreate( store.getRemoteTimeCreate() );
		eventMsg.setStatus( store.getStatus() );
		eventMsg.setTriggerKey( store.getTriggerKey() );
		eventMsg.setType( store.getType() );
		eventMsg.setMessageStoreGuid( store.getGuid() );

		return eventMsg;
	}

	//Use this function to get the JdbcTemplate. The input parameter is the datasource.
	private JdbcTemplate getJdbcTemplate( DriverManagerDataSource source ) {
		
		return new JdbcTemplate( source );
	}
}
