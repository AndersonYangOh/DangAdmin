/**
 * com.tydic.dbs.system.organize.bo.SysOrganizeBo.java
 */
package com.chinauicom.research.rudang.system.organize.service.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.organize.dao.SysOrganizeDao;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;

/**
 * @file  SysOrganizeBo.java
 * @author liugaolin
 * @version 0.1
 * @SysOrganize业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysOrganizeBo implements SysOrganizeService {
	@Autowired
	private SysOrganizeDao sysOrganizeDao;

    /**
	 * @param sysOrganizeDao the sysOrganizeDao to set
	 */
	public void setSysOrganizeDao(SysOrganizeDao sysOrganizeDao) {
		this.sysOrganizeDao = sysOrganizeDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysOrganize> getAll() throws Exception {
		return sysOrganizeDao.selectAll();
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
		return sysOrganizeDao.queryForPage(params);
	}
    public Page getPageByParamMap1(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return sysOrganizeDao.queryForPagePa(params);
	}
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysOrganize get(String pkId) throws Exception{
		if(pkId==null) return null;
     	return sysOrganizeDao.selectByPk(pkId);
	}
	public List selectByVo(SysOrganize vo) throws Exception {
		if(vo==null) return null;
     	return sysOrganizeDao.selectByVo(vo);
	}
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : RpDir 返回插入操作是否成功
     * @throws Exception
     */
    public SysOrganize save(SysOrganize vo, int flag) throws Exception{
    	if(vo == null) return null;		
		if(flag != 0) {
			return sysOrganizeDao.updateByVo(vo);
		} else {
			return sysOrganizeDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysOrganizeDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysOrganize vo) throws Exception{
    	if(vo == null) return false;
     	return sysOrganizeDao.deleteByVo(vo);
    }
    
    /**
	 * 逻辑删除数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean deleteLogical(List<String> ids, String modifier) throws Exception{
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", "0");
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysOrganizeDao.updateStatus(params);
	}
	
    /**
	 * 恢复已逻辑删除的数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean recover(List<String> ids, String modifier) throws Exception{
		Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", "1");
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysOrganizeDao.updateStatus(params);
	}

	/**
     * 根据父组织机构编码获取旗下所有子组织机构信息
     * @param parentOrgCode 父组织机构编码
     * @return
	 * @throws Exception
	 * @remark 当传入父组织结构编码为空时，查询所有组织机构信息
     */
	public List<SysOrganize> getByParentOrgCode(String parentOrgCode) throws Exception {
		List<SysOrganize> data = null;
		if (null == parentOrgCode || parentOrgCode.trim().length() == 0){
			
			data = sysOrganizeDao.selectAll();
		}else{
			data = sysOrganizeDao.selectByParentOrgCode(parentOrgCode);
		}
		
		return data;
	}
	/**
	 * 删除菜单
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean deleteByPks(List ids) throws Exception{
		
    	return sysOrganizeDao.deleteByPks(ids);
	}

}
