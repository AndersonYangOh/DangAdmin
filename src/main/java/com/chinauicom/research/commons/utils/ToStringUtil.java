/**
 * com.tydic.commons.utils.ToStringUtil.java
 */
package com.chinauicom.research.commons.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

 /**
 * @file  ToStringUtil.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 用反射实现DataVO-->ToString
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class ToStringUtil {
	private static final Log log =LogFactory.getLog(ToStringUtil.class);
	public static String toString(BaseVO entity, String... fieldName) {
		Class cls = entity.getClass();
		StringBuffer buffer = new StringBuffer(cls.getSimpleName() + ":[ ");
		try {
			// 不获取私有方法
			Method[] methods = cls.getMethods();
			if (null != fieldName && fieldName.length != 0) {
				for (Method method : methods) {
					String mn = method.getName();
					for (String fn : fieldName) {
						if (mn.equalsIgnoreCase("get" + fn)) {
							Object o=method.invoke(entity);
							if(o!=null){
								String value = o.toString();
								buffer.append(mn + "=" + value + " ,");
							}else{
								buffer.append(mn + "=  ,");
							}
						}
					}
				}
			} else {
				// 得到所有field
				Field[] fields = cls.getDeclaredFields();
				for (Method method : methods) {
					String mn = method.getName();
					for (Field field : fields) {
						String name = field.getName().toString();
						if (mn.equalsIgnoreCase("get" + name)) {
							Object o=method.invoke(entity);
							if(o!=null){
								String value = o.toString();
								buffer.append(name + "=" + value + " ,");
							}else{
								buffer.append(name + "=  ,");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("ToStringUtil.toString:"+e);
			}
		}
		return buffer.substring(0, buffer.length() - 1).toString()+" ]";
	}
}
