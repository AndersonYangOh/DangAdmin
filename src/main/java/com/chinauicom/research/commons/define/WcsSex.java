package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;



/**
 * @file  WcsSex.java
 * @author yancan
 * @version 0.1
 * @WcsSex性别
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-31 04:25:15
 *      	Author: yancan
 *      	Modification: this file was created
 *   	2. ...
 */
public class WcsSex {
	private static final String DICT_CODE="SEX";//对应数据库表SYS_DICT的DICT_CODE值
	
	 /**男 */
   public static final String WCS_PC_TERMINAL = "1";
   /** 女 */
   public static final String WCS_WAP_TERMINAL = "2";
   /** 键值对象 */
   public static Map<String, String> WCS_SEX_MAP = new LinkedHashMap<String, String>();
   static {
   	/*WCS_ACCESS_TYPE_MAP.put(WCS_PC_TERMINAL, "PC");
   	WCS_ACCESS_TYPE_MAP.put(WCS_WAP_TERMINAL, "WAP");
   	WCS_ACCESS_TYPE_MAP.put(WCS_PAD_TERMINAL, "PAD");*/
   	SysDictConstant.initSysDictByCode(WCS_SEX_MAP, DICT_CODE);
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
