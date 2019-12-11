<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作员管理 - 选择</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<body>
	<div class="window no_pd_br_mg_trbl" style="width:570px;padding:5px">
		<input type="hidden" id="groCodes" name="groCodes" value=""/>
		<span>用户组编码<input id="groCode" name="groCode" type="text" style="width:100px" onblur="Tools.trimVal(this)"></span>
		<span>用户组名称<input id="groName" name="groName" type="text" style="width:100px" onblur="Tools.trimVal(this)"></span>
		<span><input class="button5 bor_no c_p" style="padding:0 5px" type="button" onclick="queryData()" value="查询" /></span>
		<div style="width:550px; height:400px; margin-top:10px;">
			<table id="dataTable" style="width:100%;height:100%;"></table>
		</div>
		<div class="benpart">
			<input class="button5 bor_no c_p" style="padding:0 5px" type="button" id="addGdsBtn" onclick="selectData()" value="确定" />
		</div>
	</div>
</body>
<script type="text/javascript">
var dataTable=null;
$(function() {
	dataTable = $('#dataTable').datagrid( {
		url : 'operator/getUserGroupList.do',
		fit : true,
		nowrap : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		idField : 'groCode',
		columns : [ [ {
			field : 'userGroup',
			checkbox : true
		}, {
			field : 'groCode',
			align : 'left',
			width : 10,
			title : '用户组编码'
		}, {
			field : 'groName',
			align : 'left',
			width : 10,
			title : '用户组编码'
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
		groCode:$('#groCode').val(),
		groName:$('#groName').val()
	});
}

var api = frameElement.api, W = api.opener;
var groCodeList = W.document.getElementById('groCodeList');//用户组
/**
 * 选择用户组
 */
var groCodes = [];
var operGroupArray = [];//已关联的用户组
$(groCodeList).find("span").each(function(item){
	operGroupArray.push({"groCode":$(this).attr("groCode") , "groName":$(this).attr("groName")});
});
function selectData() {
	var row = dataTable.datagrid('getSelections');
	if(row.length < 1){
		alert('请选择您需要的记录！');
		return false;
	}
	
	var operTypeEqualsRoleTypeByUserGroup = true;//操作员类型与角色类型是否一致
	/*判断所选每个用户组所关联的角色类型与该操作员类型是否一致*/
	for(var i=0;i<row.length;i++){
		var groCode = row[i].groCode;
		var groName = row[i].groName;
		
		if(operTypeEqualsRoleTypeByUserGroup){
			$.ajax({
				url : 'operator/validateOperTypeEqualsRoleTypeByUserGroup.do',
				data : 'groCode='+groCode+"&operType=${operType}",
				type : 'POST',
				dataType : 'json',
				async : false,
				success : function(result){
					//如果不为正常,则给予提示,并阻止提交
					if(result.flag != true){
						alert('所选用户组的角色类型与操作员类型不一致！');
						operTypeEqualsRoleTypeByUserGroup = false;
					}
				},error:function(result){
					//如果程序运行不正常,则给予提示,并阻止提交
					alert('服务器出错！');
					operTypeEqualsRoleTypeByUserGroup = false;
				}
			});
		}
	}
	
	if(operTypeEqualsRoleTypeByUserGroup){
		var html="";
		var id = 0;
		var label = "";
		var selectedUserGroupArray = [];
		for(var i=0;i<row.length;i++){
			id = row[i].groCode;
			label = row[i].groName;
			
			if(groCodes[id]) {
				continue;
			} else {
				if(operGroupArray && operGroupArray.length > 0){
					var existsGroup = false;
					for(var j = 0;j < operGroupArray.length;j++){
						if(id == operGroupArray[j]["groCode"]){
							existsGroup = true;
							break;
						}
					}
					if(existsGroup){
						continue;
					}else{
						groCodes[id] = 1;
					}
				}else{
					groCodes[id] = 1;
				}
			}
			operGroupArray.push({"groCode":id , "groName":label});
			html += "<span id='ug_"+id+"' groCode='"+id+"' groName='"+label+"'><a href='javascript:void(0);' onclick=\"delItem('ug_','"+id+"');\">×</a>";
			html += label+"<input type='hidden' id='groCodes' name='groCodes' value='"+id+"'/></span>";
			$(groCodeList).append(html);
			html="";
		}
		//关闭窗口
		api.close();
	}
}
</script>
</html>
