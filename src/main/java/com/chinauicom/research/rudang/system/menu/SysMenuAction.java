package com.chinauicom.research.rudang.system.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinauicom.research.commons.Constants;
import com.chinauicom.research.commons.Message;
import com.chinauicom.research.commons.constant.CommonConstant;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.menu.entity.SysMenu;
import com.chinauicom.research.rudang.system.menu.service.SysMenuService;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;

/**
 * 
 * @ClassName: SysMenuAction
 * @Description: TODO(后台菜单管理)
 * @author huangChuQin
 * @date 2016-7-18 上午9:51:13
 *
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuAction {

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 操作员登录成功后，可操作功能菜单数据获取
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "static-access" })
	@RequestMapping("/getLoginMenus.do")
	public String getLoginMenus(HttpServletRequest request) throws Exception {
		try {
			HttpSession session = request.getSession();
			SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

			/** 用户登录成功后，用户操作菜单数据获取，获取一级菜单数据 */
			List<SysMenu> menus = sysMenuService.getByParams(operator.getOperId(),
					WcsDefinition.WcsCommonStatus.WCS_VALID, null, null);
			if (CollectionUtils.isNotEmpty(menus)) {
				/** 递归进行菜单数据封装 */
				List<SysMenu> menuVec = new ArrayList<SysMenu>();
				for (SysMenu _menu : menus) {
					if (StringUtils.isNotEmpty(_menu.getParentMenuCode())
							&& (_menu.getParentMenuCode()).equals(String.valueOf(CommonConstant.PARENT_ID))) {
						menuVec.add(_menu);
						formartTree(menus, _menu);
					}
				}
				menus = new ArrayList<SysMenu>();
				menus.addAll(menuVec);
				menuVec = null;
			}
			request.setAttribute("menus", menus);
			// 设置菜单session
			session.removeAttribute(WcsSessionConstant.SESSION_MUNE);
			session.setAttribute(WcsSessionConstant.SESSION_MUNE, menus);

			return "system/login/main";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 到新增/修改菜单页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/menuAdd.do")
	public String menuAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		map.put("parentMenuCode", Constants.PARENT_MENU_CODE);
		List<SysMenu> list = sysMenuService.selectMenuByMap(map);
		request.setAttribute("list", list);
		String operType = request.getParameter("operType");
		if (Constants.OPER_TYPE_UPDATE.equals(operType)) {
			String menuCode = request.getParameter("menuCode");
			SysMenu sysMenu = sysMenuService.get(menuCode);
			request.setAttribute("sysMenu", sysMenu);
			request.setAttribute("flag", Constants.OPER_TYPE_UPDATE);
		} else {
			request.setAttribute("flag", Constants.OPER_TYPE_SAVE);
		}
		return "system/menu/menuAddOrMod";
	}

	/**
	 * 菜单树数据获取
	 */
	@RequestMapping("/getMenuTree.do")
	public @ResponseBody List<Map<String, Object>> getMenuTree(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == operator || StringUtils.isEmpty(operator.getOperId()))
			return null;
		final String showFlag = request.getParameter("showFlag");// 菜单是否展开标志(true是
																	// false否)
		/** 获取菜单数据 */
		List<SysMenu> menuArray = sysMenuService.getAll();
		List<Map<String, Object>> array = new ArrayList<Map<String, Object>>();
		if (CollectionUtils.isNotEmpty(menuArray)) {
			final boolean bool = (StringUtils.isNotEmpty(showFlag) && showFlag.equals("true")) ? Boolean.TRUE
					: Boolean.FALSE;
			Map<String, Object> map = null;
			for (SysMenu menu : menuArray) {
				map = new HashMap<String, Object>();
				map.put("id", menu.getMenuCode());
				map.put("name", menu.getMenuName());
				map.put("pId", menu.getParentMenuCode());
				// map.put("url", menu.getMenuUri());
				map.put("open", bool);
				array.add(map);
			}
			menuArray = null;
		}
		return array;
	}

	/**
	 * 获取角色已经拥有权限操作菜单树
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHasMenuTree.do")
	public @ResponseBody List<Map<String, Object>> getHasMenuTree(HttpServletRequest request, String roleCode)
			throws Exception {
		HttpSession session = request.getSession();
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		if (null == operator || StringUtils.isEmpty(operator.getOperId()))
			return null;
		if (StringUtils.isEmpty(roleCode))
			return null;

		/** 菜单数据获取 */
		List<SysMenu> hasMenuArray = sysMenuService.getByRoleCode(roleCode);
		List<Map<String, Object>> array = new ArrayList<Map<String, Object>>();
		if (CollectionUtils.isNotEmpty(hasMenuArray)) {
			Map<String, Object> map = null;
			for (SysMenu menu : hasMenuArray) {
				map = new HashMap<String, Object>();
				map.put("id", menu.getMenuCode());
				map.put("name", menu.getMenuName());
				map.put("pId", menu.getParentMenuCode());
				map.put("checked", Boolean.TRUE);// 选中
				map.put("open", Boolean.TRUE);// 菜单展开
				array.add(map);
			}
			hasMenuArray = null;
		}
		return array;
	}

	/**
	 * 菜单树数据封装
	 * 
	 * @param sourceMenues
	 *            未封装菜单数据
	 * @param parentMenu
	 *            顶级菜单编码
	 * @version 1.0,2013-12-06 11:20,刘高林,Ins
	 */
	private void formartTree(List<SysMenu> sourceMenues, SysMenu parentMenu) {
		for (SysMenu menu : sourceMenues) {
			if (StringUtils.isNotEmpty(menu.getParentMenuCode())
					&& menu.getParentMenuCode().compareTo(parentMenu.getMenuCode()) == 0) {
				List<SysMenu> child = parentMenu.getChildMenus();// 获取现有已关联的子菜单数据
				if (CollectionUtils.isEmpty(child))
					child = new ArrayList<SysMenu>();
				child.add(menu);
				parentMenu.setChild(true);
				parentMenu.setChildMenus(child);
				// 递归进行数据封装
				formartTree(sourceMenues, menu);
			}
		}
	}

	/**
	 * 跳转到菜单列表页面
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/toMenuList.do")
	public String toMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> statusHash = WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP;
		Map map = new HashMap();
		map.put("parentMenuCode", Constants.PARENT_MENU_CODE);
		List<SysMenu> list = sysMenuService.selectMenuByMap(map);
		request.setAttribute("list", list);
		List<SysMenu> menuList = sysMenuService.getAll();
		request.setAttribute("menuList", menuList);
		request.setAttribute("statusHash", statusHash);
		return "system/menu/menuList";
	}

	/**
	 * 查询菜单列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMenuList")
	public @ResponseBody Page getMenuList(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		String menuName = request.getParameter("menuName");
		String menuCode = request.getParameter("menuCode");
		String pageNo = request.getParameter("pageNo");
		pageNo = pageNo == null || pageNo.equals("") ? "1" : pageNo;
		paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo));
		List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("createTime", "desc");
		orderBy.add(hash);
		paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
		paramMap.put("menuName", "" == menuName ? null : menuName);
		paramMap.put("menuCode", "" == menuCode ? null : menuCode);
		paramMap.put("orderBy", orderBy);
		try {
			Page page = sysMenuService.getPageByParamMap(paramMap);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询菜单详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMenuDeatil")
	@ResponseBody
	public Map<String, Object> getMenuDeatil(HttpServletRequest request) throws Exception {
		Map map = new HashMap();
		try {
			String menuCode = request.getParameter("menuCode");
			Map<String, String> param = new HashMap<>();
			param.put("menuCode", menuCode);
			List<SysMenu> menus = sysMenuService.selectMenuByMap(param);
			map.put("menus", menus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 新增菜单/修改
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMenu")
	@ResponseBody
	public Map<String, Object> insertMenu(HttpServletRequest request) throws Exception {
		Map map = new HashMap();
		SysMenu sysMenu = new SysMenu();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		try {
			if (Constants.OPER_TYPE_SAVE.equals(type)) {
				sysMenu.setCreater(operator.getOperId());
			} else {
				sysMenu.setModifier(operator.getOperId());
			}
			sysMenu.setMenuCode(request.getParameter("menuCode"));
			sysMenu.setMenuName(request.getParameter("menuName"));
			sysMenu.setParentMenuCode(request.getParameter("parentCode"));
			sysMenu.setMenuUri(request.getParameter("menuUrl"));
			sysMenu.setReorder(Long.parseLong(request.getParameter("reorder")));
			sysMenu.setRemark(request.getParameter("remark"));
			sysMenu.setStatus(Constants.MENU_STATUS);
			sysMenuService.save(sysMenu, Integer.parseInt(type));
			map.put("success", true);
			if (Constants.OPER_TYPE_SAVE.equals(type)) {
				map.put("message", "新增成功");
			} else {
				map.put("message", "更新成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			if (Constants.OPER_TYPE_SAVE.equals(type)) {
				map.put("message", "新增失败");
			} else {
				map.put("message", "更新失败");
			}
		}
		return map;
	}

	/**
	 * 更新菜单
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMenu")
	@ResponseBody
	public Map<String, Object> updateMenu(HttpServletRequest request) throws Exception {
		Map map = new HashMap();
		SysMenu sysMenu = new SysMenu();
		try {
			sysMenu.setMenuCode(request.getParameter(""));
			sysMenuService.updateMenu(sysMenu);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 获取菜单列表数据
	 *//*
		 * @SuppressWarnings("unchecked")
		 * 
		 * @RequestMapping("/getMenuList") public void
		 * getMenuList(HttpServletRequest request, HttpServletResponse response,
		 * int page, int rows) throws Exception { final String parentCode =
		 * request.getParameter("parentMenuCode");//上级菜单 String menuName1 =
		 * request.getParameter("menuName"); String menuCode1 =
		 * request.getParameter("menuCode"); final String status =
		 * request.getParameter("status"); if
		 * (StringUtils.isNotEmpty(menuName1)){ menuName1 =
		 * menuName1.replaceAll("%", "\\\\%"); menuName1 =
		 * menuName1.replaceAll("_", "\\\\_"); } if
		 * (StringUtils.isNotEmpty(menuCode1)){ menuCode1 =
		 * menuCode1.replaceAll("%", "\\\\%"); menuCode1 =
		 * menuCode1.replaceAll("_", "\\\\_"); } final String menuName =
		 * menuName1; final String menuCode = menuCode1;
		 * 
		 * Map<String, Object> params = new HashMap<String, Object>();
		 * params.put(Page.CURR_PAGE, page); params.put(Page.PAGE_SIZE, rows > 0
		 * ? rows : Page.DEFAULT_PAGE_SIZE);
		 * 
		 * if (StringUtils.isNotEmpty(parentCode)) {
		 * params.put("parentMenuCode", parentCode); } else {
		 * params.put("parentMenuCode",
		 * String.valueOf(CommonConstant.PARENT_ID)); } if
		 * (StringUtils.isNotEmpty(menuCode)) params.put("menuCodeLike",
		 * menuCode); if (StringUtils.isNotEmpty(menuName))
		 * params.put("menuNameLike", menuName); if
		 * (StringUtils.isNotEmpty(status)) params.put("status", status);
		 * 
		 * Page pageObj = sysMenuService.getMenusByParams(params); List<SysMenu>
		 * data = pageObj.getList(); Map<String, Object> map = new
		 * HashMap<String, Object>(); map.put("total",
		 * pageObj.getTotalNumber()); map.put("rows", data);
		 * this.asyncReturnResult(response, JSONObject.fromObject(map)); }
		 */

	/**
	 * 菜单信息禁用
	 * 
	 * @param menuCodes
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteMenu")
	public @ResponseBody Message deleteMenu(String[] menuCodes, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (null == session)
			return null;
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		Message msg = new Message();
		if (null != menuCodes && menuCodes.length > 0) {
			try {
				boolean bool = sysMenuService.deleteLogical(Arrays.asList(menuCodes), operator.getOperId());
				if (bool) {
					// 如果是父账户，则禁用子菜单状态
					sysMenuService.deleteMenuByParentCodes(Arrays.asList(menuCodes), operator.getOperId());

					msg.setFlag(true);
					msg.setMsg("删除成功");
					return msg;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		msg.setFlag(false);
		msg.setMsg("删除失败");
		return msg;
	}

	/**
	 * 渠道状态恢复
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/recoverMenu")
	public @ResponseBody Message recoverMenu(String menuCode, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (null == session)
			return null;
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

		Message msg = new Message();
		if (StringUtils.isNotEmpty(menuCode)) {
			try {
				List<String> codes = new ArrayList<String>();
				codes.add(menuCode);
				boolean bool = sysMenuService.recover(codes, operator.getOperId());
				if (bool) {
					msg.setFlag(true);
					msg.setMsg("恢复成功");
					return msg;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		msg.setFlag(false);
		msg.setMsg("恢复失败");
		return msg;
	}

	/**
	 * 页面跳转（add新增 edit编辑 detail详情）
	 * 
	 * @param request
	 * @param operType
	 * @param menuCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/toPage")
	public String toPage(HttpServletRequest request, String operType, String menuCode) throws Exception {
		// 状态
		Map<String, String> statusHash = WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP;
		request.setAttribute("statusHash", statusHash);
		// 获取菜单数据
		List<SysMenu> menuArray = sysMenuService.getAll();
		request.setAttribute("menuArray", menuArray);

		if (StringUtils.isNotEmpty(operType) && operType.equals("add")) {
			request.setAttribute("type", "add");
			return "system/menu/menuAddOrMod";
		} else if (StringUtils.isNotEmpty(operType) && operType.equals("edit")) {
			SysMenu menu = sysMenuService.get(menuCode);
			request.setAttribute("menu", menu);
			request.setAttribute("type", "edit");
			return "system/menu/menuAddOrMod";
		} else {
			SysMenu menu = sysMenuService.get(menuCode);
			request.setAttribute("menu", menu);
			return "system/menu/menuDetail";
		}
	}

	/**
	 * 菜单新增、编辑
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/menuSaveOrUpdate")
	public @ResponseBody Message menuSaveOrUpdate(HttpServletRequest request, SysMenu menu, String type)
			throws Exception {
		Message msg = new Message();
		try {
			HttpSession session = request.getSession();
			SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

			msg.setFlag(true);
			if (StringUtils.isNotEmpty(type) && type.equals("add")) {
				// 判断数据是否存在
				SysMenu tmp = sysMenuService.get(menu.getMenuCode());
				if (null != tmp) {
					msg.setFlag(false);
					msg.setMsg("添加失败，此菜单编码已经存在");
					return msg;
				}
				// 新增
				menu.setCreater(operator.getOperId());
				sysMenuService.save(menu, 0);
				msg.setMsg("新增菜单信息成功");
			} else {
				// 修改
				menu.setCreater(operator.getOperId());
				menu.setModifyTime(Calendar.getInstance().getTime());
				sysMenuService.save(menu, 1);
				msg.setMsg("修改菜单信息成功");
			}
		} catch (Exception e) {
			msg.setFlag(false);
			msg.setMsg("操作失败");
		}
		return msg;
	}

}
