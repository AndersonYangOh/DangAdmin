/**
 * com.tydic.dbs.basicConfig.basRegion.bo.BasRegionBo.java
 */
package com.chinauicom.research.rudang.system.basregion.service.bo;

import com.chinauicom.research.commons.constant.CommonConstant;
import com.chinauicom.research.commons.define.WcsCommonStatus;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.exception.BizException;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.basregion.dao.BasRegionDao;
import com.chinauicom.research.rudang.system.basregion.entity.BasRegion;
import com.chinauicom.research.rudang.system.basregion.service.BasRegionService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @file  BasRegionBo.java
 * @author caipeimin
 * @version 0.1
 * @BasRegion业务操作接口实现类
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:00:51
 *      	Author: caipeimin
 *      	Modification: this file was created
 *   	2. ...
 */
@Service
public class BasRegionBo implements BasRegionService {
	@Autowired
	private BasRegionDao basRegionDao;
	


	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	public List getByParamMap(Map paramMap) throws Exception{
		return basRegionDao.selectByParamMap(paramMap);
	}
	
	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    @SuppressWarnings("unchecked")
	public List<BasRegion> getAll() throws Exception {
		return basRegionDao.selectAll();
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes" })
    public List get(BasRegion vo) throws Exception{
		if(vo == null) return null;
        return basRegionDao.selectByVo(vo);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param physicsStockId 物理仓库ID
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getBasRegionAncestorsByPhysicsStockId(Long physicsStockId, String lang) throws Exception{
		if (physicsStockId == null) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("physicsStockId", physicsStockId);
		params.put("lang", lang);
		return basRegionDao.queryForList("BAS_REGION.selectByPhysicsStockId", params);
	}
	
	/**
	 * 查找符合条件的所有数据库记录(数据权限控制)
	 * @param physicsStockId 物理仓库ID
	 * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
	 * @throws Exception
	 */
	public List<BasRegion> getBasRegionAncestorsByPhysicsStockId(Long physicsStockId, String lang, Map<String , Object> params) throws Exception{
		if (physicsStockId == null) return null;
		params.put("physicsStockId", physicsStockId);
		params.put("lang", lang);
//		return basRegionDao.queryForList("BAS_REGION.selectByPhysicsStockId", physicsStockId);
		return basRegionDao.selectByParamMap("BAS_REGION.selectByPhysicsStockIdAndDataPermission",params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param regionCode 区域编码
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getBasRegionChildsByRegionCode(String regionCode, String lang) throws Exception{
		if (StringUtils.isEmpty(regionCode)) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regionCode", regionCode);
		params.put("lang", lang);
		return basRegionDao.queryForList("BAS_REGION.selectByRegionCodedesc", params);
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param regionCode 区域编码
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getBasRegionChilds(String regionCode, String lang) throws Exception{
		if (StringUtils.isEmpty(regionCode)) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regionCode", regionCode);
		params.put("lang", lang);
		return basRegionDao.queryForList("BAS_REGION.selectByRegionCode", params);
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
		return basRegionDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public BasRegion get(String pkId) throws Exception{
		if(pkId==null) return null;
     	return basRegionDao.selectByPk(pkId);
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @param lang 语种
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public BasRegion get(String pkId, String lang) throws Exception{
		if(pkId==null) return null;
		if(lang==null) return null;
		
		BasRegion vo = new BasRegion();
		vo.setRegionCode(pkId);
		vo.setLang(lang);
		
     	List<BasRegion> list = basRegionDao.selectByVo(vo);
     	
     	if(CollectionUtils.isNotEmpty(list)){
     		return list.get(0);
     	}else{
     		return null;
     	}
	}
	
	/**
     * 向数据库中插入一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回插入操作是否成功
     * @throws Exception
     */
    public BasRegion save(BasRegion vo) throws Exception{
    	if(vo == null) return null;
    	
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("regionCode", vo.getRegionCode());
    	BasRegion po1 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
    	
		params.remove("regionCode");
		params.put("regionName", vo.getRegionName());
		BasRegion po2 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
		
		if (po1 != null)
			throw new BizException(0, "地区编码不能重复!");
		if (po2 != null)
			throw new BizException(0, "区域名称不能重复!");
		return basRegionDao.insertByVo(vo);
    }
    
    /**
	 * 更新数据库中对象对应的记录
	 * @param vo 对象对应到数据库中的一条记录记录
	 * @return type : 
	 * @throws Exception
	 */
	public BasRegion updateByVoNotNull(BasRegion vo) throws Exception {
		if(vo == null) return null;
		
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("regionCode", vo.getRegionCode());
    	BasRegion po1 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
    	
		params.remove("regionCode");
		params.put("regionName", vo.getRegionName());
		BasRegion po2 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
		
		if (po1 != null && !po1.getRegionCode().equals(vo.getRegionCode()))
			throw new BizException(0, "地区编码不能重复!");
		if (po2 != null && !po2.getRegionCode().equals(vo.getRegionCode()))
			throw new BizException(0, "区域名称不能重复!");
		return basRegionDao.updateByVoNotNull(vo);
	}
    
	/**
     * 向数据库中更新一条记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : 返回插入操作是否成功
     * @throws Exception
     */
    public BasRegion update(BasRegion vo) throws Exception{
    	if(vo == null) return null;
    	
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("regionCode", vo.getRegionCode());
    	BasRegion po1 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
    	
		params.remove("regionCode");
		params.put("regionName", vo.getRegionName());
		BasRegion po2 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
		
		if (po1 != null && !po1.getRegionCode().equals(vo.getRegionCode()))
			throw new BizException(0, "地区编码不能重复!");
		if (po2 != null && !po2.getRegionCode().equals(vo.getRegionCode()))
			throw new BizException(0, "区域名称不能重复!");
		return basRegionDao.updateByVo(vo);
    }
    
    /**
     * 删除符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public boolean delete(String pkId) throws Exception{
    	if(pkId == null) return false;
    	return basRegionDao.deleteByPk(pkId);
    }
    

    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(BasRegion vo) throws Exception{
    	if(vo == null) return false;
     	return basRegionDao.deleteByVo(vo);
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
    	params.put("status", WcsCommonStatus.WCS_INVALID);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return basRegionDao.updateStatus(params);
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
    	params.put("status", WcsCommonStatus.WCS_VALID);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return basRegionDao.updateStatus(params);
	}
	
    /**
	 * 校验对象在数据库中是否存在
	 * @param regionCode: 地区编码 regionName:区域名称
	 * @return type : boolean 返回校验结果
	 * @throws Exception
	 */
	public boolean validateExist(String regionCode, String regionName) throws Exception {
		if (StringUtils.isEmpty(regionCode) || StringUtils.isEmpty(regionName)) throw new BizException(0, "传入的参数不能为空!");
		
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("regionCode", regionCode);
    	BasRegion po1 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
    	
		params.remove("regionCode");
		params.put("regionName", regionName);
		BasRegion po2 = (BasRegion) basRegionDao.queryForObject("BAS_REGION.selectByParams", params);
    	
		if (po1 == null && po2 == null)
			return false;
		else
			return true;
	}
	
	/**
     * 查找广东所有地市数据库记录 返回Map<code, name>  有序的
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public Map<String, String> getCityRegionByMap() throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("regionPid", CommonConstant.WCS_REGION);
	
		List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("reOrder", "asc");
		orderBy.add(hash);
		paramMap.put("orderBy", orderBy);

		List<BasRegion> list = basRegionDao.selectByParamMap(paramMap);
		Map<String, String> map = new LinkedHashMap<String, String>();
		for(BasRegion basRegion : list){
			map.put(basRegion.getRegionCode(), basRegion.getRegionName());
		}
		return map;
	}
	
	/**
     * 查找广东所有地市数据库记录 返回Map<code, name>  有序的
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<BasRegion> getCityRegionByList() throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("regionPid", CommonConstant.WCS_REGION);
		paramMap.put("lang", WcsDefinition.WcsLangType.WCS_EN);//地市查询加语种参数
		
		List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("reOrder", "asc");
		orderBy.add(hash);
		paramMap.put("orderBy", orderBy);
		List<BasRegion> list = basRegionDao.selectByParamMap(paramMap);
		return list;
	}
}
