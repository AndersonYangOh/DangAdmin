/**
 * com.tydic.dbs.system.userGroup.mapper.SysUserGroupRole.java
 */
package com.chinauicom.research.rudang.system.usergroup.entity;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * @file  SysUserGroupRole.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroupRole实体类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-04 11:32:48
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public class SysUserGroupRole extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = 5873293219316718986L;
	private Long grpRoleId;
	private String roleCode;//角色编码
	private String roleName;//角色名称
	private String groCode;//用户组编码
	private String remark;
	
	public SysUserGroupRole(){
	}
	public SysUserGroupRole(Long grpRoleId) {
		this.grpRoleId = grpRoleId;
	}
	public void setGrpRoleId(Long value) {
		this.grpRoleId = value;
	}	
	public Long getGrpRoleId() {
		return this.grpRoleId;
	}
	public void setRoleCode(String value) {
		this.roleCode = value;
	}	
	public String getRoleCode() {
		return this.roleCode;
	}
	public void setGroCode(String value) {
		this.groCode = value;
	}	
	public String getGroCode() {
		return this.groCode;
	}
	public void setRemark(String value) {
		this.remark = value;
	}	
	public String getRemark() {
		return this.remark;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
