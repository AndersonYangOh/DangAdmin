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
var materialId="4";//页数

function right(){
	var loca = "Process/toRudangProcess.do?materialId=5&operId="+operId;
	window.location.href=loca;
}
function left(){
	var loca = "Process/toRudangProcess.do?materialId=3&operId="+operId;
	window.location.href=loca;
}

$(document).ready(function(){
	$( "#completionTime1Stage121" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage122" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage131" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage1511" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage152" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage153" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage153" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage16" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage17" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage18" ).datepicker({
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
                	
                	//Stage121完成情况
                	//$("#completionTime1Stage31").val(process[4].completionTime1);
                	//$("#completionTime2Stage31").val(process[4].completionTime2);
                	if(process[0].completionTime1!=null){
                	var timeToWork =new Date(process[0].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage121').val(t1+'-'+t2+'-'+t3);
                	}
                	
                	$("#uncompletionDescriptionStage121").val(process[0].uncompletionDescription);
                    
                    if(process[0].status==1){
                    	document.getElementById('121').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess121()'>正在进行";
                	}else if(process[0].status==2){
                		document.getElementById('121').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage121").disabled=true;
                		document.getElementById("uncompletionDescriptionStage121").disabled=true;
                	}else if(process[0].status==0){
                		document.getElementById('121').innerHTML ="";
                		document.getElementById("completionTime1Stage121").disabled=true;
                		document.getElementById("uncompletionDescriptionStage121").disabled=true;
                	}
                    
                    //Stage122完成情况
                    if(process[1].completionTime1!=null){
                	var timeToWork =new Date(process[1].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage122').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage122").val(process[1].uncompletionDescription);
                    
                    if(process[1].status==1){
                    	document.getElementById('122').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess122()'>正在进行";
                	}else if(process[1].status==2){
                		document.getElementById('122').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage122").disabled=true;
                		document.getElementById("uncompletionDescriptionStage122").disabled=true;
                	}else if(process[1].status==0){
                		document.getElementById('122').innerHTML ="";
                		document.getElementById("completionTime1Stage122").disabled=true;
                		document.getElementById("uncompletionDescriptionStage122").disabled=true;
                	}
                    
                    //Stage131完成情况
                    if(process[2].completionTime1!=null){
                    var timeToWork =new Date(process[2].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage131').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage131").val(process[2].uncompletionDescription);
                    
                    if(process[2].status==1){
                    	document.getElementById('131').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess131()'>正在进行";
                	}else if(process[2].status==2){
                		document.getElementById('131').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage131").disabled=true;
                		document.getElementById("uncompletionDescriptionStage131").disabled=true;
                	}else if(process[2].status==0){
                		document.getElementById('131').innerHTML ="";
                		document.getElementById("completionTime1Stage131").disabled=true;
                		document.getElementById("uncompletionDescriptionStage131").disabled=true;
                	}
                    
                    //Stage132完成情况
                	$("#completionDescriptionStage132").val(process[3].completionDescription);
                	$("#uncompletionDescriptionStage132").val(process[3].uncompletionDescription);
               
                    if(process[3].status==1){
                    	document.getElementById('132').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess132()'>正在进行";
                	}else if(process[3].status==2){
                		document.getElementById('132').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage132").disabled=true;
                		document.getElementById("uncompletionDescriptionStage132").disabled=true;
                	}else if(process[3].status==0){
                		document.getElementById('132').innerHTML ="";
                		document.getElementById("completionDescriptionStage132").disabled=true;
                		document.getElementById("uncompletionDescriptionStage132").disabled=true;
                	}
                    
                  //Stage141完成情况
                	$("#completionDescriptionStage141").val(process[4].completionDescription);
                	$("#uncompletionDescriptionStage141").val(process[4].uncompletionDescription);
               
                    if(process[4].status==1){
                    	document.getElementById('141').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess141()'>正在进行";
                	}else if(process[4].status==2){
                		document.getElementById('141').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage141").disabled=true;
                		document.getElementById("uncompletionDescriptionStage141").disabled=true;
                	}else if(process[4].status==0){
                		document.getElementById('141').innerHTML ="";
                		document.getElementById("completionDescriptionStage141").disabled=true;
                		document.getElementById("uncompletionDescriptionStage141").disabled=true;
                	}
                    
                  //Stage142完成情况
                	$("#completionDescriptionStage142").val(process[5].completionDescription);
                	$("#uncompletionDescriptionStage142").val(process[5].uncompletionDescription);
               
                    if(process[5].status==1){
                    	document.getElementById('142').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess142()'>正在进行";
                	}else if(process[5].status==2){
                		document.getElementById('142').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage142").disabled=true;
                		document.getElementById("uncompletionDescriptionStage142").disabled=true;
                	}else if(process[5].status==0){
                		document.getElementById('142').innerHTML ="";
                		document.getElementById("completionDescriptionStage142").disabled=true;
                		document.getElementById("uncompletionDescriptionStage142").disabled=true;
                	}
                    
                  //Stage1511完成情况
                    if(process[6].completionTime1!=null){
                    var timeToWork =new Date(process[6].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage1511').val(t1+'-'+t2+'-'+t3);
                    }
                  
                    if(process[6].completionDescription!=null){
                        var arr1 = process[6].completionDescription.split("|");
                    	$("#completionDescriptionStage15111").val(arr1[0]);
                    	$("#completionDescriptionStage15112").val(arr1[1]);
                    	$("#completionDescriptionStage15113").val(arr1[2]);
                    }
               
                    $("#uncompletionDescriptionStage1511").val(process[6].uncompletionDescription);
                    
                    if(process[6].status==1){
                    	document.getElementById('1511').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess1511()'>正在进行";
                	}else if(process[6].status==2){
                		document.getElementById('1511').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage1511").disabled=true;
                		document.getElementById("completionDescriptionStage15111").disabled=true;
                		document.getElementById("completionDescriptionStage15112").disabled=true;
                		document.getElementById("completionDescriptionStage15113").disabled=true;
                		document.getElementById("uncompletionDescriptionStage1511").disabled=true;
                	}else if(process[6].status==0){
                		document.getElementById('1511').innerHTML ="";
                		document.getElementById("completionTime1Stage1511").disabled=true;
                		document.getElementById("completionDescriptionStage15111").disabled=true;
                		document.getElementById("completionDescriptionStage15112").disabled=true;
                		document.getElementById("completionDescriptionStage15113").disabled=true;
                		document.getElementById("uncompletionDescriptionStage1511").disabled=true;
                	}
                    
                  //Stage152完成情况
                    if(process[13].completionTime1!=null){
                    var timeToWork =new Date(process[13].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage152').val(t1+'-'+t2+'-'+t3);
                    }
                  
                    $("#uncompletionDescriptionStage152").val(process[13].uncompletionDescription);
               
                    if(process[13].status==1){
                    	document.getElementById('152').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess152()'>正在进行";
                	}else if(process[13].status==2){
                		document.getElementById('152').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage152").disabled=true;
                		document.getElementById("uncompletionDescriptionStage152").disabled=true;
                	}else if(process[13].status==0){
                		document.getElementById('152').innerHTML ="";
                		document.getElementById("completionTime1Stage152").disabled=true;
                		document.getElementById("uncompletionDescriptionStage152").disabled=true;
                	}
                    
                  //Stage153完成情况
                    if(process[14].completionTime1!=null){
                    var timeToWork =new Date(process[14].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage153').val(t1+'-'+t2+'-'+t3);
                    }
                    if(process[14].completionTime2!=null){
                        var timeToWork =new Date(process[14].completionTime2);
                        var t1 = timeToWork.getFullYear();
                        var t2 = timeToWork.getMonth()+1;
                        var t3 = timeToWork.getDate();
                        $('#completionTime2Stage153').val(t1+'-'+t2+'-'+t3);
                        }
                    $("#completionDescriptionStage153").val(process[14].completionDescription);
                    $("#uncompletionDescriptionStage153").val(process[14].uncompletionDescription);
                    
                    if(process[14].status==1){
                    	document.getElementById('153').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess153()'>正在进行";
                	}else if(process[14].status==2){
                		document.getElementById('153').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage153").disabled=true;
                		document.getElementById("completionTime2Stage153").disabled=true;
                		document.getElementById("completionDescriptionStage153").disabled=true;
                		document.getElementById("uncompletionDescriptionStage153").disabled=true;
                	}else if(process[14].status==0){
                		document.getElementById('153').innerHTML ="";
                		document.getElementById("completionTime1Stage153").disabled=true;
                		document.getElementById("completionTime2Stage153").disabled=true;
                		document.getElementById("completionDescriptionStage153").disabled=true;
                		document.getElementById("uncompletionDescriptionStage153").disabled=true;
                	}
                    
                    //Stage154完成情况
                    $("#completionDescriptionStage154").val(process[15].completionDescription);
                    $("#uncompletionDescriptionStage154").val(process[15].uncompletionDescription);
                    
                    if(process[15].status==1){
                    	document.getElementById('154').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess154()'>正在进行";
                	}else if(process[15].status==2){
                		document.getElementById('154').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage154").disabled=true;
                		document.getElementById("uncompletionDescriptionStage154").disabled=true;
                	}else if(process[15].status==0){
                		document.getElementById('154').innerHTML ="";
                		document.getElementById("completionDescriptionStage154").disabled=true;
                		document.getElementById("uncompletionDescriptionStage154").disabled=true;
                	}
                    
                  //Stage155完成情况
                    $("#completionDescriptionStage155").val(process[16].completionDescription);
                    $("#uncompletionDescriptionStage155").val(process[16].uncompletionDescription);
                    
                    if(process[16].status==1){
                    	document.getElementById('155').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess155()'>正在进行";
                	}else if(process[16].status==2){
                		document.getElementById('155').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage155").disabled=true;
                		document.getElementById("uncompletionDescriptionStage155").disabled=true;
                	}else if(process[16].status==0){
                		document.getElementById('155').innerHTML ="";
                		document.getElementById("completionDescriptionStage155").disabled=true;
                		document.getElementById("uncompletionDescriptionStage155").disabled=true;
                	}
                    
                  //Stage156完成情况
                    $("#completionDescriptionStage156").val(process[17].completionDescription);
                    $("#uncompletionDescriptionStage156").val(process[17].uncompletionDescription);
                    
                    if(process[17].status==1){
                    	document.getElementById('156').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess156()'>正在进行";
                	}else if(process[17].status==2){
                		document.getElementById('156').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage156").disabled=true;
                		document.getElementById("uncompletionDescriptionStage156").disabled=true;
                	}else if(process[17].status==0){
                		document.getElementById('156').innerHTML ="";
                		document.getElementById("completionDescriptionStage156").disabled=true;
                		document.getElementById("uncompletionDescriptionStage156").disabled=true;
                	}
                    
                  //Stage16完成情况
                    if(process[18].completionTime1!=null){
                    var timeToWork =new Date(process[18].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage16').val(t1+'-'+t2+'-'+t3);
                    }
                    $("#completionDescriptionStage16").val(process[18].completionDescription);
                    $("#uncompletionDescriptionStage16").val(process[18].uncompletionDescription);
                    
                    if(process[18].status==1){
                    	document.getElementById('16').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess16()'>正在进行";
                	}else if(process[18].status==2){
                		document.getElementById('16').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage16").disabled=true;
                		document.getElementById("completionDescriptionStage16").disabled=true;
                		document.getElementById("uncompletionDescriptionStage16").disabled=true;
                	}else if(process[18].status==0){
                		document.getElementById('16').innerHTML ="";
                		document.getElementById("completionTime1Stage16").disabled=true;
                		document.getElementById("completionDescriptionStage16").disabled=true;
                		document.getElementById("uncompletionDescriptionStage16").disabled=true;
                	}
                    
                  //Stage17完成情况
                    if(process[19].completionTime1!=null){
                    var timeToWork =new Date(process[19].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage17').val(t1+'-'+t2+'-'+t3);
                    }
                  
                    $("#uncompletionDescriptionStage17").val(process[19].uncompletionDescription);
                    
                    if(process[19].status==1){
                    	document.getElementById('17').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess17()'>正在进行";
                	}else if(process[19].status==2){
                		document.getElementById('17').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage17").disabled=true;
                		document.getElementById("uncompletionDescriptionStage17").disabled=true;
                	}else if(process[19].status==0){
                		document.getElementById('17').innerHTML ="";
                		document.getElementById("completionTime1Stage17").disabled=true;
                		document.getElementById("uncompletionDescriptionStage17").disabled=true;
                	}
                    
                  //Stage18完成情况
                    if(process[20].completionTime1!=null){
                    var timeToWork =new Date(process[20].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage18').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage18").val(process[20].uncompletionDescription);
                  
                    if(process[20].status==1){
                    	document.getElementById('18').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess18()'>正在进行";
                	}else if(process[20].status==2){
                		document.getElementById('18').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage18").disabled=true;
                		document.getElementById("uncompletionDescriptionStage18").disabled=true;
                	}else if(process[20].status==0){
                		document.getElementById('18').innerHTML ="";
                		document.getElementById("completionTime1Stage18").disabled=true;
                		document.getElementById("uncompletionDescriptionStage18").disabled=true;
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

function updateRudangProcess121() {
	var stageId="30";
	var completionTime1=$("#completionTime1Stage121").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage121").val();//填写内容
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
		document.getElementById('121').innerHTML ="已通过";
		document.getElementById('122').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess122()'>正在进行";
		document.getElementById("completionTime1Stage121").disabled=true;
		document.getElementById("uncompletionDescriptionStage121").disabled=true;
		document.getElementById("completionTime1Stage122").disabled=false;
		document.getElementById("uncompletionDescriptionStage122").disabled=false;
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

function updateRudangProcess122() {
	var stageId="31";
	var completionTime1=$("#completionTime1Stage122").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage122").val();//填写内容
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
		document.getElementById('122').innerHTML ="已通过";
		document.getElementById('131').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess131()'>正在进行";
		document.getElementById("completionTime1Stage122").disabled=true;
		document.getElementById("uncompletionDescriptionStage122").disabled=true;
		document.getElementById("completionTime1Stage131").disabled=false;
		document.getElementById("uncompletionDescriptionStage131").disabled=false;
		//document.getElementById("completionDescriptionStage121").disabled=true;
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

function updateRudangProcess131() {
	var stageId="32";
	var completionTime1=$("#completionTime1Stage131").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage131").val();
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
		document.getElementById('131').innerHTML ="已通过";
		document.getElementById('132').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess132()'>正在进行";
		document.getElementById("completionTime1Stage131").disabled=true;
		document.getElementById("uncompletionDescriptionStage131").disabled=true;
		document.getElementById("completionDescriptionStage132").disabled=false;
		document.getElementById("uncompletionDescriptionStage132").disabled=false;
		
		//document.getElementById("completionDescriptionStage121").disabled=true;
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

function updateRudangProcess132() {
	var stageId="33";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage132").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage132").val();//填写内容
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
		document.getElementById('132').innerHTML ="已通过";
		document.getElementById('141').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess141()'>正在进行";
		//document.getElementById("completionTime1Stage132").disabled=true;
		document.getElementById("completionDescriptionStage132").disabled=true;
		document.getElementById("uncompletionDescriptionStage132").disabled=true;
		document.getElementById("completionDescriptionStage141").disabled=false;
		document.getElementById("uncompletionDescriptionStage141").disabled=false;
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

function updateRudangProcess141() {
	var stageId="34";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage141").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage141").val();//填写内容
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
		document.getElementById('141').innerHTML ="已通过";
		document.getElementById('142').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess142()'>正在进行";
		//document.getElementById("completionTime1Stage132").disabled=true;
		document.getElementById("completionDescriptionStage141").disabled=true;
		document.getElementById("uncompletionDescriptionStage141").disabled=true;
		document.getElementById("completionDescriptionStage142").disabled=false;
		document.getElementById("uncompletionDescriptionStage142").disabled=false;
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

function updateRudangProcess142() {
	var stageId="35";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage142").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage142").val();//填写内容
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
		document.getElementById('142').innerHTML ="已通过";
		document.getElementById('1511').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess1511()'>正在进行";
		//document.getElementById("completionTime1Stage132").disabled=true;
		document.getElementById("completionDescriptionStage142").disabled=true;
		document.getElementById("uncompletionDescriptionStage142").disabled=true;
		document.getElementById("completionTime1Stage1511").disabled=false;
		document.getElementById("completionDescriptionStage15111").disabled=false;
		document.getElementById("completionDescriptionStage15112").disabled=false;
		document.getElementById("completionDescriptionStage15113").disabled=false;
		document.getElementById("uncompletionDescriptionStage1511").disabled=false;
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

function updateRudangProcess1511() {
	var stageId="36";
	var nextStageId="43";
	var completionTime1=$("#completionTime1Stage1511").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription15111=$("#completionDescriptionStage15111").val();//填写内容
    var completionDescription15112=$("#completionDescriptionStage15112").val();//填写内容
    var completionDescription15113=$("#completionDescriptionStage15113").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage1511").val();//填写内容
    var completionDescription=completionDescription15111+"|"+completionDescription15112+"|"+completionDescription15113;
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
		document.getElementById('1511').innerHTML ="已通过";
		document.getElementById('152').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess152()'>正在进行";
		document.getElementById("completionTime1Stage1511").disabled=true;
		document.getElementById("uncompletionDescriptionStage1511").disabled=true;
		document.getElementById("completionDescriptionStage15111").disabled=true;
		document.getElementById("completionDescriptionStage15112").disabled=true;
		document.getElementById("completionDescriptionStage15113").disabled=true;
		document.getElementById("completionTime1Stage152").disabled=false;
		document.getElementById("uncompletionDescriptionStage152").disabled=false;
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

function updateRudangProcess152() {
	var stageId="43";
	var completionTime1=$("#completionTime1Stage152").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage152").val();//填写内容
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
		document.getElementById('152').innerHTML ="已通过";
		document.getElementById('153').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess153()'>正在进行";
		document.getElementById("completionTime1Stage152").disabled=true;
		document.getElementById("uncompletionDescriptionStage152").disabled=true;
		document.getElementById("completionTime1Stage153").disabled=false;
		document.getElementById("completionTime2Stage153").disabled=false;
		document.getElementById("completionDescriptionStage153").disabled=false;
		document.getElementById("uncompletionDescriptionStage153").disabled=false;
	//	document.getElementById("completionDescriptionStage1511").disabled=true;
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

function updateRudangProcess153() {
	var stageId="44";
	var completionTime1=$("#completionTime1Stage153").val();//第一个日期
    var completionTime2=$("#completionTime2Stage153").val();//第二个日期
    var completionDescription=$("#completionDescriptionStage153").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage153").val();//填写内容
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
		document.getElementById('153').innerHTML ="已通过";
		document.getElementById('154').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess154()'>正在进行";
		document.getElementById("completionTime1Stage153").disabled=true;
		document.getElementById("completionTime2Stage153").disabled=true;
		document.getElementById("completionDescriptionStage153").disabled=true;
		document.getElementById("uncompletionDescriptionStage153").disabled=true;
		document.getElementById("completionDescriptionStage154").disabled=false;
		document.getElementById("uncompletionDescriptionStage154").disabled=false;
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

function updateRudangProcess154() {
	var stageId="45";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage154").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage154").val();//填写内容
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
		document.getElementById('154').innerHTML ="已通过";
		document.getElementById('155').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess155()'>正在进行";
		//document.getElementById("completionTime1Stage154").disabled=true;
		document.getElementById("completionDescriptionStage154").disabled=true;
		document.getElementById("uncompletionDescriptionStage154").disabled=true;
		document.getElementById("completionDescriptionStage155").disabled=false;
		document.getElementById("uncompletionDescriptionStage155").disabled=false;
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

function updateRudangProcess155() {
	var stageId="46";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage155").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage155").val();//填写内容
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
		document.getElementById('155').innerHTML ="已通过";
		document.getElementById('156').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess156()'>正在进行";
		//document.getElementById("completionTime1Stage154").disabled=true;
		document.getElementById("completionDescriptionStage155").disabled=true;
		document.getElementById("uncompletionDescriptionStage155").disabled=true;
		document.getElementById("completionDescriptionStage156").disabled=false;
		document.getElementById("uncompletionDescriptionStage156").disabled=false;
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

function updateRudangProcess156() {
	var stageId="47";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage156").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage156").val();//填写内容
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
		document.getElementById('156').innerHTML ="已通过";
		document.getElementById('16').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess16()'>正在进行";
		//document.getElementById("completionTime1Stage154").disabled=true;
		document.getElementById("completionDescriptionStage156").disabled=true;
		document.getElementById("uncompletionDescriptionStage156").disabled=true;
		document.getElementById("completionTime1Stage16").disabled=false;
		document.getElementById("completionDescriptionStage16").disabled=false;
		document.getElementById("uncompletionDescriptionStage16").disabled=false;
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

function updateRudangProcess16() {
	var stageId="48";
	var completionTime1=$("#completionTime1Stage16").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage16").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage16").val();//填写内容
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
		document.getElementById('16').innerHTML ="已通过";
		document.getElementById('17').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess17()'>正在进行";
		document.getElementById("completionTime1Stage16").disabled=true;
		document.getElementById("completionDescriptionStage16").disabled=true;
		document.getElementById("uncompletionDescriptionStage16").disabled=true;
		document.getElementById("completionTime1Stage17").disabled=false;
		document.getElementById("uncompletionDescriptionStage17").disabled=false;
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

function updateRudangProcess17() {
	var stageId="49";
	var completionTime1=$("#completionTime1Stage17").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage17").val();//填写内容
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
		document.getElementById('17').innerHTML ="已通过";
		document.getElementById('18').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess18()'>正在进行";
		document.getElementById("completionTime1Stage17").disabled=true;
		document.getElementById("uncompletionDescriptionStage17").disabled=true;
		document.getElementById("completionTime1Stage18").disabled=false;
		document.getElementById("uncompletionDescriptionStage18").disabled=false;
		//document.getElementById("completionDescriptionStage17").disabled=true;
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

function updateRudangProcess18() {
	var stageId="50";
	var completionTime1=$("#completionTime1Stage18").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage18").val();
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
		document.getElementById('18').innerHTML ="已通过";
		document.getElementById("completionTime1Stage18").disabled=true;
		document.getElementById("uncompletionDescriptionStage18").disabled=true;
		//document.getElementById("completionDescriptionStage17").disabled=true;
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
						<th colspan="2" width="25">所需材料</th>
						<th width="100">时间要求</th>
						<th>备注</th>
						<th width="170">完成情况</th>
						<th width="50">状态</th>
						<th width="70">说明</th>	
					</tr>
				    </thead>
				    <tbody class="cl-color">
				   
					<tr>
					    <td rowspan="21">四、预备党员的接收</td>
						<td rowspan="2">12、支委会审查</td>
						<td>12.1 集体讨论确认发展对象具备入党条件、手续完备</td>
						<td></td>
						<td>时间在培训之后，第3个支委会，</td>
						<td><span><p>讨论时间：</p><input type="text" value="" id="completionTime1Stage121"></span></td>
						<td id="121" ></td>
						<td><span><p style="width: auto;">若完成情况未填写，需在此处选择未填写原因，若已填写完成情况，请忽略此步</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage121"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>12.2 上报预审请示，同时提交相关材料；包括：
                                <br>（1） 入党申请书；</br>                                           
                                <br>（2） 入党积极分子考察登记表</br>
                                <br>（3） 思想汇报</br>
                                <br>（4）政治审查、外调及结论性材料；</br>
                                <br>（5）参加短期集中培训情况（证书）</br>
                                <br>（6） 其他需要报上级党委审查的材料。</br>  
                        </td>                                        
						<td></td>
						<td></td>
						<td><span><p>提交时间：</p><input type="text" value="" id="completionTime1Stage122"></span></td>
						<td id="122" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage122"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td rowspan="2">13、上级党委预审</td>
						<td>13.1 审查结果书面通知党支部</td>
						<td></td>
						<td></td>
						<td><span><p style="width: 120px;">书面通知时间：</p><input type="text" value="" id="completionTime1Stage131" style="float: none;"></span></td>
						<td id="131" ></td>
						<td><span><p >同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage131"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>13.2 向审查合格对象发放《中国共产党入党志愿书》</td>                                        
						<td></td>
						<td></td>
						<td><span><p style="width: 120px;">入党志愿书编号：</p><input type="text" value="" id="completionDescriptionStage132" style="float: none;"></span></td>
						<td id="132" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage132"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td rowspan="2">14、填写入党志愿书</td>
						<td>14.1 发展对象个人填写</td>
						<td></td>
						<td></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage141"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="141" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage141"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>14.2 入党介绍人填写意见</td>                                        
						<td></td>
						<td></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage142"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="142" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage142"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td rowspan="12">15、支部大会讨论</td>
						<td>15.1.1发展对象宣读《入党志愿书》，汇报自己对党的认识、入党动机、本人履历、现实表现、家庭主要成员和主要社会关系情况，以及需要向党组织说明的问题。</td>
						<td></td>
						<td rowspan="7">第一次党员大会</td>
						<td rowspan="7">
						    <span><p style="width: 170px;">支部大会召开时间：</p><input type="text" value="" id="completionTime1Stage1511" style="float: none;"></span>
						    <span>有表决权应到会人数：<textarea rows="5" cols="30" id="completionDescriptionStage15111" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						    <span>有表决权实到会人数：<textarea rows="5" cols="30" id="completionDescriptionStage15112" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						    <span>无记名投票结果：<textarea rows="5" cols="30" id="completionDescriptionStage15113" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
					    </td>
						<td rowspan="7" id="1511" ></td>
						<td rowspan="7"><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage1511"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>15.1.2 入党介绍人介绍发展对象的主要情况和对其进行培养教育情况，并对其能否入党表明意见。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.1.3 支委会向支部大会报告对发展对象审查的情况及征求党内外有关群众意见的情况。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.1.4 与会党员充分发表意见，对发展对象能否入党进行讨论。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.1.5 发展对象表态，谈自己对大家提出意见的看法及今后的决心。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.1.6 采取无记名投票的方式进行表决。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.1.7 宣布投票结果。</td>
						<td></td>
					</tr>
					
					<tr>
						<td>15.2 党总支对支部党员大会通过接收的预备党员进行审议。（设有党总支）</td>
						<td></td>
						<td>第1个总支委会</td>
						<td><span><p>审议时间：</p><input type="text" value="" id="completionTime1Stage152"></span></td>
						<td id="152" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage152"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>15.3 大会决议公示且无异议）</td>
						<td>五个工作日</td>
						<td>第3次公示</td>
						<td>
						    <span><p style="width: 120px;">公示开始时间：</p><input type="text" value="" id="completionTime1Stage153" style="float: none;"></span>
						    <span><p style="width: 120px;">公示结束时间：</p><input type="text" value="" id="completionTime2Stage153" style="float: none;"></span>
						    <span><p style="width: 120px;">公示形式：</p>
						    <select class="textarea"  id="completionDescriptionStage153"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						    </select>
						    </span>
						</td>
						<td id="153" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage153"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>15.4 将决议写入入党志愿书
                        <br>主要包括：发展对象的主要表现；应到会和实到会有表决权的党员人数；表决结果；通过决议的日期；支部书记签名。</br></td>
						<td></td>
						<td></td>
						<td><span><p></p><textarea rows="5" cols="30" id="completionDescriptionStage154" style="float:none; min-height:auto;width:auto;"  ></textarea></span></td>
						<td id="154" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage154"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>15.5 总支将审议意见写入党志愿书</td>
						<td></td>
						<td></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage155"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="155" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage155"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td>15.6 报上级党委</td>
						<td></td>
						<td></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage156"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="156" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage156"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>16、上级党委派人谈话</td>
					    <td></td>
						<td>党委委员或组织员第4次谈话谈话内容填入入党志愿书</td>
						<td></td>
						<td>
						   <span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage16"></span>
						   <span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage16"></span>
						</td>
						<td id="16" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage16"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>17、上级党委审批</td>
					    <td></td>
						<td>三个月内，集体讨论并逐个审议表决，审批意见写入入党志愿书；审批后将结果通知党支部，支部通知本人并在党员大会宣布；党委审批结果报直属党委备案发邮件时给组织委员和党群（魏媛婕）发送 </td>
						<td></td>
						<td>
						   <span><p>审批时间：</p><input type="text" value="" id="completionTime1Stage17"></span>
						</td>
						<td id="17" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage17"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>18、在上一级党委组织部门备案</td>
					    <td></td>
						<td></td>
						<td></td>
						<td>
						   <span><p>备案时间：</p><input type="text" value="" id="completionTime1Stage18"></span>
						</td>
						<td id="18" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage18"   >
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
















