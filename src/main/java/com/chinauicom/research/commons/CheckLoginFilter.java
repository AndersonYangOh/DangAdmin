package com.chinauicom.research.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;

/**
 * @file CheckLoginFilter.java
 * @author 刘高林
 * @version 0.1
 * @CheckLoginFilter验证用户是否过滤器
 * Copyright(C), 2013-2014
 *		  GuangZhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-3-26 上午10:39:35
 *      	Author: 刘高林
 *      	Modification: this file was created
 *   	2. Remark:
 *   		用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面
 *   		
 */
public class CheckLoginFilter implements Filter {

	/**
	 * loginStrings:对登录页面不进行过滤
	 * includeStrings:只对指定过滤参数后缀进行过滤
	 * redirectURL:如果用户未登录，则重定向到指定的页面,URL不包括 ContextPath
	 * disableFilter:过滤器是否有效(Y表示过滤无效)
	 */
	public FilterConfig config;

	public void destroy() {
		this.config = null;
	}

	public static boolean isContains(String container, String[] regx) {
		boolean result = false;
		for (int i = 0; i < regx.length; i++) {
			if (container.indexOf(regx[i]) != -1) {
				return true;
			}
		}
		return result;
	}

	@SuppressWarnings("static-access")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);

		//参数获取
		String loginStrings = config.getInitParameter("loginStrings"); //登录登陆页面
		String includeStrings = config.getInitParameter("includeStrings");//过滤资源后缀参数
		String redirectPath = hrequest.getContextPath() + "/" + config.getInitParameter("redirectUrl");//没有登陆转向页面
		String disablefilter = config.getInitParameter("disableFilter");//过滤器是否有效

		if (disablefilter.toUpperCase().equals("Y")) { // 过滤无效
			chain.doFilter(request, response);
			return;
		}
		String[] logonList = loginStrings.split(";");
		String[] includeList = includeStrings.split(";");

		if (!this.isContains(hrequest.getRequestURI(), includeList)) {//只对指定过滤参数后缀进行过滤
			chain.doFilter(request, response);
			return;
		}
		if (this.isContains(hrequest.getRequestURI(), logonList)) {//对登录页面不进行过滤
			chain.doFilter(request, response);
			return;
		}
		SysOperator user = (SysOperator) hrequest.getSession().getAttribute(WcsSessionConstant.SESSION_OPERATOR);//判断用户是否登录
		if (user == null) {
			wrapper.sendRedirect(redirectPath);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

}
