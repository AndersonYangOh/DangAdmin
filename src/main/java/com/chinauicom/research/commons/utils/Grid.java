/**
 * com.tydic.commons.utils.Grid.java
 */
package com.chinauicom.research.commons.utils;

import java.util.List;
import java.util.Map;

 /**
 * @file  Grid.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 封装Grid的信息
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-23
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class Grid {
	private String id;
	private Page pageInfo;
	private List sortInfo;
	private List filterInfo;
	private List columnInfo;	
	private List fieldsName;
	private List data;
	private List insertRecords;
	private List updateRecords;
	private List deleteRecords;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pageInfo
	 */
	public Page getPageInfo() {
		return pageInfo;
	}
	/**
	 * @param pageInfo the pageInfo to set
	 */
	public void setPageInfo(Page pageInfo) {
		this.pageInfo = pageInfo;
	}
	/**
	 * @return the sortInfo
	 */
	public List getSortInfo() {
		return sortInfo;
	}
	/**
	 * @param sortInfo the sortInfo to set
	 */
	public void setSortInfo(List sortInfo) {
		this.sortInfo = sortInfo;
	}
	/**
	 * @return the filterInfo
	 */
	public List getFilterInfo() {
		return filterInfo;
	}
	/**
	 * @param filterInfo the filterInfo to set
	 */
	public void setFilterInfo(List filterInfo) {
		this.filterInfo = filterInfo;
	}
	/**
	 * @return the columnInfo
	 */
	public List getColumnInfo() {
		return columnInfo;
	}
	/**
	 * @param columnInfo the columnInfo to set
	 */
	public void setColumnInfo(List columnInfo) {
		this.columnInfo = columnInfo;
	}
	/**
	 * @return the fieldsName
	 */
	public List getFieldsName() {
		return fieldsName;
	}
	/**
	 * @param fieldsName the fieldsName to set
	 */
	public void setFieldsName(List fieldsName) {
		this.fieldsName = fieldsName;
	}
	/**
	 * @return the data
	 */
	public List getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List data) {
		this.data = data;
	}
	/**
	 * @return the insertRecords
	 */
	public List getInsertRecords() {
		return insertRecords;
	}
	/**
	 * @param insertRecords the insertRecords to set
	 */
	public void setInsertRecords(List insertRecords) {
		this.insertRecords = insertRecords;
	}
	/**
	 * @return the updateRecords
	 */
	public List getUpdateRecords() {
		return updateRecords;
	}
	/**
	 * @param updateRecords the updateRecords to set
	 */
	public void setUpdateRecords(List updateRecords) {
		this.updateRecords = updateRecords;
	}
	/**
	 * @return the deleteRecords
	 */
	public List getDeleteRecords() {
		return deleteRecords;
	}
	/**
	 * @param deleteRecords the deleteRecords to set
	 */
	public void setDeleteRecords(List deleteRecords) {
		this.deleteRecords = deleteRecords;
	}
	

}
