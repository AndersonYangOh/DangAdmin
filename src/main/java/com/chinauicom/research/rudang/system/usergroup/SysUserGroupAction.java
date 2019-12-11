package com.chinauicom.research.rudang.system.usergroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinauicom.research.commons.Message;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.service.SysOperatorService;
import com.chinauicom.research.rudang.system.role.entity.SysRole;
import com.chinauicom.research.rudang.system.role.service.SysRoleService;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroup;
import com.chinauicom.research.rudang.system.usergroup.entity.SysUserGroupRole;
import com.chinauicom.research.rudang.system.usergroup.service.SysUserGroupRoleService;
import com.chinauicom.research.rudang.system.usergroup.service.SysUserGroupService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @file SysUserGroupAction.java
 * @author 刘高林
 * @version 0.1
 * @SysUserGroupAction用户组action类
 * Copyright(C), 2013-2014
 *		  GuangZhou Sunrise Technology Co., Ltd.
 * History
 *   	1. Date: 2014-3-28 上午11:20:29
 *      	Author: 刘高林
 *      	Modification: this file was created
 *   	2. ...
 */
@Controller
@RequestMapping("/sysUserGroup")
public class SysUserGroupAction {

	@Autowired
	private SysUserGroupService sysUserGroupService;
	@Autowired
	private SysOperatorService sysOperatorService;
	@Autowired
	private SysUserGroupRoleService sysUserGroupRoleService;
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 跳转到用户组管理页面
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/toUserGroupList.do")
	public String toUserGroupList(HttpServletRequest request) throws Exception {
		Map<String, String> statusHash = WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		return "system/userGroup/userGroupList";
	}

