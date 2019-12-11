/**
 * com.tydic.dbs.basicConfig.basRegion.bo.BasRegionService.java
 */
package com.chinauicom.research.rudang.system.basregion.service;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.basregion.entity.BasRegion;

import java.util.List;
import java.util.Map;

/**
 * @file  BasRegionService.java
 * @author caipeimin
 * @version 0.1
 * @BasRegion业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:00:51
 *      	Author: caipeimin
 *      	Modification: this file was created
 *   	2. ...
 */
public  interface BasRegionService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public List<BasRegion> getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page.list<BasRegion> 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
    public Page getPageByParamMap(Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public BasRegion get(String pkId) throws Exception;
	
	/**
     * 查找符合条件的所有数据库记录

     * @param lang 语种
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public BasRegion get(String pkId, String lang) throws Exception;
	
	/**
     * 查找符合条件的所有数据库记录

     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	public List getByParamMap(Map paramMap) throws Exception;
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	public List get(BasRegion vo) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param physicsStockId 物理仓库ID
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public List<BasRegion> getBasRegionAncestorsByPhysicsStockId(Long physicsStockId, String lang) throws Exception;
	
	/**
	 * 查找符合条件的所有数据库记录
	 * @param physicsStockId 物理仓库ID
	 * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
	 * @throws Exception
	 */
	public List<BasRegion> getBasRegionAncestorsByPhysicsStockId(Long physicsStockId, String lang, Map<String, Object> params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param regionCode 区域编码
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public List<BasRegion> getBasRegionChildsByRegionCode(String regionCode, String lang) throws Exception;
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public BasRegion save(BasRegion vo) throws Exception;
    
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public BasRegion updateByVoNotNull(BasRegion vo) throws Exception;
    
	/**
     * 向数据库中更新一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    public BasRegion update(BasRegion vo) throws Exception;
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception;
    
    /**
	 * 逻辑删除数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public abstract boolean deleteLogical(List ids, String modifier) throws Exception;
	
    /**
	 * 恢复已逻辑删除的数据库中的对象
	 * @param ids: Id列表, modifier: 修改者
	 * @return type : boolean 返回操作是否成功
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public abstract boolean recover(List ids, String modifier) throws Exception;
	
    /**
	 * 校验对象在数据库中是否存在
	 * @param regionCode: 地区编码 regionName:区域名称
	 * @return type : boolean 返回校验结果
	 * @throws Exception
	 */
	public abstract boolean validateExist(String regionCode, String regionName) throws Exception;
	
	/**
     * 查找广东所有地市数据库记录 返回Map<code, name>  有序的
     * @throws Exception
     */
	public Map<String, String> getCityRegionByMap() throws Exception;
	
	/**
     * 查找广东所有地市数据库记录 返回Map<code, name>  有序的
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getCityRegionByList() throws Exception;
	/**
     * 查找符合条件的所有数据库记录
     * @param regionCode 区域编码
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getBasRegionChilds(String regionCode, String lang) throws Exception;
}
