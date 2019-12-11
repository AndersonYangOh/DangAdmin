/**
 * com.tydic.dbs.system.menu.dao.SysFunOperateDao.java
 */
package com.chinauicom.research.rudang.system.menu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.entity.SysFunOperate;
import com.chinauicom.research.rudang.system.role.entity.SysRoleOperate;

/**
 * 
 * @ClassName: SysFunOperateDao 
 * @Description: TODO(菜单按钮关系数据操作) 
 * @author huangChuQin
 * @date 2016-7-28 下午8:35:51 
 *
 */
@Repository
public class SysFunOperateDao extends BaseDao {
	
	public Page queryByParams(String sqlDef, @SuppressWarnings("rawtypes") Map params, int currPage, int pageSize) throws Exception {
		return queryForPage(sqlDef, params, currPage, pageSize);
	}
	
	public Page queryByParams(@SuppressWarnings("rawtypes") Map params, int currPage,	int pageSize) throws Exception {
		return queryForPage("SYS_FUN_OPERATE.selectByParams", params, currPage, pageSize);
	}
	
	public Page queryForPage(String sqlDef, @SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage(sqlDef, params, null);
	}
	
	public Page queryForPage(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("SYS_FUN_OPERATE.selectByParams", params, null);
	}
	
    /**
	 * 对数据库进行查询并返回一个VO数组
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectAll() throws Exception {
		return queryForList("SYS_FUN_OPERATE.selectAll", null);
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
	public List<SysFunOperate> selectByParamMap(@SuppressWarnings("rawtypes") Map paramMap) throws Exception {
	    return queryForList("SYS_FUN_OPERATE.selectByParams", paramMap);
	}
	
	/**
	 * 搜索数据库中所有与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectByVo(SysFunOperate vo) throws Exception {
	    if(vo == null) return null;
	    return queryForList("SYS_FUN_OPERATE.selectByVO", vo);
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
        	sqlStr = "SYS_FUN_OPERATE.selectAll";
        }else {
        	sqlStr = "SYS_FUN_OPERATE.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
     /**
     * 实现翻页
     * @param {Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(SysFunOperate vo, int pageIndex, int perPageSize) throws Exception {
        String sqlStr = "";
        if(vo == null) {
        	sqlStr = "SYS_FUN_OPERATE.selectAll";
        }else {
        	sqlStr = "SYS_FUN_OPERATE.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
    /**
     * 搜索数据库中与传入的主键对应的记录
     * @param pkid 与数据库主键对应
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public SysFunOperate selectByPk(String pkId) throws Exception {
    	if(pkId ==null) return null;
    	return (SysFunOperate)queryForObject("SYS_FUN_OPERATE.selectByPk", pkId);
    }
    
    /**
	 * 根据菜单编码获取所有操作功能列表
	 * @param menuCode 菜单编码
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public List<SysFunOperate> selectByMenuCode(String menuCode) throws Exception {
    	if(menuCode == null)
    		return null;
    	return queryForList("SYS_FUN_OPERATE.selectByMenuCode", menuCode);
    }
    
    /**
	 * 根据菜单编码获取用户拥有权限操作的操作功能列表
	 * @param menuCode 菜单编码
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public List<SysFunOperate> selectHasAuthFunOperateByMenuCodeAndOperId(String menuCode, String operId) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("menuCode", menuCode);
    	map.put("operId", operId);
    	return queryForList("SYS_FUN_OPERATE.selectHasAuthFunOperateByMenuCodeAndOperId", map);
    }
    
	/**
	 * 向数据库中插入一个VO对象
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysFunOperate insertByVo(SysFunOperate vo) throws Exception {
	    if(vo == null) return null;
	    return (SysFunOperate)insert("SYS_FUN_OPERATE.insertByVo", vo);
    }
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysFunOperate updateByVo(SysFunOperate vo) throws Exception {
		if(vo == null) return null;
		update("SYS_FUN_OPERATE.updateByVO", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysFunOperate updateByVoNotNull(SysFunOperate vo) throws Exception {
		if(vo == null) return null;
		update("SYS_FUN_OPERATE.updateByVoNotNull", vo);
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
    	getSqlSession().update("SYS_FUN_OPERATE.updateStatus", params);
    	return true;
    }
	   
	/**
	 * 删除数据库中所有记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		return delete("SYS_FUN_OPERATE.deleteAll", null) > 0?true:false;
	}
	

	/**
	 * 删除数据库中与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteByVo(SysFunOperate vo) throws Exception {
		if(vo == null) return false;
		int i = delete("SYS_FUN_OPERATE.deleteByVO", vo);
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
		delete("SYS_FUN_OPERATE.deleteByPk", pkId);
		return true;
	}
    
    /**
     * 根据角色menuCode删除菜单按钮关系
     * @param menuCode
     */
	public boolean deleteByMenuCode(String menuCode) throws Exception {
		if(menuCode == null)
			return false;
		//删除按钮角色关系
		getSqlSession().delete("SYS_FUN_OPERATE.deleteByMenuCode", menuCode);
		//删除菜单按钮关系
		getSqlSession().delete("SYS_FUN_OPERATE.deleteByMenuCode2", menuCode);
		return true;
	}

    /**
     * 根据角色roleCode删除角色按钮关系
     * @param roleCode
     */
	public boolean deleteByRoleCode(String roleCode) throws Exception {
		if(roleCode == null)
			return false;
		getSqlSession().delete("SYS_FUN_OPERATE.deleteByRoleCode", roleCode);
		return true;
	}

	/**
	 * 根据角色roleCode添加角色按钮关系
	 * @param sysFunOperate 使用operateDesc的存放roleCode
	 * @throws Exception 
	 */
	public void insertByVoRoleCode(SysFunOperate sysFunOperate) throws Exception {
		if(sysFunOperate != null)
			insert("SYS_FUN_OPERATE.insertByVoRoleCode", sysFunOperate);
	}
	
	public boolean delByRoleAndOperateCode(Map <String,Object> map){
		if(map ==null){
			return false;
		}
		getSqlSession().delete("SYS_ROLE_OPERATE.delByRoleAndOperateCode", map);
		return true;
	}
	
	
	public void addSysRoleOperateBatch(List<SysRoleOperate> paramList) throws Exception {
		if(paramList ==null){
			return ;
		}
		getSqlSession().insert("SYS_ROLE_OPERATE.addSysRoleOperateBatch", paramList);  
	}  
}
