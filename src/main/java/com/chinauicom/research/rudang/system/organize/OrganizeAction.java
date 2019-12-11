package com.chinauicom.research.rudang.system.organize;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinauicom.research.commons.Message;
import com.chinauicom.research.commons.constant.CommonConstant;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.define.WcsDefinition;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.system.basregion.entity.BasRegion;
import com.chinauicom.research.rudang.system.basregion.service.BasRegionService;
import com.chinauicom.research.rudang.system.menu.entity.SysMenu;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;
import com.chinauicom.research.rudang.system.organize.vo.SysOrganizeVo;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName: OrganizeAction 
 * @Description: TODO(组织管理控制类) 
 * @author Zhongjialiang zhongjialiang@tydic.com 
 * @date 2016-7-26 下午4:40:12 
 *
 */
@Controller
@RequestMapping("/organize")
public class OrganizeAction  {

    @Autowired
    private SysOrganizeService sysOrganizeService;
   
    /**
     * 页面初始加载
     * @param request
     * @param response
     * @return
     * @author zhongjialiang
     */
    @SuppressWarnings("static-access")
    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        // 状态
        request.setAttribute("WCS_COMMON_STATUS_MAP", WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP);
        request.setAttribute("WCS_COMMON_STATUS_MAP_JSON",
                JSONObject.fromObject(WcsDefinition.WcsCommonStatus.WCS_COMMON_STATUS_MAP));

