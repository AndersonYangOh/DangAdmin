<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>菜单详情</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<div class="window no_pd_br_mg_trbl" style="width:570px;">
  	<div class="win_tree7 otherWin7" style="height:380px;">
    	<ul class="text3part1">
        	<li>
            	<div class="lt"><span>*</span>菜单编码：</div>
                <div class="rt">
               		<input class="input" id="menuCode" name="menuCode" disabled="disabled" type="text" value="${menu.menuCode }">
                </div>
            </li>
            <li>
            	<div class="lt"><span>*</span>菜单名称：</div>
                <div class="rt"><input class="input" id="menuName" name="menuName" disabled="disabled" type="text" value="${menu.menuName }"></div>
            </li>
            <li>
            	<div class="lt">菜单地址：</div>
                <div class="rt"><input class="input" id="menuUri" name="menuUri" disabled="disabled" type="text" value="${menu.menuUri }"></div>
            </li>
            <li>
            	<div class="lt">父菜单：</div>
                <div class="rt">
					<input class="input" id="parentMenuName" name="parentMenuName" disabled="disabled" type="text" value="${menu.parentMenuName }">
				</div>
            </li>
            <li>
            	<div class="lt"><span>*</span>状态：</div>
                <div class="rt">
                	<select id="status" name="status" disabled="disabled">
                		<option value="">请选择...</option>
                		<c:forEach items="${statusHash }" var="state">
                			<option value="${state.key }" <c:if test="${state.key eq menu.status }">selected="selected"</c:if>>${state.value }</option>
                		</c:forEach>
                	</select>
                </div>
            </li>
            <li>
            	<div class="lt">菜单排序：</div>
                <div class="rt"><input class="input" id="reorder" name="reorder" disabled="disabled" type="text" value="${menu.reorder }"></div>
            </li>
            <li>
            	<div class="lt">描述：</div>
                <div class="rt"><textarea id="menuDesc" name="menuDesc" disabled="disabled" style="font-size:12px;" rows="3" cols="30">${menu.menuDesc }</textarea></div>
            </li>
        </ul>
   </div>
	<div class="benpart">
		<a href="javascript:void(0);" class="button2" onClick="closeWin();">关闭</a>
	</div>
</div> 
<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
	function closeWin() {
		api.close();
 	}
</script>
</body>
</html>
