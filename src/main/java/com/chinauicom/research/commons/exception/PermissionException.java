package com.chinauicom.research.commons.exception;

/**
 * @file  PermissionException.java
 * @author caipeimin
 * @version 0.1
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2014-02-25 11:41:49
 *      	Author: caipeimin
 *      	Modification: this file was created
 *   	2. ...
 */
public class PermissionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2804950003750376928L;
	
	private Integer state;
	
	private String messages;
	
	public PermissionException () {
		super();
	}
	
	public PermissionException (Integer state, String messages) {
		super(messages);
		
		this.state = state;
		this.messages = messages;
	}
	
	public PermissionException (Integer state, String messages, Throwable cause) {
		super(cause);
		
		this.state = state;
		this.messages = messages;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}
