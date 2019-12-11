/**
 * com.sunrise.system.mapper.SysOrganize.java
 */
package com.chinauicom.research.rudang.system.organize.entity;

import java.util.Date;
import java.util.List;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * 
 * @ClassName: SysOrganize 
 * @Description: TODO(实体) 
 * @author Zhongjialiang zhongjialiang@tydic.com 
 * @date 2016-7-11 下午5:47:32 
 *
 */
public class SysOrganize extends BaseVO implements java.io.Serializable{

  private static final long serialVersionUID = -1052381547312871411L;
  private String orgCode;

  private String orgName;

  private String parentOrgCode;

  private String orgDesc;

  private String creater;

  private Date createTime;

  private String modifier;

  private Date modifyTime;

  private String remark;
  
	
  private List<SysOrganize> childOrganize;
	
  public SysOrganize(){
	}

	public SysOrganize(
		java.lang.String orgCode
	){
		this.orgCode = orgCode;
	}
	


	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<SysOrganize> getChildOrganize() {
		return childOrganize;
	}

	public void setChildOrganize(List<SysOrganize> childOrganize) {
		this.childOrganize = childOrganize;
	}

	public void setOrgCode(java.lang.String value) {
		this.orgCode = value;
	}	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgName(java.lang.String value) {
		this.orgName = value;
	}	
	public java.lang.String getOrgName() {
		return this.orgName;
	}

	public void setParentOrgCode(java.lang.String value) {
		this.parentOrgCode = value;
	}	
	public java.lang.String getParentOrgCode() {
		return this.parentOrgCode;
	}

	public void setOrgDesc(java.lang.String value) {
		this.orgDesc = value;
	}	
	public java.lang.String getOrgDesc() {
		return this.orgDesc;
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
			   buffer.append("OrgCode").append("='").append(getOrgCode()).append("' ");	
			   buffer.append("OrgName").append("='").append(getOrgName()).append("' ");	
			   buffer.append("ParentOrgCode").append("='").append(getParentOrgCode()).append("' ");	
			   buffer.append("Status").append("='").append(getStatus()).append("' ");	
			   buffer.append("OrgDesc").append("='").append(getOrgDesc()).append("' ");	
			   buffer.append("Creater").append("='").append(getCreater()).append("' ");	
			   buffer.append("CreateTime").append("='").append(getCreateTime()).append("' ");	
			   buffer.append("Modifier").append("='").append(getModifier()).append("' ");	
			   buffer.append("ModifyTime").append("='").append(getModifyTime()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysOrganize) ) return false;
		 SysOrganize  castOther = ( SysOrganize) other;  
		 return 
					( (this.getOrgCode()==castOther.getOrgCode()) ||( this.getOrgCode()!=null && castOther.getOrgCode()!=null && this.getOrgCode().equals(castOther.getOrgCode()) ) )
					&&( (this.getOrgName()==castOther.getOrgName()) ||( this.getOrgName()!=null && castOther.getOrgName()!=null && this.getOrgName().equals(castOther.getOrgName()) ) )
					&&( (this.getParentOrgCode()==castOther.getParentOrgCode()) ||( this.getParentOrgCode()!=null && castOther.getParentOrgCode()!=null && this.getParentOrgCode().equals(castOther.getParentOrgCode()) ) )
					&&( (this.getStatus()==castOther.getStatus()) ||( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
					&&( (this.getOrgDesc()==castOther.getOrgDesc()) ||( this.getOrgDesc()!=null && castOther.getOrgDesc()!=null && this.getOrgDesc().equals(castOther.getOrgDesc()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getModifier()==castOther.getModifier()) ||( this.getModifier()!=null && castOther.getModifier()!=null && this.getModifier().equals(castOther.getModifier()) ) )
					&&( (this.getModifyTime()==castOther.getModifyTime()) ||( this.getModifyTime()!=null && castOther.getModifyTime()!=null && this.getModifyTime().equals(castOther.getModifyTime()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getOrgCode() == null ? 0 : this.getOrgCode().hashCode() );
				  result = 37 * result + (getOrgName() == null ? 0 : this.getOrgName().hashCode() );
				  result = 37 * result + (getParentOrgCode() == null ? 0 : this.getParentOrgCode().hashCode() );
				  result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode() );
				  result = 37 * result + (getOrgDesc() == null ? 0 : this.getOrgDesc().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getModifier() == null ? 0 : this.getModifier().hashCode() );
				  result = 37 * result + (getModifyTime() == null ? 0 : this.getModifyTime().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
