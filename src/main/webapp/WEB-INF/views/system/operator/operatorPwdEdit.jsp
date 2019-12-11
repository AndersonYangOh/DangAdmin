<%@page import="com.chinauicom.research.commons.constant.WcsSessionConstant"%>
<%-- <%@page import="com.chinauicom.research.iotoperation.system.operator.entity.SysOperator"%> --%>
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作员管理 - 修改密码</title>
<%@include file="/commons/pages/common.jsp" %>
<%-- <% --%>
// 	SysOperator user = (SysOperator)session.getAttribute(WcsSessionConstant.SESSION_OPERATOR);
// 	String operId = user == null ? "" : user.getOperId();
// 	pageContext.setAttribute("operId", operId);
<%-- %> --%>
</head>
<body>
<body>
	<form action="" id="pwdForm" name="pwdForm">
		<input type="hidden" id="id" name="id" value="${operId }" />
		<div class="nform" style="width:300px;padding:25px 15px;">
		    <dl>
		      <dt><span>*</span>旧密码：</dt>
		      <dd><input id="oldPwd" name="oldPwd" type="password" style="width:150px" maxlength="12"></dd>
		      <dt><span>*</span>新密码：</dt>
		      <dd><input id="newPwd" name="newPwd" type="password" style="width:150px" maxlength="12"></dd>
		      <dt><span>*</span>确认密码：</dt>
		      <dd><input id="reNewPwd" name="reNewPwd" type="password" style="width:150px" maxlength="12"></dd>
		    </dl>
		    <span style="text-align: center;"><font color="red" size="2">(密码只能由字母、数字、下划线组成)</font></span>
		    <br><br>
		    <div style="text-align:center;">
		    	<input class="button3" type="button" id="addGdsBtn" onclick="savePwd()" value="确认" />
		    </div>
		</div>
	</form>
</body>
<script type="text/javascript">
var api = frameElement.api, W = api.opener;
//保存密码
function savePwd(){
	var oldPwd = $('#oldPwd').val();
	if (null==oldPwd || ''==oldPwd){
		alert('请输入旧密码');
		$('#oldPwd').focus();
		return false;
	}
	var newPwd = $('#newPwd').val();
	if (null==newPwd || ''==newPwd){
		alert('请输入新密码');
		$('#newPwd').focus();
		return false;
	}
	var reNewPwd = $('#reNewPwd').val();
	if (null==reNewPwd || ''==reNewPwd){
		alert('请输入确认密码');
		$('#reNewPwd').focus();
		return false;
	}
	if (reNewPwd!=newPwd){
		alert('两次输入的密码不一致');
		$('#newPwd').val('');
		$('#reNewPwd').val('');
		$('#newPwd').focus();
		return false;
	}
	$.ajax({
        type : 'POST',
        url : 'operator/operatorPwdUpdate.do',
        data : $('#pwdForm').serialize(),
		datatype : 'json',
		async : false,
        success : function(msg) {
        	alert(msg.msg);
        	if (msg.flag){
        		api.close();//关闭窗口
        	}
        }
	});
}
</script>
</html>
