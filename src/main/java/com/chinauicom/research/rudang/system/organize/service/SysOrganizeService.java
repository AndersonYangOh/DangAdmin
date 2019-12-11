/**
 * com.tydic.dbs.system.organize.service.SysOrganizeService.java
 */
package com.chinauicom.research.rudang.system.organize.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;

/**
 * @file  SysOrganizeService.java
 * @author liugaolin
 * @version 0.1
 * @SysOrganize业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2016-07-27 05:42:53
 *      	Author: 钟家梁
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract interface SysOrganizeService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysOrganize> getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception;
    public Page getPageByParamMap1(@SuppressWarnings("rawtypes") Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysOrganize get(String pkId) throws Exception;
	public List selectByVo(SysOrganize vo) throws Exception ;
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysOrganize save(SysOrganize vo, int flag) throws Exception;
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception;
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean deleteByPks(List pkId) throws Exception;
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysOrganize vo) throws Exception;
    
    /**
     * 根据ids逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param modifier 修改者
     * @return
     * @throws Exception
     */
    public boolean deleteLogical(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据ids恢复数据权限数据信息（将数据状态置为有效）
     * @param ids 数据权限集合
     * @param modifier 修改者
     * @return
     * @throws Exception
     */
    public boolean recover(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据父组织机构编码获取旗下所有子组织机构信息，当父组织机构编码为空时，默认查询所有组织机构数据
     * @param parentOrgCode 父组织机构编码
     * @return
     */
    public abstract List<SysOrganize> getByParentOrgCode(String parentOrgCode) throws Exception;
    
}
