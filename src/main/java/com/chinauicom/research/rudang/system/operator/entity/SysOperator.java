package com.chinauicom.research.rudang.system.operator.entity;

import java.util.Date;
import java.util.List;

import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.rudang.system.role.entity.SysOperRole;

/**
 * 
 * @ClassName: SysOperator 
 * @Description: TODO(实体) 
 * @date 2016-7-11 下午5:46:02 
 *
 */
public class SysOperator extends BaseVO implements java.io.Serializable{

    private static final long serialVersionUID = 5080988912706823918L;
    private String operId;

	private  String operAccount;

    private String operPwd;

    private String operName;

    private String orgCode;

    private String operSex;

    private String operCardNo;

    private String operMobile;

    private String operTeleNo;

    private String operAddr;

    private String operEmail;

    private String position;

    private Double errorCount;

    private Date lastLoginTime;

    private String operDesc;

    private Date createTime;

    private String creater;

    private Date modifyTime;

    private String modifier;

    private String remark;
	
	private String groName;
	private String orgName;
	
	
	private List<SysOperRole> sysOperRole;
	
	public List<SysOperRole> getSysOperRole() {
		return sysOperRole;
	}

	public void setSysOperRole(List<SysOperRole> sysOperRole) {
		this.sysOperRole = sysOperRole;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getGroName() {
		return groName;
	}

	public void setGroName(String groName) {
		this.groName = groName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}



	public SysOperator(){
	}

	public SysOperator(
		java.lang.String operId
	){
		this.operId = operId;
	}



	public void setOperId(java.lang.String value) {
		this.operId = value;
	}	
	public java.lang.String getOperId() {
		return this.operId;
	}

	public void setOperPwd(java.lang.String value) {
		this.operPwd = value;
	}	
	public java.lang.String getOperPwd() {
		return this.operPwd;
	}

	public void setOperName(java.lang.String value) {
		this.operName = value;
	}	
	public java.lang.String getOperName() {
		return this.operName;
	}

	public void setOrgCode(java.lang.String value) {
		this.orgCode = value;
	}	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}

	public void setOperSex(java.lang.String value) {
		this.operSex = value;
	}	
	public java.lang.String getOperSex() {
		return this.operSex;
	}

	public void setOperCardNo(java.lang.String value) {
		this.operCardNo = value;
	}	
	public java.lang.String getOperCardNo() {
		return this.operCardNo;
	}

	public void setOperMobile(java.lang.String value) {
		this.operMobile = value;
	}	
	public java.lang.String getOperMobile() {
		return this.operMobile;
	}

	public void setOperTeleNo(java.lang.String value) {
		this.operTeleNo = value;
	}	
	public java.lang.String getOperTeleNo() {
		return this.operTeleNo;
	}

	public void setOperAddr(java.lang.String value) {
		this.operAddr = value;
	}	
	public java.lang.String getOperAddr() {
		return this.operAddr;
	}

	public void setOperEmail(java.lang.String value) {
		this.operEmail = value;
	}	
	public java.lang.String getOperEmail() {
		return this.operEmail;
	}

	public void setPosition(java.lang.String value) {
		this.position = value;
	}	
	public java.lang.String getPosition() {
		return this.position;
	}

