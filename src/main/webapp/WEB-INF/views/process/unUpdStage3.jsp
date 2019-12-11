<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path1 = request.getContextPath();
    String basePath1 = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户管理页-中国联通研究院大数据运营后台管理系统</title>
<base href="<%=basePath1 %>" />
<!--[if lt IE 9]>
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="js/kkpager/kkpager_blue.css">
    <link rel="stylesheet" href="js/jbox/jbox.css">
    <link rel="stylesheet" href="js/jquery-ui-1.12.1.custom/jquery-ui.css">

    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validate/additional-methods.min.js"></script>
<script type="text/javascript" src="js/validate/messages_zh.js"></script>
<script type="text/javascript" src="js/kkpager/kkpager.min.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modalmanager.js"></script>
<link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="js/modal/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>

<script type="text/javascript">
var operId="${operId}";
var materialId="3";//页数

function right(){
	var loca = "Process/toRudangProcess.do?geren=geren&materialId=4&operId="+operId;
	window.location.href=loca;
}
function left(){
	var loca = "Process/toRudangProcess.do?geren=geren&materialId=2&operId="+operId;
	window.location.href=loca;
}


$(document).ready(function(){
	$( "#completionTime1Stage73" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage75" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage75" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage101" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage102" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage103" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage11" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	getProcess();
});

function getProcess() {
    $.ajax({
        url : "Process/getRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId
            },
        success : function (msg) {
            if(msg.flag){
                var process=msg.result.rudangProcess;
                if(process.length>0){
                	
                	//Stage71完成情况
                	//$("#completionTime1Stage31").val(process[4].completionTime1);
                	//$("#completionTime2Stage31").val(process[4].completionTime2);
                	$("#completionDescriptionStage71").val(process[0].completionDescription);
                	$("#uncompletionDescriptionStage71").val(process[0].uncompletionDescription);
               
                    if(process[0].status==1){
                    	document.getElementById('71').innerHTML = "正在进行";
                	}else if(process[0].status==2){
                		document.getElementById('71').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage71").disabled=true;
                		document.getElementById("uncompletionDescriptionStage71").disabled=true;
                	}else if(process[0].status==0){
                		document.getElementById('71').innerHTML ="";
                		document.getElementById("completionDescriptionStage71").disabled=true;
                		document.getElementById("uncompletionDescriptionStage71").disabled=true;
                	}
                    
                    //Stage72完成情况
                	$("#completionDescriptionStage72").val(process[1].completionDescription);
                	$("#uncompletionDescriptionStage72").val(process[1].uncompletionDescription);
               
                    if(process[1].status==1){
                    	document.getElementById('72').innerHTML = "正在进行";
                	}else if(process[1].status==2){
                		document.getElementById('72').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage72").disabled=true;
                		document.getElementById("uncompletionDescriptionStage72").disabled=true;
                	}else if(process[1].status==0){
                		document.getElementById('72').innerHTML ="";
                		document.getElementById("completionDescriptionStage72").disabled=true;
                		document.getElementById("uncompletionDescriptionStage72").disabled=true;
                	}
                    
                    //Stage73完成情况
                    if(process[2].completionTime1!=null){
                    var timeToWork =new Date(process[2].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage73').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage73").val(process[2].uncompletionDescription);
                    
                    if(process[2].status==1){
                    	document.getElementById('73').innerHTML = "正在进行";
                	}else if(process[2].status==2){
                		document.getElementById('73').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage73").disabled=true;
                		document.getElementById("uncompletionDescriptionStage73").disabled=true;
                	}else if(process[2].status==0){
                		document.getElementById('73').innerHTML ="";
                		document.getElementById("completionTime1Stage73").disabled=true;
                		document.getElementById("uncompletionDescriptionStage73").disabled=true;
                	}
                    
                    //Stage74完成情况
                	$("#completionDescriptionStage74").val(process[3].completionDescription);
                	$("#uncompletionDescriptionStage74").val(process[3].uncompletionDescription);
               
                    if(process[3].status==1){
                    	document.getElementById('74').innerHTML = "正在进行";
                	}else if(process[3].status==2){
                		document.getElementById('74').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage74").disabled=true;
                		document.getElementById("uncompletionDescriptionStage74").disabled=true;
                	}else if(process[3].status==0){
                		document.getElementById('74').innerHTML ="";
                		document.getElementById("completionDescriptionStage74").disabled=true;
                		document.getElementById("uncompletionDescriptionStage74").disabled=true;
                	}
                    
                  //Stage75完成情况
                    if(process[4].completionTime1!=null){
                    var timeToWork =new Date(process[4].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage75').val(t1+'-'+t2+'-'+t3);
                    }
                  
                    if(process[4].completionTime2!=null){
                        var timeToWork =new Date(process[4].completionTime2);
                        var t1 = timeToWork.getFullYear();
                        var t2 = timeToWork.getMonth()+1;
                        var t3 = timeToWork.getDate();
                        $('#completionTime2Stage75').val(t1+'-'+t2+'-'+t3);
                       }
                	$("#completionDescriptionStage75").val(process[4].completionDescription);
                	$("#uncompletionDescriptionStage75").val(process[4].uncompletionDescription);
               
                    if(process[4].status==1){
                    	document.getElementById('75').innerHTML = "正在进行";
                	}else if(process[4].status==2){
                		document.getElementById('75').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage75").disabled=true;
                		document.getElementById("completionTime2Stage75").disabled=true;
                		document.getElementById("completionDescriptionStage75").disabled=true;
                		document.getElementById("uncompletionDescriptionStage75").disabled=true;
                	}else if(process[4].status==0){
                		document.getElementById('75').innerHTML ="";
                		document.getElementById("completionTime1Stage75").disabled=true;
                		document.getElementById("completionTime2Stage75").disabled=true;
                		document.getElementById("completionDescriptionStage75").disabled=true;
                		document.getElementById("uncompletionDescriptionStage75").disabled=true;
                	}
                    
                  //Stage81完成情况
                	$("#completionDescriptionStage81").val(process[5].completionDescription);
                	$("#uncompletionDescriptionStage81").val(process[5].uncompletionDescription);
               
                    if(process[5].status==1){
                    	document.getElementById('81').innerHTML = "正在进行";
                	}else if(process[5].status==2){
                		document.getElementById('81').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage81").disabled=true;
                		document.getElementById("uncompletionDescriptionStage81").disabled=true;
                	}else if(process[5].status==0){
                		document.getElementById('81').innerHTML ="";
                		document.getElementById("completionDescriptionStage81").disabled=true;
                		document.getElementById("uncompletionDescriptionStage81").disabled=true;
                	}
                    
                  //Stage82完成情况
                	$("#completionDescriptionStage82").val(process[6].completionDescription);
                	$("#uncompletionDescriptionStage82").val(process[6].uncompletionDescription);
               
                    if(process[6].status==1){
                    	document.getElementById('82').innerHTML = "正在进行";
                	}else if(process[6].status==2){
                		document.getElementById('82').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage82").disabled=true;
                		document.getElementById("uncompletionDescriptionStage82").disabled=true;
                	}else if(process[6].status==0){
                		document.getElementById('82').innerHTML ="";
                		document.getElementById("completionDescriptionStage82").disabled=true;
                		document.getElementById("uncompletionDescriptionStage82").disabled=true;
                	}
                    
                  //Stage9完成情况
                    if(process[7].completionDescription!=null){
                        var arr1 = process[7].completionDescription.split("|");
                    	$("#completionDescriptionStage91").val(arr1[0]);
                    	$("#completionDescriptionStage92").val(arr1[1]);
                    	$("#completionDescriptionStage95").val(arr1[2]);
                    }
                	//$("#completionDescriptionStage9").val(process[7].completionDescription);
               
                    document.getElementById('9').innerHTML = "以“完成情况”为准";
                    $("#uncompletionDescriptionStage9").val(process[7].uncompletionDescription);
                    document.getElementById("completionDescriptionStage91").disabled=true;
                    document.getElementById("completionDescriptionStage92").disabled=true;
                    document.getElementById("completionDescriptionStage95").disabled=true;
            		document.getElementById("uncompletionDescriptionStage9").disabled=true;
                    
                  //Stage101完成情况
                    if(process[8].completionTime1!=null){
                    var timeToWork =new Date(process[8].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage101').val(t1+'-'+t2+'-'+t3);
                    }
                    $("#completionDescriptionStage101").val(process[8].completionDescription);
                    $("#uncompletionDescriptionStage101").val(process[8].uncompletionDescription);
                   
                    
                    if(process[8].status==1){
                    	document.getElementById('101').innerHTML = "正在进行";
                	}else if(process[8].status==2){
                		document.getElementById('101').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage101").disabled=true;
                		document.getElementById("completionDescriptionStage101").disabled=true;
                		document.getElementById("uncompletionDescriptionStage101").disabled=true;
                	}else if(process[8].status==0){
                		document.getElementById('101').innerHTML ="";
                		document.getElementById("completionTime1Stage101").disabled=true;
                		document.getElementById("completionDescriptionStage101").disabled=true;
                		document.getElementById("uncompletionDescriptionStage101").disabled=true;
                	}
                    
                    //Stage102完成情况
                    if(process[9].completionTime1!=null){
                    var timeToWork =new Date(process[9].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage102').val(t1+'-'+t2+'-'+t3);
                    }
                    $("#completionDescriptionStage102").val(process[9].completionDescription);
                    $("#uncompletionDescriptionStage102").val(process[9].uncompletionDescription);
                    
                    if(process[9].status==1){
                    	document.getElementById('102').innerHTML = "正在进行";
                	}else if(process[9].status==2){
                		document.getElementById('102').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage102").disabled=true;
                		document.getElementById("completionDescriptionStage102").disabled=true;
                		document.getElementById("uncompletionDescriptionStage102").disabled=true;
                	}else if(process[9].status==0){
                		document.getElementById('102').innerHTML ="";
                		document.getElementById("completionTime1Stage102").disabled=true;
                		document.getElementById("completionDescriptionStage102").disabled=true;
                		document.getElementById("uncompletionDescriptionStage102").disabled=true;
                	}
                    
                    //Stage103完成情况
                    if(process[10].completionTime1!=null){
                    var timeToWork =new Date(process[10].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage103').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage103").val(process[10].uncompletionDescription);
                    
                    if(process[10].status==1){
                    	document.getElementById('103').innerHTML = "正在进行";
                	}else if(process[10].status==2){
                		document.getElementById('103').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage103").disabled=true;
                		document.getElementById("uncompletionDescriptionStage103").disabled=true;
                	}else if(process[10].status==0){
                		document.getElementById('103').innerHTML ="";
                		document.getElementById("completionTime1Stage103").disabled=true;
                		document.getElementById("uncompletionDescriptionStage103").disabled=true;
                	}
                    
                  //Stage11完成情况
                    if(process[11].completionTime1!=null){
                    var timeToWork =new Date(process[11].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage11').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    if(process[11].completionDescription!=null){
                        var arr1 = process[11].completionDescription.split("|");
                    	$("#completionDescriptionStage111").val(arr1[0]);
                    	$("#completionDescriptionStage112").val(arr1[1]);
                    }
                    
                    $("#uncompletionDescriptionStage11").val(process[11].uncompletionDescription);
               
                    if(process[11].status==1){
                    	document.getElementById('11').innerHTML = "正在进行";
                	}else if(process[11].status==2){
                		document.getElementById('11').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage11").disabled=true;
                		document.getElementById("completionDescriptionStage111").disabled=true;
                		document.getElementById("completionDescriptionStage112").disabled=true;
                		document.getElementById("uncompletionDescriptionStage11").disabled=true;
                	}else if(process[11].status==0){
                		document.getElementById('11').innerHTML ="";
                		document.getElementById("completionTime1Stage11").disabled=true;
                		document.getElementById("completionDescriptionStage111").disabled=true;
                		document.getElementById("completionDescriptionStage112").disabled=true;
                		document.getElementById("uncompletionDescriptionStage11").disabled=true;
                	}
                    
                 
               
               
                }
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function (XMLHttpRequest, textStatus, errorThrown) {
        	alert ("XMLHttpRequest.status="+XMLHttpRequest.status+"\ntextStatus="+textStatus+"\nerrorThrown=" + errorThrown);
            return false;
        }
    });
}

function updateRudangProcess71() {
	var stageId="18";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage71").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage71").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
                $.jBox.tip(msg.msg,'success');
		document.getElementById('71').innerHTML ="已通过";
		document.getElementById('72').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage71").disabled=true;
		document.getElementById("uncompletionDescriptionStage71").disabled=true;
		document.getElementById("completionDescriptionStage72").disabled=false;
		document.getElementById("uncompletionDescriptionStage72").disabled=false;
		//id=id+1;//下一行
		//document.getElementById('2').innerHTML ="<button>通过</button> 正在进行";
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function (XMLHttpRequest, textStatus, errorThrown) {
        	alert ("XMLHttpRequest.status="+XMLHttpRequest.status+"\ntextStatus="+textStatus+"\nerrorThrown=" + errorThrown);
            return false;
        }
    });
}

function updateRudangProcess72() {
	var stageId="19";//"步骤数 你想个地方保存当前行的步骤数 ";
    var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage72").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage72").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('72').innerHTML ="已通过";
		document.getElementById('73').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage72").disabled=true;
		document.getElementById("uncompletionDescriptionStage72").disabled=true;
		document.getElementById("completionTime1Stage73").disabled=false;
		document.getElementById("uncompletionDescriptionStage73").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess73() {
	var stageId="20";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage73").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage73").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('73').innerHTML ="已通过";
		document.getElementById('74').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage73").disabled=true;
		document.getElementById("uncompletionDescriptionStage73").disabled=true;
		document.getElementById("completionDescriptionStage74").disabled=false;
		document.getElementById("uncompletionDescriptionStage74").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess74() {
	var stageId="21";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage74").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage74").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('74').innerHTML ="已通过";
		document.getElementById('75').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage74").disabled=true;
		document.getElementById("uncompletionDescriptionStage74").disabled=true;
		document.getElementById("completionTime1Stage75").disabled=false;
		document.getElementById("completionTime2Stage75").disabled=false;
		document.getElementById("completionDescriptionStage75").disabled=false;
		document.getElementById("uncompletionDescriptionStage75").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess75() {
	var stageId="22";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage75").val();//第一个日期
    var completionTime2=$("#completionTime2Stage75").val();;//第二个日期
    var completionDescription=$("#completionDescriptionStage75").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage75").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('75').innerHTML ="已通过";
		document.getElementById('81').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage75").disabled=true;
		document.getElementById("completionTime2Stage75").disabled=true;
		document.getElementById("completionDescriptionStage75").disabled=true;
		document.getElementById("uncompletionDescriptionStage75").disabled=true;
		document.getElementById("completionDescriptionStage81").disabled=false;
		document.getElementById("uncompletionDescriptionStage81").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess81() {
	var stageId="23";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage81").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage81").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('81').innerHTML ="已通过";
		document.getElementById('82').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage81").disabled=true;
		document.getElementById("uncompletionDescriptionStage81").disabled=true;
		document.getElementById("completionDescriptionStage82").disabled=false;
		document.getElementById("uncompletionDescriptionStage82").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess82() {
	var stageId="24";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="26";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage82").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage82").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId,
                "nextStageId":nextStageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('82').innerHTML ="已通过";
		document.getElementById('101').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage82").disabled=true;
		document.getElementById("uncompletionDescriptionStage82").disabled=true;
		document.getElementById("completionTime1Stage101").disabled=false;
		document.getElementById("completionDescriptionStage101").disabled=false;
		document.getElementById("uncompletionDescriptionStage101").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess9() {
	var stageId="25";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="25";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription91=$("#completionDescriptionStage91").val();//填写内容
    var completionDescription92=$("#completionDescriptionStage92").val();//填写内容
    var completionDescription93=$("#completionDescriptionStage93").val();//填写内容
    var completionDescription94=$("#completionDescriptionStage94").val();//填写内容
    var completionDescription95=$("#completionDescriptionStage95").val();//填写内容
    var uncompletionDescription=$("#completionDescriptionStage9").val();//填写内容
    var completionDescription=completionDescription91+"|"+completionDescription92+"|"+completionDescription95;
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId,
                "nextStageId":nextStageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('9').innerHTML ="已通过";
        var completionDescription951=$("#completionDescriptionStage95").val(completionDescription93+" "+completionDescription94);
        var completionDescription931=$("#completionDescriptionStage93").val(completionDescription91);
        var completionDescription941=$("#completionDescriptionStage94").val(completionDescription92);
        document.getElementById('9').innerHTML = "正在进行";
            }else{
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess101() {
	var stageId="26";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage101").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage101").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage101").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('101').innerHTML ="已通过";
		document.getElementById('102').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage101").disabled=true;
		document.getElementById("completionDescriptionStage101").disabled=true;
		document.getElementById("uncompletionDescriptionStage101").disabled=true;
		document.getElementById("completionTime1Stage102").disabled=false;
		document.getElementById("completionDescriptionStage102").disabled=false;
		document.getElementById("uncompletionDescriptionStage102").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess102() {
	var stageId="27";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage102").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage102").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage102").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('102').innerHTML ="已通过";
		document.getElementById('103').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage102").disabled=true;
		document.getElementById("completionDescriptionStage102").disabled=true;
		document.getElementById("uncompletionDescriptionStage102").disabled=true;
		document.getElementById("completionTime1Stage103").disabled=false;
		document.getElementById("uncompletionDescriptionStage103").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

function updateRudangProcess103() {
	var stageId="28";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage103").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage103").val();;//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('103').innerHTML ="已通过";
		document.getElementById('11').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage103").disabled=true;
		document.getElementById("uncompletionDescriptionStage103").disabled=true;
		document.getElementById("completionTime1Stage11").disabled=false;
		document.getElementById("completionDescriptionStage111").disabled=false;
		document.getElementById("completionDescriptionStage112").disabled=false;
		document.getElementById("uncompletionDescriptionStage11").disabled=false;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}


function updateRudangProcess11() {
	var stageId="29";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage11").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription111=$("#completionDescriptionStage111").val();//填写内容
    var completionDescription112=$("#completionDescriptionStage112").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage11").val();//填写内容
    var completionDescription=completionDescription111+"|"+completionDescription112;
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionTime1" : completionTime1,
                "completionTime2" : completionTime2,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        document.getElementById('11').innerHTML ="已通过";
		//document.getElementById('Blank1').innerHTML = "<input type='button' value='通过'  onclick='updateRudangProcessBlank1()'>正在进行";
		document.getElementById("completionTime1Stage11").disabled=true;
		document.getElementById("uncompletionDescriptionStage11").disabled=true;
		document.getElementById("completionDescriptionStage111").disabled=true;
		document.getElementById("completionDescriptionStage112").disabled=true;
            }else {
                $.jBox.error(msg.msg, '提示');
                return false;
            }
        },
        error : function () {
            $.jBox.error(msg.msg, '提示');
            return false;
        }
    });
}

</script>

<body>

<!-------------------------CONT---------------------------->
<div class="List-cont box-cont">
	<div class="panel panel-default">
	 <div class="panel-header">
			<h4>流程管理</h4>
		</div>
		<div class="panel-body cl">

			
			<div class="fl sub-cont">
				
				<!--列表-->
				<style>
					.cl-color{
						background: rgba(255,255,255,1) ! important;
					}
					.cl-color th,td,tr{
						background: rgba(255,255,255,1) ! important;
					}
					.cl-color td{
						border:1px solid #e0e0e0 ! important;
					}
					.cl-color span{
						float:left;
						margin-bottom:10px
					}
					.cl-color span p{
						float:left;
						width:70px;
						text-align: left;
					}
					.cl-color input,textarea{
						float:right;
						min-height:24px;
						width:80px;
						background:#f5f5f5;
						border-radius:3px;
						border:1px solid #e0e0e0 ! important;
					}
					.cl-color select{
						float:none;
						min-height:24px;
						width:auto;
						background:#f5f5f5;
						text-align: auto;
					}
				</style>
				
				<table class="table table-primary mt-30" border="1"  style="width:100%;min-width: 1000px;" >
				    <thead>  
					<tr>
						<th width="130">党员发展工作阶段</th>
						<th colspan="2">所需材料</th>
						<th width="60">时间要求</th>
						<th>备注</th>
						<th width="170">完成情况</th>
						<th width="50">状态</th>
						<th width="70">说明</th>	
					</tr>
				    </thead>
				    <tbody class="cl-color">
				   
					<tr>
					    <td rowspan="14">三、发展对象的确定和考察</td>
						<td rowspan="5">7、确定发展对象</td>
						<td>7.1、培养联系人、党小组和团支部提出意见</td>
						<td>与确定为入党积极分子时间间隔至少一年</td>
						<td>28岁以下需团支部意见，开会时邀请群众、团支部参加，小组会议纪要形式，没有党小组要有书面推荐意见</td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage71"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="71" ></td>
						<td><span><p style="width: auto;">若完成情况未填写，需在此处选择未填写原因，若已填写完成情况，请忽略此步</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage71"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>7.2、党支部认真听取培养联系人、党小组、团支部及群众的意见并记录</td>
						<td></td>
						<td>考察意见情况写入《入党积极分子考察登记表》</td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage72"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="72" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage72"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>7.3、支部委员会研究确定发展对象</td>
						<td></td> 
						<td>第2个支委会，成为发展对象的时间</td>
						<td><span><p style="width: 120px;">支委会召开时间：</p><br /><input type="text" value="" id="completionTime1Stage73" ></span></td>
						<td id="73" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage73"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>7.4、党总支审查同意（设有党总支））</td>
						<td></td>
						<td>党总支书记签字同意</td>
						<td><span><p></p><textarea rows="5" cols="30" id="completionDescriptionStage74" style="float:none; min-height:auto;width:auto;"  ></textarea></span></td>
						<td id="74" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage74"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>7.5 公示并无异议</td>
					    <td>五个工作日</td>
						<td>第2次公示，要求同1次公示</td>
						<td>
						    <span><p style="width: 120px;">公示开始时间：</p><input type="text" value="" id="completionTime1Stage75" style="float: none;"></span>
						    <span><p style="width: 120px;">公示结束时间：</p><input type="text" value="" id="completionTime2Stage75" style="float: none;"></span>
							<span><p style="width: 120px;">公示方式：</p>
							<select class="textarea"  id="completionDescriptionStage75"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						    </select>
							</span>
						</td>
						<td id="75" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage75"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td rowspan="2">8、上级党委备案</td>
						<td>8.1 填写《中国联通直属党委发展对象备案登记表》</td>
						<td></td>
						<td rowspan="2">第2份备案表；上级党委签字后留存原件，支部留存复印件。备案时间在2次公示后</td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage81"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						<option value="外单位转入">外单位转入</option>
						<option value="其它">其它</option>
						</select>
						</span></td>
						<td id="81"></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage81"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>8.2 登记备案</td>
						<td></td>
						<td><span><p style="width: 170px;">备案登记表接收人签字：</p><br /><input type="text" value="" id="completionDescriptionStage82" style="float: none;"></span></td>
						<td id="82" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage82"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					
						<td colspan="2">9、确定2名入党介绍人（一般由培养联系人担任）</td>
						<td></td>
						<td>由党组织指定，本人同意，一名党员不宜同时担任几名发展对象介绍人</td>
						<td>
						    <span><p style="width: 120px;">入党介绍人姓名：</p><input type="text" value="" id="completionDescriptionStage91" style="float: none;"></span>
						    <span><p style="width: 120px;">入党介绍人姓名：</p><input type="text" value="" id="completionDescriptionStage92" style="float: none;"></span>
						    <span><p></p><input type="text" value="" id="completionDescriptionStage93" style="display:none"></span>
						    <span><p></p><input type="text" value="" id="completionDescriptionStage94" style="display:none"></span>
						    <span>备注栏：（上一任培养联系人姓名）<textarea rows="5" cols="30" id="completionDescriptionStage95" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="9"></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage9"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td rowspan="3">10、政治审查</td>
						<td>10.1 支部派人谈话了解对发展对象直系关系情况和社会关系情况</td>
						<td rowspan="3">政审有效期为一年</td>
						<td>第3次谈话</td>
						<td>
						    <span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage101"></span>
						    <span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage101"></span>
					    <td id="101" ></td>
					    <td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage101"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>10.2 必要的函调或者外调</td>
						<td>直系亲属必须政治审查，主要社会关系可审查1-2名，人力、纪委调查可根据需要</td>
						<td>
						    <span><p>外调时间：</p><input type="text" value="" id="completionTime1Stage102"></span>
						    <span><p style="width: 170px;">外调对象：（全部对象）</p><br />
						    <input type="text" value="" id="completionDescriptionStage102" style="margin-left:50px; float: none;">
						    </span>
						</td>
						<td id="102" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage102"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>10.3 形成结论性材料</td>
						<td>政审时间，见结论性材料模板</td>
						<td>
						    <span><p>形成时间：</p><input type="text" value="" id="completionTime1Stage103"></span>
						</td>
						<td id="103" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage103"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>11、参加短期集中培训</td>
					    <td></td>
						<td>三天或者二十四学时；培训证书有效期为三年</td>
						<td></td>
						<td>
						   <span><p>参加培训时间：</p><input type="text" value="" id="completionTime1Stage11"></span>
						   <span><p>培训单位：</p><textarea rows="5" cols="30" id="completionDescriptionStage111"></textarea></span>
						   <span><p>培训时长：</p><textarea rows="5" cols="30" id="completionDescriptionStage112"></textarea></span>
						</td>
						<td id="11" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage11"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					</tbody>
				</table>
				
				<footer  style=margin:20px 0 0 0"">
				    <div id="right" class="rt"  style="float:right;"><a  type="button" onclick="right();"><i class="fa fa-arrow-circle-o-right">下一页</a></i></div>
					<div id="right" class="rt"  style="float:right;margin-right:30px"><a  type="button" onclick="left();"><i class="fa fa-arrow-circle-o-right">上一页</a></i></div>
			    </footer>
				<!--分页-->
			</div>

		</div>
	</div>
</div>




</body>
</html>