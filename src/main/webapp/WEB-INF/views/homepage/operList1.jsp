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
<title>入党人员管理页-党员发展流程系统</title>
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
    var roleName="${roleName}";
	$(function(){
		getMenuList(); 
		if(roleName=="党群工作室"){$("#visiRoleName").css('display','block');}
		
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
		var operName=$("#operName").val().trim();
		var orgName=$("#orgName").val().trim();
		$.ajax({
			url : "operOrgan/getOperList.do",
			data : {"operName" : operName,
					"orgName" : orgName,
					"pageNo" : pageNo},
			type : "post",
			dataType : "json",
			success: function (result) {
				var html="";
				$("#menuList").html("");
				var list=result.objects;
				var operName;
				var orgName;
				var operMobile;
				var operEmail;
				for (var i in list){
					operName = (null==list[i].operName?"":list[i].operName);
					orgName = (null==list[i].orgName?"":list[i].orgName);
					operMobile=(null==list[i].operMobile?"":list[i].operMobile);
					operEmail=(null==list[i].operEmail?"":list[i].operEmail);
					html += "<tr>";
					html += "<td>"+operName+"</td>";
					html += "<td>"+orgName+"</td>";
					html += "<td>"+operEmail+"</td>";
					html += "<td>"+operMobile+"</td>";
					html += '<td>'+
								'<c:if test="${sessionScope.funOperate[\'RUDANG_DANGQUN_MANAGE_CHECK\'] }">'+
								'<a class="btn btn-op" data-toggle="modal" href="Process/toRudangProcess.do?geren=geren&operId='+list[i].operId+'" title="查看"><i class="fa fa-search"></i></a>'+
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
				$.jBox.error('查询列表失败!', '提示');
				return false;
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
			<h4>人员管理</h4>
		</div>
		<div class="panel-body cl">

			 
			<div class="fl sub-cont">
				<!--搜索模块-->
				<div class="search-form  ">
					<form id="searchForm">
						<div class="row cl">
							<div class="col-sm-3">
								<label class="form-label" for="">人员名称：</label>
								<div class="formControls">
									<input type="text" class="input-text" name="operName" id="operName">
								</div>
							</div>
							<div class="col-sm-3" style="display:none" id="visiRoleName">
								<label class="form-label" for="">党支部名称：</label>
								<div class="formControls">
									<input type="text" class="input-text" name="orgName" id="orgName">
								</div>
							</div>

							<div class="col-sm-3 text-r">
								<a  class="btn btn-primary " onclick="getMenuList('1')">查询</a> 

							</div>

						</div>

					</form>
				</div>
				<!--列表-->
				<table class="table table-primary mt-30">
					<thead>
					<tr> 
						<th>人员名称</th>
						<th>党支部</th>
						<th>邮箱</th>
						<th>电话</th>
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


<script>
	$("#btn-sure").click(function(){
		$(".modal-scrollable,.modal-backdrop").hide();
	});
</script>

</body>

</html>