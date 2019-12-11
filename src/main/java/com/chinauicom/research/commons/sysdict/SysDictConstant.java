/**
 * 
 */
package com.chinauicom.research.commons.sysdict;


import java.util.Map;



/**
 */
public class SysDictConstant  {
	
	
	public static Map<String, Map<String, String>> SYS_DICT_MAP = null ;
		
	/**
	 * 
	 * @Title: initSysDictByCode 
	 * @Description: 获取数据字典
	 * @param @param dictMap
	 * @param @param dictCode    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void initSysDictByCode(Map<String, String> dictMap, String dictCode){
		//Map<String, String> tmpDictMap = SYS_DICT_MAP.get(WcsDefinition.WcsLangType.WCS_EN + "_" + dictCode);
		Map<String, String> tmpDictMap = SYS_DICT_MAP.get(dictCode);
		if(tmpDictMap != null){
			dictMap.putAll(SYS_DICT_MAP.get(dictCode));
		}
	}
	
	/**
	 * 
	 * @Title: initSysDictByCode 
	 * @Description: 根据语种获取数据字典
	 * @param @param dictMap
	 * @param @param dictCode
	 * @param @param lang    语种
	 * @return void    返回类型 
	 * @throws
	 */
	public static void initSysDictByCode(Map<String, String> dictMap, String dictCode, String lang){
		Map<String, String> tmpDictMap = SYS_DICT_MAP.get(lang + "_" + dictCode);
		if(tmpDictMap != null){
			dictMap.putAll(SYS_DICT_MAP.get(lang + "_" + dictCode));
		}
	}
}
