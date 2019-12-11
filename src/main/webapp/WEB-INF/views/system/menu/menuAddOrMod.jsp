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
	<link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
	<link rel="stylesheet" href="js/jbox/jbox.css">
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

	<script type="text/javascript" src="js/app.js"></script>
	<!--[if IE 6]>
	<script type="text/javascript" src="Lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('.pngfix,.icon');</script>
	<![endif]-->

<script type="text/javascript">
	function saveMenu(type) {
		var menuCode;
		if (type=='1'){
			menuCode=$("#menuCode").val().trim();
		}else {
			menuCode=$("#oldMenuCode").val().trim();
		}

		var menuName=$("#menuName").val().trim();
		var parentCode=$("#parentList").val().trim();
		var menuUrl=$("#menuUrl").val().trim();
		var reorder=$("#reorder").val().trim();
		var remark=$("#remark").val().trim();
		if(null ==menuCode || ""==menuCode){ $("#codeTip").show();return false;}
		if(null ==menuName || ""==menuName){ $("#nameTip").show();return false;}
		if(null ==menuUrl || ""==menuUrl){ $("#urlTip").show();return false;}
		if(null == reorder || ""==reorder){$("#reorderTip").show();return false;}

		$.ajax({
			url : "sysMenu/insertMenu.do",
			type : "post",
			data : {"menuCode" : menuCode,
					"menuName" : menuName,
					"parentCode" : parentCode,
					"menuUrl" : menuUrl,
					"reorder" : reorder,
					"remark" : remark,
					"type" : type
			},
			dataType : "json",
			success : function (data) {
				if(data.success==true){
					$.jBox.tip(data.message,'success');
					setTimeout("window.location.href='sysMenu/toMenuList.do'",500);
				}else {
					$.jBox.error(data.message, '提示');
					return false;
				}
			},
			error : function () {
				$.jBox.error(data.message, '提示');
				return false;
			}
		});
	}
	function changeTip() {
		var menuCode=$("#menuCode").val().trim();
		var menuName=$("#menuName").val().trim();
		var menuUrl=$("#menuUrl").val().trim();
		var reorder=$("#reorder").val().trim();
		if(null !=menuCode || ""!=menuCode){ $("#codeTip").hide();}
		if(null !=menuName || ""!=menuName){ $("#nameTip").hide();}
		if(null !=menuUrl || ""!=menuUrl){ $("#urlTip").hide();}
		if(null !=reorder || ""!=reorder){ $("#reorderTip").hide();}

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
				<div class="panel panel-primary">
					<div class="panel-header">
						<c:if test="${flag=='1'}">
							<h4>新增菜单</h4>
						</c:if>
						<c:if test="${flag=='0'}">
							<h4>修改菜单</h4>
							<input type="hidden" name="oldMenuCode" id="oldMenuCode" value="${sysMenu.menuCode}"/>
						</c:if>
					</div>
					<div class="panel-body">
						<!--机构模块-->
						<div class="menu-form">
							<form>
								<div class="form-group">
									<label class="form-label" for="">菜单编码：</label>
									<div class="formControls">
										<input type="text" class="input-text" maxlength="25" name="menuCode" id="menuCode" onkeyup="this.value=this.value.replace(/[^a-zA-Z0-9_]/g,'')" onafterpaste="this.value=this.value.replace(/[^a-zA-Z0-9_]/g,'')" onchange="changeTip()"<c:if test="${flag=='0'}">disabled="disabled"</c:if> value="${sysMenu.menuCode}"><span style="color: red;display: none;float: left" id="codeTip">菜单编码不能为空！</span>
									</div>
								</div>
								<div class="form-group">
									<label class="form-label" for="">菜单名称：</label>
									<div class="formControls">
										<input type="text" class="input-text" maxlength="50" name="menuName" id="menuName" onchange="changeTip()" value="${sysMenu.menuName}" ><span style="color: red;display: none;float: left" id="nameTip">菜单名称不能为空！</span>
									</div>
								</div>
								<div class="form-group">
									<label class="form-label" for="">父&nbsp;节&nbsp;点：</label>
									<div class="formControls">
										<select class="input-text" name="parentList" id="parentList">
											<c:forEach items="${list}" var="vt" varStatus="vtStatus">
												<option value="${vt.menuCode}" <c:if test="${vt.menuCode == sysMenu.parentMenuCode}"> selected="selected"</c:if>>${vt.menuName}</option>
											</c:forEach>
												<option value="-1" <c:if test="${vt.menuCode == sysMenu.parentMenuCode}"> selected="selected"</c:if>>-1</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="form-label" for="">菜单链接：</label>
									<div class="formControls">
										<input type="text" class="input-text" maxlength="100" name="menuUrl" id="menuUrl" onchange="changeTip()" value="${sysMenu.menuUri}"><span style="color: red;display: none;float: left" id="urlTip">菜单Url不能为空！</span>
									</div>
								</div>
								<div class="form-group">
									<label class="form-label" for="">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序：</label>
									<div class="formControls">
										<input type="text" class="input-text" name="reorder" maxlength="3" id="reorder" onchange="changeTip()" value="${sysMenu.reorder}" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d]/g,'')"><span style="color: red;display: none;float: left" id="reorderTip">排序号不能为空！</span>
									</div>
								</div>
								<div class="form-group">
									<label class="form-label" for="">菜单描述：</label>
									<div class="formControls">
										<textarea class="textarea" name="remark" id="remark" cols="40" rows="5">${sysMenu.remark}</textarea>
									</div>
								</div>
								<%--<div class="form-group text-c">
									<a class="btn btn-primary  ml-80" onclick="saveMenu()">确定</a>
								</div>--%>

							</form>
						</div>

					</div>
				</div>
				<div class="btn-wrap pl-20 mt-10">
					<c:if test="${flag=='1'}">
						<a  class="btn btn-primary  ml-10" onclick="saveMenu('1')">保存</a> <a onclick="javascript:history.go(-1);"  class="btn btn-secondary  ml-10">取消</a>
					</c:if>
					<c:if test="${flag=='0'}">
						<a  class="btn btn-primary  ml-10" onclick="saveMenu('0')">保存</a> <a onclick="javascript:history.go(-1);"  class="btn btn-secondary  ml-10">取消</a>
					</c:if>
				</div>
			</div>

		</div>
	</div>
</div>

<!--------------------------MODAL---------------------------->

<!--删除对话框--->
<div id="Modal-delete" class="modal w300 hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="myModalLabel">删除</h3><a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();"><i class="fa fa-times"></i></a>
	</div>
	<div class="modal-body">
		<p>确定删除此商户资料？</p>
	</div>
	<div class="modal-footer text-c">
		<button class="btn btn-close" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button class="btn btn-primary">确定</button>
	</div>
</div>


</body>

</html>