/**
 * com.sunrise.system.mapper.SysFunOperate.java
 */
package com.chinauicom.research.rudang.system.menu.entity;

import java.util.Date;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * 
 * @ClassName: SysFunOperate 
 * @Description: TODO(实体) 
 * @author Zhongjialiang zhongjialiang@tydic.com 
 * @date 2016-7-11 下午5:34:52 
 *
 */
public class SysFunOperate extends BaseVO implements java.io.Serializable{

	 private String operateCode;

	    private String menuCode;

	    private String operateType;

	    private String operateDesc;

	    private String creater;

	    private Date createTime;

	    private String remark;
	    
	    private Boolean isChecked = Boolean.FALSE;//是否被选中,默认不选中
	
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

	
	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public SysFunOperate(){
	}

	public SysFunOperate(
		java.lang.String operateCode
	){
		this.operateCode = operateCode;
	}



	public void setOperateCode(java.lang.String value) {
		this.operateCode = value;
	}	
	public java.lang.String getOperateCode() {
		return this.operateCode;
	}

	public void setMenuCode(java.lang.String value) {
		this.menuCode = value;
	}	
	public java.lang.String getMenuCode() {
		return this.menuCode;
	}

	public void setOperateType(java.lang.String value) {
		this.operateType = value;
	}	
	public java.lang.String getOperateType() {
		return this.operateType;
	}

	public void setOperateDesc(java.lang.String value) {
		this.operateDesc = value;
	}	
	public java.lang.String getOperateDesc() {
		return this.operateDesc;
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
			   buffer.append("OperateCode").append("='").append(getOperateCode()).append("' ");	
			   buffer.append("MenuCode").append("='").append(getMenuCode()).append("' ");	
			   buffer.append("OperateType").append("='").append(getOperateType()).append("' ");	
			   buffer.append("OperateDesc").append("='").append(getOperateDesc()).append("' ");	
			   buffer.append("Creater").append("='").append(getCreater()).append("' ");	
			   buffer.append("CreateTime").append("='").append(getCreateTime()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysFunOperate) ) return false;
		 SysFunOperate  castOther = ( SysFunOperate) other;  
		 return 
					( (this.getOperateCode()==castOther.getOperateCode()) ||( this.getOperateCode()!=null && castOther.getOperateCode()!=null && this.getOperateCode().equals(castOther.getOperateCode()) ) )
					&&( (this.getMenuCode()==castOther.getMenuCode()) ||( this.getMenuCode()!=null && castOther.getMenuCode()!=null && this.getMenuCode().equals(castOther.getMenuCode()) ) )
					&&( (this.getOperateType()==castOther.getOperateType()) ||( this.getOperateType()!=null && castOther.getOperateType()!=null && this.getOperateType().equals(castOther.getOperateType()) ) )
					&&( (this.getOperateDesc()==castOther.getOperateDesc()) ||( this.getOperateDesc()!=null && castOther.getOperateDesc()!=null && this.getOperateDesc().equals(castOther.getOperateDesc()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getOperateCode() == null ? 0 : this.getOperateCode().hashCode() );
				  result = 37 * result + (getMenuCode() == null ? 0 : this.getMenuCode().hashCode() );
				  result = 37 * result + (getOperateType() == null ? 0 : this.getOperateType().hashCode() );
				  result = 37 * result + (getOperateDesc() == null ? 0 : this.getOperateDesc().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
