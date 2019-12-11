/**
 * com.tydic.dbs.system.menu.service.SysMenuService.java
 */
package com.chinauicom.research.rudang.system.menu.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.entity.SysMenu;

/**
 * @file  SysMenuService.java
 * @author liugaolin
 * @version 0.1
 * @SysMenu业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public  interface SysMenuService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public  List<SysMenu> getAll() throws Exception;
    
    /**
     * 根据父菜单编码递归获取旗下所有子菜单信息
     * @param parentMenuCode 父菜单编码
     * @return
     * @throws Exception
     */
    public abstract List<SysMenu> getMenuByParentMenuCode(String parentMenuCode) throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public abstract Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public abstract SysMenu get(String pkId) throws Exception;
	
	/**
	 * 根据操作员ID获取操作员角色关联菜单信息
	 * @param operId 操作员ID(必填)
	 * @param status 菜单状态(可选)
	 * @param menuCode 菜单编码(可选)
	 * @param parentMenuCode 父菜单(可选)
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> getByParams(String operId, String status, String menuCode, String parentMenuCode) throws Exception;
	
	/**
     * 数据新增/修改操作
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作类型（0新增  1修改）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public  SysMenu save(SysMenu vo, int flag) throws Exception;

    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public abstract boolean delete(String pkId) throws Exception;
    
    /**
     * 根据ids逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    public abstract boolean deleteLogical(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据ids恢复数据权限数据信息（将数据状态置为有效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    public abstract boolean recover(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据父菜单编码、菜单状态递归查询菜单数据
     * @param params
     * @return
     * @throws Exception
     */
    public abstract Page getMenusByParams(Map<String, Object> params) throws Exception;
    
    /**
     * 根据父菜单编码逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    public abstract boolean deleteMenuByParentCodes(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据角色编码获取菜单数据
     * @param roleCode 角色编码
     * @return
     * @throws Exception
     */
	public abstract List<SysMenu> getByRoleCode(String roleCode) throws Exception;

    /**
     * 查询菜单详情
     * @param map
     * @return
     * @throws Exception
     */
    public List selectMenuByMap(Map map)throws Exception;

    public SysMenu updateMenu(SysMenu vo)throws Exception;
}
