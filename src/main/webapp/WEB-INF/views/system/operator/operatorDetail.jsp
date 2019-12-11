<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作员管理 - 详情</title>
<%@include file="/commons/pages/common.jsp" %>
</head>
<body>
<div class="wrapperbr">
	<div class="wrapper">
		<div class="crumb">
			<a href="operator/sysOperatorIndex.do">权限管理&nbsp;>&nbsp;用户管理&nbsp;>&nbsp;操作员管理</a>><span>操作员详情</span>
		</div>
		<div class=" admin">
			<div class="part_y1"></div>
			<div class="part_y5">
				<div class="contu1">
					<div class="ti">
						<strong>操作员详细信息</strong><span></span>
					</div>
					<form id="couponRuleForm" action="" method="post">
						<input type="hidden" name="type" id="type" value="add">
						<ul class="ultext">
							<li>
								<div class="text">
									<span class="lt">登录账号：</span>
									<span class="rt">${sysOper.operId }</span>
								</div>
								<div class="text">
									<span class="lt">最后一次登录时间：</span>
									<span class="rt">${sysOper.lastLoginTimeTxt }</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">姓名：</span>
									<span class="rt">
										<input class="input" name="operName" id="operName" type="text" disabled="disabled" value="${sysOper.operName }" />
									</span>
								</div>
								<div class="text">
									<span class="lt">用户类型：</span>
									<span class="rt">
										<select name="operType" id="operType" disabled="disabled">
											<option value="">请选择...</option>
											<c:forEach items="${operTypeMap }" var="oper_type">
												<option value="${oper_type.key }" <c:if test="${sysOper.operType eq oper_type.key }">selected="selected"</c:if>>${oper_type.value }</option>
											</c:forEach>
										</select>
									</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">所属渠道：</span>
									<span class="rt">
										<input class="input" name="channelId" id="channelId" type="text" disabled="disabled" value="${chanOperRel.channelName }" />
									</span>
								</div>
								
								<div class="text">
									<span class="lt">是否是工号：</span>
									<span class="rt">
										<select name="isEmployee" id="isEmployee" disabled="disabled">
											<option value="">请选择...</option>
											<c:forEach items="${IS_EMPLOYEE }" var="_is">
												<option value="${_is.key }" <c:if test="${sysOper.isEmployee eq _is.key }">selected="selected"</c:if>>${_is.value }</option>
											</c:forEach>
										</select>
									</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">性别：</span>
									<span class="rt">
										<select name="sex" id="sex" disabled="disabled">
											<option value="">请选择...</option>
											<c:forEach items="${sexMap }" var="_sex">
												<option value="${_sex.key }" <c:if test="${sysOper.sex eq _sex.key }">selected="selected"</c:if>>${_sex.value }</option>
											</c:forEach>
										</select>
									</span>
								</div>
								<div class="text">
									<span class="lt">联系电话：</span>
									<span class="rt">
										<input class="input" name="telephone" id="telephone" type="text" disabled="disabled" value="${sysOper.telephone }" />
									</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">联系邮箱：</span>
									<span class="rt">
										<input class="input" name="email" id="email" type="text" disabled="disabled" value="${sysOper.email }" />
									</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">地址：</span>
									<span class="rt">
										<input class="input" name="address" id="address" type="text" disabled="disabled" value="${sysOper.address }"/>
									</span>
								</div>
							</li>
							<li>
								<div class="text2">
									<span class="fl lt w120  pd_r">描述：</span> <span class="rt">
										<textarea id="operDesc" name="operDesc" rows="4" cols="30" style="font-size:12px;" disabled="disabled">${sysOper.operDesc }</textarea>
									</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">所属组织机构：</span>
									<span class="rt">${organize.orgName }</span>
								</div>
							</li>
							<li>
								<div class="text">
									<span class="lt">所属用户组：</span>
									<span id="span_usergroup" class="rt">
										<c:if test="${operGroupArray ne null }">
											<c:forEach items="${operGroupArray }" var="group">
												<a href="javascript:void(0)" class="litxt">${group.groName }</a>
											</c:forEach>
										</c:if>
									</span>
								</div>
							</li>
						</ul>
					</form>
				</div>
				<div class="tit">
					<c:if test="${flag eq 'userGroup' }">
						<a href="sysUserGroup/toUserGroupList.do" class="button3" id="operBtn">返回</a>
					</c:if>
					<c:if test="${flag ne 'userGroup' }">
						<a href="operator/sysOperatorIndex.do" class="button3" id="operBtn">返回</a>
					</c:if>
				</div>
			</div>
		</div>
		<div class="fooder"></div>
	</div>
</div>
</body>
</html>

