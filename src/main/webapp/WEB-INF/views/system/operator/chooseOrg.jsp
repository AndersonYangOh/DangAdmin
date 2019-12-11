<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作员你管理 - </title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<body>
	<div class="window no_pd_br_mg_trbl" style="width:570px;padding:5px">
		<input type="hidden" id="orgCode" name="orgCode" value="${orgCode }"/>
		<span>组织机构名称<input id="orgName" name="orgName" type="text" style="width:100px" onblur="Tools.trimVal(this)"></span>
		<span><input class="button5 bor_no c_p" style="padding:0 5px" type="button" onclick="queryData()" value="Search" /></span>
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
		url : 'operator/getOrgList.do',
		fit : true,
		nowrap : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		idField : 'orgCode',
		columns : [ [ {
			field : 'orgCode',
			align : 'left',
			width : 10,
			title : '组织机构编码'
		}, {
			field : 'orgName',
			align : 'left',
			width : 10,
			title : '组织机构名称'
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
		orgName:$('#orgName').val()
	});
}

/**
 * 选择支付方式
 */
var orgCodes = [];
function selectData() {
	var row = dataTable.datagrid('getSelections');
	if(row.length < 1){
		$.messager.alert('提示', '请选择您需要的记录！', 'warning');
		return false;
	}
	var api = frameElement.api, W = api.opener;
	var orgCodeList = W.document.getElementById('orgCodeList');
	
	var html="";
	var id = 0;
	var label = "";
	for(var i=0;i<row.length;i++){
		id = row[i].orgCode;
		label = row[i].orgName;
		
		if(orgCodes[id]) {
			continue;
		} else {
			orgCodes[id] = 1;
		}
		//先移除掉原有值
		$(orgCodeList).html("");
		html += "<span id='o_"+id+"'><a href='javascript:void(0);' onclick=\"delItem('o_','"+id+"');\">×</a>";
		html += label+"<input type='hidden' id='orgCode' name='orgCode' value='"+id+"'/></span>";
		$(orgCodeList).html(html);
		html="";
	}
	//关闭窗口
	api.close();
}
</script>
</html>