	/**
	 * 获取用户组列表数据
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getUserGroupList.do")
	public @ResponseBody Map<String, Object> getUserGroupList(HttpServletRequest request,
			HttpServletResponse response, int page, int rows) throws Exception {
		String groName1 = request.getParameter("groName");//用户组名称
		String groCode1 = request.getParameter("groCode");//用户组编码
		final String status = request.getParameter("status");//状态
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

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Page.CURR_PAGE, page);
		params.put(Page.PAGE_SIZE, rows > 0 ? rows : Page.DEFAULT_PAGE_SIZE);

		if (StringUtils.isNotEmpty(groName))
			params.put("groNameLike", groName);
		if (StringUtils.isNotEmpty(groCode))
			params.put("groCodeLike", groCode);
		if (StringUtils.isNotEmpty(status))
			params.put("status", status);

		Page sysUserGroupPage = sysUserGroupService.getPageByParamMap(params);
		List<SysUserGroup> sysUserGroupList = sysUserGroupPage.getList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", sysUserGroupPage.getTotalNumber());
		map.put("rows", sysUserGroupList);
		return map;
	}
	
	/**
	 * 用户组信息新增、编辑、详情查询页面跳转
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/toPage.do")
	public String toPage(HttpServletRequest request, String operType, 
			String groCode) throws Exception {
		Map<String, String> statusHash = WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		
		if (StringUtils.isNotEmpty(operType) && operType.equals("add")) {
			//新增
			return "system/userGroup/userGroupAdd";
		} else if (StringUtils.isNotEmpty(operType) && operType.equals("edit")) {
			//编辑
			SysUserGroup userGroup = sysUserGroupService.get(groCode);
			request.setAttribute("userGroup", userGroup);
			//获取用户组与角色关系数据
			List<SysUserGroupRole> userGroupRoleArray = sysUserGroupRoleService.getUserGroupRoleByGroCode(groCode);
			//根据用户组与角色关系数据生成角色数据
			List<SysRole> roleList = new ArrayList<SysRole>();
			if(userGroupRoleArray != null && userGroupRoleArray.size() > 0){
				for(SysUserGroupRole userGroupRole : userGroupRoleArray){
					boolean exsitsRole = false;
					for(SysRole role : roleList){
						if(role.getRoleCode().equals(userGroupRole.getRoleCode())){
							exsitsRole = true;
						}
					}
					if(!exsitsRole){
						roleList.add(sysRoleService.get(userGroupRole.getRoleCode()));
					}
				}
			}
			//request.setAttribute("userGroupRoleArray", userGroupRoleArray);
			request.setAttribute("userGroupRoleArray", roleList);
			return "system/userGroup/userGroupEdit";
		} else if (StringUtils.isNotEmpty(operType) && operType.equals("role")) {
			//已关联的角色数据
			String[] roleCodes = request.getParameterValues("roleCodes");
			String codes = "";
			if (null != roleCodes && roleCodes.length > 0) {
				for (int i = 0; i < roleCodes.length; i++) {
					if ((i+1)==roleCodes.length) {
						codes += roleCodes[i];
					} else {
						codes += (roleCodes[i]+",");
					}
				}
			}
			request.setAttribute("roleCodes", codes);
			//用户组角色关联
			return "system/userGroup/chooseRole";
		} else {
			//详情
			SysUserGroup userGroup = sysUserGroupService.get(groCode);
			request.setAttribute("userGroup", userGroup);
			//获取用户组与角色关系数据
			List<SysUserGroupRole> userGroupRoleArray = sysUserGroupRoleService.getUserGroupRoleByGroCode(groCode);
			request.setAttribute("userGroupRoleArray", userGroupRoleArray);
			return "system/userGroup/userGroupDetail";
		}
	}
	
	/**
	 * 用户组信息新增、修改
	 * @throws Exception
	 */
	@RequestMapping("/userGroupSaveOrUpdate.do")
	public @ResponseBody
	Message userGroupSaveOrUpdate(HttpServletRequest request, SysUserGroup userGroup, String type) throws Exception {
		Message msg = new Message();
		try {
			HttpSession session = request.getSession();
			SysOperator operator = (SysOperator)session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
			//获取角色信息
			String[] roleCodes = request.getParameterValues("roleCodes");
			/////
			msg.setFlag(Boolean.TRUE);
			if (StringUtils.isNotEmpty(type) && type.equals("add")) {
				//判断用户组编码是否存在
				SysUserGroup ug = sysUserGroupService.get(userGroup.getGroCode());
				if (null != ug) {
					msg.setFlag(false);
					msg.setMsg("用户组信息新增失败，用户组编码已经存在");
				}
					else {
					//新增
					userGroup.setCreater(operator.getOperId());
					userGroup = sysUserGroupService.save(userGroup, 0);
					msg.setMsg("用户组信息新增成功");
				}
			} else {
				//修改
				SysUserGroup ug2 = sysUserGroupService.get(userGroup.getGroName());
				userGroup.setModifier(operator.getOperId());
				sysUserGroupService.save(userGroup, 1);
				msg.setMsg("用户组信息修改成功");
			}
			
			//if (StringUtils.isNotEmpty(userGroup.getGroCode()) && null != roleCodes && roleCodes.length > 0) {
			if (StringUtils.isNotEmpty(userGroup.getGroCode())) {	
				List<SysUserGroupRole> userGroupRoleArray = new ArrayList<SysUserGroupRole>();
				if(null != roleCodes && roleCodes.length > 0){
					for (int i = 0; i < roleCodes.length; i++) {
						SysUserGroupRole userGroupRole = new SysUserGroupRole();
						userGroupRole.setGroCode(userGroup.getGroCode());
						userGroupRole.setRoleCode(roleCodes[i]);
						userGroupRole.setCreater(operator.getOperId());
					///
					userGroupRoleArray.add(userGroupRole);
					}
				}
				//判断是否为修改操作，如果是，则先删除原有数据
				if (StringUtils.isNotEmpty(type) && !type.equals("add")) {
					SysUserGroupRole tmp = new SysUserGroupRole();
					tmp.setGroCode(userGroup.getGroCode());
					sysUserGroupRoleService.deleteByVo(tmp);
				}
				if(null != roleCodes && roleCodes.length > 0){
				//批量新增数据
				sysUserGroupRoleService.batchInsertUserGrouRole(userGroupRoleArray);
				}
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("操作失败");
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * 用户组信息禁用（支持批量禁用）
	 * @param groCodes 用户组编码集合
	 * @return
	 */
	@RequestMapping("/deleteUserGroup.do")
	public @ResponseBody Message deleteUserGroup(HttpServletRequest request, String[] groCodes) {
		Message msg = new Message();
		HttpSession session = request.getSession();
		SysOperator user = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == user) {
			msg.setFlag(false);
			msg.setMsg("用户组信息禁用失败");
			return msg;
		}
		try {
			if (null != groCodes && groCodes.length > 0) {
				boolean flag = sysUserGroupService.deleteLogical(Arrays.asList(groCodes), user.getOperId());
				if(flag) {
					msg.setFlag(true);
					msg.setMsg("用户组信息禁用成功");
				} else {
					msg.setFlag(false);
					msg.setMsg("用户组信息禁用失败");
				}
			} else {
				msg.setFlag(false);
				msg.setMsg("用户组信息禁用失败");
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("用户组信息禁用失败");
		}
		return msg;
	}
	
	/**
	 * 用户组状态恢复
	 * @param groCode 用户组信息集合
	 * @return
	 */
	@RequestMapping("/recoverUserGroup.do")
	public @ResponseBody Message recoverUserGroup(HttpServletRequest request, String groCode) {
		Message msg = new Message();
		HttpSession session = request.getSession();
		SysOperator user = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == user) {
			msg.setFlag(false);
			msg.setMsg("用户组状态恢复失败");
			return msg;
		}
		try {
			if (StringUtils.isNotEmpty(groCode)) {
				List<String> codes = new ArrayList<String>();
				codes.add(groCode);
				boolean flag = sysUserGroupService.recover(codes, user.getOperId());
				if(flag) {
					msg.setFlag(true);
					msg.setMsg("用户组状态恢复成功");
				} else {
					msg.setFlag(false);
					msg.setMsg("用户组状态恢复失败");
				}
			} else {
				msg.setFlag(false);
				msg.setMsg("用户组状态恢复失败");
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("用户组状态恢复失败");
		}
		return msg;
	}
	
	/**
	 * 跳转到用户组用户列表信息页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/toOperatorList.do")
	public String toOperatorList(HttpServletRequest request) throws Exception {
		final String groCode = request.getParameter("groCode");
		request.setAttribute("groCode", groCode);
		//操作员状态
		Map<String, String> statusHash = WcsDefinition.wcsOperatorStatus.WCS_OPERATOR_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		return "system/userGroup/operatorList";
	}
	
	/**
	 * 获取用户组关联用户列表数据
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getOperatorList.do")
	public @ResponseBody Map<String, Object> getOperatorList(HttpServletRequest request,
			HttpServletResponse response, int page, int rows) throws Exception {
		final String groCode = request.getParameter("groCode");
		final String operId = request.getParameter("operId");
		final String operName = request.getParameter("operName");
		final String status = request.getParameter("status");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Page.CURR_PAGE, page);
		params.put(Page.PAGE_SIZE, rows > 0 ? rows : Page.DEFAULT_PAGE_SIZE);

		if (StringUtils.isNotEmpty(operId))
			params.put("operIdLike", operId);
		if (StringUtils.isNotEmpty(operName))
			params.put("operNameLike", operName);
		if (StringUtils.isNotEmpty(status))
			params.put("status", status);
		if (StringUtils.isNotEmpty(groCode))
			params.put("groCode", groCode); 

		Page sysOperPage = sysOperatorService.getPageByParamMap(params);
		List<SysOperator> sysOperList = sysOperPage.getList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", sysOperPage.getTotalNumber());
		map.put("rows", sysOperList);
		return map;
	}
	/**
	 * 用户组名称不重复验证
	 * @throws Exception
	 */
	@RequestMapping("/checkGroName.do")
	public @ResponseBody Message checkGroName(HttpServletRequest request) throws Exception {
			Message msg = new Message();
			String groName = request.getParameter("groName");
			if(StringUtils.isNotEmpty(groName)){
			Map<String, Object> params = new HashMap<String, Object>();
	        params.put(Page.NO_PAGING, true);
	        params.put("status", WcsDefinition.WcsCommonStatus.WCS_VALID);
	        params.put("groName", groName.trim());
			Page page = sysUserGroupService.getPageByParamMap(params);
			if(page != null && page.getList() != null && page.getList().size() > 0){
				msg.setFlag(false);
				msg.setMsg("用户组信息新增失败，用户组名称已经存在");
			}
			}
			return msg;
		}
	
}
