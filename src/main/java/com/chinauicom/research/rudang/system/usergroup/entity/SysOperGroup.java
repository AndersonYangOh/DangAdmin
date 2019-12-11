/**
 * com.tydic.dbs.system.userGroup.mapper.SysOperGroup.java
 */
package com.chinauicom.research.rudang.system.usergroup.entity;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * @file  SysOperGroup.java
 * @author liugaolin
 * @version 0.1
 * @SysOperGroup实体类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public class SysOperGroup extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = 3681322872672033144L;
	private java.lang.Long operGrpRelId;
	private java.lang.String operId;
	private java.lang.String groCode;
	private java.lang.String remark;
	
	public SysOperGroup(){
	}

	public SysOperGroup(Long operGrpRelId) {
		this.operGrpRelId = operGrpRelId;
	}

	public void setOperGrpRelId(java.lang.Long value) {
		this.operGrpRelId = value;
	}	
	public java.lang.Long getOperGrpRelId() {
		return this.operGrpRelId;
	}

	public void setOperId(java.lang.String value) {
		this.operId = value;
	}	
	public java.lang.String getOperId() {
		return this.operId;
	}

	public void setGroCode(java.lang.String value) {
		this.groCode = value;
	}	
	public java.lang.String getGroCode() {
		return this.groCode;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
	}	
	public java.lang.String getRemark() {
		return this.remark;
	}

    public String toString() {
		  StringBuffer buffer = new StringBuffer();
		  buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");	
			   buffer.append("OperGrpRelId").append("='").append(getOperGrpRelId()).append("' ");	
			   buffer.append("OperId").append("='").append(getOperId()).append("' ");	
			   buffer.append("GroCode").append("='").append(getGroCode()).append("' ");	
			   buffer.append("Creater").append("='").append(getCreater()).append("' ");	
			   buffer.append("CreateTime").append("='").append(getCreateTime()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysOperGroup) ) return false;
		 SysOperGroup  castOther = ( SysOperGroup) other;  
		 return 
					( (this.getOperGrpRelId()==castOther.getOperGrpRelId()) ||( this.getOperGrpRelId()!=null && castOther.getOperGrpRelId()!=null && this.getOperGrpRelId().equals(castOther.getOperGrpRelId()) ) )
					&&( (this.getOperId()==castOther.getOperId()) ||( this.getOperId()!=null && castOther.getOperId()!=null && this.getOperId().equals(castOther.getOperId()) ) )
					&&( (this.getGroCode()==castOther.getGroCode()) ||( this.getGroCode()!=null && castOther.getGroCode()!=null && this.getGroCode().equals(castOther.getGroCode()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getOperGrpRelId() == null ? 0 : this.getOperGrpRelId().hashCode() );
				  result = 37 * result + (getOperId() == null ? 0 : this.getOperId().hashCode() );
				  result = 37 * result + (getGroCode() == null ? 0 : this.getGroCode().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