        return "system/organize/managerOrganize";
    }

    /**
     * 获取组织机构树结构数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @SuppressWarnings({ "unchecked", "static-access" })
    @RequestMapping("/getOrganizeTree.do")
    public @ResponseBody
    List<Map<String, Object>> getOrganizeTree(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
		String flag = request.getParameter("flag");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Page.NO_PAGING, true);
        if (StringUtils.isNotEmpty(flag)) {
            params.put("status", WcsDefinition.WcsCommonStatus.WCS_VALID);
        }

        Page sysOrganizePage = sysOrganizeService.getPageByParamMap(params);
        List<SysOrganize> sysOrganizes = sysOrganizePage.getList();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> pMap = new HashMap<String, Object>();
        pMap.put("id", CommonConstant.PARENT_ID);
        pMap.put("pkId", CommonConstant.PARENT_ID);
        pMap.put("name", "菜单");
        pMap.put("open", true);
        pMap.put("pId", "");
//        pMap.put("regionCode", "");
       list.add(pMap);
        for (SysOrganize sysOrganize : sysOrganizes) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", sysOrganize.getOrgCode());
            map.put("pkId", sysOrganize.getOrgCode());
            map.put("name", sysOrganize.getOrgName());
            map.put("pId", sysOrganize.getParentOrgCode());
//            map.put("regionCode", sysOrganize.getRegionCode());

            list.add(map);
        }

        return list;
    }
    
    /**
     * 获取组织机构树结构数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @SuppressWarnings({ "unchecked", "static-access" })
    @RequestMapping("/getOrganizeTreeByOrgCode.do")
    public @ResponseBody
    List<Map<String, Object>> getOrganizeTreeByOrgCode(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
		SysOperator operator = (SysOperator)request.getSession().getAttribute(WcsSessionConstant.SESSION_OPERATOR);
		String orgCode=operator.getOrgCode();
		
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgCode", orgCode);
        Page sysOrganizePage = sysOrganizeService.getPageByParamMap1(params);
        List<SysOrganize> sysOrganizes = sysOrganizePage.getList();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> pMap = new HashMap<String, Object>();
        pMap.put("id", CommonConstant.PARENT_ID);
        pMap.put("pkId", CommonConstant.PARENT_ID);
        pMap.put("name", "菜单");
        pMap.put("open", true);
        pMap.put("pId", "");
//        pMap.put("regionCode", "");
       list.add(pMap);
        for (SysOrganize sysOrganize : sysOrganizes) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", sysOrganize.getOrgCode());
            map.put("pkId", sysOrganize.getOrgCode());
            map.put("name", sysOrganize.getOrgName());
            map.put("pId", sysOrganize.getParentOrgCode());
//            map.put("regionCode", sysOrganize.getRegionCode());

            list.add(map);
        }

        return list;
    }

    /**
     * 获取组织机构列表
     * @param request
     * @param response
     * @param page
     * @param rows
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/getOrganizeList.do")
    public @ResponseBody
    Page getOrganizeList(HttpServletRequest request)
            throws Exception {
    	
    	Map<String,Object>paramMap=new HashMap<>();
		String orgName=request.getParameter("orgName");
		String orgCode=request.getParameter("orgCode");
		String OnorgCode=request.getParameter("OnorgCode");
		String status=request.getParameter("status");
		//List<String> OnorgCodes = new ArrayList<String>();
		if (OnorgCode!=null){
			String[] OnorgCodes = OnorgCode.split(",");
			if(OnorgCode!=null&&OnorgCode!=""){
				paramMap.put("OnorgCode",OnorgCodes);
			}
		}
		String pageNo = request.getParameter("pageNo");
		pageNo = pageNo==null||pageNo.equals("")?"1":pageNo;
		paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo));
		paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
		
		if(orgName!=null&&orgName!=""){
			paramMap.put("orgName",orgName);
		}
		if(orgCode!=null&&orgCode!=""){
			paramMap.put("orgCode",orgCode);
		}
		/*if(OnorgCode!=null&&OnorgCode!=""){
			paramMap.put("OnorgCode",OnorgCodes);
		}*/
		if(status!=null&&status!=""){
			paramMap.put("status",status);
		}
		List<Map<String, Object>> orderBy = new ArrayList<Map<String, Object>>();
    	Map<String, Object> hash = new HashMap<String, Object>();
    	hash.put("createTime", "desc");
    	orderBy.add(hash);
    	paramMap.put("orderBy", orderBy);

		
		paramMap.put("parentMenuCodeNot","-1");
		
		try {
			Page page=sysOrganizeService.getPageByParamMap1(paramMap);
			return page;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
    }

    /**
     * 获取组织机构详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @RequestMapping("/getOrganizeDetail.do")
    public @ResponseBody
    SysOrganizeVo getOrganizeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String orgCode = request.getParameter("orgCode");

        SysOrganize sysOrganize = sysOrganizeService.get(orgCode);

        SysOrganizeVo sysOrganizeVo = new SysOrganizeVo();
        BeanUtils.copyProperties(sysOrganize, sysOrganizeVo);

        // 查询上级机构名称
        SysOrganize pOrg = sysOrganizeService.get(sysOrganize.getParentOrgCode());
        if (pOrg != null) {
            sysOrganizeVo.setParentOrgName(pOrg.getOrgName());
        }

        return sysOrganizeVo;
    }
    /**
     * 
     * @Title: orgAdd 
     * @Description: TODO(组织机构新增) 
     * @param @param request
     * @param @param response
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @SuppressWarnings("static-access")
    @RequestMapping("/orgAdd.do")
    public String orgAdd(HttpServletRequest request, HttpServletResponse response) {
    	String type = request.getParameter("type");
        request.setAttribute("type", type);
    	return "system/organize/manageOrganizeAdd";
    }
    /**
     * @throws Exception 
     * 
     * @Title: orgModify 
     * @Description: TODO(修改) 
     * @param @param request
     * @param @param response
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @SuppressWarnings("static-access")
    @RequestMapping("/orgModify.do")
    public String orgModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String orgCode =  request.getParameter("orgCode");
    	String type = request.getParameter("type");
  	   //查询出修改的数据
       SysOrganize sysOrganize = sysOrganizeService.get(orgCode);
       request.setAttribute("sysOrganize", sysOrganize);
       request.setAttribute("type", type);
       return "system/organize/manageOrganizeModify"; 
	}
    /**
     * 新增/修改组织机构
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @SuppressWarnings("static-access")
    @RequestMapping("/update.do")
    public @ResponseBody
    Message updateLabel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

        Message msg = new Message();
        String orgCode = request.getParameter("orgCode");
        orgCode = StringUtils.trim(orgCode);
        if (StringUtils.isEmpty(orgCode)) {
        	msg.setMsg("组织机构不能为空!");
        	
            return msg;
        }
        String orgName = request.getParameter("orgName");
        if (StringUtils.isEmpty(orgName)) {
            msg.setMsg("组织机构名称不能为空!");
            return msg;
        }
        String parentOrgCode = request.getParameter("parentOrgCode");
        if (StringUtils.isEmpty(parentOrgCode)) {
            parentOrgCode = String.valueOf(CommonConstant.PARENT_ID);
        }
        String status = request.getParameter("status");
        String orgDesc = request.getParameter("orgDesc");
        String type = request.getParameter("type");

        // 查询组织机构是否存在
        SysOrganize sysOrganize = sysOrganizeService.get(orgCode);

        SysOrganize organize = null;
        if("0".equals(type)){//新增标志判断
        	if(sysOrganize != null){
        		 msg.setMsg("此组织机构已经存在!");
        		 msg.setFlag(false);
                 return msg;
        	}
        }
        // 组织机构为空新增
        if (sysOrganize == null) {
            sysOrganize = new SysOrganize();
            sysOrganize.setOrgCode(orgCode);
            sysOrganize.setOrgName(orgName);
            sysOrganize.setParentOrgCode(parentOrgCode);
            sysOrganize.setCreateTime(new Date());
            sysOrganize.setOrgDesc(orgDesc);
            sysOrganize.setCreater(operator.getOperId());
            sysOrganize.setStatus(WcsDefinition.WcsCommonStatus.WCS_VALID);

            organize = sysOrganizeService.save(sysOrganize, 0);
            if (organize != null) {
                msg.setMsg("新增成功!");
            }
            else {
            	msg.setFlag(false);
                msg.setMsg("新增组织机构不成功!");
            }
        }
        // 组织机构不为空修改
        else {
            sysOrganize.setOrgCode(orgCode);
            sysOrganize.setOrgName(orgName);
            sysOrganize.setParentOrgCode(parentOrgCode);
            sysOrganize.setStatus(status);
            sysOrganize.setOrgDesc(orgDesc);
            sysOrganize.setModifier(operator.getOperId());

            organize = sysOrganizeService.save(sysOrganize, 1);
            if (organize != null) {
                msg.setMsg("更新成功!");
            }
            else {
            	msg.setFlag(false);
                msg.setMsg("更新不成功!");
            }
        }

    
        return msg;
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author yangziran
     */
    @RequestMapping("/delete.do")
    public @ResponseBody
    Message deleteLabel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

        String orgCode = request.getParameter("orgCode");
        List<String> orgCodeIds = new ArrayList<String>();
        orgCodeIds.add(orgCode);

        // 查询下级机构
        List<SysOrganize> sysOrganizeList = sysOrganizeService.getByParentOrgCode(orgCode);
        if (CollectionUtils.isNotEmpty(sysOrganizeList)) {
            for (SysOrganize sysOrganize : sysOrganizeList) {
            	orgCodeIds.add(sysOrganize.getOrgCode());
            }
        }

        // 物理删除该组织机构以下的数据
        boolean flag = sysOrganizeService.deleteByPks(orgCodeIds);

        Message msg = new Message();
        if (flag) {
            msg.setMsg("删除成功!");
        }
        else {
            msg.setMsg("删除失败!");
        }
        return msg;
    }

    /**
     * 恢复
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author zhongjialiang
     */
    @RequestMapping("/recover.do")
    public @ResponseBody
    Message recover(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);

        String orgCode = request.getParameter("orgCode");
        List<String> ids = new ArrayList<String>();
        ids.add(orgCode);

        // 查询下级机构
        List<SysOrganize> sysOrganizeList = sysOrganizeService.getByParentOrgCode(orgCode);
        if (CollectionUtils.isNotEmpty(sysOrganizeList)) {
            for (SysOrganize sysOrganize : sysOrganizeList) {
                ids.add(sysOrganize.getOrgCode());
            }
        }

        boolean flag = sysOrganizeService.recover(ids, operator.getOperId());

        Message msg = new Message();
        if (flag) {
            msg.setMsg("恢复成功!");
        }
        else {
            msg.setMsg("恢复失败!");
        }
        return msg;
    }
}