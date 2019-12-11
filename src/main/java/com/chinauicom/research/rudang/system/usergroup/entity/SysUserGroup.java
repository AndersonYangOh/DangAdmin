/**
 * com.tydic.dbs.system.userGroup.mapper.SysUserGroup.java
 */
package com.chinauicom.research.rudang.system.usergroup.entity;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.rudang.system.role.entity.SysRole;

/**
 * @file  SysUserGroup.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroup实体类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-03 02:29:42
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public class SysUserGroup extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = -4470489294072039197L;
	private String groCode;//用户组编码
	private String groName;
	private String status;
	private String groDesc;
	private String remark;
	private Integer userNum;//关联用户数量
	private List<SysRole> sysRoleList;
	
	public SysUserGroup(){}
	public SysUserGroup(String groCode) {
		this.groCode = groCode;
	}
	public String getGroCode() {
		return groCode;
	}
	public void setGroCode(String groCode) {
		this.groCode = groCode;
	}
	public String getGroName() {
		return groName;
	}
	public void setGroName(String groName) {
		this.groName = groName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGroDesc() {
		return groDesc;
	}
	public void setGroDesc(String groDesc) {
		this.groDesc = groDesc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}
	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	
	@SuppressWarnings("static-access")
	public String getStatusTxt() {
		if (StringUtils.isNotEmpty(status)) {
			Map<String, String> hash = WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP;
			return hash.get(status);
		}
		return "";
	}
}
