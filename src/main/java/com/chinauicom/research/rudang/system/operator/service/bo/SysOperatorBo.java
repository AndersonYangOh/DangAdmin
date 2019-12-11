/**
 * com.tydic.dbs.system.operator.bo.SysOperatorBo.java
 */
package com.chinauicom.research.rudang.system.operator.service.bo;

import java.util.*;

import com.thoughtworks.xstream.XStream;

import org.apache.commons.lang3.StringUtils;

import com.chinauicom.research.commons.constant.CommonConstant;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.Endecrypt;
import com.chinauicom.research.commons.utils.Md5;
import com.chinauicom.research.commons.utils.OrderUtils;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.log.dao.SysLoginLogDao;
import com.chinauicom.research.rudang.system.log.entity.SysLoginLog;
import com.chinauicom.research.rudang.system.operator.dao.SysOperatorDao;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.service.SysOperatorService;
import com.chinauicom.research.rudang.system.role.dao.SysRoleDao;
import com.chinauicom.research.rudang.system.role.entity.SysOperRole;
import com.chinauicom.research.rudang.system.role.entity.SysRole;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorDetail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * zeng@2016/7/29
 */
@Service
public class SysOperatorBo implements SysOperatorService {
	@Autowired
	private SysOperatorDao sysOperatorDao;
	@Autowired
	private SysLoginLogDao sysLoginLogDao;
	@Autowired
	private SysRoleDao sysRoleDao;

	private final Log log = LogFactory.getLog(SysOperatorBo.class);
    /**
	 * @param sysOperatorDao the sysOperatorDao to set
	 */
	public void setSysOperatorDao(SysOperatorDao sysOperatorDao) {
		this.sysOperatorDao = sysOperatorDao;
	}
	/**
	 * @param sysLoginLogDao the sysOperatorDao to set
	 */
	public void setSysLoginLogDao(SysLoginLogDao sysLoginLogDao) {
		this.sysLoginLogDao = sysLoginLogDao;
	}
	/**
	 * @param sysRoleDao the sysRoleDao to set
	 */
	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	/**
	 * 查找所有数据库记录
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     */
	@SuppressWarnings("unchecked")
	public List<SysOperator> getAll() throws Exception {
		return sysOperatorDao.selectAll();
	}
	
	/**
     * 查找符合条件的所有数据库记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : List 返回查询操作所有符合条件的记录的VO对象集合，操作失败返回null
     * @throws Exception
     */
	@SuppressWarnings({ "unchecked" })
    public List<SysOperator> get(SysOperator vo) throws Exception{
		if(vo == null) return null;
        return sysOperatorDao.selectByVo(vo);
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
		return sysOperatorDao.queryForPage(params);
	}
	
    /**
     * 查找符合条件的所有数据库记录
     * @param pkid 与数据库中主键对应的值
     * @return type : 返回查询操作所有符合条件的记录的VO对象，操作失败返回null
     * @throws Exception
     */
	public SysOperator get(String pkId) throws Exception{
		if(pkId==null) return null;
     	return sysOperatorDao.selectByPK(pkId);
	}
	public SysOperatorDetail getDetail(String pkId) throws Exception{
		if(pkId==null) return null;
     	return sysOperatorDao.selectDetailByPK(pkId);
	}
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
	public SysOperator updateByVoNotNull(SysOperator vo) throws Exception{
		if(vo==null) return null;
     	return sysOperatorDao.updateByVoNotNull(vo);
	}
	
