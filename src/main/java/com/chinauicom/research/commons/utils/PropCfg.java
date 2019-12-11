/**
 * com.tydic.commons.utils.PropCfg.java
 */
package com.chinauicom.research.commons.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

 /**
 * @file  PropCfg.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 读取Spring中配置的属性文件
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-5-19
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class PropCfg extends PropertyPlaceholderConfigurer {
	private static Map<String, Object> ctxPropertiesMap;
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	public static Object getProperty(String key) {
		return ctxPropertiesMap.get(key);
	}
	
	public static String get(String key){
		return (String)ctxPropertiesMap.get(key);
	}
}
