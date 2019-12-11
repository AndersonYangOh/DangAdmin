/**
 * com.tydic.commons.utils.DataTransUtils.java
 */
package com.chinauicom.research.commons.utils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 /**
 * @file  DataTransUtils.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 数据转换常用方法类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-6-2
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class DataTransUtils {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DEFAULT_FORMAT_DAY = "yyyy-MM-dd";

    
    /**
     * 字符串转换成日期 如果转换格式为空，则利用默认格式进行转换操作
     * @param str 字符串
     * @param format 日期格式
     * @return 日期
     * @throws java.text.ParseException 
     */
    public static Date str2Date(String str, String format){
	   	if (null == str || "".equals(str)) {
	   		return null;
	   	}
	   	// 如果没有指定字符串转换的格式，则用默认格式进行转换
	   	if (null == format || "".equals(format)) {
	   		format = DEFAULT_FORMAT;
	   	}
	   	SimpleDateFormat sdf = new SimpleDateFormat(format);
	   	Date date = null;
	   	try {
	   		date = sdf.parse(str);
	   		return date;
	   	} catch (ParseException e) {
	   		e.printStackTrace();
	   	}
	   	return null;
    }

    /** 日期转换为字符串
     * @param date 日期
     * @param format 日期格式
     * @return 字符串
     */
    public static String date2Str(Date date, String format) {
	     if (null == date) {
	    	 return null;
	     }
	     SimpleDateFormat sdf = new SimpleDateFormat(format);
	     return sdf.format(date);
    }
    
    /**
     * 时间戳转换为字符串
     * @param time
     * @return
     */
    public static String timestamp2Str(Timestamp time) {
	     Date date = null;
	     if(null != time){
	    	 date = new Date(time.getTime());
	     }
	     return date2Str(date, DEFAULT_FORMAT);
    }
    
    /**
     * 时间戳转换为字符串
     * @param time
     * @return
     */
    public static String timestamp2DayStr(Timestamp time) {
	     Date date = null;
	     if(null != time){
	    	 date = new Date(time.getTime());
	     }
	     return date2Str(date, DEFAULT_FORMAT_DAY);
    }
    
    /** 字符串转换时间戳
     * @param str
     * @return
     */
    public static Timestamp str2Timestamp(String str) {
    	 if(str==null)return null;
    	 if(str.length()<11){
    		 str=str+" 00:00:00";
    	 }
	     Date date = str2Date(str, DEFAULT_FORMAT);
	     return new Timestamp(date.getTime());
    }
    
    /**
     * 字符转为大数字
     * @param str
     * @return
     */
    public static BigDecimal str2BD(String str){
    	if(str==null)return new BigDecimal("0");
    	return new BigDecimal(str);
    }
    
    /**
     * 字符转为大数字
     * @param str
     * @return
     */
    public static BigDecimal int2BD(int str){
    	return new BigDecimal(""+str);
    }
    
    /**
     * oracle.sql.TIMESTAMP 类型 格式化为String
     * 页面TabLib用到，己加入到custom.tld
     */
    
    public static String formatTimeStamp( Timestamp ts , String formatStr){
    	try {  
            if (formatStr == null || formatStr.equals("")) {  
                formatStr = "yyyy-MM-dd hh:mm:ss";  
            }  
            java.sql.Timestamp tt;  
            tt = ts;  
            Date date = new Date(tt.getTime());  
            SimpleDateFormat sd = new SimpleDateFormat(formatStr);  
            return sd.format(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }
    
    public static String substr(String str , int maxLength){
    	if(str == null){
    		str = "";
    	}
    	if(str.length() > maxLength){
    		return str.substring(0, maxLength -1)+"...";
    	}else{
    		return str;
    	}
    }
    
}
