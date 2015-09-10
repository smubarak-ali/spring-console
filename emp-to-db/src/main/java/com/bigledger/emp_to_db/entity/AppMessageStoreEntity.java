package com.bigledger.emp_to_db.entity;

import java.sql.Timestamp;

public class AppMessageStoreEntity {

	private String guid;
	private String triggerKey;
	private String type;
	private Integer priority;
	private String localLoginGuid;
	private Timestamp localTimeMessage;
	private Timestamp localTimeCreate;
	private Timestamp localTimeUpdate;
	private Timestamp localTimeDelete;
	private String localStatus;
	private String remoteIdDevice;
	private String remoteGuidUser;
	private String remoteIdUser;
	private String remoteGuidMessage;
	private Timestamp remoteTimeCreate;
	private String remoteDocumentId;
	private String documentJson;
	private String remarks;
	private String status;
//	private String remoteUserProfileJson;
	
	public AppMessageStoreEntity() {
		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			
//			this.remoteUserProfileJson = mapper.writeValueAsString("");
//		} 
//		catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
	}
	
	public String getGuid() {
		return guid;
	}
	public String getTriggerKey() {
		return triggerKey;
	}
	public String getType() {
		return type;
	}
	public Integer getPriority() {
		return priority;
	}
	public String getLocalLoginGuid() {
		return localLoginGuid;
	}
	public Timestamp getLocalTimeMessage() {
		return localTimeMessage;
	}
	public Timestamp getLocalTimeCreate() {
		return localTimeCreate;
	}
	public Timestamp getLocalTimeUpdate() {
		return localTimeUpdate;
	}
	public Timestamp getLocalTimeDelete() {
		return localTimeDelete;
	}
	public String getLocalStatus() {
		return localStatus;
	}
	public String getRemoteIdDevice() {
		return remoteIdDevice;
	}
	public String getRemoteGuidUser() {
		return remoteGuidUser;
	}
	public String getRemoteIdUser() {
		return remoteIdUser;
	}
	public String getRemoteGuidMessage() {
		return remoteGuidMessage;
	}
	public Timestamp getRemoteTimeCreate() {
		return remoteTimeCreate;
	}
	public String getRemoteDocumentId() {
		return remoteDocumentId;
	}
	public String getDocumentJson() {
		return documentJson;
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
	public void setTriggerKey(String triggerKey) {
		this.triggerKey = triggerKey;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public void setLocalLoginGuid(String localLoginGuid) {
		this.localLoginGuid = localLoginGuid;
	}
	public void setLocalTimeMessage(Timestamp localTimeMessage) {
		this.localTimeMessage = localTimeMessage;
	}
	public void setLocalTimeCreate(Timestamp localTimeCreate) {
		this.localTimeCreate = localTimeCreate;
	}
	public void setLocalTimeUpdate(Timestamp localTimeUpdate) {
		this.localTimeUpdate = localTimeUpdate;
	}
	public void setLocalTimeDelete(Timestamp localTimeDelete) {
		this.localTimeDelete = localTimeDelete;
	}
	public void setLocalStatus(String localStatus) {
		this.localStatus = localStatus;
	}
	public void setRemoteIdDevice(String remoteIdDevice) {
		this.remoteIdDevice = remoteIdDevice;
	}
	public void setRemoteGuidUser(String remoteGuidUser) {
		this.remoteGuidUser = remoteGuidUser;
	}
	public void setRemoteIdUser(String remoteIdUser) {
		this.remoteIdUser = remoteIdUser;
	}
	public void setRemoteGuidMessage(String remoteGuidMessage) {
		this.remoteGuidMessage = remoteGuidMessage;
	}
	public void setRemoteTimeCreate(Timestamp remoteTimeCreate) {
		this.remoteTimeCreate = remoteTimeCreate;
	}
	public void setRemoteDocumentId(String remoteDocumentId) {
		this.remoteDocumentId = remoteDocumentId;
	}
	public void setDocumentJson(String documentJson) {
		this.documentJson = documentJson;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