	public void setErrorCount(java.lang.Double value) {
		this.errorCount = value;
	}	
	public java.lang.Double getErrorCount() {
		return this.errorCount;
	}

	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}	
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setOperDesc(java.lang.String value) {
		this.operDesc = value;
	}	
	public java.lang.String getOperDesc() {
		return this.operDesc;
	}

	public String getOperAccount() {
		return operAccount;
	}

	public void setOperAccount(String operAccount) {
		this.operAccount = operAccount;
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
			   buffer.append("OperId").append("='").append(getOperId()).append("' ");	
			   buffer.append("OperPwd").append("='").append(getOperPwd()).append("' ");	
			   buffer.append("OperName").append("='").append(getOperName()).append("' ");	
			   buffer.append("OrgCode").append("='").append(getOrgCode()).append("' ");	
			   buffer.append("OperSex").append("='").append(getOperSex()).append("' ");	
			   buffer.append("OperCardNo").append("='").append(getOperCardNo()).append("' ");	
			   buffer.append("OperMobile").append("='").append(getOperMobile()).append("' ");	
			   buffer.append("OperTeleNo").append("='").append(getOperTeleNo()).append("' ");	
			   buffer.append("OperAddr").append("='").append(getOperAddr()).append("' ");	
			   buffer.append("OperEmail").append("='").append(getOperEmail()).append("' ");	
			   buffer.append("Position").append("='").append(getPosition()).append("' ");	
			   buffer.append("ErrorCount").append("='").append(getErrorCount()).append("' ");	
			   buffer.append("Status").append("='").append(getStatus()).append("' ");	
			   buffer.append("LastLoginTime").append("='").append(getLastLoginTime()).append("' ");	
			   buffer.append("OperDesc").append("='").append(getOperDesc()).append("' ");	
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
		 if ( !(other instanceof SysOperator) ) return false;
		 SysOperator  castOther = ( SysOperator) other;  
		 return 
					( (this.getOperId()==castOther.getOperId()) ||( this.getOperId()!=null && castOther.getOperId()!=null && this.getOperId().equals(castOther.getOperId()) ) )
					&&( (this.getOperPwd()==castOther.getOperPwd()) ||( this.getOperPwd()!=null && castOther.getOperPwd()!=null && this.getOperPwd().equals(castOther.getOperPwd()) ) )
					&&( (this.getOperName()==castOther.getOperName()) ||( this.getOperName()!=null && castOther.getOperName()!=null && this.getOperName().equals(castOther.getOperName()) ) )
					&&( (this.getOrgCode()==castOther.getOrgCode()) ||( this.getOrgCode()!=null && castOther.getOrgCode()!=null && this.getOrgCode().equals(castOther.getOrgCode()) ) )
					&&( (this.getOperSex()==castOther.getOperSex()) ||( this.getOperSex()!=null && castOther.getOperSex()!=null && this.getOperSex().equals(castOther.getOperSex()) ) )
					&&( (this.getOperCardNo()==castOther.getOperCardNo()) ||( this.getOperCardNo()!=null && castOther.getOperCardNo()!=null && this.getOperCardNo().equals(castOther.getOperCardNo()) ) )
					&&( (this.getOperMobile()==castOther.getOperMobile()) ||( this.getOperMobile()!=null && castOther.getOperMobile()!=null && this.getOperMobile().equals(castOther.getOperMobile()) ) )
					&&( (this.getOperTeleNo()==castOther.getOperTeleNo()) ||( this.getOperTeleNo()!=null && castOther.getOperTeleNo()!=null && this.getOperTeleNo().equals(castOther.getOperTeleNo()) ) )
					&&( (this.getOperAddr()==castOther.getOperAddr()) ||( this.getOperAddr()!=null && castOther.getOperAddr()!=null && this.getOperAddr().equals(castOther.getOperAddr()) ) )
					&&( (this.getOperEmail()==castOther.getOperEmail()) ||( this.getOperEmail()!=null && castOther.getOperEmail()!=null && this.getOperEmail().equals(castOther.getOperEmail()) ) )
					&&( (this.getPosition()==castOther.getPosition()) ||( this.getPosition()!=null && castOther.getPosition()!=null && this.getPosition().equals(castOther.getPosition()) ) )
					&&( (this.getErrorCount()==castOther.getErrorCount()) ||( this.getErrorCount()!=null && castOther.getErrorCount()!=null && this.getErrorCount().equals(castOther.getErrorCount()) ) )
					&&( (this.getStatus()==castOther.getStatus()) ||( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
					&&( (this.getLastLoginTime()==castOther.getLastLoginTime()) ||( this.getLastLoginTime()!=null && castOther.getLastLoginTime()!=null && this.getLastLoginTime().equals(castOther.getLastLoginTime()) ) )
					&&( (this.getOperDesc()==castOther.getOperDesc()) ||( this.getOperDesc()!=null && castOther.getOperDesc()!=null && this.getOperDesc().equals(castOther.getOperDesc()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getModifyTime()==castOther.getModifyTime()) ||( this.getModifyTime()!=null && castOther.getModifyTime()!=null && this.getModifyTime().equals(castOther.getModifyTime()) ) )
					&&( (this.getModifier()==castOther.getModifier()) ||( this.getModifier()!=null && castOther.getModifier()!=null && this.getModifier().equals(castOther.getModifier()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getOperId() == null ? 0 : this.getOperId().hashCode() );
				  result = 37 * result + (getOperPwd() == null ? 0 : this.getOperPwd().hashCode() );
				  result = 37 * result + (getOperName() == null ? 0 : this.getOperName().hashCode() );
				  result = 37 * result + (getOrgCode() == null ? 0 : this.getOrgCode().hashCode() );
				  result = 37 * result + (getOperSex() == null ? 0 : this.getOperSex().hashCode() );
				  result = 37 * result + (getOperCardNo() == null ? 0 : this.getOperCardNo().hashCode() );
				  result = 37 * result + (getOperMobile() == null ? 0 : this.getOperMobile().hashCode() );
				  result = 37 * result + (getOperTeleNo() == null ? 0 : this.getOperTeleNo().hashCode() );
				  result = 37 * result + (getOperAddr() == null ? 0 : this.getOperAddr().hashCode() );
				  result = 37 * result + (getOperEmail() == null ? 0 : this.getOperEmail().hashCode() );
				  result = 37 * result + (getPosition() == null ? 0 : this.getPosition().hashCode() );
				  result = 37 * result + (getErrorCount() == null ? 0 : this.getErrorCount().hashCode() );
				  result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode() );
				  result = 37 * result + (getLastLoginTime() == null ? 0 : this.getLastLoginTime().hashCode() );
				  result = 37 * result + (getOperDesc() == null ? 0 : this.getOperDesc().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getModifyTime() == null ? 0 : this.getModifyTime().hashCode() );
				  result = 37 * result + (getModifier() == null ? 0 : this.getModifier().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
