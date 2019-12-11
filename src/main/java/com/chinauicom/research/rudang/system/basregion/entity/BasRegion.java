package com.chinauicom.research.rudang.system.basregion.entity;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * @file  BasRegion.java
 * @author caipeimin
 * @version 0.1
 * @BasRegion实体类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-06 09:52:53
 *      	Author: caipeimin
 *      	Modification: this file was created
 *   	2. ...
 */
public class BasRegion extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = 7210443920190975776L;
	private String regionCode;
	/**语种*/
	private String lang;
	private String regionPid;
	private String regionName;
	private Integer reOrder;
	private Boolean isChecked = Boolean.FALSE;

	public BasRegion(){
	}

	public BasRegion(String lang,String regionCode){
		this.lang=lang;
		this.regionCode = regionCode;
	}

	public BasRegion(String regionCode){
		this.regionCode = regionCode;
	}

	public void setRegionCode(String value) {
		this.regionCode = value;
	}
	public String getRegionCode() {
		return this.regionCode;
	}

	/**
	 * @return lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang 要设置的 lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setRegionPid(String value) {
		this.regionPid = value;
	}
	public String getRegionPid() {
		return this.regionPid;
	}

	public void setRegionName(String value) {
		this.regionName = value;
	}
	public String getRegionName() {
		return this.regionName;
	}

    public Boolean getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * @return the reOrder
	 */
	public Integer getReOrder() {
		return reOrder;
	}

	/**
	 * @param reOrder the reOrder to set
	 */
	public void setReOrder(Integer reOrder) {
		this.reOrder = reOrder;
	}

	public String toString() {
		  StringBuffer buffer = new StringBuffer();
		  buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");	
			   buffer.append("RegionCode").append("='").append(getRegionCode()).append("' ");	
			   buffer.append("RegionPid").append("='").append(getRegionPid()).append("' ");	
			   buffer.append("RegionName").append("='").append(getRegionName()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BasRegion) ) return false;
		 BasRegion  castOther = ( BasRegion) other;  
		 return 
					( (this.getRegionCode()==castOther.getRegionCode()) ||( this.getRegionCode()!=null && castOther.getRegionCode()!=null && this.getRegionCode().equals(castOther.getRegionCode()) ) )
					&&( (this.getRegionPid()==castOther.getRegionPid()) ||( this.getRegionPid()!=null && castOther.getRegionPid()!=null && this.getRegionPid().equals(castOther.getRegionPid()) ) )
					&&( (this.getRegionName()==castOther.getRegionName()) ||( this.getRegionName()!=null && castOther.getRegionName()!=null && this.getRegionName().equals(castOther.getRegionName()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getRegionCode() == null ? 0 : this.getRegionCode().hashCode() );
				  result = 37 * result + (getRegionPid() == null ? 0 : this.getRegionPid().hashCode() );
				  result = 37 * result + (getRegionName() == null ? 0 : this.getRegionName().hashCode() );
         return result;
	} 
	
	/**发展人编码*/
	private String developerCode;

	public String getDeveloperCode() {
		return developerCode;
	}

	public void setDeveloperCode(String developerCode) {
		this.developerCode = developerCode;
	}
	
}
