/**
 * com.tydic.dbs.system.userGroup.dao.SysUserGroupRoleDao.java
 */
package com.chinauicom.research.rudang.system.usergroup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroupRole;

/**
 * @file  SysUserGroupRoleDao.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroupRole数据操作类
 * Copyright(C), 2013-2014
 *		  Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-04 11:32:48
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
public class SysUserGroupRoleDao extends BaseDao {
	
	public Page queryByParams(String sqlDef, @SuppressWarnings("rawtypes") Map params, int currPage, int pageSize) throws Exception {
		return queryForPage(sqlDef, params, currPage, pageSize);
	}
	
	public Page queryByParams(@SuppressWarnings("rawtypes") Map params, int currPage,	int pageSize) throws Exception {
		return queryForPage("SYS_USER_GROUP_ROLE.selectByParams", params, currPage, pageSize);
	}
	
	public Page queryForPage(String sqlDef, @SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage(sqlDef, params, null);
	}
	
	public Page queryForPage(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("SYS_USER_GROUP_ROLE.selectByParams", params, null);
	}
	
    /**
	 * 对数据库进行查询并返回一个VO数组
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public List<SysUserGroupRole> selectAll() throws Exception {
		return queryForList("SYS_USER_GROUP_ROLE.selectAll", null);
	}
	
	/**
     * 在本方法中组装出一个Map{[数据库列名:值],[数据库列名:值]}对象调用myBatis相关方法
	 * @param valueOne 需要进行查询的值。
	 * @param valueTwo 需要进行查询的值。
	 * @param valueThree 需要进行查询的值。
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysUserGroupRole> selectByParamMap(@SuppressWarnings("rawtypes") Map paramMap) throws Exception {
	    return queryForList("SYS_USER_GROUP_ROLE.selectByParams", paramMap);
	}
	
	/**
	 * 搜索数据库中所有与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysUserGroupRole> selectByVo(SysUserGroupRole vo) throws Exception {
	    if(vo == null) return null;
	    return queryForList("SYS_USER_GROUP_ROLE.selectByVO", vo);
	}
	
    /**
     * 实现翻页
     * @param condition condition{Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(@SuppressWarnings("rawtypes") Map condition) throws Exception {
        if(condition == null) return null;
        int pageIndex = ((Integer) condition.get("currPage")).intValue();
        int perPageSize = ((Integer) condition.get("pageSize")).intValue();
        String sqlStr = "";
        BaseVO vo = (BaseVO) condition.get("Vo");
        if(vo == null) {
        	sqlStr = "SYS_USER_GROUP_ROLE.selectAll";
        }else {
        	sqlStr = "SYS_USER_GROUP_ROLE.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
     /**
     * 实现翻页
     * @param {Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(SysUserGroupRole vo, int pageIndex, int perPageSize) throws Exception {
        String sqlStr = "";
        if(vo == null) {
        	sqlStr = "SYS_USER_GROUP_ROLE.selectAll";
        }else {
        	sqlStr = "SYS_USER_GROUP_ROLE.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
    /**
     * 搜索数据库中与传入的主键对应的记录
     * @param pkid 与数据库主键对应
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public SysUserGroupRole selectByPk(Long pkId) throws Exception {
    	if(pkId ==null) return null;
    	return (SysUserGroupRole)queryForObject("SYS_USER_GROUP_ROLE.selectByPk", pkId);
    }
    
	/**
	 * 向数据库中插入一个VO对象
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysUserGroupRole insertByVo(SysUserGroupRole vo) throws Exception {
	    if(vo == null) return null;
	    return (SysUserGroupRole)insert("SYS_USER_GROUP_ROLE.insertByVo", vo);
    }
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysUserGroupRole updateByVo(SysUserGroupRole vo) throws Exception {
		if(vo == null) return null;
		update("SYS_USER_GROUP_ROLE.updateByVO", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysUserGroupRole updateByVoNotNull(SysUserGroupRole vo) throws Exception {
		if(vo == null) return null;
		update("SYS_USER_GROUP_ROLE.updateByVoNotNull", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象的状态
	 * @param map: <ids: Id列表>, <status: 状态>, <modifier: 修改者>
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
    public boolean updateStatus(Map params) throws Exception {
    	if(params == null) return false;
    	getSqlSession().update("SYS_USER_GROUP_ROLE.updateStatus", params);
    	return true;
    }
	   
	/**
	 * 删除数据库中所有记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		return delete("SYS_USER_GROUP_ROLE.deleteAll", null) > 0?true:false;
	}
	

	/**
	 * 删除数据库中与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteByVo(SysUserGroupRole vo) throws Exception {
		if(vo == null) return false;
		int i = delete("SYS_USER_GROUP_ROLE.deleteByVO", vo);
		return i==0?false:true;
	}
	
    /**
	 * 删除数据库中与传入的主键对应的一条记录
	 * @param pkid 与数据库主键对应
	 * @return type : boolean 返回删除操作是否成功,如果传入参数为空则返回false,如果操作失败则抛出Exception异常
	 * @throws Exception
	 */
    public boolean deleteByPk(Long pkId) throws Exception {
		if(pkId == null) return false;
		delete("SYS_USER_GROUP_ROLE.deleteByPk", pkId);
		return true;
	}
    
    /**
	 * 删除数据库中与传入的主键对应的一条记录
	 * @param pkid 与数据库主键对应
	 * @return type : boolean 返回删除操作是否成功,如果传入参数为空则返回false,如果操作失败则抛出Exception异常
	 * @throws Exception
	 */
    public boolean deleteByGroCode(String groCode) throws Exception {
		if(groCode == null)
			return false;
		delete("SYS_USER_GROUP_ROLE.deleteByGroCode", groCode);
		return true;
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
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("userGroupRoleArray", userGroupRoleArray);
    	getSqlSession().insert("SYS_USER_GROUP_ROLE.batchInsertByVo", map);
    	return true;
    }
    
    /**
     * 根据用户组编码获取用户组角色关系数据
     * @param roleCode 角色数据
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<SysUserGroupRole> selectByGroCode(String groCode) throws Exception {
    	if (StringUtils.isEmpty(groCode))
    		return null;
    	return queryForList("SYS_USER_GROUP_ROLE.selectByGroCode", groCode);
    }
    
}
