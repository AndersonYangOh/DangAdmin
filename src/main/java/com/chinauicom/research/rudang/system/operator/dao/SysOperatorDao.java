package com.chinauicom.research.rudang.system.operator.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinauicom.research.commons.dao.BaseDao;
import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorDetail;
/**
 * @file  SysOperatorDao.java
 * @version 0.1
 * @SysOperator数据操作类
 */
@Repository
public class SysOperatorDao extends BaseDao {
	
	public Page queryByParams(String sqlDef, @SuppressWarnings("rawtypes") Map params, int currPage, int pageSize) throws Exception {
		return queryForPage(sqlDef, params, currPage, pageSize);
	}
	
	public Page queryByParams(@SuppressWarnings("rawtypes") Map params, int currPage,	int pageSize) throws Exception {
		return queryForPage("SYS_OPERATOR.selectByParams", params, currPage, pageSize);
	}
	
	public Page queryForPage(String sqlDef, @SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage(sqlDef, params, null);
	}
	
	public Page queryForPage(@SuppressWarnings("rawtypes") Map params) throws Exception {
		return queryForPage("SYS_OPERATOR.selectByParams", params, null);
	}
	
    /**
	 * 对数据库进行查询并返回一个VO数组
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectAll() throws Exception {
		return queryForList("SYS_OPERATOR.selectAll", null);
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
	public List<SysOperator> selectByParamMap(@SuppressWarnings("rawtypes") Map paramMap) throws Exception {
	    return queryForList("SYS_OPERATOR.selectByParams", paramMap);
	}
	
	/**
	 * 搜索数据库中所有与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectByVo(SysOperator vo) throws Exception {
	    if(vo == null) return null;
	    return queryForList("SYS_OPERATOR.selectByVO", vo);
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
        	sqlStr = "SYS_OPERATOR.selectAll";
        }else {
        	sqlStr = "SYS_OPERATOR.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }
    
     /**
     * 实现翻页
     * @param {Vo:条件VO对象，currPage:当前页面数，pageSize:每页最大行数}
     * @return type : Page 返回一个分页的List，操作失败返回null
	 * @throws Exception
     */
    public Page selectForPage(SysOperator vo, int pageIndex, int perPageSize) throws Exception {
        String sqlStr = "";
        if(vo == null) {
        	sqlStr = "SYS_OPERATOR.selectAll";
        }else {
        	sqlStr = "SYS_OPERATOR.selectByVO";
        }
        return queryForPage(sqlStr , vo, pageIndex, perPageSize);
    }

    /**
     * 搜索数据库中与传入的主键对应的记录
     * @param operId 与数据库主键对应
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public SysOperator selectByPK(String operId) throws Exception {
    	if(operId ==null) return null;
    	return (SysOperator)queryForObject("SYS_OPERATOR.selectByPK", operId);
    }
    public SysOperatorDetail selectDetailByPK(String operId) throws Exception {
    	if(operId ==null) return null;
    	return (SysOperatorDetail)getSqlSession().selectOne("SYS_OPERATOR.selectDetailByPK", operId);
    }
    /**
     * 搜索数据库中与传入的主键对应的记录
     * @param operAccount 与数据库账号对应
     * @return type : 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
	 * @throws Exception
     */
    public SysOperator selectByAccount(String operAccount) throws Exception {
    	if(operAccount ==null) return null;
    	return (SysOperator)queryForObject("SYS_OPERATOR.selectByAccount", operAccount);
    }
    
	/**
	 * 向数据库中插入一个VO对象
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysOperator insertByVo(SysOperator vo) throws Exception {
	    if(vo == null) return null;
	    return (SysOperator)insert("SYS_OPERATOR.insertByVo", vo);
    }
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysOperator updateByVo(SysOperator vo) throws Exception {
		if(vo == null) return null;
		update("SYS_OPERATOR.updateByVO", vo);
		return vo;
	}
	
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public SysOperator updateByVoNotNull(SysOperator vo) throws Exception {
		if(vo == null) return null;
		update("SYS_OPERATOR.updateByVoNotNull", vo);
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
    	getSqlSession().update("SYS_OPERATOR.updateStatus", params);
    	return true;
    }
	   
	/**
	 * 删除数据库中所有记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		return delete("SYS_OPERATOR.deleteAll", null) > 0?true:false;
	}
	

	/**
	 * 删除数据库中与对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录
	 * @return type : boolean 返回删除操作是否成功
	 * @throws Exception
	 */
	public boolean deleteByVo(SysOperator vo) throws Exception {
		if(vo == null) return false;
		int i = delete("SYS_OPERATOR.deleteByVO", vo);
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
		delete("SYS_OPERATOR.deleteByPk", pkId);
		return true;
	}
    
    /**
     * 根据渠道ID、操作员状态等获取关联操作员信息
     * @return
     * @throws Exception
     */
	/*public Page selectPageByChannelId(Map<String, Object> map) throws Exception {
		if (CollectionUtils.isEmpty(map))
			return null;
    	return queryForPage("SYS_OPERATOR.selectByChannelId", map, null);
    }*/
	
	
	/**
     * 根据多个渠道ID、操作员状态等获取关联操作员信息
     * @return
     * @throws Exception
     */
	/*public Page selectOperatorByChannelId(Map<String, Object> map) throws Exception {
		if (CollectionUtils.isEmpty(map))
			return null;
    	return queryForPage("SYS_OPERATOR.selectOperatorByChannelId", map, null);
    }*/
    public void insertOperExportTable(@SuppressWarnings("rawtypes") Map params) throws Exception {
		getSqlSession().insert("SYS_OPERATOR.insertOperExportTable", params);
    }
    public void updateOperExportTable(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	getSqlSession().update("SYS_OPERATOR.updateOperExportTable", params);
	}
    public void updateOperExportTableStage(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	getSqlSession().update("SYS_OPERATOR.updateOperExportTableStage", params);
	}
    public void insertOperDetail(@SuppressWarnings("rawtypes") Map params) throws Exception {
		getSqlSession().insert("SYS_OPERATOR.insertOperDetail", params);
    }
    public void updateOperDetail(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	getSqlSession().update("SYS_OPERATOR.updateOperDetail", params);
	}
    public void insertRudangProcess(@SuppressWarnings("rawtypes") Map params) throws Exception {
		getSqlSession().insert("SYS_OPERATOR.insertRudangProcess", params);
    }
    public void insertRudangProcessByOldUser(@SuppressWarnings("rawtypes") Map params) throws Exception {
		getSqlSession().insert("SYS_OPERATOR.insertRudangProcessByOldUser", params);
    }
    public void updateRudangProcessByCreate(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	getSqlSession().update("SYS_OPERATOR.updateRudangProcessByCreate", params);
	}
}
