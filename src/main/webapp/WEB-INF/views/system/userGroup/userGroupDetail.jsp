<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>User Group Management - Detail</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<div class="window no_pd_br_mg_trbl" style="width:570px;">
	<form action="" name="form1" method="post">
	  	<div class="win_tree7 otherWin7" style="height:380px;">
	    	<ul class="text3part1">
	        	<li>
	            	<div class="lt"><span>*</span>用户组编码：</div>
	                <div class="rt"><input class="input" id="groCode" name="groCode" type="text" disabled="disabled" value="${userGroup.groCode }"></div>
	            </li>
	            <li>
	            	<div class="lt"><span>*</span>用户组名称：</div>
	                <div class="rt"><input class="input" id="groName" name="groName" type="text" disabled="disabled" value="${userGroup.groName }"></div>
	            </li>
	            <li>
	            	<div class="lt"><span>*</span>状态：</div>
	                <div class="rt"><input class="input" id="status" name="status" type="text" disabled="disabled" value="${userGroup.statusTxt }"></div>
	            </li>
	            <li>
	            	<div class="lt">关联角色：</div>
	            	<div class="rt">
	            		<c:if test="${userGroupRoleArray ne null }">
	            			<c:forEach items="${userGroupRoleArray }" var="arr">
	            				${arr.roleName }&nbsp;&nbsp;&nbsp;
	            			</c:forEach>
	            		</c:if>
	            	</div>
	            </li>
	            <li>
	            	<div class="lt">备注：</div>
	                <div class="rt"><textarea id="groDesc" name="groDesc" disabled="disabled" rows="4" cols="30">${userGroup.groDesc }</textarea></div>
	            </li>
	        </ul>
	   </div>
	</form>
	<div class="benpart">
		<a href="javascript:void(0);" class="button2" onClick="closeWin();">关闭</a>
	</div>
</div> 
<script type="text/javascript">
 	function closeWin() {
 		var api = frameElement.api;
		api.close();
 	}
</script>
</body>
</html>
