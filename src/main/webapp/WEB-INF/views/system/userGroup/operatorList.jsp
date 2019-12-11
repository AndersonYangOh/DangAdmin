<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Operator Management</title>
<%@include file="/commons/pages/common.jsp"%>
</head>
<body>
	<div class="wrapperbr">
		<div class="wrapper">
			<div class="crumb">
				<a href="sysUserGroup/toUserGroupList.do">权限管理&nbsp;>&nbsp;用户管理&nbsp;>&nbsp;用户组管理</a>><span>操作人搜索</span>
			</div>
			<div class="admin">
				<div class="part_y1"></div>
				<div class="part_y2 fewS">
					<span>登录账号<input id="operId" name="operId" type="text" style="width:100px;" onblur="Tools.trimVal(this)"/></span>
					<span>姓名<input id="operName" name="operName" type="text" style="width:100px;" onblur="Tools.trimVal(this)"/></span>
					<span>状态<select id="status" name="status">
							<option value="">-所有-</option>
							<c:forEach items="${statusHash }" var="state">
								<option value="${state.key }">${state.value }</option>
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
<script type="text/javascript">
//数据加载
var sysOperatorTable=null;
$(document).ready(function() {
	sysOperatorTable=$('#sysOperatorTable').datagrid({
        url : 'sysUserGroup/getOperatorList.do?groCode=${groCode }',
        fit : true,
        nowrap : true,
        fitColumns : true,
        pagination : true,
        rownumbers : true,
        pageSize : 10,
        pageList : [10, 20, 30, 40, 50],
        idField : 'operId',
        columns : [[{
            field : 'operId',
            align : 'center',
            width : 80,
            title : '<span><b>登录账号</b></span>'
        }, {
            field : 'operName',
            align : 'center',
            width : 60,
            title : '<span><b>姓名</b></span>'
        }, {
            field : 'groName',
            align : 'center',
            width : 90,
            title : '<span><b>所属用户组</b></span>',
            formatter: function(value, rowData, rowIndex) {
				if (null != value && value.length>20){
					return "<font title='"+value+"'>"+value.substr(0,20)+"...</font>";
				} else {
					return value;
				}
			}
        }, {
            field : 'orgName',
            align : 'center',
            width : 60,
            title : '<span><b>所属机构</b></span>'
        }, {
            field : 'statusTxt',
            align : 'center',
            width : 30,
            title : '<span><b>状态</b></span>'
        }, {
            field : 'lastLoginTimeTxt',
            align : 'center',
            width : 80,
            title : '<span><b>上一次登录时间</b></span>'
        }, {
            field : 'control',
            align : 'center',
            width : 80,
            title : '<span><b>操作</b></span>',
            formatter : function(value, rowData, rowIndex) {
				return '<a href="operator/toPage.do?operType=detail&operId='+rowData.operId+'&flag=userGroup" class="operButton" title="详情"><img src="resources/easyui13/themes/gray/images/button/btn_detail.gif" alt="详情" /></a>';
            }
        }]],
        onLoadSuccess : function(data) {
            sysOperatorTable.datagrid('clearSelections');
        }
    });
});

//操作员列表查询
function queryData(){
	sysOperatorTable.datagrid('load',{
		operId:$('#operId').val(),
		operName:$('#operName').val(),
		status:$('#status').val()
	});
}
</script>
</html>
