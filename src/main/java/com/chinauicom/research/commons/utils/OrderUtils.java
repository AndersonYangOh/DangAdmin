package com.chinauicom.research.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @file OrderUtils.java
 * @author 刘高林
 * @version 0.1
 * @OrderUtils 订单工具类
 * Copyright(C), 2013-2014
 *		  GuangZhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-4-16 下午2:38:30
 *      	Author: 刘高林
 *      	Modification: this file was created
 *   	2. ...
 */
public class OrderUtils {

	/**
	 * 商户appID生成函数 —— 规则：订单时间毫秒数（格式：A+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getAppId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "A"+buffer.toString();
	}
	/**
	 * 订单ID生成函数 —— 规则：订单时间毫秒数（格式：W+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getOrderId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "W"+buffer.toString();
	}
	/**
	 * 商户ID生成函数 —— 规则：时间毫秒数（格式：B+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getBussId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "B"+buffer.toString();
	}
	/**
	 * 租户ID生成函数 —— 规则：时间毫秒数（格式：O+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getOperId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "O"+buffer.toString();
	}
	
	/**
	 * 日志ID生成函数 —— 规则：时间毫秒数（格式：L+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getProId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "P"+buffer.toString();
	}
	
	/**
	 * 产品数据资源需求ID生成函数 —— 规则：时间毫秒数（格式：L+yyyyMMddHHmmss）+5位随机数
	 * @param 
	 * @return
	 */
	
	public static String getProDataId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(5));
		return "PD"+buffer.toString();
	}
	
	public static String generateOutTradeNo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		final String dt = sdf.format(new Date());
		StringBuffer buffer = new StringBuffer();
		buffer.append(dt);
		//5位随机数
		buffer.append(getFixLenthString(3));
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getOrderId());
		System.out.println(getBussId());
		System.out.println(getOperId());
		System.out.println(getProId());
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
