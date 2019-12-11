/**
 * com.tydic.commons.utils.ReflectUtil.java
 */
package com.chinauicom.research.commons.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

 /**
 * @file  ReflectUtil.java
 * @version 0.1
 * @todo  利用反射设置JAVA对象值
 */
public class ReflectUtil {
private static final Log log =LogFactory.getLog(ReflectUtil.class);
	
	/**
	 * 设置属性名
	 * @param target
	 * @param fname
	 * @param ftype
	 * @param fvalue
	 */
	public static void setFieldValue(Object target, String fname, Class ftype, Object fvalue) throws Exception{
		if (target == null
				|| fname == null
				|| "".equals(fname)) {
			return;
		}
		Class clazz = target.getClass();
		try {
			Method method = clazz.getDeclaredMethod("set" + Character.toUpperCase(fname.charAt(0))
					+ fname.substring(1), new Class[]{fvalue.getClass()});
			if (!Modifier.isPublic(method.getModifiers())) {
				method.setAccessible(true);
			}
			method.invoke(target, new Object[]{fvalue});

		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug(e);
			}
//			try {
//				Field field = clazz.getDeclaredField(fname);
//				if (!Modifier.isPublic(field.getModifiers())) {
//					field.setAccessible(true);
//				}
//				field.set(target, fvalue);
//			} catch (Exception fe) {
//				if (log.isDebugEnabled()) {
//					log.debug(fe);
//				}
//			}
			throw new Exception(e);
		}
	}
	
	/**
	 * 设置字段的值
	 * @param voObj
	 * @param name
	 * @param data
	 */
	public static void setValue(Object voObj, String name, String data)throws Exception{
        if(data!=null&&!"class".equals(name) && PropertyUtils.isWriteable(voObj, name)){
			if (log.isDebugEnabled()) {
				log.debug(">>name="+name+" data="+data+"|");
			}
//			System.out.println(">>name="+name+" data="+data+"|");
            try{
                if(PropertyUtils.isReadable(voObj , name) && PropertyUtils.isWriteable(voObj , name)){
	                Class cls =PropertyUtils.getPropertyType(voObj,name);
	                //short/Short
	            	if(cls.equals(short.class)&&!"".equals(data.trim())){        			
	 					PropertyUtils.setProperty(voObj,name,Short.valueOf(data));
	 				}else if(cls.isAssignableFrom(Short.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,new Short(data));
	 				}
	                //int/Integer
	            	else if(cls.equals(int.class)&&!"".equals(data.trim())){        			
	 					PropertyUtils.setProperty(voObj,name,Integer.valueOf(data));
	 				}else if(cls.isAssignableFrom(Integer.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,new Integer(data));
	 				}
	                //long/Long
	            	else if(cls.equals(long.class)&&!"".equals(data.trim())){        			
	 					PropertyUtils.setProperty(voObj,name,Long.valueOf(data));
	 				}else if(cls.isAssignableFrom(Long.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,new Long(data));
	 				}
	            	//float/Float
	            	else if(cls.equals(float.class)&&!"".equals(data.trim())){
	 					PropertyUtils.setProperty(voObj,name,Float.valueOf(data));
	 				}else if(cls.isAssignableFrom(Float.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,new Float(data));
	 				}
	            	//double/Double
	            	else if(cls.equals(double.class)&&!"".equals(data.trim())){
	 					PropertyUtils.setProperty(voObj,name,Double.valueOf(data));
	 				}else if(cls.isAssignableFrom(Double.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,new Double(data));
	 				}
	            	//util.Date/sql.Date/Timestamp/Time
	            	else if(cls.isAssignableFrom(java.util.Date.class)&&!"".equals(data.trim())) {
	 					SimpleDateFormat sdf=new SimpleDateFormat();
	 					PropertyUtils.setProperty(voObj,name,sdf.parse(data) );
	 				}else if(cls.isAssignableFrom(java.sql.Date.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,java.sql.Date.valueOf(data));
	 				}else if(cls.isAssignableFrom(java.sql.Timestamp.class)&&!"".equals(data.trim())) {
	 					if(data.length()<11){
							  	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	 						java.util.Date dateTmp = simpleDateFormat.parse(data);
	 						data=df.format(dateTmp);
	 					}
	 					PropertyUtils.setProperty(voObj,name,java.sql.Timestamp.valueOf(data));
	 				}else if(cls.isAssignableFrom(java.sql.Time.class)&&!"".equals(data.trim())) {
	 					PropertyUtils.setProperty(voObj,name,java.sql.Time.valueOf(data));
	 				}
	            	//BigDecimal
	            	else if(cls.isAssignableFrom(java.math.BigDecimal.class)&&!"".equals(data.trim())){
	 					PropertyUtils.setProperty(voObj,name,new java.math.BigDecimal(data));
	 				}                	
	            	//boolean/Boolean
	            	else if(cls.isAssignableFrom(boolean.class)&&!"".equals(data.trim())){
	 					PropertyUtils.setProperty(voObj,name,Boolean.parseBoolean(data));
	 				}else if(cls.isAssignableFrom(Boolean.class)&&!"".equals(data.trim())){
	 					PropertyUtils.setProperty(voObj,name,new Boolean(data));
	 				}
	            	//String
	            	else if(cls.isAssignableFrom(String.class)){
	 					PropertyUtils.setProperty(voObj,name,data);
	 				}
	            	
	            	//Object
	            	else{
	            		
	 				}
    			}
            }catch(NoSuchMethodException e) { 
    			if (log.isErrorEnabled()) {
    				log.error("NoSuchMethodException:"+e);
    			}
    			throw new Exception(e);
            }catch(IllegalAccessException e){
    			if (log.isErrorEnabled()) {
    				log.error("NoSuchMethodException:"+e);
    			}
    			throw new Exception(e);
            }catch(InvocationTargetException e){
    			if (log.isErrorEnabled()) {
    				log.error("NoSuchMethodException:"+e);
    			}
    			throw new Exception(e);
            } catch (ParseException e) {
    			if (log.isErrorEnabled()) {
    				log.error("NoSuchMethodException:"+e);
    			}
    			throw new Exception(e);
			}
        }
	}
}
