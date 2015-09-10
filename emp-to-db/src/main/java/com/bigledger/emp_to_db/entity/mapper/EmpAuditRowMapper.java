package com.bigledger.emp_to_db.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bigledger.emp_to_db.entity.EmpAuditEntity;
import com.bigledger.emp_to_db.util.EntityReference;

public class EmpAuditRowMapper implements RowMapper<EmpAuditEntity> {

	@Override
	public EmpAuditEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmpAuditEntity entity = new EmpAuditEntity();
		entity.setGuid( rs.getString( EntityReference.TableEmpAudit.GUID ) );
		entity.setDocJson( rs.getString( EntityReference.TableEmpAudit.DOC_JSON ) );
		entity.setLocalCreatedTime( rs.getTimestamp( EntityReference.TableEmpAudit.LOCAL_CREATED_TIME ) );
		entity.setOperation( rs.getString( EntityReference.TableEmpAudit.OPERATION ) );
		entity.setRemarks( rs.getString( EntityReference.TableEmpAudit.REMARKS ) );
		entity.setStatus( rs.getString( EntityReference.TableEmpAudit.STATUS ) );
		entity.setTablePkId( rs.getInt( EntityReference.TableEmpAudit.TABLE_PKID ) );
		entity.setTableGuid( rs.getString( EntityReference.TableEmpAudit.TABLE_GUID ) );
		entity.setTableName( rs.getString( EntityReference.TableEmpAudit.TRIGGER_TABLE_NAME ) );
		entity.setUserId( rs.getString( EntityReference.TableEmpAudit.USER_ID ) );
		
		return entity;
	}

	
}
