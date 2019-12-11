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
var materialId="5";//页数
function left(){
	var loca = "Process/toRudangProcess.do?materialId=4&operId="+operId;
	window.location.href=loca;
}

$(document).ready(function(){
	$( "#completionTime1Stage20" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	/*
	$( "#completionTime1Stage211" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage211" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage211" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage211" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage2121" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage2121" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage2121" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage2121" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });

	$( "#completionTime1Stage2122" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage2122" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage2122" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage2122" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage2123" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage2123" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage2123" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage2123" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage2124" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage2124" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime3Stage2124" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime4Stage2124" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	*/
	
	
	$( "#completionTime1Stage213" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage221" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage231" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage232" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage233" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime2Stage233" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage241" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage242" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage243" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	
	$( "#completionTime1Stage25" ).datepicker({
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
                   	
                	//Stage19完成情况
                   	//$("#completionTime1Stage31").val(process[4].completionTime1);
                   	//$("#completionTime2Stage31").val(process[4].completionTime2);
                   	$("#completionDescriptionStage19").val(process[0].completionDescription);
                	$("#uncompletionDescriptionStage19").val(process[0].uncompletionDescription);
                	
                       if(process[0].status==1){
                       	document.getElementById('19').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess19()'>正在进行";
                   	}else if(process[0].status==2){
                   		document.getElementById('19').innerHTML = "已通过";
                   		document.getElementById("completionDescriptionStage19").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage19").disabled=true;
                   	}else if(process[0].status==0){
                   		document.getElementById('19').innerHTML ="";
                   		document.getElementById("completionDescriptionStage19").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage19").disabled=true;
                   	}
                       
                       //Stage20完成情况
                       if(process[1].completionTime1!=null){
                       var timeToWork =new Date(process[1].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage20').val(t1+'-'+t2+'-'+t3);
                       }
                       
                       $("#uncompletionDescriptionStage20").val(process[1].uncompletionDescription);
                       
                       if(process[1].status==1){
                       	document.getElementById('20').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess20()'>正在进行";
                   	}else if(process[1].status==2){
                   		document.getElementById('20').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage20").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage20").disabled=true;
                   	}else if(process[1].status==0){
                   		document.getElementById('20').innerHTML ="";
                   		document.getElementById("completionTime1Stage20").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage20").disabled=true;
                   	}
                       
                       //Stage211完成情况
                       /*
                       if(process[2].completionTime1!=null){
                       var timeToWork =new Date(process[2].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage211').val(t1+'-'+t2+'-'+t3);
                       }
                       
                       if(process[2].completionTime2!=null){
                       var timeToWork =new Date(process[2].completionTime2);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime2Stage211').val(t1+'-'+t2+'-'+t3);
                       }
                       
                       if(process[2].completionTime3!=null){
                       var timeToWork =new Date(process[2].completionTime3);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime3Stage211').val(t1+'-'+t2+'-'+t3);
                       }
                       
                       if(process[2].completionTime4!=null){
                       var timeToWork =new Date(process[2].completionTime4);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime4Stage211').val(t1+'-'+t2+'-'+t3);
                       }
                       */
                       $("#completionDescriptionStage211").val(process[2].completionDescription);
                       $("#uncompletionDescriptionStage211").val(process[2].uncompletionDescription);
                  
                       document.getElementById('211').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess211()'>";
                   
                       
                     //Stage2121完成情况
                       $("#completionDescriptionStage2121").val(process[3].completionDescription);
                       $("#uncompletionDescriptionStage2121").val(process[3].uncompletionDescription);
                  
                       document.getElementById('2121').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2121()'>";
                   
                       
                     //Stage2122完成情况
                       $("#completionDescriptionStage2122").val(process[4].completionDescription);
                       $("#uncompletionDescriptionStage2122").val(process[4].uncompletionDescription);
                  
                       document.getElementById('2122').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2122()'>";
                   
                       
                     //Stage2123完成情况
                       $("#completionDescriptionStage2123").val(process[5].completionDescription);
                       $("#uncompletionDescriptionStage2123").val(process[5].uncompletionDescription);
                  
                       document.getElementById('2123').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2123()'>";
                   	
                       
                       //Stage2124完成情况
                       $("#completionDescriptionStage2124").val(process[6].completionDescription);
                       $("#uncompletionDescriptionStage2124").val(process[6].uncompletionDescription);
                  
                       document.getElementById('2124').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2124()'>";
                   
                       
                     //Stage213完成情况
                       if(process[7].completionTime1!=null){
                       var timeToWork =new Date(process[7].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage213').val(t1+'-'+t2+'-'+t3);
                       }
                   	$("#completionDescriptionStage213").val(process[7].completionDescription);
                   	$("#uncompletionDescriptionStage213").val(process[7].uncompletionDescription);
                  
                       if(process[7].status==1){
                       	document.getElementById('213').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess213()'>正在进行";
                   	}else if(process[7].status==2){
                   		document.getElementById('213').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage213").disabled=true;
                		document.getElementById("completionDescriptionStage213").disabled=true;
                		document.getElementById("uncompletionDescriptionStage213").disabled=true;
                   	}else if(process[7].status==0){
                   		document.getElementById('213').innerHTML ="";
                   		document.getElementById("completionTime1Stage213").disabled=true;
                		document.getElementById("completionDescriptionStage213").disabled=true;
                		document.getElementById("uncompletionDescriptionStage213").disabled=true;
                   	}
                       
                     //Stage221完成情况
                       if(process[8].completionTime1!=null){
                   	   var timeToWork =new Date(process[8].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage221').val(t1+'-'+t2+'-'+t3);
                       }
                     
                       $("#uncompletionDescriptionStage221").val(process[8].uncompletionDescription);
                  
                       if(process[8].status==1){
                       	document.getElementById('221').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess221()'>正在进行";
                   	}else if(process[8].status==2){
                   		document.getElementById('221').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage221").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage221").disabled=true;
                   	}else if(process[8].status==0){
                   		document.getElementById('221').innerHTML ="";
                   		document.getElementById("completionTime1Stage221").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage221").disabled=true;
                   	}
                       
                     //Stage222完成情况
                   	$("#completionDescriptionStage222").val(process[9].completionDescription);
                   	$("#uncompletionDescriptionStage222").val(process[9].uncompletionDescription);
                  
                       if(process[9].status==1){
                       	document.getElementById('222').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess222()'>正在进行";
                   	}else if(process[9].status==2){
                   		document.getElementById('222').innerHTML = "已通过";
                   		document.getElementById("completionDescriptionStage222").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage222").disabled=true;
                   	}else if(process[9].status==0){
                   		document.getElementById('222').innerHTML ="";
                   		document.getElementById("completionDescriptionStage222").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage222").disabled=true;
                   	}
                       
                     //Stage223完成情况
                   	$("#completionDescriptionStage223").val(process[10].completionDescription);
                   	$("#uncompletionDescriptionStage223").val(process[10].uncompletionDescription);
                  
                       if(process[10].status==1){
                       	document.getElementById('223').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess223()'>正在进行";
                   	}else if(process[10].status==2){
                   		document.getElementById('223').innerHTML = "已通过";
                   		document.getElementById("completionDescriptionStage223").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage223").disabled=true;
                   	}else if(process[10].status==0){
                   		document.getElementById('223').innerHTML ="";
                   		document.getElementById("completionDescriptionStage223").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage223").disabled=true;
                   	}
                       
                       //Stage231完成情况
                       if(process[11].completionTime1!=null){
                       var timeToWork =new Date(process[11].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage231').val(t1+'-'+t2+'-'+t3);
                       }
                       if(process[11].completionDescription!=null){
                           var arr1 = process[11].completionDescription.split("|");
                       	$("#completionDescriptionStage2311").val(arr1[0]);
                       	$("#completionDescriptionStage2312").val(arr1[1]);
                       	$("#completionDescriptionStage2313").val(arr1[2]);
                       }
                       
                       $("#uncompletionDescriptionStage231").val(process[11].uncompletionDescription);
                  
                       if(process[11].status==1){
                       	document.getElementById('231').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess231()'>正在进行";
                   	}else if(process[11].status==2){
                   		document.getElementById('231').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage231").disabled=true;
                		document.getElementById("completionDescriptionStage2311").disabled=true;
                		document.getElementById("completionDescriptionStage2312").disabled=true;
                		document.getElementById("completionDescriptionStage2313").disabled=true;
                		document.getElementById("uncompletionDescriptionStage231").disabled=true;
                   	}else if(process[11].status==0){
                   		document.getElementById('231').innerHTML ="";
                   		document.getElementById("completionTime1Stage231").disabled=true;
                		document.getElementById("completionDescriptionStage2311").disabled=true;
                		document.getElementById("completionDescriptionStage2312").disabled=true;
                		document.getElementById("completionDescriptionStage2313").disabled=true;
                		document.getElementById("uncompletionDescriptionStage231").disabled=true;
                   	}
                       
                       
                       //Stage232完成情况
                           if(process[12].completionTime1!=null){
                           var timeToWork =new Date(process[12].completionTime1);
                           var t1 = timeToWork.getFullYear();
                           var t2 = timeToWork.getMonth()+1;
                           var t3 = timeToWork.getDate();
                           $('#completionTime1Stage232').val(t1+'-'+t2+'-'+t3);
                           }
                       
                           $("#uncompletionDescriptionStage232").val(process[12].uncompletionDescription);
                     
                       if(process[12].status==1){
                        document.getElementById('232').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess232()'>正在进行";
                    }else if(process[12].status==2){
                        document.getElementById('232').innerHTML = "已通过";
                        document.getElementById("completionTime1Stage232").disabled=true;
                        document.getElementById("uncompletionDescriptionStage232").disabled=true;
                    }else if(process[12].status==0){
                     	document.getElementById('232').innerHTML ="";
                     	document.getElementById("completionTime1Stage232").disabled=true;
                     	document.getElementById("uncompletionDescriptionStage232").disabled=true;
                    }
                       
                        //Stage233完成情况
                          if(process[13].completionTime1!=null){
                          var timeToWork =new Date(process[13].completionTime1);
                          var t1 = timeToWork.getFullYear();
                          var t2 = timeToWork.getMonth()+1;
                          var t3 = timeToWork.getDate();
                          $('#completionTime1Stage233').val(t1+'-'+t2+'-'+t3);
                          }
                          if(process[13].completionTime2!=null){
                              var timeToWork =new Date(process[13].completionTime2);
                              var t1 = timeToWork.getFullYear();
                              var t2 = timeToWork.getMonth()+1;
                              var t3 = timeToWork.getDate();
                              $('#completionTime2Stage233').val(t1+'-'+t2+'-'+t3);
                              }
                      	$("#completionDescriptionStage233").val(process[13].completionDescription);
                      	$("#uncompletionDescriptionStage233").val(process[13].uncompletionDescription);
                     
                          if(process[13].status==1){
                          	document.getElementById('233').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess233()'>正在进行";
                      	}else if(process[13].status==2){
                      		document.getElementById('233').innerHTML = "已通过";
                      		document.getElementById("completionTime1Stage233").disabled=true;
                      		document.getElementById("completionTime2Stage233").disabled=true;
                    		document.getElementById("completionDescriptionStage233").disabled=true;
                    		document.getElementById("uncompletionDescriptionStage233").disabled=true;
                      	}else if(process[13].status==0){
                      		document.getElementById('233').innerHTML ="";
                      		document.getElementById("completionTime1Stage233").disabled=true;
                      		document.getElementById("completionTime2Stage233").disabled=true;
                    		document.getElementById("completionDescriptionStage233").disabled=true;
                    		document.getElementById("uncompletionDescriptionStage233").disabled=true;
                      	}
                          
                       
                        //Stage234完成情况
                       $("#completionDescriptionStage234").val(process[14].completionDescription);
                       $("#uncompletionDescriptionStage234").val(process[14].uncompletionDescription);
                       
                       if(process[14].status==1){
                         	document.getElementById('234').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess234()'>正在进行";
                     	}else if(process[14].status==2){
                     		document.getElementById('234').innerHTML = "已通过";
                     		document.getElementById("completionDescriptionStage234").disabled=true;
                     		document.getElementById("uncompletionDescriptionStage234").disabled=true;
                     	}else if(process[14].status==0){
                     		document.getElementById('234').innerHTML ="";
                     		document.getElementById("completionDescriptionStage234").disabled=true;
                     		document.getElementById("uncompletionDescriptionStage234").disabled=true;
                     	}
                       
                       //Stage235完成情况
                       $("#completionDescriptionStage235").val(process[15].completionDescription);
                       $("#uncompletionDescriptionStage235").val(process[15].uncompletionDescription);
                       
                       if(process[15].status==1){
                         	document.getElementById('235').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess235()'>正在进行";
                     	}else if(process[15].status==2){
                     		document.getElementById('235').innerHTML = "已通过";
                     		document.getElementById("completionDescriptionStage235").disabled=true;
                     		document.getElementById("uncompletionDescriptionStage235").disabled=true;
                     	}else if(process[15].status==0){
                     		document.getElementById('235').innerHTML ="";
                     		document.getElementById("completionDescriptionStage235").disabled=true;
                     		document.getElementById("uncompletionDescriptionStage235").disabled=true;
                     	}
                    
                     //Stage241完成情况
                       if(process[16].completionTime1!=null){
                       var timeToWork =new Date(process[16].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage241').val(t1+'-'+t2+'-'+t3);
                       }
                  //   $("#completionDescriptionStage241").val(process[13].completionDescription);
                       $("#uncompletionDescriptionStage241").val(process[16].uncompletionDescription);
                  
                       if(process[16].status==1){
                       	document.getElementById('241').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess241()'>正在进行";
                   	}else if(process[16].status==2){
                   		document.getElementById('241').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage241").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage241").disabled=true;
                   	}else if(process[16].status==0){
                   		document.getElementById('241').innerHTML ="";
                   		document.getElementById("completionTime1Stage241").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage241").disabled=true;
                   	}
                       
                     //Stage242完成情况
                       if(process[17].completionTime1!=null){
                       var timeToWork =new Date(process[17].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage242').val(t1+'-'+t2+'-'+t3);
                       }
                       $("#completionDescriptionStage242").val(process[17].completionDescription);
                       $("#uncompletionDescriptionStage242").val(process[17].uncompletionDescription);
                  
                       if(process[17].status==1){
                       	document.getElementById('242').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess242()'>正在进行";
                   	}else if(process[17].status==2){
                   		document.getElementById('242').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage242").disabled=true;
                		document.getElementById("completionDescriptionStage242").disabled=true;
                		document.getElementById("uncompletionDescriptionStage242").disabled=true;
                   	}else if(process[17].status==0){
                   		document.getElementById('242').innerHTML ="";
                   		document.getElementById("completionTime1Stage242").disabled=true;
                		document.getElementById("completionDescriptionStage242").disabled=true;
                		document.getElementById("uncompletionDescriptionStage242").disabled=true;
                   	}
                       
                     //Stage243完成情况
                       if(process[18].completionTime1!=null){
                       var timeToWork =new Date(process[18].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage243').val(t1+'-'+t2+'-'+t3);
                       }
                     
                       $("#uncompletionDescriptionStage243").val(process[18].uncompletionDescription);
                  
                       if(process[18].status==1){
                       	document.getElementById('243').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess243()'>正在进行";
                   	}else if(process[18].status==2){
                   		document.getElementById('243').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage243").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage243").disabled=true;
                   	}else if(process[18].status==0){
                   		document.getElementById('243').innerHTML ="";
                   		document.getElementById("completionTime1Stage243").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage243").disabled=true;
                   	}
                       
                     //Stage25完成情况
                       if(process[19].completionTime1!=null){
                       var timeToWork =new Date(process[19].completionTime1);
                       var t1 = timeToWork.getFullYear();
                       var t2 = timeToWork.getMonth()+1;
                       var t3 = timeToWork.getDate();
                       $('#completionTime1Stage25').val(t1+'-'+t2+'-'+t3);
                       }
                     
                       $("#uncompletionDescriptionStage25").val(process[19].uncompletionDescription);
                  
                       if(process[19].status==1){
                       	document.getElementById('25').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess25()'>正在进行";
                   	}else if(process[19].status==2){
                   		document.getElementById('25').innerHTML = "已通过";
                   		document.getElementById("completionTime1Stage25").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage25").disabled=true;
                   	}else if(process[19].status==0){
                   		document.getElementById('25').innerHTML ="";
                   		document.getElementById("completionTime1Stage25").disabled=true;
                   		document.getElementById("uncompletionDescriptionStage25").disabled=true;
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
   
function updateRudangProcess19() {
	var stageId="51";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage19").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage19").val();//填写内容
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
		document.getElementById('19').innerHTML ="已通过";
		document.getElementById('20').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess20()'>正在进行";
		document.getElementById("completionDescriptionStage19").disabled=true;
		document.getElementById("uncompletionDescriptionStage19").disabled=true;
		document.getElementById("completionTime1Stage20").disabled=false;
		document.getElementById("uncompletionDescriptionStage20").disabled=false;
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

function updateRudangProcess20() {
	var stageId="52";
	var nextStageId="58";
	var completionTime1=$("#completionTime1Stage20").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage20").val();//填写内容
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
		document.getElementById('20').innerHTML ="已通过";
		document.getElementById('213').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess213()'>正在进行";
		document.getElementById("completionTime1Stage20").disabled=true;
		document.getElementById("uncompletionDescriptionStage20").disabled=true;
		document.getElementById("completionTime1Stage213").disabled=false;
		document.getElementById("completionDescriptionStage213").disabled=false;
		document.getElementById("uncompletionDescriptionStage213").disabled=false;
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

function updateRudangProcess211() {
	var stageId="53";
	var nextStageId="53";
	//var completionTime1=$("#completionTime1Stage211").val();//第一个日期
    //var completionTime2=$("#completionTime2Stage211").val();//第二个日期
    //var completionTime3=$("#completionTime3Stage211").val();//第三个日期
    //var completionTime4=$("#completionTime4Stage211").val();//第四个日期
    var completionDescription=$("#completionDescriptionStage211").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage211").val();//填写内容
    $.ajax({
        url : "Process/updateRudangProcess.do",
        type : "post",
        data : {"operId": operId,
                "materialId" : materialId,
                //"completionTime1" : completionTime1,
               // "completionTime2" : completionTime2,
               // "completionTime3" : completionTime3,
               // "completionTime4" : completionTime4,
                "completionDescription" : completionDescription,
                "uncompletionDescription" : uncompletionDescription,
                "stageId" : stageId
            },
        success : function (msg) {
            if(msg.flag){
                $.jBox.tip(msg.msg,'success');
		//document.getElementById('211').innerHTML ="已通过";
		document.getElementById('211').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess211()'>";
		//document.getElementById("completionTime1Stage211").disabled=true;
		//document.getElementById("completionTime2Stage211").disabled=true;
		//document.getElementById("completionTime3Stage211").disabled=true;
		//document.getElementById("completionTime4Stage211").disabled=true;
		//document.getElementById("completionDescriptionStage19").disabled=true;
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

function updateRudangProcess2121() {
	var stageId="54";
	var nextStageId="54";
    var completionDescription=$("#completionDescriptionStage2121").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage2121").val();//填写内容
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
		//document.getElementById('2121').innerHTML ="已通过";
		document.getElementById('2121').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2121()'>";
		//document.getElementById("completionTime1Stage2121").disabled=true;
		//document.getElementById("completionTime2Stage2121").disabled=true;
		//document.getElementById("completionTime3Stage2121").disabled=true;
		//document.getElementById("completionTime4Stage2121").disabled=true;
		//document.getElementById("completionDescriptionStage19").disabled=true;
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
   
function updateRudangProcess2122() {
	var stageId="55";
	var nextStageId="55";
    var completionDescription=$("#completionDescriptionStage2122").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage2122").val();//填写内容
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
		//document.getElementById('2122').innerHTML ="已通过";
		document.getElementById('2122').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2122()'>";
		//document.getElementById("completionTime1Stage2122").disabled=true;
		//document.getElementById("completionTime2Stage2122").disabled=true;
		//document.getElementById("completionTime3Stage2122").disabled=true;
		//document.getElementById("completionTime4Stage2122").disabled=true;
		//document.getElementById("completionDescriptionStage19").disabled=true;
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

function updateRudangProcess2123() {
	var stageId="56";
	var nextStageId="56";
    var completionDescription=$("#completionDescriptionStage2123").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage2123").val();//填写内容
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
		//document.getElementById('2123').innerHTML ="已通过";
		document.getElementById('2123').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2123()'>";
		//document.getElementById("completionTime1Stage2123").disabled=true;
		//document.getElementById("completionTime2Stage2123").disabled=true;
		//document.getElementById("completionTime3Stage2123").disabled=true;
		//document.getElementById("completionTime4Stage2123").disabled=true;
		//document.getElementById("completionDescriptionStage19").disabled=true;
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
      
function updateRudangProcess2124() {
	var stageId="57";
	var nextStageId="57";
    var completionDescription=$("#completionDescriptionStage2124").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage2124").val();//填写内容
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
		//document.getElementById('2124').innerHTML ="已通过";
		document.getElementById('2124').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2124()'>";
		//document.getElementById("completionTime1Stage1").disabled=true;
		//document.getElementById("completionDescriptionStage2124").disabled=true;
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

function updateRudangProcess213() {
	var stageId="58";
	var completionTime1=$("#completionTime1Stage213").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage213").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage213").val();//填写内容
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
		document.getElementById('213').innerHTML ="已通过";
		document.getElementById('221').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess221()'>正在进行";
		document.getElementById("completionTime1Stage213").disabled=true;
		document.getElementById("completionDescriptionStage213").disabled=true;
		document.getElementById("uncompletionDescriptionStage213").disabled=true;
		document.getElementById("completionTime1Stage221").disabled=false;
		document.getElementById("uncompletionDescriptionStage221").disabled=false;
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

function updateRudangProcess221() {
	var stageId="59";
	var completionTime1=$("#completionTime1Stage221").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage221").val();//填写内容
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
		document.getElementById('221').innerHTML ="已通过";
		document.getElementById('222').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess222()'>正在进行";
		document.getElementById("completionTime1Stage221").disabled=true;
		document.getElementById("uncompletionDescriptionStage221").disabled=true;
		document.getElementById("completionDescriptionStage222").disabled=false;
		document.getElementById("uncompletionDescriptionStage222").disabled=false;
		//document.getElementById("completionDescriptionStage213").disabled=true;
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

function updateRudangProcess222() {
	var stageId="60";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage222").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage222").val();//填写内容
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
		document.getElementById('222').innerHTML ="已通过";
		document.getElementById('223').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess223()'>正在进行";
		//document.getElementById("completionTime1Stage221").disabled=true;
		document.getElementById("completionDescriptionStage222").disabled=true;
		document.getElementById("uncompletionDescriptionStage222").disabled=true;
		document.getElementById("completionDescriptionStage223").disabled=false;
		document.getElementById("uncompletionDescriptionStage223").disabled=false;
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

function updateRudangProcess223() {
	var stageId="61";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage223").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage223").val();//填写内容
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
		document.getElementById('223').innerHTML ="已通过";
		document.getElementById('231').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess231()'>正在进行";
		//document.getElementById("completionTime1Stage221").disabled=true;
		document.getElementById("completionDescriptionStage223").disabled=true;
		document.getElementById("uncompletionDescriptionStage223").disabled=true;
		document.getElementById("completionTime1Stage231").disabled=false;
		document.getElementById("completionDescriptionStage2311").disabled=false;
		document.getElementById("completionDescriptionStage2312").disabled=false;
		document.getElementById("completionDescriptionStage2313").disabled=false;
		document.getElementById("uncompletionDescriptionStage231").disabled=false;
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

function updateRudangProcess231() {
	var stageId="62";
	var completionTime1=$("#completionTime1Stage231").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription2311=$("#completionDescriptionStage2311").val();//填写内容
    var completionDescription2312=$("#completionDescriptionStage2312").val();//填写内容
    var completionDescription2313=$("#completionDescriptionStage2313").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage231").val();//填写内容
    var completionDescription=completionDescription2311+"|"+completionDescription2312+"|"+completionDescription2313;
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
		document.getElementById('231').innerHTML ="已通过";
		document.getElementById('232').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess232()'>正在进行";
		document.getElementById("completionTime1Stage231").disabled=true;
		document.getElementById("uncompletionDescriptionStage231").disabled=true;
		document.getElementById("completionDescriptionStage2311").disabled=true;
		document.getElementById("completionDescriptionStage2312").disabled=true;
		document.getElementById("completionDescriptionStage2313").disabled=true;
		document.getElementById("completionTime1Stage232").disabled=false;
		document.getElementById("uncompletionDescriptionStage232").disabled=false;
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

function updateRudangProcess232() {
	var stageId="63";
	var completionTime1=$("#completionTime1Stage232").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage232").val();//填写内容
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
		document.getElementById('232').innerHTML ="已通过";
		document.getElementById('233').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess233()'>正在进行";
		document.getElementById("completionTime1Stage232").disabled=true;
		document.getElementById("uncompletionDescriptionStage232").disabled=true;
		document.getElementById("completionTime1Stage233").disabled=false;
		document.getElementById("completionTime2Stage233").disabled=false;
		document.getElementById("completionDescriptionStage233").disabled=false;
		document.getElementById("uncompletionDescriptionStage233").disabled=false;
		//document.getElementById("completionDescriptionStage232").disabled=true;
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

function updateRudangProcess233() {
	var stageId="64";
	var completionTime1=$("#completionTime1Stage233").val();//第一个日期
    var completionTime2=$("#completionTime2Stage233").val();//第二个日期
    var completionDescription=$("#completionDescriptionStage233").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage233").val();//填写内容
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
		document.getElementById('233').innerHTML ="已通过";
		document.getElementById('234').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess234()'>正在进行";
		document.getElementById("completionTime1Stage233").disabled=true;
		document.getElementById("completionTime2Stage233").disabled=true;
		document.getElementById("completionDescriptionStage233").disabled=true;
		document.getElementById("uncompletionDescriptionStage233").disabled=true;
		document.getElementById("completionDescriptionStage234").disabled=false;
		document.getElementById("uncompletionDescriptionStage234").disabled=false;
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

function updateRudangProcess234() {
	var stageId="65";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage234").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage234").val();//填写内容
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
		document.getElementById('234').innerHTML ="已通过";
		document.getElementById('235').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess235()'>正在进行";
		//document.getElementById("completionTime1Stage234").disabled=true;
		document.getElementById("completionDescriptionStage234").disabled=true;
		document.getElementById("uncompletionDescriptionStage234").disabled=true;
		document.getElementById("completionDescriptionStage235").disabled=false;
		document.getElementById("uncompletionDescriptionStage235").disabled=false;
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



function updateRudangProcess235() {
	var stageId="66";
	var completionTime1="";//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage235").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage235").val();//填写内容
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
		document.getElementById('235').innerHTML ="已通过";
		document.getElementById('241').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess241()'>正在进行";
		//document.getElementById("completionTime1Stage234").disabled=true;
		document.getElementById("completionDescriptionStage235").disabled=true;
		document.getElementById("uncompletionDescriptionStage235").disabled=true;
		document.getElementById("completionTime1Stage241").disabled=false;
		document.getElementById("uncompletionDescriptionStage241").disabled=false;
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

function updateRudangProcess241() {
	var stageId="67";
	var completionTime1=$("#completionTime1Stage241").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage241").val();//填写内容
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
		document.getElementById('241').innerHTML ="已通过";
		document.getElementById('242').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess242()'>正在进行";
		document.getElementById("completionTime1Stage241").disabled=true;
		document.getElementById("uncompletionDescriptionStage241").disabled=true;
		document.getElementById("completionTime1Stage242").disabled=false;
		document.getElementById("completionDescriptionStage242").disabled=false;
		document.getElementById("uncompletionDescriptionStage242").disabled=false;
		//document.getElementById("completionDescriptionStage241").disabled=true;
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

function updateRudangProcess242() {
	var stageId="68";
	var completionTime1=$("#completionTime1Stage242").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription=$("#completionDescriptionStage242").val();//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage242").val();//填写内容
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
		document.getElementById('242').innerHTML ="已通过";
		document.getElementById('243').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess243()'>正在进行";
		document.getElementById("completionTime1Stage242").disabled=true;
		document.getElementById("completionDescriptionStage242").disabled=true;
		document.getElementById("uncompletionDescriptionStage242").disabled=true;
		document.getElementById("completionTime1Stage243").disabled=false;
		document.getElementById("uncompletionDescriptionStage243").disabled=false;
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

function updateRudangProcess243() {
	var stageId="69";
	var completionTime1=$("#completionTime1Stage243").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage243").val();//填写内容
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
		document.getElementById('243').innerHTML ="已通过";
		document.getElementById('25').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess25()'>正在进行";
		document.getElementById("completionTime1Stage243").disabled=true;
		document.getElementById("uncompletionDescriptionStage243").disabled=true;
		document.getElementById("completionTime1Stage25").disabled=false;
		document.getElementById("uncompletionDescriptionStage25").disabled=false;
		//document.getElementById("completionDescriptionStage242").disabled=true;
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

function updateRudangProcess25() {
	var stageId="70";
	var completionTime1=$("#completionTime1Stage25").val();//第一个日期
    var completionTime2="";//第二个日期
    var completionDescription="";//填写内容
    var uncompletionDescription=$("#uncompletionDescriptionStage25").val();//填写内容
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
		document.getElementById('25').innerHTML ="已通过";
		document.getElementById("completionTime1Stage25").disabled=true;
		document.getElementById("uncompletionDescriptionStage25").disabled=true;
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
				        <td rowspan="20">五、预备党员的教育、考察和转正</td>
					    <td colspan="2">19、编入党支部和党小组</td>
					    <td></td>
						<td></td>
						<td>
						   <span><p></p>
						   <select class="textarea"  id="completionDescriptionStage19"   >
						   <option value></option>
						   <option value="完成">完成</option>
						   <option value="未完成">未完成</option>
						   </select>
						   </span>
						</td>
						<td id="19" ></td>
						<td><span><p style="width: auto;">若完成情况未填写，需在此处选择未填写原因，若已填写完成情况，请忽略此步</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage19"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td colspan="2">20、党支部（党总支）组织进行入党宣誓</td>
					    <td></td>
						<td></td>
						<td>
						   <span><p>宣誓时间：</p><input type="text" value="" id="completionTime1Stage20"></span>
						</td>
						<td id="20" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage20"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td rowspan="6">21、党支部（党总支）组织进行入党宣誓</td>
					    <td>21.1 预备党员提交思想汇报</td>
					    <td>每季度一次</td>
						<td rowspan="5">填写入《入党志愿书》</td>
						<td>
						<span>备注栏：（例如：**思想汇报提交时间 ：2013-03-05） <textarea rows="5" cols="30" id="completionDescriptionStage211" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="211" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage211"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>21.2.1 介绍人对预备党员进行考察并填写意见</td>
					    <td>每季度一次</td>
						<td>
						<span>备注栏：（例如：**考察意见提交时间 ：2013-03-05）<textarea rows="5" cols="30" id="completionDescriptionStage2121" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="2121" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage2121"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>21.2.2 党小组对预备党员进行考察并填写意见</td>
					    <td>每季度一次</td>
						<td>
						<span>备注栏：（例如：**考察意见提交时间 ：2013-03-05）<textarea rows="5" cols="30" id="completionDescriptionStage2122" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="2122" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage2122"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>21.2.3 党支部对预备党员进行考察并填写意见</td>
					    <td>每季度一次</td>
						<td>
						<span>备注栏：（例如：**考察意见提交时间 ：2013-03-05）<textarea rows="5" cols="30" id="completionDescriptionStage2123" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="2123" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage2123"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>21.2.4 预备党员提出自我改进措施</td>
					    <td>每季度一次</td>
						<td>
						<span>备注栏：（例如：**考察意见提交时间 ：2013-03-05）<textarea rows="5" cols="30" id="completionDescriptionStage2124" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="2124" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage2124"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>21.3 党支部派人谈话</td>
					    <td>至少一次</td>
					    <td>第五次谈话</td>
						<td>
						   <span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage213"></span>
						   <span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage213"></span>
						</td>
						<td id="213" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage213"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td rowspan="3">22、党支部（党总支）组织进行入党宣誓</td>
					    <td>22.1 本人提交转正申请</td>
					    <td>预备期至少1年；预备期满前一周内</td>
						<td></td>
						<td>
						   <span><p>递交时间：</p><input type="text" value="" id="completionTime1Stage221"></span>
						</td>
						<td id="221" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage221"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>22.2 党小组提出能否按期转正意见</td>
					    <td></td>
					    <td>填写入《入党志愿书》</td>
						<td>
						   <span><p></p>
						   <select class="textarea"  id="completionDescriptionStage222"   >
						   <option value></option>
						   <option value="完成">完成</option>
						   <option value="未完成">未完成</option>
						   </select>
						   </span>
						</td>
						<td id="222" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage222"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>22.3 党支部提出能否按期转正意见</td>
					    <td></td>
					    <td>填写入《入党志愿书》；第4个支委会</td>
						<td>
						   <span><p></p>
						   <select class="textarea"  id="completionDescriptionStage223"   >
						   <option value></option>
						   <option value="完成">完成</option>
						   <option value="未完成">未完成</option>
						   </select>
						   </span>
						</td>
						<td id="223" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage223"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td rowspan="5">23、支部大会讨论</td>
					    <td>23.1 讨论预备党员转正的支部党员大会，对到会人数、赞成人数等要求与讨论接收预备党员的支部党员大会相同。</td>
					    <td></td>
						<td>第2个党员大会</td>
						<td>
						   <span><p style="width: 170px;">支部大会召开时间：</p><input type="text" value="" id="completionTime1Stage231" style="float: none;"></span>
						   <span><p style="width: 120px;">应到会人数：</p><textarea rows="5" cols="30" id="completionDescriptionStage2311" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						   <span><p style="width: 120px;">实到会人数：</p><textarea rows="5" cols="30" id="completionDescriptionStage2312" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						   <span><p style="width: 120px;">无记名投票结果：</p><textarea rows="5" cols="30" id="completionDescriptionStage2313" style="float:none; min-height:auto;width:auto;"  ></textarea></span>
						</td>
						<td id="231" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage231"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>23.2 党总支对支部党员大会通过接收的预备党员进行审议。</td>
					    <td></td>
					    <td>第2个总支委会</td>
						<td>
						   <span><p>审议时间：</p><input type="text" value="" id="completionTime1Stage232"></span>
						</td>
						<td id="232" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage232"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>23.3 大会决议公示且无异议</td>
					    <td>五个工作日</td>
					    <td>第4次公示</td>
						<td>
						   <span><p style="width: 120px;">公示开始时间：</p><input type="text" value="" id="completionTime1Stage233" style="float: none;"></span>
						   <span><p style="width: 120px;">公示结束时间：</p><input type="text" value="" id="completionTime2Stage233" style="float: none;"></span>
						   <span><p style="width: 120px;">公示方式：</p>
						    <select class="textarea"  id="completionDescriptionStage233"   >
						   <option value></option>
						   <option value="邮件">邮件</option>
						   <option value="公示栏">公示栏</option>
						   <option value="其它">其它</option>
						   </select>
						   </span>
						</td>
						<td id="233" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage233"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>23.4 将决议写入入党志愿书
                        <br>主要包括：</br>
                        <br>  预备党员的主要表现；应到会和实到会有表决权的党员人数；表决结果；通过决议的日期；支部书记签名。</br>
                        </td>
					    <td></td>
					    <td></td>
						<td>
						   <span><p></p>
						   <select class="textarea"  id="completionDescriptionStage234"   >
						   <option value></option>
						   <option value="完成">完成</option>
						   <option value="未完成">未完成</option>
						   </select>
						   </span>
						</td>
						<td id="234" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage234"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>23.5 总支将审议意见写入党志愿书</td>
					    <td></td>
					    <td></td>
						<td>
						   <span><p></p>
						   <select class="textarea"  id="completionDescriptionStage235"   >
						   <option value></option>
						   <option value="完成">完成</option>
						   <option value="未完成">未完成</option>
						   </select>
						   </span>
						</td>
						<td id="235" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage235"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td rowspan="3">24、上级党委审批</td>
					    <td>24.1 审批结果及时通知党支部</td>
					    <td></td>
						<td></td>
						<td>
						   <span><p>审批时间：</p><input type="text" value="" id="completionTime1Stage241"></span>
						</td>
						<td id="241" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage241"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>24.2 支部书记同本人谈话</td>
					    <td></td>
					    <td>第5次谈话</td>
						<td>
						   <span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage242"></span>
						   <span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage242"></span>
						</td>
						<td id="242" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage242"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>24.3 审批结果在党员大会上宣布</td>
					    <td></td>
					    <td>第3个党员大会</td>
						<td>
						   <span><p>党员大会时间：</p><input type="text" value="" id="completionTime1Stage243"></span>
						</td>
						<td id="243" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage243"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					<tr>
					    <td>25、材料归档</td>
					    <td>将党员个人材料上报党委</td>
					    <td></td>
					    <td></td>
						<td>
						   <span><p>移交时间：</p><input type="text" value="" id="completionTime1Stage25"></span>
						</td>
						<td id="25" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage25"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					
					
				   
					</tbody>
					
				</table>
				
				<footer  style=margin:20px 0 0 0"">
				    <div id="right" class="rt"  style="float:right;"><a  type="button" onclick="left();"><i class="fa fa-arrow-circle-o-right">上一页</a></i></div>
			    </footer>
				
				<!--分页-->
			</div>

		</div>
	</div>
</div>




</body>
</html>