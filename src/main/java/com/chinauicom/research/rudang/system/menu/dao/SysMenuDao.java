/**
 * com.tydic.dbs.system.menu.dao.SysMenuDao.java
 */
package com.chinauicom.research.rudang.system.menu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.entity.SysMenu;

/**
 * hcq @20016/7/27
 */
@Repository
public class SysMenuDao extends BaseDao {
	
	public Page queryByParams(String sqlDef, @SuppressWarnings("rawtypes") Map params, int currPage, int pageSize) throws Exception {
		return queryForPage(sqlDef, params, currPage, pageSize);
	}
	
	public Page queryByParams(@SuppressWarnings("rawtypes") Map params, int currPage,	int pageSize) throws Exception {
		return queryForPage("SYS_MENU.selectByParams", params, currPage, pageSize);
	}
	
	public Page queryForPage(String sqlDef, @SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage(sqlDef, params, null);
	}
	
	public Page queryForPage(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("SYS_MENU.selectByMap", params, null);
	}
	
	public Page selectMenusByParams(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("SYS_MENU.selectMenusByParams", params, null);
	}
	
	
    /**
	 * 对数据库进行查询并返回一个VO数组
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenu> selectAll() throws Exception {
		return queryForList("SYS_MENU.selectAll", null);
	}
	
	/**
     * 根据父菜单编码递归获取旗下所有子菜单信息
     * @param parentMenuCode 父菜单编码
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<SysMenu> selectMenuByParentMenuCode(String parentMenuCode) throws Exception {
		return queryForList("SYS_MENU.selectByParentMenuCode", parentMenuCode);
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
	public List<SysMenu> selectByParamMap(@SuppressWarnings("rawtypes") Map paramMap) throws Exception {
	    return queryForList("SYS_MENU.selectByParams", paramMap);
	}
	
	/**
	 * 搜索数据库中所有与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenu> selectByVo(SysMenu vo) throws Exception {
	    if(vo == null) return null;
	    return queryForList("SYS_MENU.selectByVO", vo);
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
        	sqlStr = "SYS_MENU.selectAll";
        }else {
        	sqlStr = "SYS_MENU.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
     /**
     * 实现翻页
     * @param {Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(SysMenu vo, int pageIndex, int perPageSize) throws Exception {
        String sqlStr = "";
        if(vo == null) {
        	sqlStr = "SYS_MENU.selectAll";
        }else {
        	sqlStr = "SYS_MENU.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
    /**
     * 搜索数据库中与传入的主键对应的记录
     * @param pkid 与数据库主键对应
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public SysMenu selectByPk(String pkId) throws Exception {
    	if(pkId ==null) return null;
    	return (SysMenu)queryForObject("SYS_MENU.selectByPk", pkId);
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
    @SuppressWarnings("unchecked")
	public List<SysMenu> selectByParams(String operId, String status, String menuCode, String parentMenuCode) throws Exception {
    	if (null == operId)
    		return null;
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("operId", operId);
    	params.put("status", status);
    	params.put("menuCode", menuCode);
    	params.put("parentMenuCode", parentMenuCode);
    	
    	//排序
    	List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("reorder", "asc");
    	orderBy.add(map);
    	params.put("orderBy", orderBy);
    	return (List<SysMenu>) queryForList("SYS_MENU.selectByOperId", params);
    }
    
	/**
	 * 向数据库中插入一个VO对象
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysMenu insertByVo(SysMenu vo) throws Exception {
	    if(vo == null) return null;
	    return (SysMenu)insert("SYS_MENU.insertByVo", vo);
    }
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysMenu updateByVo(SysMenu vo) throws Exception {
		if(vo == null) return null;
		update("SYS_MENU.updateByVO", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysMenu updateByVoNotNull(SysMenu vo) throws Exception {
		if(vo == null) return null;
		update("SYS_MENU.updateByVoNotNull", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象的状态
	 * @param map: <ids: Id列表>, <status: 状态>, <modifier: 修改者>, <modifyTime:修改时间>
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
    public boolean updateStatus(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	if(params == null) return false;
    	getSqlSession().update("SYS_MENU.updateStatus", params);
    	return true;
    }
	
	/**
	 * 根据父菜单编码更新菜单状态
	 * @param params 父菜单编码
	 * @return
	 * @throws Exception
	 */
	public boolean updateStatusByParentMenuCode(@SuppressWarnings("rawtypes") Map params) throws Exception {
		if(params == null) return false;
    		getSqlSession().update("SYS_MENU.updateStatusByParentMenuCode", params);
    	return true;
	}
	   
	/**
	 * 删除数据库中所有记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		return delete("SYS_MENU.deleteAll", null) > 0?true:false;
	}
	

	/**
	 * 删除数据库中与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteByVo(SysMenu vo) throws Exception {
		if(vo == null) return false;
		int i = delete("SYS_MENU.deleteByVO", vo);
		return i==0?false:true;
	}
	
    /**
	 * 删除数据库中与传入的主键对应的一条记录
	 * @param pkid 与数据库主键对应
	 * @return type : boolean 返回删除操作是否成功,如果传入参数为空则返回false,如果操作失败则抛出Exception异常
	 * @throws Exception
	 */
    public boolean deleteByPk(String pkId) throws Exception {
		if(pkId == null) return false;
		delete("SYS_MENU.deleteByPk", pkId);
		return true;
	}
    
    /**
     * 根据角色编码获取菜单数据
     * @param roleCode 角色编码
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<SysMenu> selectByRoleCode(String roleCode) throws Exception {
    	if (StringUtils.isEmpty(roleCode))
    		return null;
    	return queryForList("SYS_MENU.selectByRoleCode", roleCode);
    }
    
}
