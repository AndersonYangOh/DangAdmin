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
var materialId="1";//页数


function right(){
		var loca = "Process/toRudangProcess.do?materialId=2&operId="+operId;
		window.location.href=loca;
		//document.getElementById('31').innerHTML = "<input type='button' value='通过'  onclick='updateRudangProcess3()'>正在进行";
	}

$(document).ready(function(){
	$( "#completionTime1Stage1" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
	$( "#completionTime1Stage2" ).datepicker({
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
                    //alert(process);
                    //console.log(process);
                    if(process.length>0){
                    	//Stage1完成情况
                    	if(process[0].completionTime1!=null){
                        	var timeToWork =new Date(process[0].completionTime1);
                            var t1 = timeToWork.getFullYear();
                            var t2 = timeToWork.getMonth()+1;
                            var t3 = timeToWork.getDate();
                            $('#completionTime1Stage1').val(t1+'-'+t2+'-'+t3);
                    	}
                    	//$("#completionTime1Stage1").val(process[0].completionTime1);
                    	//$("#completionTime2Stage1").val(process[0].completionTime2);
                    	$("#completionDescriptionStage1").val(process[0].completionDescription);
                    	$("#uncompletionDescriptionStage1").val(process[0].uncompletionDescription);
                        if(process[0].status==1){
                        	document.getElementById('1').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess1()'>正在进行";
                    	}else if(process[0].status==2){
                    		document.getElementById('1').innerHTML = "已通过";
                    		document.getElementById("completionTime1Stage1").disabled=true;
                			document.getElementById("completionDescriptionStage1").disabled=true;
                			document.getElementById("uncompletionDescriptionStage1").disabled=true;
                    	}else if(process[0].status==0){
                    		document.getElementById('1').innerHTML ="";
                    		document.getElementById("completionTime1Stage1").disabled=true;
                			document.getElementById("completionDescriptionStage1").disabled=true;
                			document.getElementById("uncompletionDescriptionStage1").disabled=true;
                    	}
                        
                        //Stage2完成情况
                        if(process[1].completionTime1!=null){
                        	var timeToWork =new Date(process[1].completionTime1);
                            var t1 = timeToWork.getFullYear();
                            var t2 = timeToWork.getMonth()+1;
                            var t3 = timeToWork.getDate();
                            $('#completionTime1Stage2').val(t1+'-'+t2+'-'+t3);
                        }
                    	$("#completionDescriptionStage2").val(process[1].completionDescription);
                    	$("#uncompletionDescriptionStage2").val(process[1].uncompletionDescription);
                   
                        if(process[1].status==1){
                        	document.getElementById('2').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2()'>正在进行";
                    	}else if(process[1].status==2){
                    		document.getElementById('2').innerHTML = "已通过";
                    		document.getElementById("completionTime1Stage2").disabled=true;
                			document.getElementById("completionDescriptionStage2").disabled=true;
                			document.getElementById("uncompletionDescriptionStage2").disabled=true;
                    	}else if(process[1].status==0){
                    		document.getElementById('2').innerHTML ="";
                    		document.getElementById("completionTime1Stage2").disabled=true;
                			document.getElementById("completionDescriptionStage2").disabled=true;
                			document.getElementById("uncompletionDescriptionStage2").disabled=true;
                    	}
                        
                        //Stage3完成情况
                    	$("#completionDescriptionStage3").val(process[2].completionDescription);
                    	$("#uncompletionDescriptionStage3").val(process[2].uncompletionDescription);
                   
                        if(process[2].status==1){
                        	document.getElementById('3').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess3()'>正在进行";
                    	}else if(process[2].status==2){
                    		document.getElementById('3').innerHTML = "已通过";
                			document.getElementById("completionDescriptionStage3").disabled=true;
                			document.getElementById("uncompletionDescriptionStage3").disabled=true;
                    	}else if(process[2].status==0){
                    		document.getElementById('3').innerHTML ="";
                			document.getElementById("completionDescriptionStage3").disabled=true;
                			document.getElementById("uncompletionDescriptionStage3").disabled=true;
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
    
    function updateRudangProcess1() {
		var stageId="1";
		var completionTime1=$("#completionTime1Stage1").val();//第一个日期
        var completionTime2="";//第二个日期
        var completionDescription=$("#completionDescriptionStage1").val();//填写内容
        var uncompletionDescription=$("#uncompletionDescriptionStage1").val();//填写内容
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
			document.getElementById('1').innerHTML ="已通过";
			document.getElementById('2').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess2()'>正在进行";
			document.getElementById("completionTime1Stage1").disabled=true;
			document.getElementById("completionDescriptionStage1").disabled=true;
			document.getElementById("uncompletionDescriptionStage1").disabled=true;
			document.getElementById("completionTime1Stage2").disabled=false;
			document.getElementById("completionDescriptionStage2").disabled=false;
			document.getElementById("uncompletionDescriptionStage2").disabled=false;
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
    
    function updateRudangProcess2() {
		var stageId="2";//"步骤数 你想个地方保存当前行的步骤数 ";
        var completionTime1=$("#completionTime1Stage2").val();//第一个日期
        var completionTime2="";//第二个日期
        var completionDescription=$("#completionDescriptionStage2").val();//填写内容
        var uncompletionDescription=$("#uncompletionDescriptionStage2").val();//填写内容
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
            document.getElementById('2').innerHTML ="已通过";
			document.getElementById('3').innerHTML = "<input type='button' value='通过' onclick='updateRudangProcess3()'>正在进行";
			document.getElementById("completionTime1Stage2").disabled=true;
			document.getElementById("completionDescriptionStage2").disabled=true;
			document.getElementById("uncompletionDescriptionStage2").disabled=true;
			document.getElementById("completionDescriptionStage3").disabled=false;
			document.getElementById("uncompletionDescriptionStage3").disabled=false;
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
    
    function updateRudangProcess3() {
		var stageId="3";//"步骤数 你想个地方保存当前行的步骤数 ";
		var completionTime1="";//第一个日期
	    var completionTime2="";//第二个日期
        var completionDescription=$("#completionDescriptionStage3").val();//填写内容
        var uncompletionDescription=$("#uncompletionDescriptionStage3").val();//填写内容
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
            document.getElementById('3').innerHTML ="已通过";
			//document.getElementById('4').innerHTML = "<input type='button' value='通过'  onclick='updateRudangProcess3()'>正在进行";
			//document.getElementById("completionTime1Stage3").disabled=true;
			document.getElementById("completionDescriptionStage3").disabled=true;
			document.getElementById("uncompletionDescriptionStage3").disabled=true;
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
				
				<table class="table table-primary mt-30" border="1"  style="width:100%;min-width:1000px;" >
				    <thead>  
					<tr>
						<th width="130">党员发展工作阶段</th>
						<th>所需材料</th>
						<th width="60">时间要求</th>
						<th>备注</th>
						<th width="170">完成情况</th>
						<th width="50">状态</th>
						<th width="70">说明</th>					
					</tr>
				    </thead>
				    <tbody class="cl-color">
				   
					<tr>
					    <td rowspan="3">一、申请入党</td>
						<td>1、递交入党申请书</td>
						<td></td>
						<td>本人书写&#44;时间&#58;年月日&#44;不要涂改&#44;入党申请书放入个人档案</td>
						<td>
							<span><p>递交时间：</p><input type="text" value="" id="completionTime1Stage1"></span>
							<span><p>接收人：</p><input type="text" value="" id="completionDescriptionStage1"></textarea></span>
						</td>
						<td id="1"></td>
						<td><span><p style="width: auto;">若完成情况未填写，需在此处选择未填写原因，若已填写完成情况，请忽略此步</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage1"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>2、党组织派人谈话&#40;书记或者副书记或者组织委员&#41;</td>
						<td>收到入党申请书一个月</td>
						<td>书记或组织委员谈&#44;外单位转过来的要重新谈话&#44;一个党委内转不用重新谈&#44;记在谈话本上&#46;对党的认识 入党动机 个人基本情况&#44;成长经历 家庭情况及其他须向组织说明问题&#44;谈完话签字，第1次谈话</td>
						<td>
						    <span><p>谈话人：</p><input type="text" value="" id="completionDescriptionStage2"></textarea></span>
							<span><p>谈话时间：</p><input type="text" value="" id="completionTime1Stage2"></span>
						</td>
						<td id="2" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage2"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					<tr>
					    <td>3、支部建立档案</td>
						<td></td> 
						<td></td>
						<td><span><p></p><textarea rows="5" cols="30" id="completionDescriptionStage3" style="float:none; min-height:auto;width:auto;"></textarea></span></td>
						<td id="3" ></td>
						<td><span><p>同上</p></span>
						<select class="textarea"  id="uncompletionDescriptionStage3"   >
						  <option value></option>
						  <option value="外单位转入">外单位转入</option>
						  <option value="其它">其它</option>
						</select>
						</td>
					</tr>
					</tbody>

				</table>
				<footer style=margin:20px 0 0 0"">
					<div id="right" class="rt" style="float:right;"><a  type="button" onclick="right();"><i class="fa fa-arrow-circle-o-right">下一页</a></i></div>
				</footer>
				<!--分页-->
			</div>

		</div>
	</div>
</div>




</body>
</html>