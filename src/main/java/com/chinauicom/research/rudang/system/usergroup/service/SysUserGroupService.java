/**
 * com.tydic.dbs.system.userGroup.service.SysUserGroupService.java
 */
package com.chinauicom.research.rudang.system.usergroup.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroup;

/**
 * @file  SysUserGroupService.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroup业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-03 02:29:42
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract interface SysUserGroupService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
	@SuppressWarnings({ "rawtypes" })
    public List getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public Page getPageByParamMap(Map params) throws Exception;
	
	/**
	 * 根据操作员编码信息获取用户组信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Page getPageByOper(Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysUserGroup get(String pkId) throws Exception;
	
	/**
     * 向数据库中插入/修改一条数据记录
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysUserGroup save(SysUserGroup vo, int flag) throws Exception;
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception;
    
    /**
	 * 逻辑删除数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public boolean deleteLogical(List ids, String modifier) throws Exception;
	
    /**
	 * 恢复已逻辑删除的数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public boolean recover(List ids, String modifier) throws Exception;
	
}