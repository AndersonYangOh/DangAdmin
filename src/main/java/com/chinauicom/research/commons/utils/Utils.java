/**
 * com.tydic.commons.utils.Utils.java
 */
package com.chinauicom.research.commons.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;


 /**
 * @file  Utils.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 基本处理类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class Utils {
	/**
	 * 取得UUID数据
	 * @return
	 */
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	
	/**
	 * 字符转整型
	 * @param value
	 * @return
	 */
	public static Integer toInteger(String value){
		if(value==null||"".equals(value))return new Integer(0);
		return new Integer(value);
	}
	
	/**
	 * 转为整型
	 * @param value
	 * @return
	 */
	public static int toInt(String value){
		return Utils.toInteger(value).intValue();
	}
	
	/**
	 * 字符串Null处理
	 * @param value
	 * @return
	 */
	public static String disNull(String value){
		return value==null?"--":value;
	}
	
	/**
	 * 把非数字转为数字
	 * @param value
	 * @return
	 */
	public static String toDoubleString(String value){
		String ret="0";
		try{
			ret=Double.parseDouble(value)+"";
		}catch(Exception e){}
		return ret;
	}
	
	/**
	 * 字符串Null处理
	 * @param value
	 * @return
	 */
	public static String NULL(String value){
		return value==null?"":value;
	}
	
	/**
	 * 字符串Null处理
	 * @param value
	 * @return
	 */
	public static String NULL_ZIRO(String value){
		return null;
	}
	
	/**
	 * HTML字符串Null处理
	 * @param value
	 * @return
	 */
	public static String htmlDisNull(String value){
		if(value==null){
			value="--";
		}
		return "".equals(value)?"--":value;
	}
	
	public static String getString(String data,String defaults){
		
		if(StringUtils.isEmpty(data)){
			return defaults;
		}
		else{
			return data;
		}
	}
	
	/**
	 * 把逗号转为特别的字符
	 * @param str
	 * @return
	 */
	public static String replaceSplit(String str){
		if(str!=null){
			str=str.replaceAll(",", "▓");
		}
		return str;
	}
	
	/**
	 * 根据时间计算相对时间,用于报表计算相对规则
	 * @param date 需要计算的相对时间
	 * @param cntCode
	 * cntCode :1.20130813 2.201308 3.-1 -2 1 2(相对时间)   
	 * @param type1--日 2--月
	 * @return
	 */
	public static Date getRelaTime(Date date ,String cntCode,int type){
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		try{
		//计算相对时间
		 cntCode =StringUtils.isEmpty(cntCode)?"0":cntCode;
		 
		 //6-8位排除
		 if(cntCode.length()==8||cntCode.length()==6){
			Date rtnTime= DateUtils.parseDate(cntCode, "yyyyMMdd","yyyyMM");
			return rtnTime;
		 }
		 else{
			//根据指标情况选择计算月 or日
			 int calType=0;
			 if(calType>0){
				 cal.add(calType, Integer.valueOf(cntCode)); 
				 return cal.getTime();
			 }
		 }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

	
	
	/**
	 * 忽略相同时间
	 * @param tar
	 * @param source
	 * @param type
	 * @return 0 相等 1 tar大 -1 source 大
	 */
	public static int compareTime(Date tar,Date source,int type){
		String format=null;
			String tar_parse=org.apache.commons.lang.time.DateFormatUtils.format(tar, format);
			String source_parse=org.apache.commons.lang.time.DateFormatUtils.format(source, format);
			if(tar_parse.equals(source_parse)){
				return 0;
			}
			if(tar.after(source)){
				return 1;
			}
			else{
				return -1;
			}
	}
	
	/**
	 * 返回长度为【strLength】的随机数，在前面补0 
	 * @param strLength 字符长度
	 * @return
	 */
	public static String getFixLenthString(int strLength) {  
	      
	    Random rm = new Random();  
	      
	    // 获得随机数  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	} 
	
}
