package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;

/**
 * @file WcsYesNoMark.java
 * @author yancan
 * @version 0.1
 * @WcsYesNoMark是否标志 Copyright(C), 2013-2014 Guangzhou Sunrise Technology Co.,
 *                   Ltd. History 1. Date: 2014-03-12 04:25:15 Author: yancan
 *                   Modification: this file was created 2. ...
 */
public class WcsYesNoMark {
	private static final String DICT_CODE = "YESNO_MARK";// 对应数据库表SYS_DICT的DICT_CODE值
	/** 是 */
	public static final String WCS_YES = "1";
	/** 否 */
	public static final String WCS_NO = "0";
	/** 键值对象 */
	public static Map<String, String> WCS_YESNO_MARK_MAP = new LinkedHashMap<String, String>();
	static {
		/*
		 * WCS_YESNO_MARK_MAP.put(WCS_YES, "是"); WCS_YESNO_MARK_MAP.put(WCS_NO,
		 * "否");
		 */
		SysDictConstant.initSysDictByCode(WCS_YESNO_MARK_MAP, DICT_CODE);
	}

	/**
	 * 
	 * @Title: getMap @Description: 获取指定语种 @param @param lang @param @return
	 * 设定文件 @return Map<String,String> 返回类型 @throws
	 */
	public static Map<String, String> getMap(String lang) {
		Map<String, String> result = new HashMap<String, String>();
		SysDictConstant.initSysDictByCode(result, DICT_CODE, lang);
		return result;
	}

}
