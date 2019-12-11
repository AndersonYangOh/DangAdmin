package com.chinauicom.research.rudang.system.operator.entity;
 

public class SysOperatorEmailTable {
	private String id;
	private String operMail;
	private String sendTime;	
	private String sendContent;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperMail() {
		return operMail;
	}
	public void setOperMail(String operMail) {
		this.operMail = operMail;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	
}
