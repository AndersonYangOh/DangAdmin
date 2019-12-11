/**
 * com.tydic.dbs.system.menu.service.SysDataFactorService.java
 */
package com.chinauicom.research.rudang.system.menu.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.entity.SysDataFactor;

/**
 * @file  SysDataFactorService.java
 * @author liugaolin
 * @version 0.1
 * @SysDataFactor业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract interface SysDataFactorService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysDataFactor> getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysDataFactor get(Long pkId) throws Exception;
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysDataFactor save(SysDataFactor vo) throws Exception;
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(Long pkId) throws Exception;
    
    /**
     * 根据ids逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    public boolean deleteLogical(List<Long> ids, String status) throws Exception;
    
    /**
     * 根据ids恢复数据权限数据信息（将数据状态置为有效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    public boolean recover(List<Long> ids, String status) throws Exception;
    
}
