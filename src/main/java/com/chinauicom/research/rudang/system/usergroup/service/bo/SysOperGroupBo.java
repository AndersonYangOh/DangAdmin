/**
 * com.tydic.dbs.bo.SysOperGroupBo.java
 */
package com.chinauicom.research.rudang.system.usergroup.service.bo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.usergroup.dao.SysOperGroupDao;
import com.chinauicom.research.rudang.system.usergroup.entity.SysOperGroup;
import com.chinauicom.research.rudang.system.usergroup.service.SysOperGroupService;

/**
 * @file  SysOperGroupBo.java
 * @author liugaolin
 * @version 0.1
 * @SysOperGroup业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysOperGroupBo implements SysOperGroupService {
	
	private SysOperGroupDao sysOperGroupDao;

    /**
	 * @param sysOperGroupDao the sysOperGroupDao to set
	 */
	public void setSysOperGroupDao(SysOperGroupDao sysOperGroupDao) {
		this.sysOperGroupDao = sysOperGroupDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysOperGroup> getAll() throws Exception {
		return sysOperGroupDao.selectAll();
	}
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null) return null;
		return sysOperGroupDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysOperGroup get(Long pkId) throws Exception{
		if(pkId==null) return null;
     	return sysOperGroupDao.selectByPk(pkId);
	}
	
	/**
     * 向数据库中插入/修改一条记录
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysOperGroup save(SysOperGroup vo, int flag) throws Exception{
    	if(vo == null)
    		return null;		
		if(flag != 0) {
			return sysOperGroupDao.updateByVo(vo);
		} else {
			return sysOperGroupDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(Long pkId) throws Exception{
    	if(pkId == null)
    		return false;
    	return sysOperGroupDao.deleteByPk(pkId);
    }

    /**
     * 根据操纵员ID删除操作员与用户组间关系
     * @param groCode 用户组编码
     * @return
     * @throws Exception
     */
	public boolean deleteByGroCode(String groCode) throws Exception {
		return sysOperGroupDao.deleteByGroCode(groCode);
	}

	/**
     * 根据用户组编码删除操作员与用户组间关系
     * @param groCode 用户组编码
     * @return
     * @throws Exception
     */
	public boolean deleteByOperId(String operId) throws Exception {
		return sysOperGroupDao.deleteByOperId(operId);
	}

}
