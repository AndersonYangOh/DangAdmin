package com.chinauicom.research.rudang.process;

import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.chinauicom.research.commons.constant.WcsSessionConstant;  
import com.chinauicom.research.commons.utils.Page; 
import com.chinauicom.research.rudang.process.service.OperOrganService; 
import com.chinauicom.research.rudang.system.operator.entity.SysOperator; 
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorExportTable;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;
import com.chinauicom.research.rudang.system.role.entity.SysOperRole;
import com.chinauicom.research.rudang.system.role.service.SysRoleService;
import com.chinauicom.research.commons.ExportExcel;
 
/**
 * 
 * @ClassName: SysMenuAction
 * @Description: TODO(后台菜单管理)
 * @author huangChuQin
 * @date 2016-7-18 上午9:51:13
 *
 */
@Controller
@RequestMapping("/operOrgan")
public class OperOrganAction {

	@Autowired
	private OperOrganService operOrganService;
	@Resource
	SysOrganizeService sysOrganizeService;
    @Resource
    SysRoleService sysRoleService;
    ExportExcel export;
    @RequestMapping("/exportExcel.do")
    public void ExportExcel(HttpServletRequest request,HttpServletResponse response)throws  Exception{
    	Map<String,Object>paramMap=new HashMap<>();
    	HttpSession session = request.getSession();
    	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR); 
		SysOrganize orgInfo = sysOrganizeService.get(operator.getOrgCode());
		List<SysOperRole> list1=sysRoleService.selectOperRole(operator.getOperId()); 
        List<SysOperatorExportTable> list = new ArrayList<SysOperatorExportTable>();
		String partenOrg = orgInfo.getParentOrgCode(); 		
		if(list1.get(0).getRoleName().equals("党群工作室")){			
			while(!partenOrg.equals("-1")){//父节点不是-1就一直取父节点
				orgInfo = sysOrganizeService.get(orgInfo.getParentOrgCode());
				partenOrg = orgInfo.getParentOrgCode();
			}
			String parentOrgCode = orgInfo.getOrgCode(); 
			paramMap.put("parentOrgCode", "" == parentOrgCode ? null : parentOrgCode);  
			list=operOrganService.selectExportExcelByParentOrgan(paramMap); 
		}else if(list1.get(0).getRoleName().equals("组织委员")){ 
			String orgCode = operator.getOrgCode();  
			paramMap.put("orgCode", "" == orgCode ? null : orgCode);  
			list=operOrganService.selectExportExcelByOragn(paramMap); 
		} 
        try {              
//            设置表头
            List<String> headInfoList = new ArrayList<String>();
            headInfoList.add("序号");
            headInfoList.add("党员姓名");
            headInfoList.add("性别");
            headInfoList.add("出生年月");
            headInfoList.add("民族");
            headInfoList.add("年龄");
            headInfoList.add("学历情况");
            headInfoList.add("职称");
            headInfoList.add("单位");
            headInfoList.add("部门");
            headInfoList.add("职务");
            headInfoList.add("是否千人计划、万人计划");

            headInfoList.add("递交入党申请书时间");
            headInfoList.add("确定为积极分子时间");
            headInfoList.add("确定为发展对象时间");
            headInfoList.add("参加培训时间");
            headInfoList.add("政审时间");
            headInfoList.add("预审请示时间");
            headInfoList.add("批复时间");
            headInfoList.add("入党时间");
            headInfoList.add("党委审批时间");
            headInfoList.add("转正时间");
            headInfoList.add("党委审批时间");
            headInfoList.add("培养联系人");
//            设置内容
            List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();   
            Map<String, Object> dataItem = null; 
            
            for(int i=0; i < list.size(); i++){   
                dataItem = new HashMap<String, Object>();   
                SysOperatorExportTable fa =list.get(i);  
                dataItem.put("序号", i+1);                  
                dataItem.put("党员姓名", fa.getOperName());   
                dataItem.put("性别", fa.getOperSex());   
                dataItem.put("出生年月", fa.getOperBirth());   
                dataItem.put("民族", fa.getOperNation());   
                dataItem.put("年龄", fa.getOperAge());   
                dataItem.put("学历情况", fa.getOperDegree());   
                dataItem.put("职称", fa.getOperProfessional()); 
                dataItem.put("单位", fa.getOperCompany());  
                dataItem.put("部门", fa.getOperDep()); 
                dataItem.put("职务", fa.getOperTitle()); 
                dataItem.put("是否千人计划、万人计划", fa.getOperThousand()); 
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
                if(fa.getStageId1()!=null)
                dataItem.put("递交入党申请书时间" , sdf.format(fa.getStageId1()));
                if(fa.getStageId6()!=null)
                dataItem.put("确定为积极分子时间", sdf.format(fa.getStageId6()));
                if(fa.getStageId20()!=null)
                dataItem.put("确定为发展对象时间", sdf.format(fa.getStageId20()));
                if(fa.getStageId29()!=null)
                dataItem.put("参加培训时间", sdf.format(fa.getStageId29()));
                if(fa.getStageId28()!=null)
                dataItem.put("政审时间",sdf.format( fa.getStageId28()));
                if(fa.getStageId31()!=null)
                dataItem.put("预审请示时间", sdf.format(fa.getStageId31()));
                if(fa.getStageId32()!=null)
                dataItem.put("批复时间", sdf.format(fa.getStageId32()));
                if(fa.getStageId36()!=null)
                dataItem.put("入党时间", sdf.format(fa.getStageId36()));
                if(fa.getStageId49()!=null)
                dataItem.put("党委审批时间", sdf.format(fa.getStageId49()));
                if(fa.getStageId62()!=null)
                dataItem.put("转正时间", sdf.format(fa.getStageId62()));
                if(fa.getStageId67()!=null)
                dataItem.put("党委审批时间", sdf.format(fa.getStageId67()));
                dataItem.put("培养联系人", fa.getStageId11());
                dataList.add(dataItem);   
                } 
           export.exportExcel2FilePath("中国联通直属党委工作情况统计表","中国联通直属党委工作情况统计表.xls", headInfoList, dataList,response);//sheetName,fileName,headInfoList,dataList,response
            // export.exportExcel2FilePath(0,1,"资金计划汇总表","资金计划汇总表.xls", headInfoList, dataList,response);//sheetName,fileName,headInfoList,dataList,response
        }catch (Exception e){
            //log.error("ERROR:",e);
        }
    }
    
    
	@RequestMapping("/toOperList.do")
	public String toOperList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR); 
    	List<SysOperRole> list=sysRoleService.selectOperRole(operator.getOperId());  
    	request.setAttribute("roleName",list.get(0).getRoleName()); 
		return "homepage/operList";
	}
	
	
	@RequestMapping("/toOperList1.do")
	public String toOperList1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR); 
    	List<SysOperRole> list=sysRoleService.selectOperRole(operator.getOperId());  
    	request.setAttribute("roleName",list.get(0).getRoleName()); 
		return "homepage/operList1";
	}
	
	
	@RequestMapping("/getOperList")
	public @ResponseBody Page getOperList(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		HttpSession session = request.getSession();
    	SysOperator operator = (SysOperator) session.getAttribute(WcsSessionConstant.SESSION_OPERATOR); 
		SysOrganize orgInfo = sysOrganizeService.get(operator.getOrgCode());
		List<SysOperRole> list=sysRoleService.selectOperRole(operator.getOperId()); 
		String partenOrg = orgInfo.getParentOrgCode(); 
		
		if(list.get(0).getRoleName().equals("党群工作室")){
			
			while(!partenOrg.equals("-1")){//父节点不是-1就一直取父节点
				orgInfo = sysOrganizeService.get(orgInfo.getParentOrgCode());
				partenOrg = orgInfo.getParentOrgCode();
			}
			String parentOrgCode = orgInfo.getOrgCode();
			String operName = request.getParameter("operName");
			String orgName = request.getParameter("orgName");
			String orgCode =null;
			if(""!=orgName){
				SysOrganize o = new SysOrganize();
				o.setOrgName(orgName);
				orgCode = ((SysOrganize)sysOrganizeService.selectByVo(o).get(0)).getOrgCode();				
			} 
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo == null || pageNo.equals("") ? "1" : pageNo;
			paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo)); 
			paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
			paramMap.put("parentOrgCode", "" == parentOrgCode ? null : parentOrgCode);
			paramMap.put("operName", "" == operName ? null : operName);
			paramMap.put("orgCode", "" == orgCode ? null : orgCode); 
			try {
				Page page = operOrganService.selectByParentOrgan(paramMap);
				return page;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(list.get(0).getRoleName().equals("组织委员")){
			String operName = request.getParameter("operName");
			String orgCode = operator.getOrgCode();
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo == null || pageNo.equals("") ? "1" : pageNo;
			paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo)); 
			paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
			paramMap.put("operName", "" == operName ? null : operName);
			paramMap.put("orgCode", "" == orgCode ? null : orgCode); 
			try {
				Page page = operOrganService.selectByOragn(paramMap);
				return page;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	@RequestMapping("/getByOragn")
	public @ResponseBody Page getByOragn(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		String operName = request.getParameter("operName");
		String orgCode = request.getParameter("orgCode");
		String pageNo = request.getParameter("pageNo");
		pageNo = pageNo == null || pageNo.equals("") ? "1" : pageNo;
		paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo)); 
		paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
		paramMap.put("operName", "" == operName ? null : operName);
		paramMap.put("orgCode", "" == orgCode ? null : orgCode); 
		try {
			Page page = operOrganService.selectByOragn(paramMap);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/getByParentOrgan")
	public @ResponseBody Page getByParentOrgan(HttpServletRequest request) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		String parentOrgCode = request.getParameter("parentOrgCode");
		String operName = request.getParameter("operName");
		String orgCode = request.getParameter("orgCode");
		String pageNo = request.getParameter("pageNo");
		pageNo = pageNo == null || pageNo.equals("") ? "1" : pageNo;
		paramMap.put(Page.CURR_PAGE, Integer.parseInt(pageNo)); 
		paramMap.put(Page.PAGE_SIZE, Page.DEFAULT_PAGE_SIZE);
		paramMap.put("parentOrgCode", "" == parentOrgCode ? null : parentOrgCode);
		paramMap.put("operName", "" == operName ? null : operName);
		paramMap.put("orgCode", "" == orgCode ? null : orgCode); 
		try {
			Page page = operOrganService.selectByParentOrgan(paramMap);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	 

}
