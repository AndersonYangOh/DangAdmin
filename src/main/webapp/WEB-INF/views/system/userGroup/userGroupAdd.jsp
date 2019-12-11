<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>User Role Management- New</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<div class="window no_pd_br_mg_trbl" style="width:570px;">
	<form action="" id="form1" name="form1" method="post">
		<input type="hidden" name="type" id="type" value="add"/>
	  	<div class="win_tree7 otherWin7" style="height:380px;">
	    	<ul class="text3part1">
	        	<li>
	            	<div class="lt"><span>*</span>用户组编码：</div>
	                <div class="rt">
	                	<input class="input" id="groCode" name="groCode" type="text" value="" maxlength="30" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')">
	                	<span>(请输入字母、数字和下划线)</span>
	                </div>
	            </li>
	            <li>
	            	<div class="lt"><span>*</span>用户组名称：</div>
	                <div class="rt"><input class="input" id="groName" name="groName" type="text" value="" maxlength="64" onblur="clearSpace(this)"></div>
	            </li>
	            <li>
	            	<div class="lt"><span>*</span>状态：</div>
	                <div class="rt">
	                	<select id="status" name="status">
	                		<option value="">请选择...</option>
	                		<c:forEach items="${statusHash }" var="state">
	                			<option value="${state.key }">${state.value }</option>
	                		</c:forEach>
	                	</select>
	                </div>
	            </li>
	            <li>
	            	<div class="lt">关联角色：</div>
	                <div class="rt">
	               		<input type="button" id="addChanBtn" value="选择角色" onclick="openWin('选择角色', 'role')" />
	                </div>
	            </li>
	            <li>
	            	<div class="lt">&nbsp;</div>
	                <div class="rt">
	               		<span id="rel_role_span"></span>
	                </div>
	            </li>
	            <li>
	            	<div class="lt">备注：</div>
	                <div class="rt"><textarea id="groDesc" name="groDesc" cols="30" rows="5" maxlength="200"></textarea></div>
	            </li>
	        </ul>
	   </div>
	</form>
	<div class="benpart">
		<a href="javascript:void(0);" class="button3" onClick="doSubmit();">保存</a>
		<a href="javascript:void(0);" class="button2" onClick="closeWin();">关闭</a>
	</div>
</div> 
<script type="text/javascript">
var api = frameElement.api, W = api.opener;
function doSubmit() {
	var groCode = $('#groCode').val();
	if (null==groCode || groCode==''){
		alert('用户组编码不能为空');
		$('#groCode').focus();
		return;
	}
	var groName = $('#groName').val();
	if (null==groName || groName==''){
		alert('用户组名称不能为空');
		$('#groName').focus();
		return;
	}
	if (null!=groName || groName!=''){
		if(!checkGroName(groName))
		return;
	} 
	var status = $("#status").val();
	if (null==status || status==''){
		alert('请选择用户组状态');
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'sysUserGroup/userGroupSaveOrUpdate.do',
		data : $('#form1').serialize(),
		datatype : 'json',
		async : false,
		success : function(msg) {
			var flag = msg.flag;
			$.dialog({
				content:msg.msg,
				parent:api,
		    	zIndex: 1985,
			    ok: function(){
			    	if (flag){//新增成功
			       		api.reload(W);
			       	}
			    },
			    lock:true
			});
		}
	});
}
function closeWin() {
	api.close();
}

	
/**
 * 弹出新窗口
 * @param title 弹出层标题
 * @param operType 操作类型
 */
function openWin(title, operType) {
	var roleArr =[];//记录已选择的数据
	$('input[name="roleCodes"]').each(function(){
		roleArr.push($(this).val());    
	});

	var params = "?operType="+operType+"&roleCodes="+(roleArr.join(","));
	var url = "url:sysUserGroup/toPage.do" + params;
	$.dialog({
		title: title,
		zIndex:2000,
		parent:api,
		lock: true,
		drag: false,
   		resize: false,
	    width: '580px',
	    height: '490px',
	    content: url
	});
}

/**
 * 删除元素
 */
function delItem(pre, id) {
	$("#"+pre+id).remove();
}
//验证名称不重复
function checkGroName(groName){
	var state = false;
	$.ajax({
			type : 'POST',
			url :'sysUserGroup/checkGroName.do',
			data : {groName:  groName},
			async:false,
			datatype : 'json',
			success : function(msg) {
				if(!msg.flag){
					alert("该名称已存在");
					state=false;
				}else{
				    state=true;
				}
				
			}
		});
	return state;
}
</script>
</body>
</html>
