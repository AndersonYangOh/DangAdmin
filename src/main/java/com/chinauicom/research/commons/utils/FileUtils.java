/**
 * com.tydic.commons.utils.FileUtils.java
 */
package com.chinauicom.research.commons.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

 /**
 * @file  FileUtils.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo 文件处理类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-24
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class FileUtils {

	/**
	 * 文件复制
	 * @param fromFile
	 * @param toFile
	 * @throws Exception
	 */
	public static void copyFile(String fromFile, String toFile) throws Exception{
		File oldFile = new File(fromFile);
		File newFile = new File(toFile);
		if(oldFile.exists()){
			FileInputStream fis = new FileInputStream(oldFile);
			FileOutputStream fos = new FileOutputStream(newFile);				
			byte[] buf = new byte[1024];
			int i = 0;
			while((i=fis.read(buf))!=-1) {
				fos.write(buf, 0, i);
			}
			fis.close();
			fos.close();
		}
	}
	
	/**
	 * 把一个字符串写到文件
	 * @param filePath
	 * @param value
	 * @throws Exception
	 */
	public static void writeStringToFile(String filePath,String value)throws Exception{
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
		out.write(value);
		out.close();
		  
	}
	
	/**
	 * 把一个字符串写到文件
	 * @param file
	 * @param value
	 * @throws Exception
	 */
	public static void writeStringToFile(File file,String value)throws Exception{
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		out.write(value);
		out.close();
		  
	}
	
	/**
	 * 以UTF-8编码从文件中读取内容
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String readTextFromFileUsedUTF8(String filePath) throws Exception{
		StringBuffer ret=new StringBuffer();
		String charsetName = "UTF-8";   
		InputStreamReader insReader = new InputStreamReader(new FileInputStream(filePath), charsetName);  
        BufferedReader bufReader = new BufferedReader(insReader);  
        String line = null;
        while ((line = bufReader.readLine()) != null) {  
        	ret.append(line); 
        }  
        bufReader.close();  
        insReader.close();  
        return ret.toString();
	}
	
	
}
