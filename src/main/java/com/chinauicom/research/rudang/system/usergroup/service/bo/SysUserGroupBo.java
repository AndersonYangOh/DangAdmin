/**
 * com.tydic.dbs.system.userGroup.bo.SysUserGroupBo.java
 */
package com.chinauicom.research.rudang.system.usergroup.service.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.role.entity.SysRole;
import com.chinauicom.research.rudang.system.usergroup.dao.SysUserGroupDao;
import com.chinauicom.research.rudang.system.usergroup.dao.SysUserGroupRoleDao;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroup;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroupRole;
import com.chinauicom.research.rudang.system.usergroup.service.SysUserGroupService;

/**
 * @file  SysUserGroupBo.java
 * @author liugaolin
 * @version 0.1
 * @SysUserGroup业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-03-03 02:29:42
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class SysUserGroupBo implements SysUserGroupService {
	
	private SysUserGroupDao sysUserGroupDao;
	private SysUserGroupRoleDao sysUserGroupRoleDao;

    /**
	 * @param sysUserGroupDao the sysUserGroupDao to set
	 */
	public void setSysUserGroupDao(SysUserGroupDao sysUserGroupDao) {
		this.sysUserGroupDao = sysUserGroupDao;
	}
	/**
	 * @param sysUserGroupRoleDao the sysUserGroupDao to set
	 */
	public void setSysUserGroupRoleDao(SysUserGroupRoleDao sysUserGroupRoleDao) {
		this.sysUserGroupRoleDao = sysUserGroupRoleDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
	public List<SysUserGroup> getAll() throws Exception {
		return sysUserGroupDao.selectAll();
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	public List<SysUserGroup> get(SysUserGroup vo) throws Exception{
		if(vo == null) return null;
        return sysUserGroupDao.selectByVo(vo);
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
		return sysUserGroupDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysUserGroup get(String pkId) throws Exception{
		if(pkId==null) return null;
     	return sysUserGroupDao.selectByPk(pkId);
	}
	
	/**
     * 向数据库中插入/修改一条数据记录
     * @param vo 与数据库中记录对应的值对象
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public SysUserGroup save(SysUserGroup vo, int flag) throws Exception{
    	if(vo == null)
    		return null;		
		if(flag != 0) {
			/**判断是否关联角色信息*/
			List<SysRole> sysRoleList = vo.getSysRoleList();
			if (CollectionUtils.isNotEmpty(sysRoleList)) {
				/**根据用户组编码删除原有关联数据*/
				boolean bool = sysUserGroupRoleDao.deleteByGroCode(vo.getGroCode());
				if (bool) {
					for (SysRole sysRole : sysRoleList) {
						SysUserGroupRole groRole = new SysUserGroupRole();
						groRole.setGroCode(vo.getGroCode());
						groRole.setRoleCode(sysRole.getRoleCode());
						groRole.setCreater(vo.getCreater());
						groRole.setCreateTime(Calendar.getInstance().getTime());
						sysUserGroupRoleDao.insertByVo(groRole);
					}
				} else {
					throw new Exception("数据修改失败，根据用户组编码删除用户组角色关系数据失败。");
				}
			}
			return sysUserGroupDao.updateByVoNotNull(vo);
		} else {
			/**判断用户组编码是否存在*/
			if (null != vo.getGroCode() && vo.getGroCode().trim().length() > 0) {
				SysUserGroup userGroup = sysUserGroupDao.selectByPk(vo.getGroCode().trim());
				if (null != userGroup) {
					throw new Exception("数据新增失败，新增用户组编码已存在。");
				} else {
					/**判断是否关联角色信息*/
					List<SysRole> sysRoleList = vo.getSysRoleList();
					if (!CollectionUtils.isEmpty(sysRoleList)) {
						/**根据用户组编码删除原有关联数据*/
						boolean bool = sysUserGroupRoleDao.deleteByGroCode(vo.getGroCode());
						if (bool) {
							for (SysRole sysRole : sysRoleList) {
								SysUserGroupRole groRole = new SysUserGroupRole();
								groRole.setGroCode(vo.getGroCode());
								groRole.setRoleCode(sysRole.getRoleCode());
								groRole.setCreater(vo.getCreater());
								groRole.setCreateTime(Calendar.getInstance().getTime());
								sysUserGroupRoleDao.insertByVo(groRole);
							}
						} else {
							throw new Exception("数据新增失败，根据用户组编码删除用户组角色关系数据失败。");
						}
					}
					return sysUserGroupDao.insertByVo(vo);
				}
			} else {
				throw new Exception("数据新增失败，新增用户组编码数据为空。");
			}
		}
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception{
    	if(pkId == null) return false;
    	return sysUserGroupDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysUserGroup vo) throws Exception{
    	if(vo == null) return false;
     	return sysUserGroupDao.deleteByVo(vo);
    }
    
    /**
	 * 逻辑删除数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean deleteLogical(List ids, String modifier) throws Exception{
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", "0");
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysUserGroupDao.updateStatus(params);
	}
	
    /**
	 * 恢复已逻辑删除的数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean recover(List ids, String modifier) throws Exception{
    	Map params = new HashMap();
    	params.put("ids", ids);
    	params.put("status", "1");
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysUserGroupDao.updateStatus(params);
	}
	
	/**
	 * 根据操作员编码信息获取用户组信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Page getPageByOper(@SuppressWarnings("rawtypes") Map params) throws Exception {
		if (null == params || params.isEmpty())
			return null;
		return sysUserGroupDao.selectByOper(params);
	}
}
