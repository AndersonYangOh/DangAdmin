package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;


/**
 * @file  WcsRoleType.java
 * @author shuyongfu
 * @version 0.1
 * @WcsRoleType 角色类型
 */
public class WcsRoleType {
private static final String DICT_CODE="ROLE_TYPE";//对应数据库表SYS_DICT的DICT_CODE值
	
	/** 系统管理员*/
	public static final String WCS_ROLE_TYPE_SYSTEM = "1";
	/** 省公司管理员 */
    public static final String WCS_ROLE_TYPE_COMPANY = "2";
    /** 地市管理员 */
    public static final String WCS_ROLE_TYPE_CITY = "3";
    /** 渠道管理员*/
    public static final String WCS_ROLE_TYPE_CHANNEL = "4";
    /** 键值对象 */
    public static Map<String, String> WCS_ROLE_TYPE_MAP = new LinkedHashMap<String, String>();
    static {
    	SysDictConstant.initSysDictByCode(WCS_ROLE_TYPE_MAP, DICT_CODE);
    }
    /**
	 * 
	 * @Title: getMap 
	 * @Description: 获取指定语种
	 * @param @param lang
	 * @param @return    设定文件 
	 * @return Map<String,String>    返回类型 
	 * @throws
	 */
	public static Map<String, String> getMap(String lang) {
		Map<String, String> result = new HashMap<String, String>();
		SysDictConstant.initSysDictByCode(result, DICT_CODE, lang);
		return result;
	}
}
