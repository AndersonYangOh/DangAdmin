<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path1 = request.getContextPath();
	String basePath1 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>菜单管理页-中国联通研究院大数据运营后台管理系统</title>
<base href="<%=basePath1 %>" />
<!--[if lt IE 9]>
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="js/kkpager/kkpager_blue.css">
<link rel="stylesheet" href="js/jbox/jbox.css">
<link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validate/additional-methods.min.js"></script>
<script type="text/javascript" src="js/validate/messages_zh.js"></script>
<script type="text/javascript" src="js/kkpager/kkpager.min.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="resources/js/system/menu.js"></script>
<script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>

	<!--[if IE 6]>
<script type="text/javascript" src="Lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('.pngfix,.icon');</script>
<![endif]-->

<script type="text/javascript">
	var totalPage;
	var totalRecords;
	var pageNo = 1;
	var param = {};
	$(function(){
		getMenuList();
	});
	//切换页码获取数据
	function changPage(){
		pageNo = $(".curr").text()==undefined||$(".curr").text()==""?1:$(".curr").text();
		getMenuList();
	}
	function getMenuList(type,menuCode) {
		if (type=="1"){
			pageNo=1;
		}
		var menuName=$("#menuName").val().trim();
		$.ajax({
			url : "sysMenu/getMenuList.do",
			data : {"menuName" : menuName,
					"menuCode" : menuCode,
					"pageNo" : pageNo},
			type : "post",
			dataType : "json",
			success: function (result) {
				var html="";
				$("#menuList").html("");
				var list=result.objects;
				var menuName;
				var menuCode;
				var parentMenuName;
				var menuUri;
				for (var i in list){
					menuName = (null==list[i].menuName?"":list[i].menuName);
					menuCode = (null==list[i].menuCode?"":list[i].menuCode);
					parentMenuName=(null==list[i].parentMenuName?"":list[i].parentMenuName);
					menuUri=(null==list[i].menuUri?"":list[i].menuUri);
					html += "<tr>";
					html += "<td>"+menuName+"</td>";
					html += "<td>"+menuCode+"</td>";
					html += "<td>"+parentMenuName+"</td>";
					html += "<td>"+menuUri+"</td>";
					html += '<td>'+
								'<c:if test="${sessionScope.funOperate[\'SYS_MENU_CHECK\'] }">'+
								'<a class="btn btn-op" data-toggle="modal" href="#Modal-edit" title="查看" onclick="menuDeatil(\''+list[i].menuCode+'\',\'0\')"><i class="fa fa-search"></i></a>'+
								'</c:if>'+
								'<c:if test="${sessionScope.funOperate[\'SYS_MENU_UPDATE\'] }">'+
								'<a class="btn btn-op" data-toggle="modal" href="sysMenu/menuAdd.do?operType=0&menuCode='+list[i].menuCode+'" title="修改"><i class="fa fa-edit"></i></a>'+
								'</c:if>'+
								'</td>';
					html += "</tr>";
				}
				$("#menuList").html(html);
				totalPage = result.totalPage;
				totalRecords = result.totalNumber;
				pageNo = result.currentPage;
				toPage();
			},
			error : function () {
				$.jBox.error('查询菜单列表失败!', '提示');
				return false;
			}
		});
	}
	function menuDeatil(menuCode,type) {
		if (type=="0"){
			$("#divHid").hide();
			$("#menuCode").prop("disabled","disabled");
			$("#menEditName").prop("disabled","disabled");
			$("#parentCode").prop("disabled","disabled");
			$("#menuUrl").prop("disabled","disabled");
			$("#reOrder").prop("disabled","disabled");
			$("#reMark").prop("disabled","disabled");
		}else {
			$("#divHid").show();
			$("#menuCode").prop("disabled","disabled");
			$("#menEditName").removeAttr("disabled");
			$("#parentCode").removeAttr("disabled");
			$("#menuUrl").removeAttr("disabled");
			$("#reOrder").removeAttr("disabled");
			$("#reMark").removeAttr("disabled");
		}
		$.ajax({
			url : "sysMenu/getMenuDeatil.do",
			type : "post",
			data : {"menuCode" : menuCode},
			dataType : 'json',
			success :function (data) {
				var list=data.menus;
				$("#menuCode").val(list[0].menuCode);
				$("#menEditName").val(list[0].menuName);
				//$("#parentCode").val(list[0].parentMenuName);
				$("#parentCode option[value="+list[0].parentMenuCode+"]").prop("selected","selected");
				$("#menuUrl").val(list[0].menuUri);
				$("#reOrder").val(list[0].reorder);
				$("#reMark").val(list[0].remark);
			},
			error : function () {
				
			}
		});
	}

	function toPage(){
		//alert("总页数"+totalPage+"-总数据"+totalRecords+"-当前页"+pageNo);
		kkpager.total = totalPage;
		kkpager.totalRecords = totalRecords;
		kkpager.pno = pageNo;
		kkpager.hasPrv = (kkpager.pno > 1)
		kkpager.hasNext = (kkpager.pno < kkpager.total);
		kkpager.generPageHtml({
			pno : pageNo,
			mode : 'click',
			total : totalPage,
			totalRecords : totalRecords,
			click : function(n){
				this.selectPage(n);
				changPage();
				return false;
			},
			getHref : function(n){
				return "javascript:void(0)";
			}
		},true);
	}
	
	function updataMenu() {
		var menuCode=$("#menuCode").val();
		var menuName=$("#menEditName").val();
		var parentCode=$("#parentCode").val();
		var menuUrl=$("#menuUrl").val();
		var reorder=$("#reOrder").val();
		var remark=$("#reMark").val();
		if(null ==menuCode || ""==menuCode){ $("#codeTip").show();return false;}
		if(null ==menuName || ""==menuName){ $("#nameTip").show();return false;}
		if(null ==menuUrl || ""==menuUrl){ $("#urlTip").show();return false;}
		$.ajax({
			url : "sysMenu/insertMenu.do",
			type : "post",
			data : {"menuCode" : menuCode,
				"menuName" : menuName,
				"parentCode" : parentCode,
				"menuUrl" : menuUrl,
				"reorder" : reorder,
				"remark" : remark,
				"type" : "1"
			},
			dataType : "json",
			success : function (data) {
				if(data.success==true){
					$(".modal-scrollable,.modal-backdrop").hide();
					alert("修改成功！");
					getMenuList();
				}else {
					alert("修改失败！");
					return false;
				}
			},
			error : function () {
				alert("修改失败！");
				return false;
			}
		});
	}
	
	function changeTip() {
		var menuCode=$("#menuCode").val();
		var menuName=$("#menEditName").val();
		var menuUrl=$("#menuUrl").val();
		if(null !=menuCode || ""!=menuCode){ $("#codeTip").hide();}
		if(null !=menuName || ""!=menuName){ $("#nameTip").hide();}
		if(null !=menuUrl || ""!=menuUrl){ $("#urlTip").hide();}
	}
