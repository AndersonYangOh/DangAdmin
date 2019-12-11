/**
 * com.tydic.dbs.system.menu.mapper.SysDataFactor.java
 */
package com.chinauicom.research.rudang.system.menu.entity;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * @file  SysDataFactor.java
 * @author liugaolin
 * @version 0.1
 * @SysDataFactor实体类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public class SysDataFactor extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = 7690172599177898443L;
	private java.lang.Long factorId;
	private java.lang.String factorName;
	private java.lang.String tabNameEn;
	private java.lang.String tabNameCn;
	private java.lang.String attrNameEn;
	private java.lang.String attrNameCn;
	private java.lang.String factorVal;
	private java.lang.String memo;
	private java.lang.String remark;
	public SysDataFactor(){
	}

	public SysDataFactor(
		java.lang.Long factorId
	){
		this.factorId = factorId;
	}



	public void setFactorId(java.lang.Long value) {
		this.factorId = value;
	}	
	public java.lang.Long getFactorId() {
		return this.factorId;
	}

	public void setFactorName(java.lang.String value) {
		this.factorName = value;
	}	
	public java.lang.String getFactorName() {
		return this.factorName;
	}

	public void setTabNameEn(java.lang.String value) {
		this.tabNameEn = value;
	}	
	public java.lang.String getTabNameEn() {
		return this.tabNameEn;
	}

	public void setTabNameCn(java.lang.String value) {
		this.tabNameCn = value;
	}	
	public java.lang.String getTabNameCn() {
		return this.tabNameCn;
	}

	public void setAttrNameEn(java.lang.String value) {
		this.attrNameEn = value;
	}	
	public java.lang.String getAttrNameEn() {
		return this.attrNameEn;
	}

	public void setAttrNameCn(java.lang.String value) {
		this.attrNameCn = value;
	}	
	public java.lang.String getAttrNameCn() {
		return this.attrNameCn;
	}

	public void setFactorVal(java.lang.String value) {
		this.factorVal = value;
	}	
	public java.lang.String getFactorVal() {
		return this.factorVal;
	}

	public void setMemo(java.lang.String value) {
		this.memo = value;
	}	
	public java.lang.String getMemo() {
		return this.memo;
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
			   buffer.append("FactorId").append("='").append(getFactorId()).append("' ");	
			   buffer.append("FactorName").append("='").append(getFactorName()).append("' ");	
			   buffer.append("TabNameEn").append("='").append(getTabNameEn()).append("' ");	
			   buffer.append("TabNameCn").append("='").append(getTabNameCn()).append("' ");	
			   buffer.append("AttrNameEn").append("='").append(getAttrNameEn()).append("' ");	
			   buffer.append("AttrNameCn").append("='").append(getAttrNameCn()).append("' ");	
			   buffer.append("FactorVal").append("='").append(getFactorVal()).append("' ");	
			   buffer.append("Memo").append("='").append(getMemo()).append("' ");	
			   buffer.append("CreateTime").append("='").append(getCreateTime()).append("' ");	
			   buffer.append("Creater").append("='").append(getCreater()).append("' ");	
			   buffer.append("ModifyTime").append("='").append(getModifyTime()).append("' ");	
			   buffer.append("Modifier").append("='").append(getModifier()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysDataFactor) ) return false;
		 SysDataFactor  castOther = ( SysDataFactor) other;  
		 return 
					( (this.getFactorId()==castOther.getFactorId()) ||( this.getFactorId()!=null && castOther.getFactorId()!=null && this.getFactorId().equals(castOther.getFactorId()) ) )
					&&( (this.getFactorName()==castOther.getFactorName()) ||( this.getFactorName()!=null && castOther.getFactorName()!=null && this.getFactorName().equals(castOther.getFactorName()) ) )
					&&( (this.getTabNameEn()==castOther.getTabNameEn()) ||( this.getTabNameEn()!=null && castOther.getTabNameEn()!=null && this.getTabNameEn().equals(castOther.getTabNameEn()) ) )
					&&( (this.getTabNameCn()==castOther.getTabNameCn()) ||( this.getTabNameCn()!=null && castOther.getTabNameCn()!=null && this.getTabNameCn().equals(castOther.getTabNameCn()) ) )
					&&( (this.getAttrNameEn()==castOther.getAttrNameEn()) ||( this.getAttrNameEn()!=null && castOther.getAttrNameEn()!=null && this.getAttrNameEn().equals(castOther.getAttrNameEn()) ) )
					&&( (this.getAttrNameCn()==castOther.getAttrNameCn()) ||( this.getAttrNameCn()!=null && castOther.getAttrNameCn()!=null && this.getAttrNameCn().equals(castOther.getAttrNameCn()) ) )
					&&( (this.getFactorVal()==castOther.getFactorVal()) ||( this.getFactorVal()!=null && castOther.getFactorVal()!=null && this.getFactorVal().equals(castOther.getFactorVal()) ) )
					&&( (this.getMemo()==castOther.getMemo()) ||( this.getMemo()!=null && castOther.getMemo()!=null && this.getMemo().equals(castOther.getMemo()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getModifyTime()==castOther.getModifyTime()) ||( this.getModifyTime()!=null && castOther.getModifyTime()!=null && this.getModifyTime().equals(castOther.getModifyTime()) ) )
					&&( (this.getModifier()==castOther.getModifier()) ||( this.getModifier()!=null && castOther.getModifier()!=null && this.getModifier().equals(castOther.getModifier()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getFactorId() == null ? 0 : this.getFactorId().hashCode() );
				  result = 37 * result + (getFactorName() == null ? 0 : this.getFactorName().hashCode() );
				  result = 37 * result + (getTabNameEn() == null ? 0 : this.getTabNameEn().hashCode() );
				  result = 37 * result + (getTabNameCn() == null ? 0 : this.getTabNameCn().hashCode() );
				  result = 37 * result + (getAttrNameEn() == null ? 0 : this.getAttrNameEn().hashCode() );
				  result = 37 * result + (getAttrNameCn() == null ? 0 : this.getAttrNameCn().hashCode() );
				  result = 37 * result + (getFactorVal() == null ? 0 : this.getFactorVal().hashCode() );
				  result = 37 * result + (getMemo() == null ? 0 : this.getMemo().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getModifyTime() == null ? 0 : this.getModifyTime().hashCode() );
				  result = 37 * result + (getModifier() == null ? 0 : this.getModifier().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
