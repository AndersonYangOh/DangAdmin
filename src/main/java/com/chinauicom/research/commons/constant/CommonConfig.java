/*
 * com.sunrise.wcs.obh.common  2015-1-28
 *
 * Copyright 2010 Shenzhen TYDIC Information Technology Co.,Ltd.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.chinauicom.research.commons.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/** 
 * @ClassName: CommonConfig 
 * @Description: TODO 注入累
 * @author Carson haoyuyang@tydic.com 
 * @date 2015-1-28 上午11:12:51 
 *  
 */
@Component
public class CommonConfig implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 8270367415397285438L;
	@Value("${http.path}")
	public static String httpPath;
	@Value("${http.encode}")
	public static String httpEncode;
	@Value("${http.key}")
	public static String httpKey;
	@Value("${ftp.path}")
	public static String ftpPath;
	@Value("${ftp.user}")
	public static String ftpUser;
	@Value("${ftp.pwd}")
	public static String ftpPwd;
	@Value("${http.service.path}")
	public static String httpServicePath;
	
	
	private String prdAuditUrl;


	public String getHttpEncode() {
		return httpEncode;
	}

	public String getHttpPath() {
		return httpPath;
	}

	public String getHttpKey() {
		return httpKey;
	}

	public String getFtpPath() {
		return ftpPath;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPwd() {
		return ftpPwd;
	}

	public void setFtpPwd(String ftpPwd) {
		this.ftpPwd = ftpPwd;
	}

	public void setHttpPath(String httpPath) {
		this.httpPath = httpPath;
	}

	public void setHttpEncode(String httpEncode) {
		this.httpEncode = httpEncode;
	}

	public void setHttpKey(String httpKey) {
		this.httpKey = httpKey;
	}

	public void setFtpPath(String ftpPath) {
		this.ftpPath = ftpPath;
	}

	public String getHttpServicePath() {
		return httpServicePath;
	}

	public void setHttpServicePath(String httpServicePath) {
		this.httpServicePath = httpServicePath;
	}



	public String getPrdAuditUrl() {
		return prdAuditUrl;
	}

	public void setPrdAuditUrl(String prdAuditUrl) {
		this.prdAuditUrl = prdAuditUrl;
	}
	
	
}
