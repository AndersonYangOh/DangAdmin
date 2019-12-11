<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>操作员管理</title>
<%@include file="/commons/pages/common.jsp"%>
<script type="text/javascript" src="resources/js/system/sysOperator.js"></script>
<script>
var SYS_USER_LIST_UPD = "${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_UPD']}";
var SYS_USER_LIST_DEL = "${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_DEL']}";
var SYS_USER_LIST_REC = "${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_REC']}";
var SYS_USER_LIST_DETAIL = "${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_DETAIL']}";
var SYS_USER_LIST_UPDPASS = "${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_UPDPASS']}";

</script>
</head>
<body>
	<div class="wrapperbr">
		<div class="wrapper">
			<div class="crumb">
				<a href="javascript:void(0)">权限管理&nbsp;>&nbsp;用户管理</a>><span>操作员管理</span>
				<div class="leftben">
				  <c:if test="${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_ADD']}">
					<a href="operator/toPage.do?operType=add" class="button3" >新增</a>
			      </c:if>
			      <c:if test="${sessionScope.funOperate['SYS_USER_LIST_SYS_USER_LIST_DEL']}">
					<a href="javascript:void(0);" class="button2 mg_r" onclick="delConfirm('')">禁用</a>
			      </c:if>
		  		</div>
			</div>
			<div class="admin">
				<div class="part_y1"></div>
				<div class="part_y2 fewS">
					<span>登录账号<input type="text" id="operId" name="operId" style="width:100px;" onblur="Tools.trimVal(this)"/></span>
					<span>姓名<input type="text" id="operName" name="operName" style="width:100px;" onblur="Tools.trimVal(this)"/></span> 
					<span>状态<select id="status" name="status">
							<option value="">-所有-</option>
							<c:forEach items="${statusHash }" var="state">
								<option value="${state.key}">${state.value}</option>
							</c:forEach>
						</select>
					</span>
					<span>所属组织机构<select id="orgCode" name="orgCode" style="width:100px;">
							<option value="">-所有-</option>
							<c:forEach items="${sysOrgArray}" var="org">
								<option value="${org.orgCode}">${org.orgName}</option>
							</c:forEach>
						</select>
					</span>
					<span>用户组<select id="groCode" name="groCode" style="width:100px;">
							<option value="">-所有-</option>
							<c:forEach items="${sysUserGroArray}" var="sysUserGro">
								<option value="${sysUserGro.groCode}">${sysUserGro.groName}</option>
							</c:forEach>
						</select>
					</span>
					<span><a href="javascript:void(0);" class="button_search2" onclick="queryData()"></a></span>
				</div>
				<div class="grid_div" style="height:430px;width:100%;">
					<table id="sysOperatorTable"></table>
				</div>
			</div>
			<div class="fooder"></div>
		</div>
	</div>
</body>
</html>
