package com.chinauicom.research.rudang.process;

import com.chinauicom.research.commons.Constants;
import com.chinauicom.research.commons.Message;
import com.chinauicom.research.commons.constant.WcsSessionConstant;
import com.chinauicom.research.commons.utils.Page;
import com.chinauicom.research.rudang.process.entity.RudangProcess;
import com.chinauicom.research.rudang.process.service.ProcessService;
import com.chinauicom.research.rudang.system.operator.vo.SysOperateVo;
import com.chinauicom.research.rudang.system.organize.entity.SysOrganize;
import com.chinauicom.research.rudang.system.organize.service.SysOrganizeService;
import com.chinauicom.research.rudang.system.role.entity.SysOperRole;
import com.chinauicom.research.rudang.system.role.service.SysRoleService;
import com.chinauicom.research.rudang.system.operator.entity.SysOperator;
import com.chinauicom.research.rudang.system.operator.service.SysOperatorService;
import com.chinauicom.research.rudang.system.operator.service.bo.SysOperatorBo;

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

@Controller
@RequestMapping("/Process")
public class ProcessAction {
	protected final  Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    ProcessService processService;
    @Autowired
	private SysOperatorService sysOperatorService;
    /**
     * 跳转至入党流程
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/toRudangProcess.do")
    public String toRudangProcess(HttpServletRequest request)throws  Exception{
    	String operId=request.getParameter("operId");
    	String materialId=request.getParameter("materialId");
    	String geren=request.getParameter("geren");
    	try {
    		int period;
    		Map<String,Object>params=new HashMap<>();
    		if(operId==null||operId==""){
        		SysOperator operator = (SysOperator)request.getSession().getAttribute(WcsSessionConstant.SESSION_OPERATOR);
        		operId=operator.getOperId();
        		//获取用户当前所在步骤
        		params.put("operId",operId);
        		if(materialId==null||materialId==""){
            		period=processService.selectProcessPeriod(params);
        		}else{
            		period=Integer.valueOf(materialId);
        		}
        		//获取该步骤所有信息
        		request.setAttribute("operId",operId);
        	}else{
        		//获取用户当前所在步骤
        		params.put("operId",operId);
        		if(materialId==null||materialId==""){
            		period=processService.selectProcessPeriod(params);
        		}else{
            		period=Integer.valueOf(materialId);
        		}
        		//获取该步骤所有信息
        		request.setAttribute("operId",operId);
        	}
    		
    		if(geren==null||geren=="") {
    			
    			switch(period){
        		case 1:
            		return "process/stage1";//改
        		case 2:
            		return "process/stage2";//改
        		case 3:
            		return "process/stage3";//改
        		case 4:
            		return "process/stage4";//改
        		case 5:
            		return "process/stage5";//改
        		}

        		
    		}else {
    			
    			switch(period){
        		case 1:
            		return "process/unUpdStage1";//改
        		case 2:
            		return "process/unUpdStage2";//改
        		case 3:
            		return "process/unUpdStage3";//改
        		case 4:
            		return "process/unUpdStage4";//改
        		case 5:
            		return "process/unUpdStage5";//改
        		}
    			
    		}
    		
    		
    	} catch (Exception e) {
			log.error("跳转页面出错:", e);
		}
        return "process/stage1";
    }
    @RequestMapping("/getRudangProcess.do")
    @ResponseBody
    public Message getRudangProcess(HttpServletRequest request)throws  Exception{
    	Message msg = new Message();
    	String operId=request.getParameter("operId");
    	String materialId=request.getParameter("materialId");
    	try {
    		Map<String, Object> resultMap = new HashMap<String, Object>();
    		Map<String,Object>params=new HashMap<>();
    		params.put("operId",operId);
    		params.put("materialId",materialId);
    		List<RudangProcess> rudangProcess = processService.selectProcess(params);
    		resultMap.put("rudangProcess", rudangProcess);
    		msg.setResult(resultMap);
    		msg.setFlag(true);
			msg.setMsg("查询成功");
    	} catch (Exception e) {
			log.error("跳转页面出错:", e);
			msg.setFlag(false);
			msg.setMsg("查询出错");
		}
    	return msg;
    }
    
    @RequestMapping("/updateRudangProcess.do")
    @ResponseBody
    public Message updateRudangProcess(HttpServletRequest request)throws  Exception{
    	Message msg = new Message();
    	String operId=request.getParameter("operId");
    	String materialId=request.getParameter("materialId");
    	String stageId=request.getParameter("stageId");
    	String completionTime1=request.getParameter("completionTime1");
    	String completionTime2=request.getParameter("completionTime2");
    	String completionTime3=request.getParameter("completionTime3");
    	String completionTime4=request.getParameter("completionTime4");
    	String completionDescription=request.getParameter("completionDescription");
    	String uncompletionDescription=request.getParameter("uncompletionDescription");
    	String nextStageId=request.getParameter("nextStageId");
    	try { 
    		if(stageId.equals("1")||stageId.equals("6")||stageId.equals("20")
    				||stageId.equals("29")||stageId.equals("28")||stageId.equals("31")
    				||stageId.equals("32")||stageId.equals("36")||stageId.equals("49")
    				||stageId.equals("62")||stageId.equals("67")){
    			//1，6,20,29，28，31，32，36，49，62，67 是时间
    			String stagename = "stage_id"+stageId;
    			String stageIdNo = completionTime1;
    			Map<String,Object> p=new HashMap<>();
        		p.put("operId",operId);
        		p.put("stagename",stagename);
        		p.put("stageIdNo",stageIdNo);        		
        		sysOperatorService.updateOperExportTableStage(p);
    		}
    		if(stageId.equals("11")){ //11 是值
    			String stagename = "stage_id"+stageId;
    			String stageIdNo = completionDescription;
    			Map<String,Object> p=new HashMap<>();
        		p.put("operId",operId);
        		p.put("stagename",stagename);
        		p.put("stageIdNo",stageIdNo);        		
        		sysOperatorService.updateOperExportTableStage(p);
    		}    		
    		Map<String,Object>params=new HashMap<>();
    		params.put("operId",operId);
    		params.put("materialId",Integer.valueOf(materialId));
    		params.put("stageId",Integer.valueOf(stageId));
    		params.put("completionTime1",completionTime1);
    		params.put("completionTime2",completionTime2);
    		params.put("completionTime3",completionTime3);
    		params.put("completionTime4",completionTime4);
    		params.put("completionDescription",completionDescription);
    		params.put("uncompletionDescription",uncompletionDescription);
    		params.put("nextStageId",nextStageId);
    		if(nextStageId==null||nextStageId.equals("")){
    			processService.updateRudangProcessStatus(params);
    		}else{
    			processService.updateRudangProcessStatusByNext(params);
    		}
    		
    		msg.setFlag(true);
			msg.setType("0");
			msg.setMsg("更新状态成功");
    	} catch (Exception e) {
    		e.printStackTrace();
			log.error("更新状态出错:",e.getMessage());
			msg.setFlag(false);
			msg.setMsg("更新状态出错");
		}
        System.out.println(msg.getMsg());
    	return msg;
    }
}
