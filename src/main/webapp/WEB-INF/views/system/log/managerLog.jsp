<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>User login log</title>
    <%@ include file="/commons/pages/common.jsp"%>
    <link rel="stylesheet" type="text/css" href="resources/css/index4.css"/>
    <script type="text/javascript" src="resources/artDialog4.1.7/jquery.artDialog.js?skin=chrome"></script>
    <script type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
    <script type="text/javascript" src="resources/js/log/managerLog.js"></script>
    <script>
		var SYS_USER_LOGIN_LOG_DETAIL = "${sessionScope.funOperate['SYS_USER_LOGIN_LOG_SYS_USER_LOGIN_LOG_DETAIL']}";
	</script>
  </head>
  <body>
    <div class="wrapperbr">
      <div class="wrapper">
        <div class="crumb">
          <a href="javascript:void(0);">权限管理</a>&gt;<span>用户登录日志</span>
        </div>
        <div class="admin">
          <div class="part_y1"></div>
          <div class="part_y2">
            <span>操作人员：<input id="operId" name="operId" type="text" style="width: 100px;"/></span>
            <span>登录时间： 
              <input id="startLoginTime" name="startLoginTime" type="text" onClick="WdatePicker()" style="width: 80px;"/>
              -<input id="endLoginTime" name="endLoginTime" type="text" onClick="WdatePicker()" style="width: 80px;"/>
            </span>
            <span>退出时间： 
              <input id="startLogoutTime" name="startLogoutTime" type="text" onClick="WdatePicker()" style="width: 80px;"/>
              -<input id="endLogoutTime" name="endLogoutTime" type="text" onClick="WdatePicker()" style="width: 80px;"/>
            </span>
            <span><a href="javascript:void(0);" id="btn_search" class="button_search2"></a></span>
          </div>
          <div class="part_y3" style="width:100%; height: 430px;">
            <table id="logTable"></table>
          </div>
        </div>
      </div>
    </div>
    <div id="div_detail" style="display: none;">
      <div class="win_tree6">
        <ul class="text3part1">
          <li>
            <div class="lt">操作人员：</div>
            <div class="rt"><input type="text" id="det_operId" disabled="disabled"/></div>
          </li>
          <li>
            <div class="lt">登录时间：</div>
            <div class="rt"><input type="text" id="det_loginTime" disabled="disabled"/></div>
          </li>
          <li>
            <div class="lt">退出时间：</div>
            <div class="rt"><input type="text" id="det_logoutTime" disabled="disabled"/></div>
          </li>
          <li>
            <div class="lt">IP地址：</div>
            <div class="rt"><input type="text" id="det_ipAddress" disabled="disabled"/></div>
          </li>
          <li>
            <div class="lt">MAC地址：</div>
            <div class="rt"><input type="text" id="det_macId" disabled="disabled"/></div>
          </li>
          <li>
            <div class="lt">备注：</div>
            <div class="rt"><textarea rows="" cols="25" id="det_remark" style="resize:none;" disabled="disabled"></textarea></div>
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>