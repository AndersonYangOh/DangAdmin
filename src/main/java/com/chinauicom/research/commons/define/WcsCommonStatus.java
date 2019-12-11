package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;

/**
 * @file WcsCommonStatus.java
 * @author yancan
 * @version 0.1
 * @WcsCommonStatus公共状态
 */
public class WcsCommonStatus {
	private static final String DICT_CODE = "COMMON_STATUS";// 对应数据库表SYS_DICT的DICT_CODE值
	/** 有效 */
	public static final String WCS_VALID = "1";
	/** 无效 */
	public static final String WCS_INVALID = "0";
	/** 键值对象 */
	public static Map<String, String> WCS_COMMON_STATUS_MAP = new LinkedHashMap<String, String>();
	static {
		/*
		 * WCS_COMMON_STATUS_MAP.put(WCS_VALID, "有效");
		 * WCS_COMMON_STATUS_MAP.put(WCS_INVALID, "无效");
		 */
		SysDictConstant.initSysDictByCode(WCS_COMMON_STATUS_MAP, DICT_CODE);
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
