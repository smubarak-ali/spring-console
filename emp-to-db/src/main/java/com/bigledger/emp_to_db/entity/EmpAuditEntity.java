package com.bigledger.emp_to_db.entity;

import java.sql.Timestamp;

public class EmpAuditEntity {

	private String guid;
	private String operation;
	private String userId;
	private Timestamp localCreatedTime;
	private String docJson;
	private int tablePkId;
	private String tableGuid;
	private String tableName;
	private String remarks;
	private String status;
	
	public String getGuid() {
		return guid;
	}
	public String getOperation() {
		return operation;
	}
	public String getUserId() {
		return userId;
	}
	public Timestamp getLocalCreatedTime() {
		return localCreatedTime;
	}
	public String getDocJson() {
		return docJson;
	}
	public int getTablePkId() {
		return tablePkId;
	}
	public String getTableGuid() {
		return tableGuid;
	}
	public String getTableName() {
		return tableName;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setLocalCreatedTime(Timestamp localCreatedTime) {
		this.localCreatedTime = localCreatedTime;
	}
	public void setDocJson(String docJson) {
		this.docJson = docJson;
	}
	public void setTablePkId(int tablePkId) {
		this.tablePkId = tablePkId;
	}
	public void setTableGuid(String tableGuid) {
		this.tableGuid = tableGuid;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
