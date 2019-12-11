/**
 * 
 */
package com.chinauicom.research.rudang.system.organize.vo;

import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;

/**
 * @author yangziran
 * @version 1.0 2014年4月3日
 */
@SuppressWarnings("serial")
public class SysOrganizeVo extends SysOrganize {

    private String parentOrgName;
    private String regionName;

    /**
     * 取得 parentOrgName
     * @return parentOrgName String
     */
    public String getParentOrgName() {
        return parentOrgName;
    }

    /**
     * 设定 parentOrgName
     * @param parentOrgName String
     */
    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
    }

    /**
     * 取得 regionName
     * @return regionName String
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 设定 regionName
     * @param regionName String
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
