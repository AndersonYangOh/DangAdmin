/**
 * com.sunrise.system.mapper.SysLoginLog.java
 */
package com.chinauicom.research.rudang.system.log.entity;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * 
 * @ClassName: SysLoginLog 
 * @Description: TODO(实体) 
 * @author Zhongjialiang zhongjialiang@tydic.com 
 * @date 2016-7-11 下午5:35:32 
 *
 */
 
public class SysLoginLog extends BaseVO implements java.io.Serializable{

	private java.lang.Long logId;
	private java.lang.String operId;
	private java.util.Date loginTime;
	private java.util.Date logoutTime;
	private java.lang.String ipAddress;
	private java.lang.String macId;
	private java.lang.String remark;
	public SysLoginLog(){
	}

	public SysLoginLog(
		java.lang.Long logId
	){
		this.logId = logId;
	}



	public void setLogId(java.lang.Long value) {
		this.logId = value;
	}	
	public java.lang.Long getLogId() {
		return this.logId;
	}

	public void setOperId(java.lang.String value) {
		this.operId = value;
	}	
	public java.lang.String getOperId() {
		return this.operId;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}	
	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setLogoutTime(java.util.Date value) {
		this.logoutTime = value;
	}	
	public java.util.Date getLogoutTime() {
		return this.logoutTime;
	}

	public void setIpAddress(java.lang.String value) {
		this.ipAddress = value;
	}	
	public java.lang.String getIpAddress() {
		return this.ipAddress;
	}

	public void setMacId(java.lang.String value) {
		this.macId = value;
	}	
	public java.lang.String getMacId() {
		return this.macId;
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
			   buffer.append("LogId").append("='").append(getLogId()).append("' ");	
			   buffer.append("OperId").append("='").append(getOperId()).append("' ");	
			   buffer.append("LoginTime").append("='").append(getLoginTime()).append("' ");	
			   buffer.append("LogoutTime").append("='").append(getLogoutTime()).append("' ");	
			   buffer.append("IpAddress").append("='").append(getIpAddress()).append("' ");	
			   buffer.append("MacId").append("='").append(getMacId()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysLoginLog) ) return false;
		 SysLoginLog  castOther = ( SysLoginLog) other;  
		 return 
					( (this.getLogId()==castOther.getLogId()) ||( this.getLogId()!=null && castOther.getLogId()!=null && this.getLogId().equals(castOther.getLogId()) ) )
					&&( (this.getOperId()==castOther.getOperId()) ||( this.getOperId()!=null && castOther.getOperId()!=null && this.getOperId().equals(castOther.getOperId()) ) )
					&&( (this.getLoginTime()==castOther.getLoginTime()) ||( this.getLoginTime()!=null && castOther.getLoginTime()!=null && this.getLoginTime().equals(castOther.getLoginTime()) ) )
					&&( (this.getLogoutTime()==castOther.getLogoutTime()) ||( this.getLogoutTime()!=null && castOther.getLogoutTime()!=null && this.getLogoutTime().equals(castOther.getLogoutTime()) ) )
					&&( (this.getIpAddress()==castOther.getIpAddress()) ||( this.getIpAddress()!=null && castOther.getIpAddress()!=null && this.getIpAddress().equals(castOther.getIpAddress()) ) )
					&&( (this.getMacId()==castOther.getMacId()) ||( this.getMacId()!=null && castOther.getMacId()!=null && this.getMacId().equals(castOther.getMacId()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getLogId() == null ? 0 : this.getLogId().hashCode() );
				  result = 37 * result + (getOperId() == null ? 0 : this.getOperId().hashCode() );
				  result = 37 * result + (getLoginTime() == null ? 0 : this.getLoginTime().hashCode() );
				  result = 37 * result + (getLogoutTime() == null ? 0 : this.getLogoutTime().hashCode() );
				  result = 37 * result + (getIpAddress() == null ? 0 : this.getIpAddress().hashCode() );
				  result = 37 * result + (getMacId() == null ? 0 : this.getMacId().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
