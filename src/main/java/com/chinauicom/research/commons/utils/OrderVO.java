/**
 * com.tydic.commons.utils.OrderVO.java
 */
package com.chinauicom.research.commons.utils;

 /**
 * @file  OrderVO.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 排序的VO对象
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-8-28
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class OrderVO {

	/**
	 * 排序属性
	 */
	private int order;
	
	/**
	 * 业务编码
	 */
	private String keyCode;

	public OrderVO(int order,String keyCode){
		this.order=order;
		this.keyCode=keyCode;
	}
	
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return the keyCode
	 */
	public String getKeyCode() {
		return keyCode;
	}

	/**
	 * @param keyCode the keyCode to set
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	
	
}
