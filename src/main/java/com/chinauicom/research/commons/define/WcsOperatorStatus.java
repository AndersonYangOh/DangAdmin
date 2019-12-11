package com.chinauicom.research.commons.define;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chinauicom.research.commons.sysdict.SysDictConstant;



/**
 *<p>File: WcsOperatorStatus.java</p>
 *<p>Description: 操作员状态定义</p>
 *<p>Company: 从兴技术有限公司</p>
 *<p>Author: 刘高林</p>
 *<p>Version: 1.0,2014-3-25 下午3:23:06,刘高林,Ins</p>
 *
 */
public class WcsOperatorStatus {
	private static final String DICT_CODE="OPERATOR_STATUS";//对应数据库表SYS_DICT的DICT_CODE值
	/**冻结*/
	public static final String FROZEN = "0";
	/**正常使用*/
	public static final String NORMAL = "1";
	/**未激活*/
	public static final String NOT_ACTIVE = "2";
	/**注销*/
	public static final String CANCEL = "3";
	
	/**键值*/
	public static Map<String, String> WCS_OPERATOR_STATUS_MAP = new LinkedHashMap<String, String>();
	
	static {
		SysDictConstant.initSysDictByCode(WCS_OPERATOR_STATUS_MAP, DICT_CODE);
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
