<%@ page language="java" pageEncoding="utf-8"%>
<%@page import=" com.chinauicom.research.commons.constant.CommonModuleConstant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作员管理 - 新增</title>
<%@include file="/commons/pages/common.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
<script type="text/javascript" src="resources/zTree_v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
var channelDG=null;
$(function() {
	$('#channelLi').hide();
	//加载渠道树数据
	$.ajax({
        type : 'POST',
        url : 'channel/getChannelTree.do',
        datatype : 'text',
        success : function(result) {
            $.fn.zTree.init($("#channelTree"), {
                check : {
                    enable : true,
                    chkStyle : "radio",
                    radioType : "all"
                },
                view : {
                    dblClickExpand : false
                },
                data : {
                    simpleData : {
                        enable : true
                    }
                },
                callback : {
                    onClick : onClickChannel,
                    onCheck : onCheckChannel
                }
            }, result);
        }
    });

	//det_channelId文本框点击事件,channelId元素赋值为所选渠道编号,det_channelId为渠道名称
    $("#det_channelId").click(function(){
        var module = "<%=CommonModuleConstant.moduleCode_operator%>";
    	var url = "url:channelSelection/gotoChannelListPage.do?singleSelect=1&module="+module;//渠道选择公共组件(单选)
	    $.dialog({
	      title:"选择渠道",
	      min:false,
	      max:false,
	      zIndex:2000,
	      lock: true,
	      drag: false,
	        resize: false,
	        content: url
	    });
    });
});

//渠道选择对话框对应的回调函数(单选)
function selectChannelBySelections(channelSelections){
	if(null!=channelSelections && channelSelections.length>0){
		$('#channelId').val(channelSelections[0]['channelId']);
		$('#det_channelId').val(channelSelections[0]['channelName']);
	}
}

function onClickChannel(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("channelTree");
    zTree.checkNode(treeNode, !treeNode.checked, null, true);
    return false;
}
function onCheckChannel(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("channelTree"), nodes = zTree.getCheckedNodes(true), v = "", id = "";
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i].name + ",";
        id += nodes[i].id + ",";
    }
    if (v.length > 0)
        v = v.substring(0, v.length - 1);
    if (id.length > 0)
        id = id.substring(0, id.length - 1);
    $("#det_channelId").val(v);
    $("#channelId").val(id);
}
function showMenu(arg1, arg2) {
    var cityObj = $("#"+arg1);
    var cityOffset = $("#"+arg1).offset();
    $("#"+arg2).slideDown("fast");
    $("body").bind("mousedown", function(event) {
        onBodyDown(arg1, arg2, event)
    });
}
function hideMenu(div1, div2) {
    $("#" + div2).fadeOut("fast");
    $("body").unbind("mousedown", function(event) {
        onBodyDown(div1, div2, event)
    });
}
function onBodyDown(div1, div2, event) {
    if (! (event.target.id == "menuBtn" || event.target.id == div1 || event.target.id == div2 || $(event.target).parents("#" + div2).length > 0)) {
        hideMenu(div1, div2);
    }
}

//////////////////////////////////////////////////////
/**
 * 操作员类型选择值变化
 */
function changeVal(obj){
	var operChannelType = $('#operChannelType').val();
	if (obj==operChannelType){
		$('#channel_li').show();
		//$('#channelLi').removeClass('he1').addClass('he2').slideToggle('slow');
		
		/*channelDG=$("#channelDG").datagrid({
			url : 'channel/getChannelList.do?channelTypeId='+$('#channelTypeId').val()+'&channelGrade='+$('#channelGrade').val()+'&channelName='+$('#channelName').val()+'&channelAccount='+$('#channelAccount').val(),
			fit : true,
			nowrap : true,
			singleSelect:true,
			fitColumns : true,
			pagination : true,
			rownumbers : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			idField : "channelId",
			columns : [ [ 
			{
				field : "channelId",
				checkbox:true
			}, {
				field : "channelName",
				align : "left",
				width : 20,
				title : "渠道名称"
			},{
				field : "channelTypeName",
				align : "left",
				width : 15,
				title : "渠道类型"
			} ] ],
			onLoadSuccess: function (data) {
				channelDG.datagrid('clearSelections'); 
			},
			onSelect:function(rowIndex, rowData){
				$('#channelId').val(rowData.channelId);
				$('#det_channelId').val(rowData.channelName);
			}
		});*/
		
	} else {
		$('#channelId').val('');
		$('#det_channelId').val('');
		$('#channel_li').hide();
		//$('#channelLi').removeClass('he2').addClass('he1').slideToggle('slow');
	}
}

