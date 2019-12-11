package com.chinauicom.research.rudang.system.user;

import com.chinauicom.research.commons.Constants;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.process.service.OperOrganService;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorDetail;
import com.chinauicom.research.rudang.system.operator.service.SysOperatorService;
import com.chinauicom.research.rudang.system.operator.vo.SysOperateVo;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;
import com.chinauicom.research.rudang.system.role.entity.SysOperRole;
import com.chinauicom.research.rudang.system.role.service.SysRoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 * 用户管理
 * Created by long on 2016/7/28.
 */
@Controller
@RequestMapping("/sysUser")
public class sysUserAction {
	protected final  Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Resource
    SysOperatorService sysOperatorService;
    @Resource
    SysRoleService sysRoleService;
    @Resource
    SysOrganizeService sysOrganizeService;
	@Autowired
	private OperOrganService operOrganService;
    /**
     * 用户列表
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/toUserList.do")
    public String toUserList(HttpServletRequest request)throws  Exception{
        return "system/user/userManage";
    }
    
    @RequestMapping("/toUserOrganList.do")
    public String toUserOrganList(HttpServletRequest request)throws  Exception{

    	HttpSession session = request.getSession();
    	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR); 
		String orgCode = operator.getOrgCode();
		request.setAttribute("orgCode",orgCode);
        return "system/user/userOrganManage";
    }
    @RequestMapping("/getUserOrganList.do")
    public @ResponseBody Page getUserOrganList(HttpServletRequest request)throws Exception{
        Map<String,Object>paramMap=new HashMap<>(); 
        String  operName=request.getParameter("operName"); 
        String orgCode=request.getParameter("orgCode");
        String pageNo = request.getParameter("pageNo");
        pageNo = pageNo==null||pageNo.equals("")?Constants.PAGE_NO:pageNo;
        paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo)); 
        paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE); 
        paramMap.put("operName","" ==operName ? null:operName); 
        paramMap.put("orgCode","" ==orgCode ? null:orgCode); 
        try {
            log.debug("开始查询！");
            Page page = operOrganService.selectByOragn(paramMap);
            log.debug("查询列表结束");
            return page;
        }catch (Exception e){
            log.error("ERROR:",e);
        }
        return null;
    }
    /**
     * 获取用户列表
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserList.do")
    public @ResponseBody Page getUserList(HttpServletRequest request)throws Exception{
        Map<String,Object>paramMap=new HashMap<>();
        String operAccount=request.getParameter("operAccount");
        String  operName=request.getParameter("operName");
        String status=request.getParameter("status");
        String pageNo = request.getParameter("pageNo");
        pageNo = pageNo==null||pageNo.equals("")?Constants.PAGE_NO:pageNo;
        paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo));
        List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("createTime", "desc");
        orderBy.add(hash);
        paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
        paramMap.put("operAccount","" ==operAccount ? null:operAccount);
        paramMap.put("operNameLike","" ==operName ? null:operName);
        paramMap.put("status","" ==status ? null:status);
        paramMap.put("orderBy",orderBy);
        try {
            log.debug("开始查询！");
            Page page=sysOperatorService.getPageByParamMap(paramMap);
            log.debug("查询列表结束");
            return page;
        }catch (Exception e){
            log.error("ERROR:",e);
        }
        return null;
    }
    
    /**
     * 获取用户列表
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserListByOrgCode.do")
    public @ResponseBody Page getUserListByOrgCode(HttpServletRequest request)throws Exception{
    	SysOperator operator = (SysOperator)request.getSession().getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		String orgCode=operator.getOrgCode();
        Map<String,Object>paramMap=new HashMap<>();
        String operAccount=request.getParameter("operAccount");
        String operName=request.getParameter("operName");
        String status=request.getParameter("status");
        String pageNo = request.getParameter("pageNo");
        pageNo = pageNo==null||pageNo.equals("")?Constants.PAGE_NO:pageNo;
        paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo));
        List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("createTime", "desc");
        orderBy.add(hash);
        paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
        paramMap.put("orgCode",orgCode);
        paramMap.put("operAccount","" ==operAccount ? null:operAccount);
        paramMap.put("operNameLike","" ==operName ? null:operName);
        paramMap.put("status","" ==status ? null:status);
        paramMap.put("orderBy",orderBy);
        try {
            log.debug("开始查询！");
            Page page=sysOperatorService.getPageByParamMap(paramMap);
            log.debug("查询列表结束");
            return page;
        }catch (Exception e){
            log.error("ERROR:",e);
        }
        return null;
    }

    /**
     * 新增/修改用户
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/toUserAdd.do")
    public String toUserAdd(HttpServletRequest request)throws Exception{
        String operId=request.getParameter("operId");
        String operType=request.getParameter("operType");
        if(Constants.OPER_TYPE_UPDATE.equals(operType)){
            log.debug("修改信息：>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            SysOperator sysOperator=sysOperatorService.get(operId);
            SysOperatorDetail sysOperatorDetail=sysOperatorService.getDetail(operId);
            SysOrganize sysOrganize=sysOrganizeService.get(sysOperator.getOrgCode());
            List<SysOperRole> list=sysRoleService.selectOperRole(operId);
            List<String> orgCode=new ArrayList<>();
            for (SysOperRole role:list) {
                orgCode.add(role.getRoleCode());
            }
            request.setAttribute("orgCode",orgCode);
            request.setAttribute("sysOperator",sysOperator);
            request.setAttribute("sysOrganize",sysOrganize);
            request.setAttribute("sysOperatorDetail",sysOperatorDetail);
            request.setAttribute("list",list);
            request.setAttribute("flag",Constants.OPER_TYPE_UPDATE);
        }else {
            request.setAttribute("flag",Constants.OPER_TYPE_SAVE);            
        }
        return "system/user/userAdd";
    }
    
    @RequestMapping("/toUserOrganAdd.do")
    public String toUserOrganAdd(HttpServletRequest request)throws Exception{
        String operId=request.getParameter("operId");
        String operType=request.getParameter("operType");
        if(Constants.OPER_TYPE_UPDATE.equals(operType)){
            log.debug("修改信息：>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            SysOperator sysOperator=sysOperatorService.get(operId);
            SysOperatorDetail sysOperatorDetail=sysOperatorService.getDetail(operId);
            SysOrganize sysOrganize=sysOrganizeService.get(sysOperator.getOrgCode());
            List<SysOperRole> list=sysRoleService.selectOperRole(operId);
            List<String> orgCode=new ArrayList<>();
            for (SysOperRole role:list) {
                orgCode.add(role.getRoleCode());
            }
            request.setAttribute("orgCode",orgCode);
            request.setAttribute("sysOperator",sysOperator);
            request.setAttribute("sysOrganize",sysOrganize);
            request.setAttribute("sysOperatorDetail",sysOperatorDetail);
            request.setAttribute("list",list);
            request.setAttribute("flag",Constants.OPER_TYPE_UPDATE);
        }else {

        	HttpSession session = request.getSession();
        	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);   
            SysOrganize sysOrganize=sysOrganizeService.get(operator.getOrgCode());
            request.setAttribute("sysOrganize",sysOrganize);
            request.setAttribute("flag",Constants.OPER_TYPE_SAVE);            
        }
        return "system/user/userOrganAdd";
    }

    /**
     * 获取角色列表
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getRoleList.do")
    public @ResponseBody Page getRoleList(HttpServletRequest request)throws Exception{
        Map map=new HashMap();
        String roleCode=request.getParameter("roleCode");
        String roleName=request.getParameter("roleName");
        String pageNo = request.getParameter("pageNo");
        pageNo = pageNo==null||pageNo.equals("")?Constants.PAGE_NO:pageNo;
        map.put(Page.CURR_PAGE, Integer.parseInt(pageNo));
        List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("createTime", "desc");
        orderBy.add(hash);
        map.put(Page.PAGE_SIZE, Constants.PAGE_SIZE);
        map.put("roleCode",""==roleCode?null : roleCode);
        map.put("roleName",""==roleName?null : roleName);
        map.put("orderBy",orderBy);
       
        try {
            Page page=sysRoleService.getPageByParamMap(map);
            return page;
        }catch (Exception e){
            log.error("ERROR:",e);
        }
        return null;
    }

    /**
     * 获取用户详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @RequestMapping("/getOperateDetail.do")
    public @ResponseBody
    SysOperator getOperateDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String operId = request.getParameter("operId");//获取用户id
        SysOperator sysOperator = sysOperatorService.get(operId);//获取用户信息
        SysOperator sysOperate = new SysOperator();
        BeanUtils.copyProperties(sysOperator, sysOperate);//copy操作
        if(sysOperator.getOrgCode()!=null){
        	SysOrganize sysOrganize=sysOrganizeService.get(sysOperator.getOrgCode());//获取组织机构信息
            if(sysOrganize==null || sysOrganize.getOrgName()==null || "".equals(sysOrganize.getOrgName())){
                sysOperate.setOrgName("");
            }else{
                sysOperate.setOrgName(sysOrganize.getOrgName());
            }
        }
        if(operId!=null){
        	   List<SysOperRole> list=sysRoleService.selectOperRole(operId);
        	   sysOperate.setSysOperRole(list);
        }
        return sysOperate;
    }

    /**
     * 新增或者修改用户
     * @param request
     * @return
     */
    @RequestMapping("/saveOrUpdateUser.do")
    @ResponseBody
    public Map<String,Object> saveOrUpdateUser(HttpServletRequest request){
        Map map=new HashMap();
        Map<String,Object>paramMap=new HashMap<>();
        SysOperator sysOperator=new SysOperator();
        String operType=request.getParameter("operType");
        String roleCodes=request.getParameter("roleCode");
        SysOperator operator = (SysOperator) request.getSession().getAttribute(WcsSessionConstant.SESSION_OPERATOR);
        String[] roles=roleCodes.split(",");
        Set<String> hs=new HashSet<String>();
        for (int i=0;i<roles.length;i++){
            hs.add(roles[i]);
        }
        String[] arr=new String[hs.size()];
        try {
            if (Constants.OPER_TYPE_UPDATE.equals(operType)){
                sysOperator.setOperId(request.getParameter("oldOperId"));
                /*List<SysOperRole> list=sysRoleService.selectOperRole(request.getParameter("oldOperId"));
                for (SysOperRole role:list) {
                    hs.add(role.getRoleCode());
                }*/
                sysOperator.setModifier(operator.getOperId());
                paramMap.put("operId", request.getParameter("oldOperId"));
            }else {
                sysOperator.setCreater(operator.getOperId());
            }
            String operPwd=request.getParameter("operPwd");
            sysOperator.setOperAccount(request.getParameter("operAccount"));
            sysOperator.setOperPwd(""==operPwd?null:operPwd);
            sysOperator.setOperName(request.getParameter("operName"));
            sysOperator.setOrgCode(request.getParameter("orgCode"));
            sysOperator.setOperCardNo(request.getParameter("idCard"));
            sysOperator.setOperMobile(request.getParameter("mobile"));
            sysOperator.setOperAddr(request.getParameter("operAddr"));
            sysOperator.setPosition(request.getParameter("position"));
            sysOperator.setOperEmail(request.getParameter("email"));
            sysOperator.setStatus(Constants.ROLE_STATUS_NORMAL);
            paramMap.put("operName", request.getParameter("operName"));
            paramMap.put("operBirth", request.getParameter("operBirth"));
            paramMap.put("operAge", request.getParameter("operAge"));
            paramMap.put("operTitle", request.getParameter("operTitle"));
            paramMap.put("operDep", request.getParameter("operDep"));
            paramMap.put("operThousand", request.getParameter("operThousand"));
            paramMap.put("operSex", request.getParameter("operSex"));
            paramMap.put("operNation", request.getParameter("operNation"));
            paramMap.put("operDegree", request.getParameter("operDegree"));
            paramMap.put("operNativePlace", request.getParameter("operNativePlace"));
            paramMap.put("operCardNo", request.getParameter("operCardNo"));
            paramMap.put("operTimeToWork", request.getParameter("operTimeToWork"));
            paramMap.put("operCompany", request.getParameter("operCompany"));
            paramMap.put("operProfessional", request.getParameter("operProfessional"));
            paramMap.put("operUserType", request.getParameter("operUserType"));
            sysOperatorService.save(sysOperator,hs.toArray(arr),Integer.parseInt(operType),paramMap);
            
            map.put("success",true);
            if(Constants.OPER_TYPE_UPDATE.equals(operType)){
               map.put("message","更新成功！");
            }else {
                map.put("message","新增成功！");
            }
        }catch (Exception e){
            log.error("Error:",e);
            map.put("success",false);
            if(Constants.OPER_TYPE_UPDATE.equals(operType)){
                map.put("message","更新失败！");
            }else {
                map.put("message","新增失败！");
            }
        }
        return map;
    }
    
    /**
     * 
     * @Title: changStatus 
     * @Description: TODO(逻辑删除用户) 
     * @param @param request
     * @param @param response
     * @param @return
     * @param @throws Exception    设定文件 
     * @return SysOperateVo    返回类型 
     * @throws
     */
    @RequestMapping("/changStatus.do")
    public @ResponseBody SysOperateVo changStatus(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
    	SysOperateVo vo = new SysOperateVo();
    	String operId = request.getParameter("operId");
    	String operType = request.getParameter("operType");
    	if (operId!=null&&!"".equals(operId)) {
    		if (operType!=null&&!"".equals(operType)) {
        		List<String> ids = new ArrayList<String>();
        		ids.add(operId);
        		if (operType.equals("0"))
        			sysOperatorService.deleteLogical(ids, operator.getOperId());
        		else
        			sysOperatorService.recover(ids, operator.getOperId());
			}
		}
		return vo;
    }
}
