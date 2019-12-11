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
var materialId="2";//页数


function right(){
		var loca = "Process/toRudangProcess.do?geren=geren&materialId=3&operId="+operId;
		window.location.href=loca;
// 		document.getElementById('71').innerHTML = "<input type='button' value='通过'  onclick='updateRudangProcess71()'>正在进行";
	}
function left(){
	var loca = "Process/toRudangProcess.do?geren=geren&materialId=1&operId="+operId;
	window.location.href=loca;
}

$(document).ready(function(){
	$( "#completionTime1Stage33" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage35" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime2Stage35" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	/*
	$( "#completionTime1Stage61" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage61" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage61" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage61" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage62" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage62" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage62" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage62" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage63" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage63" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage63" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage63" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	*/
	
	
	$( "#completionTime1Stage64" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1StageB1" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2StageB1" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1StageB2" ).datepicker({
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
                	//Stage31完成情况
                	//$("#completionTime1Stage31").val(process[4].completionTime1);
                	//$("#completionTime2Stage31").val(process[4].completionTime2);
                	$("#completionDescriptionStage31").val(process[0].completionDescription);
                	$("#uncompletionDescriptionStage31").val(process[0].uncompletionDescription);
               
                    if(process[0].status==1){
                    	document.getElementById('31').innerHTML = "正在进行";
                	}else if(process[0].status==2){
                		document.getElementById('31').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage31").disabled=true;
                		document.getElementById("uncompletionDescriptionStage31").disabled=true;
                	}else if(process[0].status==0){
                		document.getElementById('31').innerHTML ="";
                		document.getElementById("completionDescriptionStage31").disabled=true;
                		document.getElementById("uncompletionDescriptionStage31").disabled=true;
                	}
                    
                    //Stage32完成情况
                	$("#completionDescriptionStage32").val(process[1].completionDescription);
                	$("#uncompletionDescriptionStage32").val(process[1].uncompletionDescription);
                    if(process[1].status==1){
                    	document.getElementById('32').innerHTML = "正在进行";
                	}else if(process[1].status==2){
                		document.getElementById('32').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage32").disabled=true;
                		document.getElementById("uncompletionDescriptionStage32").disabled=true;
                	}else if(process[1].status==0){
                		document.getElementById('32').innerHTML ="";
                		document.getElementById("completionDescriptionStage32").disabled=true;
                		document.getElementById("uncompletionDescriptionStage32").disabled=true;
                	}
                    
                    //Stage33完成情况
                    if(process[2].completionTime1!=null){
                    var timeToWork =new Date(process[2].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage33').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    $("#uncompletionDescriptionStage33").val(process[2].uncompletionDescription);
                    
                    if(process[2].status==1){
                    	document.getElementById('33').innerHTML = "正在进行";
                	}else if(process[2].status==2){
                		document.getElementById('33').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage33").disabled=true;
                		document.getElementById("uncompletionDescriptionStage33").disabled=true;
                	}else if(process[2].status==0){
                		document.getElementById('33').innerHTML ="";
                		document.getElementById("completionTime1Stage33").disabled=true;
                		document.getElementById("uncompletionDescriptionStage33").disabled=true;
                	}
                    
                    //Stage34完成情况
                	$("#completionDescriptionStage34").val(process[3].completionDescription);
                	$("#uncompletionDescriptionStage34").val(process[4].uncompletionDescription);
               
                    if(process[3].status==1){
                    	document.getElementById('34').innerHTML = "正在进行";
                	}else if(process[3].status==2){
                		document.getElementById('34').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage34").disabled=true;
                		document.getElementById("uncompletionDescriptionStage34").disabled=true;
                	}else if(process[3].status==0){
                		document.getElementById('34').innerHTML ="";
                		document.getElementById("completionDescriptionStage34").disabled=true;
                		document.getElementById("uncompletionDescriptionStage34").disabled=true;
                	}
                    
                  //Stage35完成情况
                    if(process[4].completionTime1!=null){
                    var timeToWork =new Date(process[4].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage35').val(t1+'-'+t2+'-'+t3);
                    }
                  
                    if(process[4].completionTime2!=null){
                        var timeToWork =new Date(process[4].completionTime2);
                        var t1 = timeToWork.getFullYear();
                        var t2 = timeToWork.getMonth()+1;
                        var t3 = timeToWork.getDate();
                        $('#completionTime2Stage35').val(t1+'-'+t2+'-'+t3);
                        }
                    $("#completionDescriptionStage35").val(process[4].completionDescription);
                    $("#uncompletionDescriptionStage35").val(process[4].uncompletionDescription);
                	
                    if(process[4].status==1){
                    	document.getElementById('35').innerHTML = "正在进行";
                	}else if(process[4].status==2){
                		document.getElementById('35').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage35").disabled=true;
                		document.getElementById("completionTime2Stage35").disabled=true;
            			document.getElementById("completionDescriptionStage35").disabled=true;
            			document.getElementById("uncompletionDescriptionStage35").disabled=true;
                	}else if(process[4].status==0){
                		document.getElementById('35').innerHTML ="";
                		document.getElementById("completionTime1Stage35").disabled=true;
                		document.getElementById("completionTime2Stage35").disabled=true;
            			document.getElementById("completionDescriptionStage35").disabled=true;
            			document.getElementById("uncompletionDescriptionStage35").disabled=true;
                	}
                    
                  //Stage41完成情况
                	$("#completionDescriptionStage41").val(process[5].completionDescription);
                	$("#uncompletionDescriptionStage35").val(process[5].uncompletionDescription);
               
                    if(process[5].status==1){
                    	document.getElementById('41').innerHTML = "正在进行";
                	}else if(process[5].status==2){
                		document.getElementById('41').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage41").disabled=true;
                		document.getElementById("uncompletionDescriptionStage41").disabled=true;
                	}else if(process[5].status==0){
                		document.getElementById('41').innerHTML ="";
                		document.getElementById("completionDescriptionStage41").disabled=true;
                		document.getElementById("uncompletionDescriptionStage41").disabled=true;
                	}
                    
                  //Stage42完成情况
                	$("#completionDescriptionStage42").val(process[6].completionDescription);
                	$("#uncompletionDescriptionStage42").val(process[6].uncompletionDescription);
                  
               
                    if(process[6].status==1){
                    	document.getElementById('42').innerHTML = "正在进行";
                	}else if(process[6].status==2){
                		document.getElementById('42').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage42").disabled=true;
                		document.getElementById("uncompletionDescriptionStage42").disabled=true;
                	}else if(process[6].status==0){
                		document.getElementById('42').innerHTML ="";
                		document.getElementById("completionDescriptionStage42").disabled=true;
                		document.getElementById("uncompletionDescriptionStage42").disabled=true;
                	}

                  //Stage5完成情况  
                    if(process[7].completionDescription!=null){
                        var arr1 = process[7].completionDescription.split("|");
                    	$("#completionDescriptionStage51").val(arr1[0]);
                    	$("#completionDescriptionStage52").val(arr1[1]);
                    	$("#completionDescriptionStage55").val(arr1[2]);
                    }
                  
                    $("#uncompletionDescriptionStage5").val(process[7].uncompletionDescription);
                  
                    document.getElementById('5').innerHTML = "以“完成情况”为准";
                    document.getElementById("completionDescriptionStage51").disabled=true;
                    document.getElementById("completionDescriptionStage52").disabled=true;
                    document.getElementById("completionDescriptionStage55").disabled=true;
            		document.getElementById("uncompletionDescriptionStage5").disabled=true;
                    
                    /*
                    if(process[7].status==1){
                    	document.getElementById('5').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess5()'>正在进行";
                	}else if(process[7].status==2){
                		document.getElementById('5').innerHTML = "已通过";
                		document.getElementById("completionDescriptionStage51").disabled=true;
                		document.getElementById("completionDescriptionStage52").disabled=true;
                	}else if(process[7].status==0){
                		document.getElementById('5').innerHTML ="";
                		document.getElementById("completionDescriptionStage51").disabled=true;
                		document.getElementById("completionDescriptionStage52").disabled=true;
                	}
                   */
                    
                  //Stage61完成情况
                    /*
                    if(process[8].completionTime1!=null){
                    var timeToWork =new Date(process[8].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage61').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    if(process[8].completionTime2!=null){
                    var timeToWork =new Date(process[8].completionTime2);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime2Stage61').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    if(process[8].completionTime3!=null){
                    var timeToWork =new Date(process[8].completionTime3);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime3Stage61').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    if(process[8].completionTime4!=null){
                    var timeToWork =new Date(process[8].completionTime4);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime4Stage61').val(t1+'-'+t2+'-'+t3);
                    }
                    */
                    
                    $("#completionDescriptionStage61").val(process[8].completionDescription);
                    $("#uncompletionDescriptionStage61").val(process[8].uncompletionDescription);
                    
                    document.getElementById('61').innerHTML = "以“完成情况”为准";
                    document.getElementById("completionDescriptionStage61").disabled=true;
                    document.getElementById("uncompletionDescriptionStage61").disabled=true;
                    
                	
                    //Stage62完成情况
                    $("#completionDescriptionStage62").val(process[9].completionDescription);
                    $("#uncompletionDescriptionStage62").val(process[9].uncompletionDescription);
                    
                    document.getElementById('62').innerHTML = "以“完成情况”为准";
                    document.getElementById("completionDescriptionStage62").disabled=true;
                    document.getElementById("uncompletionDescriptionStage62").disabled=true;
                	
                    
                  //Stage63完成情况
                    $("#completionDescriptionStage63").val(process[10].completionDescription);
                    $("#uncompletionDescriptionStage63").val(process[10].uncompletionDescription);
                    
                    document.getElementById('63').innerHTML = "以“完成情况”为准";
                    document.getElementById("completionDescriptionStage63").disabled=true;
                    document.getElementById("uncompletionDescriptionStage63").disabled=true;
                	
                    
                  //Stage64完成情况
                    if(process[11].completionTime1!=null){
                    var timeToWork =new Date(process[11].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1Stage64').val(t1+'-'+t2+'-'+t3);
                    }
                	$("#completionDescriptionStage64").val(process[11].completionDescription);
                	$("#uncompletionDescriptionStage64").val(process[11].uncompletionDescription);
                    
                    if(process[11].status==1){
                    	document.getElementById('64').innerHTML = "正在进行";
                	}else if(process[11].status==2){
                		document.getElementById('64').innerHTML = "已通过";
                		document.getElementById("completionTime1Stage64").disabled=true;
            			document.getElementById("completionDescriptionStage64").disabled=true;
            			document.getElementById("uncompletionDescriptionStage64").disabled=true;
                	}else if(process[11].status==0){
                		document.getElementById('64').innerHTML ="";
                		document.getElementById("completionTime1Stage64").disabled=true;
            			document.getElementById("completionDescriptionStage64").disabled=true;
            			document.getElementById("uncompletionDescriptionStage64").disabled=true;
                	}
                    
                  //StageB1完成情况
                    if(process[12].completionTime1!=null){
                    var timeToWork =new Date(process[12].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1StageB1').val(t1+'-'+t2+'-'+t3);
                    }
                    
                    if(process[12].completionTime2!=null){
                    var timeToWork =new Date(process[12].completionTime2);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime2StageB1').val(t1+'-'+t2+'-'+t3);
                    }

                    $("#completionDescriptionStageB1").val(process[12].completionDescription);
                    $("#uncompletionDescriptionStageB1").val(process[12].uncompletionDescription);
                	
                    if(process[12].status==1){
                    	document.getElementById('Blank1').innerHTML = "正在进行";
                	}else if(process[12].status==2){
                		document.getElementById('Blank1').innerHTML = "已通过";
                		document.getElementById("completionTime1StageB1").disabled=true;
                		document.getElementById("completionTime2StageB1").disabled=true;
            			document.getElementById("completionDescriptionStageB1").disabled=true;
            			document.getElementById("uncompletionDescriptionStageB1").disabled=true;
            			
                	}else if(process[12].status==0){
                		document.getElementById('Blank1').innerHTML ="";
                		document.getElementById("completionTime1StageB1").disabled=true;
                		document.getElementById("completionTime2StageB1").disabled=true;
            			document.getElementById("completionDescriptionStageB1").disabled=true;
            			document.getElementById("uncompletionDescriptionStageB1").disabled=true;
                	}
                    
                  //StageB2完成情况
                    if(process[13].completionTime1!=null){
                    var timeToWork =new Date(process[13].completionTime1);
                    var t1 = timeToWork.getFullYear();
                    var t2 = timeToWork.getMonth()+1;
                    var t3 = timeToWork.getDate();
                    $('#completionTime1StageB2').val(t1+'-'+t2+'-'+t3);
                    }
                    $("#completionDescriptionStageB2").val(process[13].completionDescription);
                    $("#uncompletionDescriptionStageB2").val(process[13].uncompletionDescription);
                    
                    if(process[13].status==1){
                    	document.getElementById('Blank2').innerHTML = "正在进行";
                	}else if(process[13].status==2){
                		document.getElementById('Blank2').innerHTML = "已通过";
                		document.getElementById("completionTime1StageB2").disabled=true;
            			document.getElementById("completionDescriptionStageB2").disabled=true;
            			document.getElementById("uncompletionDescriptionStageB2").disabled=true;
                	}else if(process[13].status==0){
                		document.getElementById('Blank2').innerHTML ="";
                		document.getElementById("completionTime1StageB2").disabled=true;
            			document.getElementById("completionDescriptionStageB2").disabled=true;
            			document.getElementById("uncompletionDescriptionStageB2").disabled=true;
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

function updateRudangProcess31() {
	var stageId="4";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage31").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage31").val();//填写内容
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
		document.getElementById('31').innerHTML ="已通过";
		document.getElementById('32').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage31").disabled=true;
		document.getElementById("uncompletionDescriptionStage31").disabled=true;
		document.getElementById("completionDescriptionStage32").disabled=false;
		document.getElementById("uncompletionDescriptionStage32").disabled=false;
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

function updateRudangProcess32() {
	var stageId="5";//"步骤数 你想个地方保存当前行的步骤数 ";
    var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage32").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage32").val();
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
        document.getElementById('32').innerHTML ="已通过";
		document.getElementById('33').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage32").disabled=true;
		document.getElementById("uncompletionDescriptionStage32").disabled=true;
		document.getElementById("completionTime1Stage33").disabled=false;
		document.getElementById("uncompletionDescriptionStage33").disabled=false;
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

function updateRudangProcess33() {
	var stageId="6";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage33").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage33").val();
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
        document.getElementById('33').innerHTML ="已通过";
		document.getElementById('34').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage33").disabled=true;
		document.getElementById("uncompletionDescriptionStage33").disabled=true;
		document.getElementById("completionDescriptionStage34").disabled=false;
		document.getElementById("uncompletionDescriptionStage34").disabled=false;
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

function updateRudangProcess34() {
	var stageId="7";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage34").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage34").val();//填写内容
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
        document.getElementById('34').innerHTML ="已通过";
		document.getElementById('35').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage34").disabled=true;
		document.getElementById("uncompletionDescriptionStage34").disabled=true;
		document.getElementById("completionTime1Stage35").disabled=false;
		document.getElementById("completionTime2Stage35").disabled=false;
		document.getElementById("completionDescriptionStage35").disabled=false;
		document.getElementById("uncompletionDescriptionStage35").disabled=false;
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

function updateRudangProcess35() {
	var stageId="8";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage35").val();//第一个日期
    var completionTime2=$("#completionTime2Stage35").val();//第二个日期
    var completionDescription=$("#completionDescriptionStage35").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage35").val();//填写内容
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
        document.getElementById('35').innerHTML ="已通过";
		document.getElementById('41').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage35").disabled=true;
		document.getElementById("completionTime2Stage35").disabled=true;
		document.getElementById("completionDescriptionStage35").disabled=true;
		document.getElementById("uncompletionDescriptionStage35").disabled=true;
		document.getElementById("completionDescriptionStage41").disabled=false;
		document.getElementById("uncompletionDescriptionStage41").disabled=false;
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

function updateRudangProcess41() {
	var stageId="9";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage41").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage41").val();//填写内容
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
        document.getElementById('41').innerHTML ="已通过";
		document.getElementById('42').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage41").disabled=true;
		document.getElementById("uncompletionDescriptionStage41").disabled=true;
		document.getElementById("completionDescriptionStage42").disabled=false;
		document.getElementById("uncompletionDescriptionStage42").disabled=false;
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

function updateRudangProcess42() {
	var stageId="10";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="15";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage42").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage42").val();//填写内容
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
        document.getElementById('42').innerHTML ="已通过";
		document.getElementById('64').innerHTML = "正在进行";
		document.getElementById("completionDescriptionStage42").disabled=true;
		document.getElementById("uncompletionDescriptionStage42").disabled=true;
		document.getElementById("completionDescriptionStage64").disabled=false;
		document.getElementById("uncompletionDescriptionStage64").disabled=false;
		document.getElementById("completionTime1Stage64").disabled=false;
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

function updateRudangProcess5() {
	var stageId="11";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="11";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription51=$("#completionDescriptionStage51").val();//填写内容
    var completionDescription52=$("#completionDescriptionStage52").val();//填写内容
   // var completionDescription=completionDescription51+"|"+completionDescription52;
    var completionDescription53=$("#completionDescriptionStage53").val();//填写内容
    var completionDescription54=$("#completionDescriptionStage54").val();//填写内容
    var completionDescription55=$("#completionDescriptionStage55").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage5").val();//填写内容
    var completionDescription=completionDescription51+"|"+completionDescription52+"|"+completionDescription55;
    	
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
         document.getElementById('5').innerHTML ="已通过";
        var completionDescription551=$("#completionDescriptionStage55").val(completionDescription53+" "+completionDescription54);
        var completionDescription531=$("#completionDescriptionStage53").val(completionDescription51);
        var completionDescription541=$("#completionDescriptionStage54").val(completionDescription52);
        
       //var jsonData = JSON.stringify(completionDescription551);// 转成JSON格式
        //var result = $.parseJSON(jsonData);// 转成JSON对象
		document.getElementById('5').innerHTML = "以“完成情况”为准";
		//document.getElementById("completionDescriptionStage51").disabled=true;
		//document.getElementById("completionDescriptionStage52").disabled=true;
		//document.getElementById("completionTime1Stage64").disabled=false;
		//document.getElementById("completionDescriptionStage64").disabled=false;
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

function updateRudangProcess61() {
	var stageId="12";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="12";
	//var completionTime1=$("#completionTime1Stage61").val();//第一个日期
  //  var completionTime2=$("#completionTime2Stage61").val();//第二个日期
   // var completionTime3=$("#completionTime3Stage61").val();//第二个日期
   // var completionTime4=$("#completionTime4Stage61").val();//第二个日期
    var completionDescription=$("#completionDescriptionStage61").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage61").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        //document.getElementById('61').innerHTML ="已通过";
		document.getElementById('61').innerHTML = "以“完成情况”为准";
		//document.getElementById("completionTime1Stage61").disabled=true;
		//document.getElementById("completionTime2Stage61").disabled=true;
		//document.getElementById("completionTime3Stage61").disabled=true;
		//document.getElementById("completionTime4Stage61").disabled=true;
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

function updateRudangProcess62() {
	var stageId="13";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="13";
    var completionDescription=$("#completionDescriptionStage62").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage62").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
       //document.getElementById('62').innerHTML ="已通过";
		document.getElementById('62').innerHTML = "以“完成情况”为准";
		//document.getElementById("completionTime1Stage62").disabled=true;
		//document.getElementById("completionTime2Stage62").disabled=true;
		//document.getElementById("completionTime3Stage62").disabled=true;
		//document.getElementById("completionTime4Stage62").disabled=true;
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

function updateRudangProcess63() {
	var stageId="14";//"步骤数 你想个地方保存当前行的步骤数 ";
	var nextStageId="14";
    var completionDescription=$("#completionDescriptionStage63").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage63").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
        $.jBox.tip(msg.msg,'success');
        //document.getElementById('63').innerHTML ="已通过";
		document.getElementById('63').innerHTML = "以“完成情况”为准";
		//document.getElementById("completionTime1Stage63").disabled=true;
		//document.getElementById("completionTime2Stage63").disabled=true;
		//document.getElementById("completionTime3Stage63").disabled=true;
		//document.getElementById("completionTime4Stage63").disabled=true;
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

function updateRudangProcess64() {
	var stageId="15";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1Stage64").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage64").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage64").val();//填写内容
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
        document.getElementById('64').innerHTML ="已通过";
		document.getElementById('Blank1').innerHTML = "正在进行";
		document.getElementById("completionTime1Stage64").disabled=true;
		document.getElementById("completionDescriptionStage64").disabled=true;
		document.getElementById("uncompletionDescriptionStage64").disabled=true;
		document.getElementById("completionTime1StageB1").disabled=false;
		document.getElementById("completionTime2StageB1").disabled=false;
		document.getElementById("completionDescriptionStageB1").disabled=false;
		document.getElementById("uncompletionDescriptionStageB1").disabled=false;
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

function updateRudangProcessBlank1() {
	var stageId="16";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1StageB1").val();//第一个日期
    var completionTime2=$("#completionTime2StageB1").val();//第二个日期
    var completionDescription=$("#completionDescriptionStageB1").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStageB1").val();//填写内容
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
        document.getElementById('Blank1').innerHTML ="已通过";
		document.getElementById('Blank2').innerHTML = "正在进行";
		document.getElementById("completionTime1StageB1").disabled=true;
		document.getElementById("completionTime2StageB1").disabled=true;
		document.getElementById("completionDescriptionStageB1").disabled=true;
		document.getElementById("uncompletionDescriptionStageB1").disabled=true;
		document.getElementById("completionTime1StageB2").disabled=false;
		document.getElementById("completionDescriptionStageB2").disabled=false;
		document.getElementById("uncompletionDescriptionStageB2").disabled=false;
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

function updateRudangProcessBlank2() {
	var stageId="17";//"步骤数 你想个地方保存当前行的步骤数 ";
	var completionTime1=$("#completionTime1StageB2").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStageB2").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStageB2").val();//填写内容
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
        document.getElementById('Blank2').innerHTML ="已通过";
		//document.getElementById('65').innerHTML = "<input type='button' value='通过'  onclick='updateRudangProcess65()'>正在进行";
		document.getElementById("completionTime1StageB2").disabled=true;
		document.getElementById("completionDescriptionStageB2").disabled=true;
		document.getElementById("uncompletionDescriptionStageB2").disabled=true;
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

function setNoVisibility(){
	document.getElementById("completionDescriptionStage53").style.display = "none";
	document.getElementById("completionDescriptionStage54").style.display = "none";
	
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
				
				<!--列表-->
				<table class="table table-primary mt-30" border="1"  style="width:100%;min-width: 1000px;" >
				    <thead>  
					<tr>
						<th width="130">党员发展工作阶段</th>
						<th colspan="2" >所需材料</th>
						<th width="60">时间要求</th>
						<th>备注</th>
						<th width="170">完成情况</th>
						<th width="50">状态</th>
						<th width="70">说明</th>	
					</tr>
				    </thead>
				    <tbody class="cl-color">
				   
					<tr>
					    <td rowspan="14">二、入党积极分子的确定和培养教育</td>
						<td rowspan="5">3、确定和推荐入党积极分子</td>
						<td>3.1 党员推荐、群团组织推优</td>
						<td></td>
						<td>（递交申请书六个月以上，具备积极分子条件）党小组会形式，开会时邀请2-3名群众参加，以小组会议纪要形式记录（如是团员需团支部意见）。没有党小组要有书面推荐意见</td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage31" onchange="updateRudangProcess31"  >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="31" ></td>
						<td><span><p style="width: auto;">若完成情况未填写，需在此处选择未填写原因，若已填写完成情况，请忽略此步</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage31"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>3.2 支部听取意见</td>
						<td></td>
						<td></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage32"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						</select>
						</span></td>
						<td id="32" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage32"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>3.3 支部委员会研究确定入党积极分子</td>
						<td></td> 
						<td>支委会是确定为积极分子的时间。第1个支委会</td>
						<td><span><p style="width:120px;">支委会召开时间：</p><br><input type="text" value="" id="completionTime1Stage33"  ></br></span></td>
						<td id="33" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage33"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>3.4 党总支审查同意（设有党总支）</td>
						<td></td>
						<td>党总支书记签字同意</td>
						<td><span><p></p><textarea rows="5" cols="30" id="completionDescriptionStage34" style="float:none; min-height:auto;width:auto;"  ></textarea></span></td>
						<td id="34" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage34"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>3.5 公示并无异议</td>
					    <td>五个工作日</td>
						<td>第1次公示，可公示栏形式，留照片。见公示模板</td>
						<td>
						    <span><p style="width:120px;" >公示开始时间：</p><input type="text" value="" id="completionTime1Stage35" style="float: none;"></span>
						    <span><p style="width:120px;" >公示结束时间：</p><input type="text" value="" id="completionTime2Stage35" style="float: none;"></span>
							<span><p style="width:120px;">公示方式：</p></span>
							<br />
							<select class="textarea"  id="completionDescriptionStage35"   >
						<option value></option>
						<option value="邮件">邮件</option>
						<option value="公示栏">公示栏</option>
						<option value="其它">其它</option>
						    </select>
						</td>
						<td id="35" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage35"  >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td rowspan="2">4、上级党委备案</td>
						<td>4.1 填写《中国联通直属党委入党积极分子备案登记表》</td>
						<td></td>
						<td rowspan="2"></td>
						<td><span><p></p>
						<select class="textarea"  id="completionDescriptionStage41"   >
						<option value></option>
						<option value="完成">完成</option>
						<option value="未完成">未完成</option>
						<option value="外单位转入">外单位转入</option>
						<option value="其它">其它</option>
						</select>
						</span></td>
						<td id="41"></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage41"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>4.2 备案登记</td>
						<td></td>
						<td><span><p style="width: 170px">备案登记表接收人签字：</p><br /><input type="text" value="" id="completionDescriptionStage42" style="float: none;"></span></td>
						<td id="42" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage42"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">5、指定2名正式党员作为培养联系人</td>
						<td></td>
						<td></td>
						<td>
						<span><p style="width: 120px;">培养联系人姓名：</p><input type="text" value="" id="completionDescriptionStage51" style="float: none;"></span>
						<span><p style="width: 120px;">培养联系人姓名：</p><input type="text" value="" id="completionDescriptionStage52" style="float: none;"></span>
						<span><p></p><input type="text" value="" id="completionDescriptionStage53" style="display:none"></span>
						<span><p></p><input type="text" value="" id="completionDescriptionStage54" style="display:none"></span>
						<span>备注栏：（上一任培养联系人姓名）<textarea rows="5" cols="30" id="completionDescriptionStage55" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="5"></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage5"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
						
					</tr>
					<tr>
						<td rowspan="4">6、积极分子培养教育考察</td>
						<td>6.1 积极分子提交思想汇报</td>
						<td>每季度一次</td>
						<td></td>
						<td>
						<span>备注栏：（例如：**思想汇报提交时间 ：2013-03-05 ）<textarea rows="5" cols="30" id="completionDescriptionStage61" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						<td id="61" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage61"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>6.2 培养联系人对入党积极分子进行考察</td>
						<td>每季度一次</td>
						<td rowspan="2">考察意见情况写入《入党积极分子考察登记表》，不能只签字，按季度填好日期</td>
						<td>
						<span>备注栏：（例如：**联系人培养意见填写时间 ：2013-03-05） <textarea rows="5" cols="30" id="completionDescriptionStage62" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="62" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage62"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>6.3 党支部每季度对进行入党积极分子考察</td>
						<td>每季度一次</td>
						<td>
						<span>备注栏：（例如：考察意见填写时间 ：2013-03-05）<textarea rows="5" cols="30" id="completionDescriptionStage63" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="63" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage63"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>6.4 党支部派人谈话</td>
						<td>至少一次</td>
						<td>第2次谈话，别单位转入的要进行一次谈话并记录</td>
						<td> 
							<span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage64"></span>
                            <span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage64"></span>
						</td>
						<td id="64" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage64"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">入党积极分子工作调动时移交或接收相关档案材料</td>
						<td></td>
						<td></td>
						<td>
						    <span><p>档案接收人：</p><input type="text" value="" id="completionDescriptionStageB1"></span>
                            <span><p>接收时间：</p><input type="text" value="" id="completionTime1StageB1"></span>
                            <span><p>认定时间：</p><input type="text" value="" id="completionTime2StageB1"></span>
						</td>
						<td id="Blank1" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStageB1"   >
						  <option value=""></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">入党积极分子调入时党支部派人谈话（书记或者副书记或者组织委员）</td>
						<td></td>
						<td></td>
						<td>
						    <span><p>谈话人：</p><input type="text" value=""  id="completionDescriptionStageB2"></span>
                            <span><p>谈话时间：</p><input type="text" value="" id="completionTime1StageB2"></span>
                        </td>
						<td id="Blank2" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStageB2"   >
						  <option value=""></option>
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
				<div id="kkpager" class="mt-10 ml-20 mr-30"></div>
			</div>

		</div>
	</div>
</div>




</body>
</html>