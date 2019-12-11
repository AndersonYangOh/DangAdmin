/*
 * com.tydic.dbs.obh.controller  2014-12-31
 *
 * Copyright 2010 Shenzhen TYDIC Information Technology Co.,Ltd.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.chinauicom.research.commons.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
 * @ClassName: ErrorAction
 * @Description: 错误控制器 
 * @author zjl
 * @date 2016-7-29
 *  
 */
@Controller
public class ErrorAction {

	/****
	 * 
	 * @Title: notFind 
	 * @Description: 404错误 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
    @RequestMapping("/404.do")
    public String notFind(){

        return "error/error";
    }
    
    @RequestMapping("/500.do")
    public String sysError(ModelMap model){
    	return "error/error";
    }
}
