/**
 * 
 */
package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;


/**
 * @file  WcsLangType.java
 * @author yuchanghong
 * @version 0.1
 * @WcsLangType语种
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-12-10 04:25:15
 *      	Author: yuchanghong
 *      	Modification: this file was created
 *   	2. ...
 */
public class WcsLangType {
	private static final String DICT_CODE="LANG_TYPE";//对应数据库表SYS_DICT的DICT_CODE值
	/**中文*/
	public static final String WCS_CN = "zh_CN";
	/**英文*/
	public static final String WCS_EN = "en_US";
	/**柬埔寨*/
	public static final String WCS_KH = "km";
	
    /** 键值对象 */
	public static Map<String, String> WCS_LANG_TYPE_MAP = new LinkedHashMap<String, String>();
    static {
    	SysDictConstant.initSysDictByCode(WCS_LANG_TYPE_MAP, DICT_CODE);
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
