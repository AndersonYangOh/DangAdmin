<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>User Group Management</title>
<%@include file="/commons/pages/common.jsp"%>
<script type="text/javascript" src="resources/js/system/sysUserGroup.js"></script>
<script>
var SYS_USER_GROUP_UPD = "${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_UPD']}";
var SYS_USER_GROUP_DEL = "${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_DEL']}";
var SYS_USER_GROUP_REC = "${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_REC']}";
var SYS_USER_GROUP_DETAIL = "${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_DETAIL']}";
</script>
</head>
<body>
	<div class="wrapperbr">
		<div class="wrapper">
			<div class="crumb">
				<a href="javascript:void(0)">权限管理&nbsp;>&nbsp;用户管理</a>><span>用户组管理</span>
				<div class="leftben">
				  <c:if test="${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_ADD']}">
					<a href="javascript:void(0)" onclick="operWin('用户组新增','add','')" class="button3" >新增</a>
				  </c:if>
				  <c:if test="${sessionScope.funOperate['SYS_USER_GROUP_SYS_USER_GROUP_DEL']}">
					<a href="javascript:void(0);" class="button2 mg_r" onclick="delConfirm('')">禁用</a>
				  </c:if>
				</div>
			</div>
			<div class="admin">
				<div class="part_y1"></div>
				<div class="part_y2 fewS">
					<span>用户组编码<input id="groCode" name="groCode" type="text" style="width:100px;" onblur="Tools.trimVal(this)"/></span>
					<span>用户组名称<input id="groName" name="groName" type="text" style="width:100px;" onblur="Tools.trimVal(this)"/></span>
					<span>状态<select id="status" name="status">
							<option value="">-所有-</option>
							<c:forEach items="${statusHash }" var="state">
								<option value="${state.key }">${state.value }</option>
							</c:forEach>
						</select>
					</span>
					<span>
						<a href="javascript:void(0);" class="button_search2" onclick="queryData()"></a>
					</span>
				</div>
				<div class="grid_div" style="height:430px;width:100%;">
					<table id="sysUserGroupTable"></table>
				</div>
			</div>
			<div class="fooder"></div>
		</div>
	</div>
</body>
</html>