//////////////////////////////////////////////////////
//请求提交
function doSubmit() {
	var operId = $('#operId').val();
	if (operId == '') {
		$.dialog.alert('登录账号不能为空');
		return;
	}
	var pwd = $('#operPwd').val();
	if (pwd == '') {
		$.dialog.alert('密码不能为空');
		return;
	}
	var operName = $('#operName').val();
	if (operName == '') {
		$.dialog.alert('姓名不能为空');
		return;
	}
	var operType = $('#operType').val();
	if (operType==''){
		$.dialog.alert('用户类型不能为空');
		return;
	} else {
		var operChannelType = $('#operChannelType').val();
		if (operType==operChannelType) {
			var channel=$('#channelId').val();
			if (channel==''){
				$.dialog.alert('所属渠道不能为空');
				return;
			}
		}
	}
	var status = $('#status').val();
	if (status==''){
		$.dialog.alert('状态不能为空');
		return;
	}
	var mobile = $('#mobile').val();
	if(mobile.length != 10 && mobile.length>0){
		$.dialog.alert('联系电话字符长度不能小于10');
		return;
	}
	var orgCode = $('#orgCode').val();
	if (!orgCode || orgCode==''){
		$.dialog.alert('所属组织机构不能为空');
		return;
	}
	//提交
	$.ajax({
		type: "POST",
		url: "operator/checkOperatorIsExists.do",
		data: "operId="+operId,
		datatype: "json",
		async : false,
		success: function(data){
			if (data.flag) {
				//保存信息
				$.ajax({
					type : "POST",
					url : "operator/addOrModOperator.do",
					data : $("#form1").serialize(),
					datatype : "json",
					async : false,
					success : function(msg) {
						$.dialog({
							content : msg.msg,
							ok : function() {
								location.href="<%=basePath%>operator/sysOperatorIndex.do";
							},
							lock : true
						});
					}
				});
			} else {
				$.dialog.alert(data.msg);
			}
		}
	});
}

/**
 * 弹出新窗口
 * @param title 窗口标题
 * @param operType 操作类型
 * @param code 操作员编码
 */
function operWin(title, operType) {
	var operTypeValue = $("#operType").val();
	if(!operTypeValue || operTypeValue == ''){
		alert("请选择操作员类型!");
		return false;
	}
	var params = "?operType=" + operType + "&operTypeValue=" + operTypeValue;
	$.dialog({
		title: title,
		lock: true,
		drag: false,
		resize: false,
	    width: 'auto',
	    height: 'auto',
	    content: "url:operator/toShowPage.do" + params
	});
}

/**
 * 删除元素
 */
function delItem(pre, id) {
	$("#"+pre+id).remove();
}

function queryChannel(){
	channelDG.datagrid('options').url='channel/getChannelList.do?channelTypeId='+$('#channelTypeId').val()+'&channelGrade='+$('#channelGrade').val()+'&channelName='+$('#channelName').val()+'&channelAccount='+$('#channelAccount').val();
	channelDG.datagrid('reload');
}

