/**
 * com.tydic.dbs.bo.SysOperatorService.java
 */
package com.chinauicom.research.rudang.system.operator.service;

import java.util.List;
import java.util.Map;

import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorDetail;
/**
 * @file  SysOperatorService.java
 * @author liugaolin
 * @version 0.1
 * @SysOperator业务操作接口
 * Copyright(C), 2013-2014
 *		 Guangzhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-02-27 05:42:53
 *      	Author: liugaolin
 *      	Modification: this file was created
 *   	2. ...
 */

public abstract interface SysOperatorService {

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
    public abstract List<SysOperator> getAll() throws Exception;
	
    /**
     * 分页查找
     * @param params 与数据库中记录对应的值对象
     * @return type : Page 返回满足条件的记录集，操作失败返回null
     * @throws Exception
     */
    public abstract Page getPageByParamMap(@SuppressWarnings("rawtypes") Map params) throws Exception;
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public abstract SysOperator get(String pkId) throws Exception;
	public abstract SysOperatorDetail getDetail(String pkId) throws Exception;
	/**
	 * 
	 * @Title: updateByVoNotNull 
	 * @Description: 修改用户信息 
	 * @param @param vo
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return SysOperator    返回类型 
	 * @throws
	 */
	public SysOperator updateByVoNotNull(SysOperator vo) throws Exception;
	
	/**
     * 向数据库中插入/修改一条数据记录
     * @param vo 与数据库中记录对应的值对象
     * @param userGroupCodes 用户组编码
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
	public  SysOperator save(SysOperator vo, String[] userGroupCodes, int flag, @SuppressWarnings("rawtypes") Map params) throws Exception;
    /**
     * 删除符合条件的所有数据库记录
     * @param pkId 与数据库中主键对应的值
     * @return type : boolean 返回删除操做是否成功，操作失败返回false
     */
    public abstract boolean delete(String pkId) throws Exception;
    
    /**
     * 根据ids逻辑删除数据权限数据信息（将数据状态置为无效）
     * @param ids 数据权限集合
     * @param modifier 修改人
     * @return
     * @throws Exception
     */
    public abstract boolean deleteLogical(List<String> ids, String modifier) throws Exception;
    
    /**
     * 根据ids恢复数据权限数据信息（将数据状态置为有效）
     * @param ids 数据权限集合
     * @param modifier 修改人
     * @return
     * @throws Exception
     */
    public abstract boolean recover(List<String> ids, String modifier) throws Exception;
    
    /**
     * 操作员登录验证
     * @param operId 操作员登录账号
     * @param operPwd 登录密码
     * @param ipAddr 登录服务器IP，用于记录日志
     * @param macAddr mac地址
     * @return map<"state"="1成功/0失败";"message"="提示消息";"loginLogId"="登录日志ID";"operator"="操作员对象">
     */
    public abstract Map<String, Object> validateOperLogin(String operId, String operPwd, String ipAddr, String macAddr) throws Exception;
    public void updateOperExportTableStage(@SuppressWarnings("rawtypes") Map params) throws Exception ;
    /**
     * 根据渠道ID、操作员状态等获取关联操作员信息
     * @return
     * @throws Exception
     */
    //public abstract Page getPageByParams(Map<String, Object> map) throws Exception;
    
    /**
     * 根据多个渠道ID、操作员状态等获取关联操作员信息
     * @return
     * @throws Exception
     */
	//public Page selectOperatorByChannelId(Map<String, Object> map) throws Exception ;

}