</script>
</head>

<body>
<!-------------------------CONT---------------------------->
<div class="List-cont box-cont">
	<div class="panel panel-default">
		<div class="panel-header">
			<h4>菜单管理</h4>
		</div>
		<div class="panel-body cl">

			<div class="fl sub-sidebar">
				<!--树状菜单-->
				<ul id="menuTree" class="ztree"></ul>
			</div>
			<div class="fl sub-cont">
				<!--搜索模块-->
				<div class="search-form  ">
					<form id="searchForm">
						<div class="row cl">
							<div class="col-sm-4">
								<label class="form-label" for="">菜单名称：</label>
								<div class="formControls">
									<input type="text" class="input-text" name="menuName" id="menuName">
								</div>
							</div>

							<div class="col-sm-8 text-r">
								<a  class="btn btn-primary " onclick="getMenuList('1')">查询</a>
				  				<c:if test="${sessionScope.funOperate['SYS_MENU_ADD'] }">
								<a href="sysMenu/menuAdd.do" class="btn btn-secondary  ml-5">新增</a>
				  				</c:if>

							</div>

						</div>

					</form>
				</div>
				<!--列表-->
				<table class="table table-primary mt-30">
					<thead>
					<tr>
						<th>菜单名称</th>
						<th>菜单编号</th>
						<th>父节点</th>
						<th>菜单链接</th>
						<th width="80">操作</th>
					</tr>
					</thead>
					<tbody id="menuList">

					</tbody>
				</table>
				<!--分页-->
				<div id="kkpager" class="mt-10 ml-20 mr-30"></div>
			</div>

		</div>
	</div>
</div>

<!--------------------------MODAL---------------------------->

<!--菜单信息对话框--->
<div id="Modal-edit" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="myModalLabel">菜单信息</h3><a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();"><i class="fa fa-times"></i></a>
	</div>
	<div class="modal-body">
		<div class="form-group cl">
			<label class=" fl">菜单编码：</label>
			<input class="input-text fl"  type="text"  onblur="true" value="" name="menuCode" id="menuCode" onchange="changeTip()">
		</div>
		<div class="form-group cl"  id="codeTip" style="display: none">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color: red">菜单信息不能为空！</span>
		</div>
		<div class="form-group cl">
			<label class=" fl">菜单名称：</label>
			<input class="input-text fl"  type="text" value="" name="menEditName" id="menEditName" onchange="changeTip()">
		</div>
		<div class="form-group cl" id="nameTip" style="display: none">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color: red" >菜单名称不能为空！</span>
		</div>
		<div class="form-group cl">
			<label class=" fl">父节点：</label>
			<select class="input-text" name="parentCode" id="parentCode">
				<c:forEach items="${list}" var="vt" varStatus="vtStatus">
					<option value="${vt.menuCode}">${vt.menuName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group cl">
			<label class=" fl">菜单链接：</label>
			<input class="input-text fl"  type="text" value="" name="menuUrl" id="menuUrl" onchange="changeTip()">
		</div>
		<div class="form-group cl" id="urlTip" style="display: none">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="color: red" >菜单链接不能为空！</span>
		</div>
		<div class="form-group cl">
			<label class=" fl">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序：</label>
			<input class="input-text fl"  type="text" value="" name="reOrder" id="reOrder">
		</div>
		<div class="form-group cl">
			<label class=" fl">菜单描述：</label>
			<textarea class="textarea" name="reMark" id="reMark" cols="30" rows="3"></textarea>
		</div>
	</div>
	<div class="modal-footer text-c">
		<button class="btn btn-close" data-dismiss="modal" aria-hidden="true">关闭</button>
		<%--<button  class="btn btn-primary" onclick="updataMenu()">确定</button>--%>
	</div>
</div>
<script>
	$("#btn-sure").click(function(){
		$(".modal-scrollable,.modal-backdrop").hide();
	});
</script>

</body>

</html>