function hideChannelDG(){
	$('#channelLi').slideToggle('slow');
	if('打开'==$('#channelBtn').text()){
		$('#channelBtn').text('关闭');
	}else{
		$('#channelBtn').text('打开');
	}
}
</script>
</head>
<body>
	<div class="wrapperbr">
		<div class="wrapper">
			<div class="crumb">
				<a href="operator/sysOperatorIndex.do">权限管理&nbsp;>&nbsp;用户管理&nbsp;>&nbsp;操作员管理</a>><span>添加操作员</span>
			</div>
			<div class="conttext1 pForm">
				<form id="form1" name="form1" action="" method="post">
					<input type="hidden" name="type" id="type" value="add">
					<div class="title"><strong>新增操作员</strong></div>
					<ul>
				    	<li>
				        	<div class="leftt"><span style="color:red">* </span>登录账户：</div>
				        	<div class="rightt">
				        		<input name="operId" id="operId" type="text" maxlength="30" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
				        		<span style="color:red">(请输入字符，数字，下划线)</span>
				        	</div>
				        </li>
				    	<li>
				        	<div class="leftt"><span style="color:red">* </span>密码：</div>
				        	<div class="rightt"><input id="operPwd" name="operPwd" type="password" maxlength="12"/></div>
				        </li>
				    </ul>
					<ul>
				        <li>
				        	<div class="leftt"><span style="color:red">* </span>姓名：</div>
				            <div class="rightt"><input name="operName" id="operName" type="text" maxlength="15" onblur="clearSpace(this)"/></div>        	
				        </li>
				        <li>
				        	<div class="leftt"><span style="color:red">* </span>操作员类型：</div>
				        	<div class="rightt">
				        		<select name="operType" id="operType" onchange="changeVal(this.value)">
									<option value="">请选择...</option>
									<c:forEach items="${operTypeMap }" var="oper_type">
										<option value="${oper_type.key }">${oper_type.value }</option>
									</c:forEach>
								</select>
							</div>
				        </li>
				        <li id="channel_li" style="display:none;">
				       		<div class="leftt"><span style="color:red">* </span>所属渠道：</div>
				        	<div class="rightt">
				        		<input type="hidden" id="operChannelType" name="operChannelType" value="${operChannelType }"/>
					        	<input type="hidden" id="channelId" name="channelId" value="" />
					            <!-- <input type="text" id="det_channelId" readonly="readonly" onclick="showMenu('det_channelId','channelContent')" value="" /> -->
					            <input type="text" id="det_channelId" readonly="readonly"  value="" />
					            <!-- <div id="channelContent" class="menuContent" style="display:none;position:absolute;left:145px;width:405px;">
					                <ul id="channelTree" class="ztree" style="margin-top:0;height:200px;background:#f0f6e4;overflow:auto;border:1px dotted #999;"></ul>
					            </div> -->
					            <!-- <a onclick="hideChannelDG()" href="javascript:void(0);" class="button3" id="channelBtn">关闭</a> -->
				            </div>
				        </li>
				        
				        <li class="fl ovf_h he1 " id="channelLi"  >
			        	<div class="leftt"></div>
			        	<div class="rightt3">
				<%-- 
							 <div class="textpart5">
			      <strong>渠道类型：</strong>
			      <strong><select id="channelTypeId" name="channelTypeId" class="inputselect va_middleSelect w120" style="top:-2px">
			        <option value="">所有</option>
			        <c:forEach items="${chlChannelTypeList}" var="chlChannelType">
			          <option value="${chlChannelType.channelTypeId}">${chlChannelType.channelTypeName}</option>
			        </c:forEach>
			      </select></strong>
			      <strong class="mg_l w60">级别：</strong>
			      <strong><select id="channelGrade" name="channelGrade" class="inputselect va_middleSelect w120" style="top:-2px">
			        <option value="">所有</option>
			        <c:forEach items="${WCS_CHANNEL_GRADE_MAP}" var="channelGrade">
			          <option value="${channelGrade.key}">${channelGrade.value}</option>
			        </c:forEach>
			      </select></strong>
			    </div>
			    <div class="textpart5" style="margin-top: 5px;">
			      <strong>渠道名称：</strong>
			      <strong><input id="channelName" name="channelName" type="text" style="width: 120px;" class="inputclass va_middleInput w120"></strong>
			      <strong  class="mg_l w60">账号：</strong>
			      <strong><input id="channelAccount" name="channelAccount" type="text" style="width: 120px;" class="inputclass va_middleInput w120"></strong>
			    </div>
			    <div class="textpart5" style="margin-top: 5px;">
			      <span ><a href="javascript:void(0);" id="btn_search"  onclick="queryChannel();" class="va_middleBen button_search2"></a></span>
			     	<!-- 跨页全选<input type="checkbox" id="checkAllChannel"  name="checkAllChannel" /> -->
			    </div>
			  				
			  				
			  				<div class="tx2" style="height: 405px;">
			  				<table style="width: 400px;" class="tableStyle2 txa_c" id="channelDG"></table></div>
						<!-- 	<div class="tx3"><a onclick="hideChannelDG()" href="javascript:void(0);" class="button3">确定</a></div> -->
			            </div> --%>
			        </li>
				        
				        <li>
				        	<div class="leftt"><span style="color:red">* </span>状态：</div>
				        	<div class="rightt">
				        		<select name="status" id="status">
									<option value="">请选择...</option>
									<c:forEach items="${statusHash }" var="state">
										<option value="${state.key }">${state.value }</option>
									</c:forEach>
								</select>
							</div>
				        </li>
				        <li>
				        	<div class="leftt">性别：</div>
				        	<div class="rightt">
				        		<select name="sex" id="sex">
									<option value="">请选择...</option>
									<c:forEach items="${sexMap }" var="_sex">
										<option value="${_sex.key }">${_sex.value }</option>
									</c:forEach>
								</select>
							</div>
				        </li>
				        <li>
				        	<div class="leftt"><span style="color:red">* </span>是否是工号：</div>
				        	<div class="rightt">
				        		<select name="isEmployee" id="isEmployee">
									<c:forEach items="${IS_EMPLOYEE }" var="_is">
										<option value="${_is.key }">${_is.value }</option>
									</c:forEach>
								</select>
							</div>
				        </li>
				        <li>
				        	<div class="leftt">固定电话：</div>
				        	<div class="rightt"><input name="telephone" id="telephone" type="text" maxlength="15" onkeyup="onlyNum(this)"/></div>
				        </li>
				        <li>
				        	<div class="leftt">联系电话：</div>
				        	<div class="rightt"><input name="mobile" id="mobile" type="text" value="" maxlength="15" onkeyup="onlyNum(this)"></div>
				        </li>
				        <li>
				        	<div class="leftt">联系邮箱：</div>
				        	<div class="rightt"><input name="email" id="email" type="text" maxlength="150"/></div>
				        </li>
				        <li>
				        	<div class="leftt">详细地址：</div>
				        	<div class="rightt"><input name="address" id="address" type="text" maxlength="100"/></div>
				        </li>
				        <li>
				        	<div class="leftt">描述：</div>
				        	<div class="rightt"><textarea id="operDesc" name="operDesc" rows="4" cols="30" maxlength="200"></textarea></div>
				        </li>
				   </ul>
				   <ul>   
			        	<li>
			        		<div class="leftt"><span style="color:red">* </span>所属组织机构：</div>
			        		<div class="rightt">
			        			<span class="buttoner3"><a href="javascript:void(0)" class="button3" onclick="operWin('组织机构设置','org')">设置</a></span>
			        			<span id="orgCodeList"></span>
			        		</div>
			        	</li>
			        	<li>
			        		<div class="leftt">所属用户组：</div>
			        		<div class="rightt">
			        			<span class="buttoner3"><a href="javascript:void(0)" class="button3" onclick="operWin('用户组设置','userGroup')">设置</a></span>
			        			<span id="groCodeList"></span>
			        		</div>
			        	</li>
			    	</ul>
				</form>
			</div>
			<div class="contben">
				<div class="text">
					<a href="javascript:void(0);" onclick="doSubmit()" class="button3" id="operBtn">保存</a>&nbsp;&nbsp;
					<a href="operator/sysOperatorIndex.do" class="button3" id="operBtn">返回</a>
				</div>
			</div>
			<div class="fooder"></div>
		</div>
	</div>
</body>
</html>