	/**
     * 向数据库中插入/修改一条数据记录
     * @param vo 与数据库中记录对应的值对象
     * @param roleCode 角色编码
     * @param flag 操作标识（0新增操作 1修改操作）
     * @return type : 返回已保存或者已更新的VO对象
     * @throws Exception
     */
    @SuppressWarnings("static-access")
	public SysOperator save(SysOperator vo, String[] roleCode, int flag, @SuppressWarnings("rawtypes") Map params) throws Exception{
    	if(vo == null)
    		return null;		
		if(flag == 0) {
			//修改
			/**操作员与角色关系修改，先删除原有记录，再新增新关联记录*/
			if (null != roleCode && roleCode.length > 0) {
				sysRoleDao.deleteByOperId(vo.getOperId());
				for (int i = 0; i < roleCode.length; i++) {
					SysRole sysRole = new SysRole();
					sysRole.setRoleDesc(vo.getOperId());
					sysRole.setRoleCode(roleCode[i]);
					sysRole.setCreater(vo.getCreater());
					sysRole.setCreateTime(Calendar.getInstance().getTime());
					sysRoleDao.insertByVoOperId(sysRole);
				}
			} else {
				//角色编码为空时
				sysRoleDao.deleteByOperId(vo.getOperId());
			}
			String pwd=vo.getOperPwd();
			if(pwd!=null || "".equals(pwd)){
				Endecrypt endecrypt = new Endecrypt();
				pwd = endecrypt.get3DESEncrypt(pwd, WcsSessionConstant.SPKEY_PASSWORD).toUpperCase();//wcs加密key
				vo.setOperPwd(pwd);
			}
			sysOperatorDao.updateOperDetail(params);//同时更新operdetail表，同时更新导出表
			sysOperatorDao.updateOperExportTable(params);
			return sysOperatorDao.updateByVoNotNull(vo);
		} else {
			//新增
			String operUserId=OrderUtils.getOperId();
			vo.setOperId(operUserId);
			params.put("operId", operUserId);
			/**判断新增操作员编码是否存在，如存在，则抛出异常*/
			SysOperator _oper = sysOperatorDao.selectByPK(vo.getOperAccount());
			if (null != _oper) {
				throw new Exception("数据新增失败，用户已存在。");
			} else {
				/**对用户密码进行加密操作*/
				String pwd = vo.getOperPwd();
				Endecrypt endecrypt = new Endecrypt();
				pwd = endecrypt.get3DESEncrypt(pwd, WcsSessionConstant.SPKEY_PASSWORD).toUpperCase();//wcs加密key
				vo.setOperPwd(pwd);
				vo.setErrorCount((double) CommonConstant.MAX_ERROR_COUNT);//同一天操作员密码输入错误次数上限
				_oper = sysOperatorDao.insertByVo(vo);

				/**操作员与用户组关系新增，先删除原有记录，再新增新关联记录*/
				///
				sysRoleDao.deleteByOperId(vo.getOperId());
				///
				for (int i = 0; i < roleCode.length; i++) {
					SysRole sysRole = new SysRole();
					sysRole.setRoleDesc(vo.getOperId());
					sysRole.setRoleCode(roleCode[i]);
					sysRole.setCreater(vo.getCreater());
					sysRole.setCreateTime(Calendar.getInstance().getTime());
					sysRoleDao.insertByVoOperId(sysRole);
				}
				sysOperatorDao.insertOperDetail(params);//同时新增operdetail表，同时新增导出表
				
				if(params.get("operUserType").equals("1")){
					sysOperatorDao.insertRudangProcess(params);
					sysOperatorDao.updateRudangProcessByCreate(params);
					sysOperatorDao.insertOperExportTable(params);//新增excel导出
				}
				/*else if(params.get("operUserType").equals("2")){
					sysOperatorDao.insertRudangProcessByOldUser(params);
				}*/
				return _oper;
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
    	return sysOperatorDao.deleteByPk(pkId);
    }
    
    /**
     * 删除数据库中与传入的值对象对应的记录
     * @param vo 与数据库中记录对应的值对象
     * @return type : boolean 返回删除操作是否成功
     * @throws Exception
     */
    public boolean delete(SysOperator vo) throws Exception{
    	if(vo == null) return false;
     	return sysOperatorDao.deleteByVo(vo);
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
    	params.put("status", WcsDefinition.wcsOperatorStatus.FROZEN);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysOperatorDao.updateStatus(params);
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
    	params.put("status", WcsDefinition.wcsOperatorStatus.NORMAL);
    	params.put("modifier", modifier);
    	params.put("modifyTime", Calendar.getInstance().getTime());
    	return sysOperatorDao.updateStatus(params);
	}
    public void updateOperExportTableStage(@SuppressWarnings("rawtypes") Map params) throws Exception {
    	 sysOperatorDao.updateOperExportTableStage(params);
	}
    /**
     * 操作员登录验证
     * @param operId 操作员登录账号
     * @param operPwd 登录密码
     * @param ipAddr 登录服务器IP，用于记录日志
     * @param macAddr mac地址
     * @return map<"state"="1成功/0失败";"message"="提示消息";"loginLogId"="登录日志ID">
     * @throws Exception 
     */
	@SuppressWarnings("static-access")
	public Map<String, Object> validateOperLogin(String operAccount, String operPwd,
			String ipAddr, String macAddr) throws Exception {
		Map<String, Object> hash = new HashMap<String, Object>();
		
		/**判断操作员是否存在*/
		SysOperator _operator = sysOperatorDao.selectByAccount(operAccount);
		if (null == _operator) {
			hash.put("state", "0");
			hash.put("message", "用户信息不存在");//登录失败,操作员信息不存在
			return hash;
		}

		/**密码验证*/
		Endecrypt endecrypt = new Endecrypt();
		operPwd = endecrypt.get3DESEncrypt(operPwd, WcsSessionConstant.SPKEY_PASSWORD).toUpperCase();
		if (!operPwd.equals(_operator.getOperPwd())) {
			hash.put("state", "0");
			hash.put("message", "密码输入错误");//登录失败,密码输入错误
			return hash;
		}
		/**操作员状态判断*/
		final String status = _operator.getStatus();
		if (null != status && !status.equals(WcsDefinition.wcsOperatorStatus.NORMAL)) {
			hash.put("state", "0");
			hash.put("message", "用户处于未生效状态");
			return hash;
		}
		/**登录成功*/
		_operator.setLastLoginTime(Calendar.getInstance().getTime());
		sysOperatorDao.updateByVo(_operator);
		
		/**操作员登录日志记录*/
		SysLoginLog log = new SysLoginLog();
		log.setOperId(operAccount);
		log.setIpAddress(ipAddr);
		log.setMacId(macAddr);
		log.setLoginTime(new Date());
		log = sysLoginLogDao.insertByVo(log);
		
		hash.put("state", "1");
		hash.put("message", "Login successful");
		hash.put(WcsSessionConstant.SESSION_LOGIN_LOG_ID, log.getLogId().toString());
		hash.put(WcsSessionConstant.SESSION_OPERATOR, _operator);
		return hash;
	}
}
