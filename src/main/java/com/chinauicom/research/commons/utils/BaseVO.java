package com.chinauicom.research.commons.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

 /**
 * @file  BaseVO.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo VO基类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract class BaseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123L;
	public static final String P_VO="Vo";
	protected String orderBy;
	protected String descOrAsc;
	
	private String creater;
	private String modifier;
	private Date createTime;
	private Date modifyTime;

	 private String status;
	
	/**
	 * @return
	 */
	public String getOrderBy() {
		if ( this.orderBy == null ) return null ;
				else return "".equals(this.orderBy.trim())?null:this.orderBy;
	}

	/**
	 * @param string
	 */
	public void setOrderBy(String string) {
		this.orderBy = string == null?null:string.trim();
	}


	
	/**
	 * @return
	 */
	public String getDescOrAsc() {
		if ( this.descOrAsc == null ) return null ;
				else return "".equals(this.descOrAsc.trim())?null:this.descOrAsc;
	}

	/**
	 * @param string
	 */
	public void setDescOrAsc(String string) {
		this.descOrAsc = string == null?null:string.trim();
	}
	
	/**
	 * 功能：打印对象所有数据
	 */
	public String toString(){
		return ToStringUtil.toString(this);
	}
	
    public BaseVO clone() throws CloneNotSupportedException { 
    	Object result = super.clone(); 
    	return (BaseVO)result; 
    } 
	
    /**
     * 功能：把一个MAP中存的数据库对应的字段值转为VO对象[设计规范如：CL_FILE_DATA]
     * @param m
     * @throws CommonException 
     */
    public void setMap(Map m) throws Exception{
		Iterator it=m.keySet().iterator();		
		while(it.hasNext()){
			String key=(String)it.next();
			String[] f=key.split("_");
			String field="";
			for(int k=0;k<f.length;k++){
				if(k==0){
					field+=f[k].toLowerCase();
				}else{
					if(f[k]!=null){//处理FI_情况
						String first=""+f[k].charAt(0);
						if(f[k].length()<2){
							field+=first.toUpperCase();
						}else{
							field+=first.toUpperCase()+(f[k].substring(1)).toLowerCase();
						}
					}
				}			
			}
			ReflectUtil.setValue(this, field, String.valueOf(m.get(key)));
		}
    }
    
    /**
     * 功能：把一个MAP中存的对象字段值转为VO对象[设计规范如：ftId]
     * @param m
     * @throws CommonException 
     */
    public void set(Map m) throws Exception{
		Iterator it=m.keySet().iterator();		
		while(it.hasNext()){
			String key=(String)it.next();
			if(m.get(key)!=null&&!"null".equals(String.valueOf(m.get(key)).trim())){
				ReflectUtil.setValue(this, key, String.valueOf(m.get(key)));
			}
		}
    }
    
    /**
     * Bean转map
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Map toMap() throws IntrospectionException, IllegalAccessException, InvocationTargetException { 
        Class type = this.getClass(); 
        Map returnMap = new HashMap(); 
        BeanInfo beanInfo = Introspector.getBeanInfo(type);  
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors(); 
        for (int i = 0; i< propertyDescriptors.length; i++) { 
            PropertyDescriptor descriptor = propertyDescriptors[i]; 
            String propertyName = descriptor.getName(); 
            if (!propertyName.equals("class")) { 
                Method readMethod = descriptor.getReadMethod(); 
                if(readMethod!=null){
	                Object result = readMethod.invoke(this, new Object[0]); 
	                if (result != null) { 
	                    returnMap.put(propertyName, result); 
	                } else { 
	                    returnMap.put(propertyName, ""); 
	                } 
                }
            } 
        } 
        return returnMap; 
    }

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modify_time) {
		this.modifyTime = modify_time;
	}


	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }
 }
