
package com.chinauicom.research.rudang.system.menu.service.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.dao.SysFunOperateDao;
import com.chinauicom.research.rudang.system.menu.entity.SysFunOperate;
import com.chinauicom.research.rudang.system.menu.service.SysFunOperateService;

/**
 * @file  SysFunOperateBo.java
 * @author liugaolin
 * @version 0.1
 * @SysFunOperate业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysFunOperateBo implements SysFunOperateService {
	@Autowired
	private SysFunOperateDao sysFunOperateDao;
	

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    @SuppressWarnings("unchecked")
	public List<SysFunOperate> getAll() throws Exception {
		return sysFunOperateDao.selectAll();
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
    public List get(SysFunOperate vo) throws Exception{
		if(vo == null) return null;
        return sysFunOperateDao.selectByVo(vo);
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
		return sysFunOperateDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysFunOperate get(String pkId) throws Exception{
		if(pkId==null) return null;
     	return sysFunOperateDao.selectByPk(pkId);
	}
	
	/**
	 * 根据菜单编码获取所有操作功能列表
	 * @param menuCode 菜单编码
	 * @return
	 * @throws Exception
	 */
	public List<SysFunOperate> getByMenuCode(String menuCode) throws Exception {
		if (null == menuCode || menuCode.trim().length() == 0)
			return null;
		return sysFunOperateDao.selectByMenuCode(menuCode);
	}
	
	/**
	 * 根据操作员ID、菜单编码获取用户拥有权限操作的操作功能列表
	 * @param menuCode 菜单编码
	 * @param operId 当前登录操作员编码
	 * @return
	 * @throws Exception
	 */
	public List<SysFunOperate> getHasAuthFunOperateByMenuCodeAndOperId(String menuCode, String operId) throws Exception {
		return sysFunOperateDao.selectHasAuthFunOperateByMenuCodeAndOperId(menuCode, operId);
	}
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : RpDir 返回插入操作是否成功
     * @throws Exception
     */
    public SysFunOperate save(SysFunOperate vo, int flag) throws Exception{
    	if(vo == null)
    		return null;		
		if(flag != 0) {
			return sysFunOperateDao.updateByVo(vo);
		} else {
			return sysFunOperateDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysFunOperateDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysFunOperate vo) throws Exception{
    	if(vo == null) return false;
     	return sysFunOperateDao.deleteByVo(vo);
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
    	return sysFunOperateDao.updateStatus(params);
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
    	return sysFunOperateDao.updateStatus(params);
	}

}
