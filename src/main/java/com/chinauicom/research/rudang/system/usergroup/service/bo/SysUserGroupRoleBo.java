/**
 * com.tydic.dbs.system.userGroup.bo.SysUserGroupRoleBo.java
 */
package com.chinauicom.research.rudang.system.usergroup.service.bo;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.usergroup.dao.SysUserGroupRoleDao;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroupRole;
import com.chinauicom.research.rudang.system.usergroup.service.SysUserGroupRoleService;

/**
 * @file  SysUserGroupRoleBo.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroupRole业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-04 11:32:48
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysUserGroupRoleBo implements SysUserGroupRoleService {
	
	private SysUserGroupRoleDao sysUserGroupRoleDao;

    /**
	 * @param sysUserGroupRoleDao the sysUserGroupRoleDao to set
	 */
	public void setSysUserGroupRoleDao(SysUserGroupRoleDao sysUserGroupRoleDao) {
		this.sysUserGroupRoleDao = sysUserGroupRoleDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysUserGroupRole> getAll() throws Exception {
		return sysUserGroupRoleDao.selectAll();
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
    public List<SysUserGroupRole> get(SysUserGroupRole vo) throws Exception{
		if(vo == null) return null;
        return sysUserGroupRoleDao.selectByVo(vo);
	}
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
    public Page getPageByParamMap(Map params) throws Exception{
		if (params == null) return null;
		return sysUserGroupRoleDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysUserGroupRole get(Long pkId) throws Exception{
		if(pkId==null) return null;
     	return sysUserGroupRoleDao.selectByPk(pkId);
	}
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : RpDir 返回插入操作是否成功
     * @throws Exception
     */
    public SysUserGroupRole save(SysUserGroupRole vo) throws Exception{
    	if(vo == null) return null;		
		if(vo.getGrpRoleId()!=null) {
			return sysUserGroupRoleDao.updateByVo(vo);
		} else {
			return sysUserGroupRoleDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(Long pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysUserGroupRoleDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysUserGroupRole vo) throws Exception{
    	if(vo == null) return false;
     	return sysUserGroupRoleDao.deleteByVo(vo);
    }

    /**
     * 批量新增用户组与角色关系数据
     * @param userGroupRoleArray 用户组与角色关系数据
     * @return
     * @throws Exception
     */
	public boolean batchInsertUserGrouRole(List<SysUserGroupRole> userGroupRoleArray) throws Exception {
		if (CollectionUtils.isEmpty(userGroupRoleArray))
			return false;
		return sysUserGroupRoleDao.batchInsertUserGrouRole(userGroupRoleArray);
	}

	/**
     * 删除用户组角色关系对象
     * @param vo 用户组角色关系对象
     * @return
     * @throws Exception
     */
	public boolean deleteByVo(SysUserGroupRole vo) throws Exception {
		if (null == vo)
			return false;
		return sysUserGroupRoleDao.deleteByVo(vo);
	}

	/**
     * 根据用户组编码获取用户组与角色关系数据
     * @param roleCode 角色编码
     * @return
     * @throws Exception
     */
    public List<SysUserGroupRole> getUserGroupRoleByGroCode(String groCode) throws Exception {
    	if (StringUtils.isEmpty(groCode))
    		return null;
    	return sysUserGroupRoleDao.selectByGroCode(groCode);
    }

    /**
     * 根据对象获取其数据
     * @param vo
     * @return
     * @throws Exception
     */
	public List<SysUserGroupRole> getByVo(SysUserGroupRole vo) throws Exception {
		if (null == vo)
			return null;
		return sysUserGroupRoleDao.selectByVo(vo);
	}
	
}
