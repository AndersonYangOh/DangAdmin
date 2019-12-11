/**
 * com.tydic.dbs.system.userGroup.service.SysUserGroupRoleService.java
 */
package com.chinauicom.research.rudang.system.usergroup.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroupRole;

/**
 * @file  SysUserGroupRoleService.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroupRole业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-04 11:32:48
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract interface SysUserGroupRoleService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysUserGroupRole> getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
    public Page getPageByParamMap(Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysUserGroupRole get(Long pkId) throws Exception;
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysUserGroupRole save(SysUserGroupRole vo) throws Exception;
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(Long pkId) throws Exception;
    
    /**
     * 删除用户组角色关系对象
     * @param vo 用户组角色关系对象
     * @return
     * @throws Exception
     */
    public boolean deleteByVo(SysUserGroupRole vo) throws Exception;
    
    /**
     * 批量新增用户组与角色关系数据
     * @param userGroupRoleArray 用户组与角色关系数据
     * @return
     * @throws Exception
     */
    public boolean batchInsertUserGrouRole(List<SysUserGroupRole> userGroupRoleArray) throws Exception;
    
    /**
     * 根据用户组编码获取用户组与角色关系数据
     * @param roleCode 角色编码
     * @return
     * @throws Exception
     */
    public List<SysUserGroupRole> getUserGroupRoleByGroCode(String groCode) throws Exception;
    
    /**
     * 根据对象获取其数据
     * @param vo
     * @return
     * @throws Exception
     */
    public List<SysUserGroupRole> getByVo(SysUserGroupRole vo) throws Exception;

}
