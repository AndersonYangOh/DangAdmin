/**
 * com.tydic.dbs.bo.SysLoginLogBo.java
 */
package com.chinauicom.research.rudang.system.log.service.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.log.dao.SysLoginLogDao;
import com.chinauicom.research.rudang.system.log.entity.SysLoginLog;
import com.chinauicom.research.rudang.system.log.service.SysLoginLogService;

/**
 * @file  SysLoginLogBo.java
 * @author liugaolin
 * @version 0.1
 * @SysLoginLog业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysLoginLogBo implements SysLoginLogService {
	@Autowired
	private SysLoginLogDao sysLoginLogDao;

    /**
	 * @param sysLoginLogDao the sysLoginLogDao to set
	 */
	public void setSysLoginLogDao(SysLoginLogDao sysLoginLogDao) {
		this.sysLoginLogDao = sysLoginLogDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
	public List<SysLoginLog> getAll() throws Exception {
		return sysLoginLogDao.selectAll();
	}
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null) return null;
		return sysLoginLogDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysLoginLog get(Long pkId) throws Exception{
		if(pkId==null) return null;
     	return sysLoginLogDao.selectByPk(pkId);
	}
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作标识（0新增 1修改）
     * @return type : RpDir 返回插入操作是否成功
     * @throws Exception
     */
    public SysLoginLog save(SysLoginLog vo, int flag) throws Exception{
    	if(vo == null)
    		return null;
		if(flag != 0) {
			return sysLoginLogDao.updateByVo(vo);
		} else {
			return sysLoginLogDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(Long pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysLoginLogDao.deleteByPk(pkId);
    }

}
