/**
 * com.tydic.dbs.system.menu.bo.SysMenuBo.java
 */
package com.chinauicom.research.rudang.system.menu.service.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.constant.CommonConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.dao.SysMenuDao;
import com.chinauicom.research.rudang.system.menu.entity.SysMenu;
import com.chinauicom.research.rudang.system.menu.service.SysMenuService;

/**
 * @file  SysMenuBo.java
 * @author liugaolin
 * @version 0.1
 * @SysMenu业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysMenuBo implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;

    /**
	 * @param sysMenuDao the sysMenuDao to set
	 */
	public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<SysMenu> getAll() throws Exception {
		return sysMenuDao.selectAll();
	}
    
    /**
     * 根据父菜单编码递归获取旗下所有子菜单信息
     * @param parentMenuCode 父菜单编码
     * @return
     * @throws Exception
     */
    public List<SysMenu> getMenuByParentMenuCode(String parentMenuCode) throws Exception {
		return sysMenuDao.selectMenuByParentMenuCode(parentMenuCode);
	}
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception{
		if (params == null)
			return null;
		return sysMenuDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysMenu get(String pkId) throws Exception{
		if(pkId==null)
			return null;
     	return sysMenuDao.selectByPk(pkId);
	}
	
	/**
	 * 根据操作员ID获取操作员角色关联菜单信息
	 * @param operId 操作员ID(必填)
	 * @param status 菜单状态(可选)
	 * @param menuCode 菜单编码(可选)
	 * @param parentMenuCode 父菜单(可选)
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> getByParams(String operId, String status, String menuCode, String parentMenuCode) throws Exception {
		if (null == operId || operId.trim().length() == 0)
			return null;
		return sysMenuDao.selectByParams(operId, status, menuCode, parentMenuCode);
	}
	
	/**
     * 菜单数据新增/修改操作
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作类型（0新增  1修改）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
	public SysMenu save(SysMenu vo, int flag) throws Exception{
    	if(vo == null)
    		return null;
		if(flag != 1) {
			if (StringUtils.isEmpty(vo.getParentMenuCode()))
				vo.setParentMenuCode(String.valueOf(CommonConstant.PARENT_ID));
			return sysMenuDao.updateByVoNotNull(vo);
		} else {
			/*判断菜单编码是否为空，如果为空，则抛出异常*/
			if (null == vo.getMenuCode() || vo.getMenuCode().trim().length() <= 0)
				throw new Exception("数据新增失败，菜单编码为空。");
			/*判断数据是否存在，如果存在，则抛出异常*/
			SysMenu _menu = sysMenuDao.selectByPk(vo.getMenuCode());
			if (null != _menu)
				throw new Exception("数据新增失败，菜单编码已存在。");
			if (StringUtils.isEmpty(vo.getParentMenuCode()))
				vo.setParentMenuCode(String.valueOf(CommonConstant.PARENT_ID));
			return sysMenuDao.insertByVo(vo);
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysMenuDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysMenu vo) throws Exception{
    	if(vo == null) return false;
     	return sysMenuDao.deleteByVo(vo);
    }
    
    /**
	 * 逻辑删除数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
    @SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public boolean deleteLogical(List<String> ids, String modifier) throws Exception{
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", WcsDefinition.WcsCommonStatus.WCS_INVALID);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysMenuDao.updateStatus(params);
	}
	
    /**
	 * 恢复已逻辑删除的数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
    @SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public boolean recover(List<String> ids, String modifier) throws Exception{
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", WcsDefinition.WcsCommonStatus.WCS_VALID);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysMenuDao.updateStatus(params);
	}

    /**
     * 根据父菜单编码、菜单状态递归查询菜单数据
     * @param params
     * @return
     * @throws Exception
     */
	public Page getMenusByParams(Map<String, Object> params) throws Exception {
		if (params == null)
			return null;
		return sysMenuDao.selectMenusByParams(params);
	}
	
	/**
     * 根据父菜单编码逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param status 数据有效状态（1有效 0无效）
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public boolean deleteMenuByParentCodes(List<String> ids, String modifier) throws Exception {
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", WcsDefinition.WcsCommonStatus.WCS_INVALID);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysMenuDao.updateStatusByParentMenuCode(params);
    }

    /**
     * 根据角色编码获取菜单数据
     * @param roleCode 角色编码
     * @return
     * @throws Exception
     */
	public List<SysMenu> getByRoleCode(String roleCode) throws Exception {
		if (StringUtils.isEmpty(roleCode))
			return null;
		return sysMenuDao.selectByRoleCode(roleCode);
	}

	public List selectMenuByMap(Map map)throws  Exception{
		if (null==map) return null;
		return sysMenuDao.selectByParamMap(map);
	}

	public SysMenu updateMenu(SysMenu vo)throws Exception{
		if (StringUtils.isEmpty(vo.getMenuCode()))return  null;
		return sysMenuDao.updateByVo(vo);
	}
}
