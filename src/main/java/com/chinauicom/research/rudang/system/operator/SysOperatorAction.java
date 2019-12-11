package com.chinauicom.research.rudang.system.operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinauicom.research.commons.Message;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.define.WcsSex;
import com.chinauicom.research.commons.utils.Endecrypt;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.service.SysOperatorService;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;
import com.chinauicom.research.rudang.system.usergroup.service.SysUserGroupService;

/**
 * 
 * @ClassName: SysOperatorAction 
 * @Description: TODO(用户操作类) 
 * @author huangChuQin
 * @date 2016-8-4 下午9:09:18 
 *
 */
@Controller
@RequestMapping("/operator")
public class SysOperatorAction {
	public final static String GROUPTYPE="1";
	public final static String ADDRESSTYPE="2";

	@Autowired
	private SysOperatorService sysOperatorService;
	@Autowired
	private SysOrganizeService sysOrganizeService;
	@Autowired
	private SysUserGroupService sysUserGroupService;
	/**
	 * 跳转到操作员列表页面
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@RequestMapping("/sysOperatorIndex.do")
	public String index(HttpServletRequest request) throws Exception {
		//组织机构
		Map<String, Object> orgParam = new HashMap<String, Object>();
		orgParam.put("status", WcsDefinition.WcsYesNoMark.WCS_YES);
		orgParam.put(Page.NO_PAGING, true);
		Page sysOrganPage = sysOrganizeService.getPageByParamMap(orgParam);
		List<SysOrganize> sysOrgArray = new ArrayList<SysOrganize>();
		if (null != sysOrganPage && !CollectionUtils.isEmpty(sysOrganPage.getList()))
			sysOrgArray = sysOrganPage.getList();
		request.setAttribute("sysOrgArray", sysOrgArray);
		sysOrgArray = null;
		
		//操作员状态
		Map<String, String> statusHash = WcsDefinition.wcsOperatorStatus.WCS_OPERATOR_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		return "system/operator/operatorList";
	}

	/**
	 * 操作员列表数据获取
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getSysOperList.do")
	public @ResponseBody Map<String, Object> getSysOperList(HttpServletRequest request,
			HttpServletResponse response, int page, int rows) throws Exception {
		String operId1 = request.getParameter("operId");
		String operName1 = request.getParameter("operName");
		final String status = request.getParameter("status");
		final String orgCode = request.getParameter("orgCode");
		if (StringUtils.isNotEmpty(operId1)){
			operId1 = operId1.replaceAll("%","\\\\%");
			operId1 = operId1.replaceAll("_","\\\\_");
			}
		if (StringUtils.isNotEmpty(operName1)){
		operName1 = operName1.replaceAll("%","\\\\%");
		operName1 = operName1.replaceAll("_","\\\\_");
		}
		final String operId = operId1;
		final String operName = operName1;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Page.CURR_PAGE, page);
		params.put(Page.PAGE_SIZE, rows > 0 ? rows : Page.DEFAULT_PAGE_SIZE);

		if (StringUtils.isNotEmpty(operId))
			params.put("operIdLike", operId);
		if (StringUtils.isNotEmpty(operName))
			params.put("operNameLike", operName);
		if (StringUtils.isNotEmpty(status))
			params.put("status", status);
		if (StringUtils.isNotEmpty(orgCode))
			params.put("orgCode", orgCode);
		
		List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
    	Map<String, Object> hash = new HashMap<String, Object>();
    	hash.put("createTime", "desc");
    	orderBy.add(hash);
    	params.put("orderBy", orderBy);

		Page sysOperPage = sysOperatorService.getPageByParamMap(params);
		List<SysOperator> sysOperList = sysOperPage.getList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", sysOperPage.getTotalNumber());
		map.put("rows", sysOperList);
		return map;
	}
	
	/**
	 * 用户信息新增、编辑、详情查询页面跳转
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	@RequestMapping("/toPage.do")
	public String toPage(HttpServletRequest request, String type, 
			String operId) throws Exception {
		//操作员状态
		Map<String, String> statusHash = WcsDefinition.wcsOperatorStatus.WCS_OPERATOR_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		
		//性别
		Map<String, String> sexMap = WcsSex.WCS_SEX_MAP;
		request.setAttribute("sexMap", sexMap);
		
		if (StringUtils.isNotEmpty(type) && type.equals("add")) {
			//组织机构
			Map<String, Object> orgParam = new HashMap<String, Object>();
			orgParam.put("status", WcsDefinition.WcsYesNoMark.WCS_YES);
			orgParam.put(Page.NO_PAGING, true);
			Page sysOrganPage = sysOrganizeService.getPageByParamMap(orgParam);
			List<SysOrganize> sysOrgArray = new ArrayList<SysOrganize>();
			if (null != sysOrganPage && !CollectionUtils.isEmpty(sysOrganPage.getList()))
				sysOrgArray = sysOrganPage.getList();
			request.setAttribute("sysOrgArray", sysOrgArray);
			//新增
			return "system/operator/operatorAdd";
		} else {
			//编辑
			SysOperator operator = sysOperatorService.get(operId);
			request.setAttribute("sysOper", operator);
			//组织机构
			SysOrganize organize = sysOrganizeService.get(operator.getOrgCode());
			request.setAttribute("organize", organize);
			//编辑
			if (StringUtils.isNotEmpty(type) && type.equals("edit")) {
				return "system/operator/operatorEdit";
			} else {
				final String flag = request.getParameter("flag");//详情返回按钮url地址标示
				request.setAttribute("flag", flag);
				return "system/operator/operatorDetail";
			}
		}
	}
	
	/**
	 * 跳转到弹出窗口页面
	 * @param request
	 * @param operType 操作类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toShowPage.do")
	public String toShowPage(HttpServletRequest request, String operType) throws Exception {
		if (StringUtils.isNotEmpty(operType) && operType.equals("org")) {
			return "system/operator/chooseOrg";
		} else if (StringUtils.isNotEmpty(operType) && operType.equals("pwdEdit")) {
			return "system/operator/operatorPwdEdit";//密码修改
		}
		return null;
	}
	
	
	/**
	 * 判断用户是否存在
	 * @param operId
	 * @return
	 */
	@RequestMapping("/checkOperatorIsExists.do")
	public @ResponseBody Message checkOperatorIsExists(String operId) {
		Message msg = new Message();
		try {
			SysOperator sysOperator = sysOperatorService.get(operId);
			if (null != sysOperator) {
				msg.setFlag(false);
				msg.setMsg("此用户已经存在");
			} else {
				msg.setFlag(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setFlag(false);
		}
		return msg;
	}
	
	
	/**
	 * 操作员状态禁用（支持批量禁用）
	 * @param operIds 操作员编码集合
	 * @return
	 */
	@RequestMapping("/deleteOperator.do")
	public @ResponseBody Message deleteOperator(HttpServletRequest request, String[] operIds) {
		Message msg = new Message();
		HttpSession session = request.getSession();
		SysOperator user = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == user) {
			msg.setFlag(false);
			msg.setMsg("用户组信息禁用失败");
			return msg;
		}
		try {
			if (null != operIds && operIds.length > 0) {
				boolean flag = sysOperatorService.deleteLogical(Arrays.asList(operIds), user.getOperId());
				if(flag) {
					msg.setFlag(true);
					msg.setMsg("操作员状态禁用成功");
				} else {
					msg.setFlag(false);
					msg.setMsg("操作员状态禁用失败");
				}
			} else {
				msg.setFlag(false);
				msg.setMsg("操作员状态禁用失败");
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("操作员状态禁用失败");
		}
		return msg;
	}
	
	/**
	 * 操作员状态恢复

	 * @return
	 */
	@RequestMapping("/recoverOperator.do")
	public @ResponseBody Message recoverOperator(HttpServletRequest request, String operId) {
		Message msg = new Message();
		HttpSession session = request.getSession();
		SysOperator user = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == user) {
			msg.setFlag(false);
			msg.setMsg("操作员状态恢复失败");
			return msg;
		}
		try {
			if (StringUtils.isNotEmpty(operId)) {
				List<String> codes = new ArrayList<String>();
				codes.add(operId);
				boolean flag = sysOperatorService.recover(codes, user.getOperId());
				if(flag) {
					msg.setFlag(true);
					msg.setMsg("操作员状态恢复成功");
				} else {
					msg.setFlag(false);
					msg.setMsg("操作员状态恢复失败");
				}
			} else {
				msg.setFlag(false);
				msg.setMsg("操作员状态恢复失败");
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("操作员状态恢复失败");
		}
		return msg;
	}
	
	/**
	 * 用户组选择
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/getUserGroupList.do")
	public @ResponseBody Map<String, Object> getUserGroupList(HttpServletRequest request,
			HttpServletResponse response, int page, int rows) throws Exception {
		final String groCodes = request.getParameter("groCodes");//已关联用户组编码
		String groName1 = request.getParameter("groName");//名称
		String groCode1 = request.getParameter("groCode");//编码
		if (StringUtils.isNotEmpty(groCode1)){
			groCode1 = groCode1.replaceAll("%","\\\\%");
			groCode1 = groCode1.replaceAll("_","\\\\_");
		}
		if (StringUtils.isNotEmpty(groName1)){
			groName1 = groName1.replaceAll("%","\\\\%");
			groName1 = groName1.replaceAll("_","\\\\_");
		}
		final String groName = groName1;
		final String groCode = groCode1;
		
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put(Page.CURR_PAGE, page);
		hash.put(Page.PAGE_SIZE, rows > 0 ? rows : Page.DEFAULT_PAGE_SIZE);
		hash.put("status", WcsDefinition.WcsCommonStatus.WCS_VALID);
		
		if (StringUtils.isNotEmpty(groCode))
			hash.put("groCodeLike", groCode);
		if (StringUtils.isNotEmpty(groName))
			hash.put("groNameLike", groName);
		if (StringUtils.isNotEmpty(groCodes))
			hash.put("groCodeNotIn", Arrays.asList(groCodes.split(",")));
		
		Page pageObj = sysUserGroupService.getPageByParamMap(hash);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageObj.getTotalNumber());
		map.put("rows", pageObj.getList());
		return map;
	}
	
	/**
	 * 用户组选择
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/getOrgList.do")
	public @ResponseBody Map<String, Object> getOrgList(HttpServletRequest request,
			HttpServletResponse response, int page, int rows) throws Exception {
		final String orgCodes = request.getParameter("orgCodes");//已关联用户组编码
		final String orgName = request.getParameter("orgName");//名称
		
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put(Page.CURR_PAGE, page);
		hash.put(Page.PAGE_SIZE, rows > 0 ? rows : Page.DEFAULT_PAGE_SIZE);
		hash.put("status", WcsDefinition.WcsCommonStatus.WCS_VALID);
		if (StringUtils.isNotEmpty(orgName))
			hash.put("orgNameLike", orgName);
		if (StringUtils.isNotEmpty(orgCodes))
			hash.put("orgCodeNotIn", Arrays.asList(orgCodes.split(",")));
		
		Page pageObj = sysOrganizeService.getPageByParamMap(hash);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageObj.getTotalNumber());
		map.put("rows", pageObj.getList());
		return map;
	}
	
	/**
	 * 用户密码修改方法
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/operatorPwdUpdate.do")
	public @ResponseBody Message operatorPwdUpdate(HttpServletRequest request) throws Exception {
		Message msg = new Message();
		try {
			String id = request.getParameter("id");//操作员帐号
			SysOperator user = sysOperatorService.get(id);
			Endecrypt endecrypt = new Endecrypt();
			String oldPwd = request.getParameter("oldPwd");//页面的旧密码
			//如果存在页面提交的旧密码值
			if(oldPwd != null && !"".equals(oldPwd)){
				//对页面的旧密码加密码再与原始密码进行对比
				String orginPwd = user.getOperPwd();//帐号的原始密码
				//对旧密码加密
				oldPwd = endecrypt.get3DESEncrypt(oldPwd, WcsSessionConstant.SPKEY_PASSWORD).toUpperCase();//加密key
				if (!oldPwd.equals(orginPwd)) {
					msg.setFlag(Boolean.FALSE);
					msg.setMsg("用户旧密码错误");
					return msg;
				}
			}
			String newPwd = request.getParameter("newPwd");
			//对新密码加密
			newPwd = endecrypt.get3DESEncrypt(newPwd, WcsSessionConstant.SPKEY_PASSWORD).toUpperCase();//加密key
			user.setOperPwd(newPwd);
			/**start modify by Carson */
			//sysOperatorService.save(user, null, 1);
			sysOperatorService.updateByVoNotNull(user);
			/**end modify by Carson */
			//修改成功，返回结果
			msg.setFlag(Boolean.TRUE);
			msg.setMsg("用户密码修改成功");
		} catch (Exception ex) {
			msg.setFlag(Boolean.FALSE);
			msg.setMsg("用户密码修改失败");
			ex.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/updatePwd.do")
	public String getSalesGood(HttpServletRequest request){
		request.setAttribute("id", request.getParameter("id"));
		return "system/operator/updatePwd";
	}
}


