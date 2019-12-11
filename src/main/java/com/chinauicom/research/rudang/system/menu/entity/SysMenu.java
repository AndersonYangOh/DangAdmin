/**
 * com.sunrise.system.mapper.SysMenu.java
 */
package com.chinauicom.research.rudang.system.menu.entity;


import java.util.Date;
import java.util.List;

import com.chinauicom.research.commons.utils.BaseVO;

/**
 * 
 * @ClassName: SysMenu 
 * @Description: TODO(实体) 
 * @author Zhongjialiang zhongjialiang@tydic.com 
 * @date 2016-7-11 下午5:37:30 
 *
 */
public class SysMenu extends BaseVO implements java.io.Serializable{

	private static final long serialVersionUID = -2540977355693984969L;

    private String menuCode;

    private String menuName;

    private String parentMenuCode;

	private String parentMenuName;

    private String menuUri;

    private String menuDesc;

    private Long menuLayer;

    private String creater;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    private Long reorder;

    private String remark;

	private boolean child = false;//是否存在子菜单,默认为false
	private List<SysMenu> childMenus;//子菜单列表
	private String roleCode;//角色编码
	
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

	public boolean isChild() {
		return child;
	}

	public void setChild(boolean child) {
		this.child = child;
	}

	public List<SysMenu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<SysMenu> childMenus) {
		this.childMenus = childMenus;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public SysMenu(){
	}

	public SysMenu(
		java.lang.String menuCode
	){
		this.menuCode = menuCode;
	}



	public void setMenuCode(java.lang.String value) {
		this.menuCode = value;
	}	
	public java.lang.String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuName(java.lang.String value) {
		this.menuName = value;
	}	
	public java.lang.String getMenuName() {
		return this.menuName;
	}

	public void setParentMenuCode(java.lang.String value) {
		this.parentMenuCode = value;
	}	
	public java.lang.String getParentMenuCode() {
		return this.parentMenuCode;
	}

	public void setMenuUri(java.lang.String value) {
		this.menuUri = value;
	}	
	public java.lang.String getMenuUri() {
		return this.menuUri;
	}

	public void setMenuDesc(java.lang.String value) {
		this.menuDesc = value;
	}	
	public java.lang.String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuLayer(java.lang.Long value) {
		this.menuLayer = value;
	}	
	public java.lang.Long getMenuLayer() {
		return this.menuLayer;
	}


	public String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public void setReorder(java.lang.Long value) {
		this.reorder = value;
	}	
	public java.lang.Long getReorder() {
		return this.reorder;
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
			   buffer.append("MenuCode").append("='").append(getMenuCode()).append("' ");	
			   buffer.append("MenuName").append("='").append(getMenuName()).append("' ");	
			   buffer.append("ParentMenuCode").append("='").append(getParentMenuCode()).append("' ");	
			   buffer.append("Status").append("='").append(getStatus()).append("' ");	
			   buffer.append("MenuUri").append("='").append(getMenuUri()).append("' ");	
			   buffer.append("MenuDesc").append("='").append(getMenuDesc()).append("' ");	
			   buffer.append("MenuLayer").append("='").append(getMenuLayer()).append("' ");	
			   buffer.append("Creater").append("='").append(getCreater()).append("' ");	
			   buffer.append("CreateTime").append("='").append(getCreateTime()).append("' ");	
			   buffer.append("Modifier").append("='").append(getModifier()).append("' ");	
			   buffer.append("ModifyTime").append("='").append(getModifyTime()).append("' ");	
			   buffer.append("Reorder").append("='").append(getReorder()).append("' ");	
			   buffer.append("Remark").append("='").append(getRemark()).append("' ");	
		  buffer.append("]");
		  return buffer.toString();
	}		

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SysMenu) ) return false;
		 SysMenu  castOther = ( SysMenu) other;  
		 return 
					( (this.getMenuCode()==castOther.getMenuCode()) ||( this.getMenuCode()!=null && castOther.getMenuCode()!=null && this.getMenuCode().equals(castOther.getMenuCode()) ) )
					&&( (this.getMenuName()==castOther.getMenuName()) ||( this.getMenuName()!=null && castOther.getMenuName()!=null && this.getMenuName().equals(castOther.getMenuName()) ) )
					&&( (this.getParentMenuCode()==castOther.getParentMenuCode()) ||( this.getParentMenuCode()!=null && castOther.getParentMenuCode()!=null && this.getParentMenuCode().equals(castOther.getParentMenuCode()) ) )
					&&( (this.getStatus()==castOther.getStatus()) ||( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
					&&( (this.getMenuUri()==castOther.getMenuUri()) ||( this.getMenuUri()!=null && castOther.getMenuUri()!=null && this.getMenuUri().equals(castOther.getMenuUri()) ) )
					&&( (this.getMenuDesc()==castOther.getMenuDesc()) ||( this.getMenuDesc()!=null && castOther.getMenuDesc()!=null && this.getMenuDesc().equals(castOther.getMenuDesc()) ) )
					&&( (this.getMenuLayer()==castOther.getMenuLayer()) ||( this.getMenuLayer()!=null && castOther.getMenuLayer()!=null && this.getMenuLayer().equals(castOther.getMenuLayer()) ) )
					&&( (this.getCreater()==castOther.getCreater()) ||( this.getCreater()!=null && castOther.getCreater()!=null && this.getCreater().equals(castOther.getCreater()) ) )
					&&( (this.getCreateTime()==castOther.getCreateTime()) ||( this.getCreateTime()!=null && castOther.getCreateTime()!=null && this.getCreateTime().equals(castOther.getCreateTime()) ) )
					&&( (this.getModifier()==castOther.getModifier()) ||( this.getModifier()!=null && castOther.getModifier()!=null && this.getModifier().equals(castOther.getModifier()) ) )
					&&( (this.getModifyTime()==castOther.getModifyTime()) ||( this.getModifyTime()!=null && castOther.getModifyTime()!=null && this.getModifyTime().equals(castOther.getModifyTime()) ) )
					&&( (this.getReorder()==castOther.getReorder()) ||( this.getReorder()!=null && castOther.getReorder()!=null && this.getReorder().equals(castOther.getReorder()) ) )
					&&( (this.getRemark()==castOther.getRemark()) ||( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
			;
    }

	public int hashCode() {
         int result = 17;
				  result = 37 * result + (getMenuCode() == null ? 0 : this.getMenuCode().hashCode() );
				  result = 37 * result + (getMenuName() == null ? 0 : this.getMenuName().hashCode() );
				  result = 37 * result + (getParentMenuCode() == null ? 0 : this.getParentMenuCode().hashCode() );
				  result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode() );
				  result = 37 * result + (getMenuUri() == null ? 0 : this.getMenuUri().hashCode() );
				  result = 37 * result + (getMenuDesc() == null ? 0 : this.getMenuDesc().hashCode() );
				  result = 37 * result + (getMenuLayer() == null ? 0 : this.getMenuLayer().hashCode() );
				  result = 37 * result + (getCreater() == null ? 0 : this.getCreater().hashCode() );
				  result = 37 * result + (getCreateTime() == null ? 0 : this.getCreateTime().hashCode() );
				  result = 37 * result + (getModifier() == null ? 0 : this.getModifier().hashCode() );
				  result = 37 * result + (getModifyTime() == null ? 0 : this.getModifyTime().hashCode() );
				  result = 37 * result + (getReorder() == null ? 0 : this.getReorder().hashCode() );
				  result = 37 * result + (getRemark() == null ? 0 : this.getRemark().hashCode() );
         return result;
	} 
	
}
