/**
 *com.tydic.wcs.basicConfig.basRegion.dao.BasRegionDao.java
 */
package com.chinauicom.research.rudang.system.basregion.dao;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.commons.utils.Utils;
import com.chinauicom.research.rudang.system.basregion.entity.BasRegion;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @file  BasRegionDao.java
 * @author caipeimin
 * @version 0.1
 * @BasRegion数据操作类
 * Copyright(C), 2013-2014
 *		  Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:00:51
 *      	Author: caipeimin
 *      	Modification: this file was created
 *   	2. ...
 */
@Repository
public class BasRegionDao extends BaseDao {
	/**
	 * 生成一个主键
	 * @return
	 * @throws Exception
	 */
	public String getPKValue() throws Exception{
		return Utils.getUUID();
	}
	
	@SuppressWarnings("rawtypes")
	public Page queryForPage(String sqlDef, Map params) throws Exception {
		return this.queryForPage(sqlDef, params, null);
	}
	
	@SuppressWarnings("rawtypes")
	public Page queryForPage(Map params) throws Exception {
		return this.queryForPage("BAS_REGION.selectByParams", params, null);
	}
	
    /**
	 * 对数据库进行查询并返回一个VO数组
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectAll() throws Exception {
		return queryForList("BAS_REGION.selectAll", null);
	}
	
	/**
     * 在本方法中组装出一个Map{[数据库列名:值],[数据库列名:值]}对象调用myBatis相关方法

	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectByParamMap(Map paramMap) throws Exception {
	    return queryForList("BAS_REGION.selectByParams", paramMap);
	}
	
	/**
	 * 在本方法中组装出一个Map{[数据库列名:值],[数据库列名:值]}对象调用myBatis相关方法(新增的数据权限控制方法)

	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectByParamMap(String sqlDef , Map paramMap) throws Exception {
		return queryForList(sqlDef, paramMap);
	}
	
	/**
	 * 搜索数据库中所有与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectByVo(BasRegion vo) throws Exception {
	    if(vo == null) return null;
	    return queryForList("BAS_REGION.selectByVO", vo);
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
        	sqlStr = "BAS_REGION.selectAll";
        }else {
        	sqlStr = "BAS_REGION.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
     /**
     * 实现翻页
     * @param {Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(BasRegion vo, int pageIndex, int perPageSize) throws Exception {
        String sqlStr = "";
        if(vo == null) {
        	sqlStr = "BAS_REGION.selectAll";
        }else {
        	sqlStr = "BAS_REGION.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
    /**
     * 搜索数据库中与传入的主键对应的记录
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public BasRegion selectByPk(String pkId) throws Exception {
    	if(pkId ==null) return null;
    	return (BasRegion)getSqlSession().selectOne("BAS_REGION.selectByPk", pkId);
    }
    
	/**
	 * 向数据库中插入一个VO对象
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : 
	 * @throws Exception
	 */
	public BasRegion insertByVo(BasRegion vo) throws Exception {
	    if(vo == null) return null;
	    return (BasRegion)insert("BAS_REGION.insertByVo", vo);
    }
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public BasRegion updateByVo(BasRegion vo) throws Exception {
		if(vo == null) return null;
		update("BAS_REGION.updateByVO", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public BasRegion updateByVoNotNull(BasRegion vo) throws Exception {
		if(vo == null) return null;
		update("BAS_REGION.updateByVoNotNull", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象的状态
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
    @SuppressWarnings("rawtypes")
	public boolean updateStatus(Map params) throws Exception {
    	if(params == null) return false;
    	getSqlSession().update("BAS_REGION.updateStatus", params);
    	return true;
    }
	   
	/**
	 * 删除数据库中所有记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		return getSqlSession().delete("BAS_REGION.deleteAll", null) > 0?true:false;
	}
	

	/**
	 * 删除数据库中与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteByVo(BasRegion vo) throws Exception {
		if(vo == null) return false;
		int i = delete("BAS_REGION.deleteByVO", vo);
		return i==0?false:true;
	}
	
    /**
	 * 删除数据库中与传入的主键对应的一条记录
	 * @return type : boolean 返回删除操作是否成功,如果传入参数为空则返回false,如果操作失败则抛出Exception异常
	 * @throws Exception
	 */
    public boolean deleteByPk(String pkId) throws Exception {
		if(pkId == null) return false;
		getSqlSession().delete("BAS_REGION.deleteByPk", pkId);
		return true;
	}
    
	/**
	 * 增加数据权限参数
	 * @param param sql语句所要用到的参数
	 * @return
	 * @throws Exception 
	 */
	/*@SuppressWarnings("rawtypes")
	protected Map addDataPermissionParam(Map param) throws Exception {
		if (param.containsKey(CommonConstant.OPER_ID)) {
			String operId = (String) param.get(CommonConstant.OPER_ID);
			SysPermission sysPermission = PermissionHelper.getInstance().getPermissionByOperatorId(operId);
			
			if (sysPermission != null) {
				if (WcsDefinition.WcsOperatorType.WCS_OPER_TYPE_PROVINCE.equals(sysPermission.getOperType())) {
					param.put("mallCodeIn", sysPermission.getMallCodeList());
				} else if (WcsDefinition.WcsOperatorType.WCS_OPER_TYPE_CITY.equals(sysPermission.getOperType())) {
					param.put("mallCodeIn", sysPermission.getMallCodeList());
					param.put("regionCodeIn", sysPermission.getRegionCodes());
				} else if (WcsDefinition.WcsOperatorType.WCS_OPER_TYPE_CHANNEL.equals(sysPermission.getOperType())) {
					param.put("parentChannelIdStartWith", sysPermission.getChannelId());
				}
			}
		}
		return param;
	}*/
}
