/**
 * com.tydic.commons.dao.BaseDao.java
 */
package com.chinauicom.research.commons.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;

import com.chinauicom.research.commons.utils.BaseVO;
import com.chinauicom.research.commons.utils.DateUtil;
import com.chinauicom.research.commons.utils.Page;

 /**
 * @file  BaseDao.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo DAO基本操作类
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public abstract class BaseDao extends SqlSessionDaoSupport {
	private static final String ORDER_BY = "orderBy";
	
	private static final String CONVERTED_ORDER_BY = "convertedOrderBy";
	
	/**
	 * 基础库连接
	 */
	protected JdbcTemplate jt;	
	
	/**
	 * Cache库连接
	 */
	protected JdbcTemplate cacheJt;
	
	/**
	 * @param jt the cacheJt to set
	 */
	public void setCacheJdbcTemplate(JdbcTemplate jt) {
		this.cacheJt = jt;
	}
	
	/**
	 * @param jt the jt to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	/**
	 * 功能：查询获取查询结果
	 * @param sqlDef	sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @return		List对象，里面是VO对象。
	 */
	@SuppressWarnings({ "rawtypes" })
	public  List queryForList(String sqlDef, Object param)throws Exception{
		addDataPermissionParam(param);
		convertOrderBy(param);
		return  getSqlSession().selectList(sqlDef,param);
	}
	
	/**
	 * 功能：查询获取查询结果的某一页的记录数据
	 * @param sqlDef	sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param starNum	开始记录的位置
	 * @param num	获取的记录个数
	 * @return		List对象，里面是VO对象。
	 */
	@SuppressWarnings({ "rawtypes" })
	public  List queryForPageList(String  sqlDef,Object param,int starNum,int num)throws Exception{
		return  getSqlSession().selectList(sqlDef, param, new RowBounds(starNum,num));
	}
	
	/**
	 * 功能：查询获取查询结果的某一页对象
	 * @param sqlDef	获取查询结果sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param currPage	当前页码
	 * @param pageSize	每页记录个数
	 * @return		Page对象
	 */	
	public  Page  queryForPage(String  sqlDef,Object param,int currPage,int pageSize)throws Exception{
		return  this.queryForPage(sqlDef,param,currPage,pageSize,sqlDef+"Count");
	}
	
	/**
	 * 功能：查询获取查询结果的某一页对象
	 * @param sqlDef	获取查询结果sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param currPage	当前页码
	 * @param pageSize	每页记录个数
	 * @param getCountSqlDef	获取记录总数sql语句的定义名称
	 * @return		Page对象
	 */	
	public Page  queryForPage(String  sqlDef,Object param,int currPage,int pageSize,String getCountSqlDef)throws Exception{
		if(getCountSqlDef==null){
			getCountSqlDef = sqlDef+"Count";
		}
		addDataPermissionParam(param);
		convertOrderBy(param);
		logger.info("查询总记录数的开始时间：："+DateUtil.DateToString5(new Date()));
		/*获取查询结果的记录总数*/
		int total = ((Integer)getSqlSession().selectOne(getCountSqlDef,param)).intValue();	
		logger.info("查询总记录数的结束时间：："+DateUtil.DateToString5(new Date()));
		int  pageIndex = currPage-1;
		pageIndex = pageIndex<0?0:pageIndex;
		currPage = currPage<1?1:currPage;
		/*开始记录的位置*/
		int  startNum = 0;
		startNum = pageIndex*(pageSize<1?1:pageSize);
		logger.info("查询分页数量的开始时间：："+DateUtil.DateToString5(new Date()));
		@SuppressWarnings("rawtypes")
		List  list = getSqlSession().selectList(sqlDef, param, new RowBounds(startNum,pageSize));
////		Gson gson = new Gson();
//		logger.info(new XStream().toXML(list));


		logger.info("查询分页数量的结束时间：："+DateUtil.DateToString5(new Date()));
		return new Page(list, pageSize,total,currPage);
	}
	
	/**
	 * 功能：查询获取查询结果的某一页对象
	 * @param sqlDef	获取查询结果sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param currPage	当前页码
	 * @param pageSize	每页记录个数
	 * @param getCountSqlDef	获取记录总数sql语句的定义名称
	 * @return		Page对象
	 */	
	public Page  queryNumberForPage(String  sqlDef,Object param,int currPage,int pageSize,String getCountSqlDef)throws Exception{
		if(getCountSqlDef==null){
			getCountSqlDef = sqlDef+"Count";
		}
		addDataPermissionParam(param);
		convertOrderBy(param);
		
		/*获取查询结果的记录总数*/
		int total = 0;	
		int  pageIndex = currPage-1;
		pageIndex = pageIndex<0?0:pageIndex;
		currPage = currPage<1?1:currPage;
		/*开始记录的位置*/
		int  startNum = 0;
		startNum = pageIndex*(pageSize<1?1:pageSize);
		
		@SuppressWarnings("rawtypes")
//		List  list = getSqlSession().selectList(sqlDef, param);
		List  list = getSqlSession().selectList(sqlDef, param, new RowBounds(startNum,pageSize));	
		if(null!=list && list.size()>0){
			if(list.size()>=0 && list.size()<=100){
				total=list.size();
			}else{
				total=100;
			}
		}else{
			total=0;
		}
		return new Page(list, pageSize,total,currPage);
	}
	
	/**
	 * 功能：根据查询参数查询并获取查询结果的所有对象或者某一页
	 * @param sqlDef	获取查询结果sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param getCountSqlDef	获取记录总数sql语句的定义名称
	 * @return		Page对象
	 */	
	@SuppressWarnings("rawtypes")
	public Page queryForPage(String sqlDef, Map map, String getCountSqlDef)throws Exception{
		if(getCountSqlDef==null){
			getCountSqlDef = sqlDef+"Count";
		}
		
		List list = null;
		
//		convertOrderBy(map);		//Convert the formats of orderBy param
		if(Boolean.TRUE.equals(map.get("pageTop"))){
			int currPage, pageSize;
			if (map.get(Page.CURR_PAGE) != null){
				currPage = (Integer) map.get(Page.CURR_PAGE);
			}else{
				currPage = 1;
			}
			
			if(map.get(Page.PAGE_SIZE) != null){
				pageSize = (Integer) map.get(Page.PAGE_SIZE);
			}else{
				pageSize = Page.DEFAULT_PAGE_SIZE;
			}

			int  pageIndex = currPage-1;
			pageIndex = pageIndex<0?0:pageIndex;
			currPage = currPage<1?1:currPage;
			/*开始记录的位置*/
			int  startNum = 0;
			startNum = pageIndex*(pageSize<1?1:pageSize);
			int total = 0;
			
			list = getSqlSession().selectList(sqlDef, map, new RowBounds(startNum,pageSize));
			if(CollectionUtils.isNotEmpty(list)){
				total = list.size();
			}
			
			return new Page(list, pageSize,total,currPage);
		}else if (Boolean.TRUE.equals(map.get("noPaging"))) {
			list = queryForList(sqlDef, map);
			
			/*获取查询结果的记录总数*/
			int total = ((Integer)getSqlSession().selectOne(getCountSqlDef,map)).intValue();
			
			Page page = new Page();
			page.setList(list);
			page.setCurrentPage(1);
			page.setPageSize(total);
			page.setTotalPage(1);
			page.setTotalNumber(total);
			return page;
		} else {
			int currPage, pageSize;
			if (map.get(Page.CURR_PAGE) != null && map.get(Page.PAGE_SIZE) != null) {
				currPage = (Integer) map.get(Page.CURR_PAGE);
				pageSize = (Integer) map.get(Page.PAGE_SIZE);
			} else if (map.get(Page.CURR_PAGE) != null) {
				currPage = (Integer) map.get(Page.CURR_PAGE);
				pageSize = Page.DEFAULT_PAGE_SIZE;
			} else {
				currPage = 1;
				pageSize = Page.DEFAULT_PAGE_SIZE;
			}
			return queryForPage(sqlDef, map, currPage, pageSize, getCountSqlDef);
		}
	}
	
	
	/**
	 * 功能：根据查询参数查询并获取查询结果的所有对象或者某一页
	 * @param sqlDef	获取查询结果sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @param getCountSqlDef	获取记录总数sql语句的定义名称
	 * @return		Page对象
	 */	
	@SuppressWarnings("rawtypes")
	public Page queryNumberForPage(String sqlDef, Map map, String getCountSqlDef)throws Exception{
		if(getCountSqlDef==null){
			getCountSqlDef = sqlDef+"Count";
		}
		
		List list = null;
		
		int currPage, pageSize;
		if (map.get(Page.CURR_PAGE) != null && map.get(Page.PAGE_SIZE) != null) {
			currPage = (Integer) map.get(Page.CURR_PAGE);
			pageSize = (Integer) map.get(Page.PAGE_SIZE);
		} else if (map.get(Page.CURR_PAGE) != null) {
			currPage = (Integer) map.get(Page.CURR_PAGE);
			pageSize = Page.DEFAULT_PAGE_SIZE;
		} else {
			currPage = 1;
			pageSize = Page.DEFAULT_PAGE_SIZE;
		}
		return queryNumberForPage(sqlDef, map, currPage, pageSize, getCountSqlDef);
	}
	
	/**
	 * 功能：查询获取查询结果,只有一条记录
	 * @param sqlDef	sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @return		BaseVO对象。
	 */	
	public  BaseVO  queryForObject(String  sqlDef,Object param)throws Exception{
		return  (BaseVO)getSqlSession().selectOne(sqlDef,param);
	}
	
	/**
	 * 功能：查询获取查询结果,只有一条记录
	 * @param sqlDef
	 * 				sql语句的定义名称
	 * @return BaseVO对象。
	 */	
	public BaseVO queryForObject(String sqlDef) 
			throws Exception {
		return (BaseVO)getSqlSession().selectOne(sqlDef);
	}
	
	public  Object  queryForExtObject(String  sqlDef,Object param)throws Exception{
		return  getSqlSession().selectOne(sqlDef,param);
	}
	
	/**
	 * 功能：查询获取查询结果,只有一条记录
	 * @param sqlDef	sql语句的定义名称
	 * @param param	查询所要用到的参数
	 * @return		Object对象。
	 */	
	public  Object  queryToObject(String  sqlDef,Object param)throws Exception{
		return  (Object)getSqlSession().selectOne(sqlDef,param);
	}
	
	/**
	 * 功能：向数据库中插入一条数据记录
	 * @param sqlDef	sql语句的定义名称
	 * @param vo		VO对象
	 * @return	VO对象
	 */
	public  Object  insert(String  sqlDef,Object vo)throws Exception{
		BaseVO baseVO = (BaseVO) vo;
		Date currentTime = Calendar.getInstance().getTime();
		baseVO.setCreateTime(currentTime);
		baseVO.setModifyTime(currentTime);
		baseVO.setModifier(baseVO.getCreater());
		getSqlSession().insert(sqlDef,baseVO);
		return baseVO;
	}
	
	/**
	 * 功能：向数据库中更新一条数据记录
	 * @param sqlDef	sql语句的定义名称
	 * @param vo		VO对象
	 * @return	VO对象
	 */	
	public  Object  update(String  sqlDef,Object vo)throws Exception{
		((BaseVO) vo).setModifyTime(Calendar.getInstance().getTime());
		getSqlSession().update(sqlDef,vo);
		return  vo;		
	}
	
	/**
	 * 功能：向数据库中更新数据记录
	 * @param sqlDef	
	 * 				SQL语句的定义名称
	 * @param vo		
	 * 				VO对象
	 * @return	int
	 * 				更新记录数
	 */	
	public int updateBySqlDef(String sqlDef, Object vo) 
			throws Exception {
		((BaseVO) vo).setModifyTime(Calendar.getInstance().getTime());
		return  getSqlSession().update(sqlDef, vo);		
	}
	
	/**
	 * 功能：向数据库中更新数据记录
	 * @param sqlDef	
	 * 				SQL语句的定义名称
	 * @return	int
	 * 				更新记录数
	 */	
	public int updateBySqlDef(String sqlDef) 
			throws Exception {
		return getSqlSession().update(sqlDef);		
	}
	
	/**
	 * 功能：删除数据库中某些记录
	 * @param sqlDef	sql语句的定义名称
	 * @param param	sql语句所要用到的参数
	 * @return		删除记录个数
	 */
	public  int delete(String sqlDef,Object param)throws Exception{
		return  getSqlSession().delete(sqlDef,param);
	}
	
	/**
	 * 序列器
	 * @param seqName
	 * @return
	 */
	public long seqNextval(String seqName){
		String sql="SELECT NEXTVAL ('"+seqName+"')";
		return jt.queryForObject(sql,Long.class);
	}
	
	/**
	 * 功能：用于count sql 
	 * @param sqlDef	sql语句的定义名称
	 * @param param sql语句所要用到的参数
	 * @return
	 */
	public long queryForLong(String sqlDef,Object param){
		return (Long)getSqlSession().selectOne(sqlDef, param);
	}
	
	/**
	 * 功能：用于count sql 
	 * @param sqlDef	sql语句的定义名称
	 * @param param sql语句所要用到的参数
	 * @return
	 */
	public int queryForInt(String sqlDef,Object param){
		return (Integer)getSqlSession().selectOne(sqlDef, param);
	}
	
	/**
	 * 功能：用于转换orderBy参数的格式 
	 * @param param sql语句所要用到的参数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object convertOrderBy(Object params) {
		if (params instanceof Map) {
			Map param = (Map) params;
			if (param.containsKey(ORDER_BY)) {
				Iterator entryIterator;
				Entry<String, String> entry;
				
				List<Map<String, String>> mapList = (List<Map<String, String>>) param.get(ORDER_BY);
				List<String> orderByList = new ArrayList<String>();
				for (Map<String, String> orderByElement : mapList) {
					entryIterator = orderByElement.entrySet().iterator();
					while (entryIterator.hasNext()) {
						entry = (Entry<String, String>) entryIterator.next();
						orderByList.add(entry.getKey() + entry.getValue().substring(0, 1).toUpperCase() + entry.getValue().substring(1).toLowerCase());
					}
				}
				param.put(CONVERTED_ORDER_BY, orderByList);
			}
			return param;
		}
		return params;
	}
	
	/**
	 * 功能：用于增加数据权限参数
	 * @param param sql语句所要用到的参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Object addDataPermissionParam(Object param) throws Exception {
		/*if (param instanceof Map) {
			return addDataPermissionParam((Map) param);
		}*/
		return param;
	}
	
	/**
	 * 功能：用于增加数据权限参数，如果使用，则需要子类override 
	 * @param param sql语句所要用到的参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Map addDataPermissionParam(Map param) throws Exception {
		return param;
	}
}
