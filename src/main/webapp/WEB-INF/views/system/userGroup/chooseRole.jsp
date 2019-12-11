<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>User Role Management - Choose</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<body>
	<div class="window no_pd_br_mg_trbl" style="width:570px;padding:5px">
		<input type="hidden" name="roleCodes" value="${roleCodes }"/>
		<span>角色编码<input id="roleCode" name="roleCode" type="text" style="width:100px" onblur="Tools.trimVal(this)"></span>
		<span>角色名称<input id="roleName" name="roleName" type="text" style="width:100px" onblur="Tools.trimVal(this)"></span>
		<span><input class="button5 bor_no c_p" style="padding:0 5px" type="button" onclick="queryData()" value="搜索" /></span>
		<div style="width:550px; height:400px; margin-top:10px;">
			<table id="dataTable" style="width:100%;height:100%;"></table>
		</div>
		<div class="benpart">
			<input class="button5 bor_no c_p" style="padding:0 5px" type="button" id="addGdsBtn" onclick="selectData()" value="确认" />
		</div>
	</div>
</body>
<script type="text/javascript">
var dataTable=null;
$(function() {
	dataTable = $('#dataTable').datagrid( {
		url : 'sysRole/getRoleList.do?roleCodes=${roleCodes }',
		fit : true,
		nowrap : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		idField : 'roleCode',
		columns : [ [ 
		{
			field : 'role',
			checkbox : true
		}, {
			field : 'roleCode',
			align : 'left',
			width : 10,
			title : '角色编码'
		}, {
			field : 'roleName',
			align : 'left',
			width : 10,
			title : '角色名称'
		}, {
			field : 'roleTypeText',
			align : 'left',
			width : 10,
			title : '角色类型'
		} ] ],
		onLoadSuccess : function(data) {
			dataTable.datagrid('clearSelections');
		}
	});
})

/**
 * 查询函数
 */
function queryData(){
	dataTable.datagrid('load',{
		roleCode:$('#roleCode').val(),
		roleName:$('#roleName').val()
	});
}

var api = frameElement.api, W = api.opener;
var roleCodeSpan = W.document.getElementById('rel_role_span');
/**
 * 选择角色
 */
var roleCodes = [];
var relatedRoles = [];//打开角色选择页面前已经选 中的角色
$(roleCodeSpan).find('input[name="roleCodes"]').each(function(){
	relatedRoles.push({"roleCode":$(this).val() , "roleType":$(this).attr("roleType")});    
});
function selectData() {
	var row = dataTable.datagrid('getSelections');
	if(row.length < 1){
		$.messager.alert('提示信息', '请选择您需要的记录！', 'warning');
		return false;
	}
	
	//1.判断本次选中的角色的角色类型是否一致
	var selectedRoleType;//所选角色类型
	var lastRoleTypeSelected;//第一次选择的角色类型
	for(var i=0;i<row.length;i++){
		if(i == 0){
			lastRoleTypeSelected = row[i].roleType;
		}else{
			if(lastRoleTypeSelected != row[i].roleType){//第一次选择的角色类型与本次所选角色类型
				$.messager.alert('提示信息', '所选角色的角色类型不一致,只能选择同一种角色类型下的角色！', 'warning');
				return false;
			}
		}
	}
	
	//2.再判断本次选择中所有的角色的角色类型与之前已经选中的角色的角色类型是否一致
	if(lastRoleTypeSelected && lastRoleTypeSelected != ""){
		for(var i=0;i<relatedRoles.length;i++){
			if(lastRoleTypeSelected != relatedRoles[i].roleType){//第一次选择的角色类型与本次所选角色类型
				$.messager.alert('提示信息', '所选角色的角色类型与之前已选择角色的角色类型不一致,只能选择同一种角色类型下的角色！', 'warning');
				return false;
			}
		}
	}
	
	var html="";
	var id = 0;
	var label = "";
	var type = "";
	for(var i=0;i<row.length;i++){
		id = row[i].roleCode;
		label = row[i].roleName;
		type = row[i].roleType;
		
		if(roleCodes[id]) {
			continue;
		} else {
			roleCodes[id] = 1;
		}
		html += "<span id='ug_"+id+"' style='color:black;'><a href='javascript:void(0);' onclick=\"delItem('ug_','"+id+"');\">×</a>";
		html += label+"<input type='hidden' name='roleCodes' value='"+id+"' roleType='"+type+"'/></span>&nbsp;&nbsp;";
		$(roleCodeSpan).append(html);
		html="";
	}
	//关闭窗口
	api.close();
}
</script>
</html>
