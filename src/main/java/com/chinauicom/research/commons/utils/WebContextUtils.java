package com.chinauicom.research.commons.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

/**
 * Copyright(C)  广州天源迪科信息技术有限公司
 *
 * Module: 东南亚电信项目
 * @author  叶子丰
 * @version
 * @see
 * @since 2014-11-27
 * @description: web应用工具，如获取国际化资源
 * @log:
 */
public class WebContextUtils {

	/**
	* @description:根据code获取国际化信息
	* @param msgCode
	* @param defaultText
	* @return String
	* @author wuxiaoxue  2013-12-26
	 */
	public static String getLocaleMessage(String msgCode,String defaultText){
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		final Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request); 
		final WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request);
		return  ctx.getMessage(msgCode,null,defaultText, locale);  
	}
	
	/***
	 * 
	 * @description: 获取国际化语言代码和国际代码
	 * @return
	 */
	public static String getLocaleType(){
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Locale locale=(Locale) WebUtils.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if(locale==null){
			return "zh_CN";
		}
		String language=locale.getLanguage();
		String country=locale.getCountry();
		return language+"_"+country;
	}
}
