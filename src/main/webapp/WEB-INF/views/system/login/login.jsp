<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
           + request.getServerName() + ":" + request.getServerPort()
           + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录页-党员发展流程系统</title>
<base href="<%=basePath %>" />
<link rel="Bookmark" href="img/favorite.png" > 
<link rel="Shortcut Icon" href="img/favorite.png" />
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/core.css">

<script type="text/javascript" src="js/jquery-2.1.4.js"></script> 
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/validate/additional-methods.min.js"></script> 
<script type="text/javascript" src="js/validate/messages_zh.js"></script> 
<script type="text/javascript" src="js/kkpager/kkpager.js"></script> 
<script type="text/javascript" src="js/app.js"></script>

<script type="text/javascript">
$(function(){
    $("#operAccount").focus();
});

/**登录验证*/
function login() {
	if($("#operAccount").val()==""){
		$("#msg").html("请输入用户名");
	 	$("#operAccount").focus();
	 	return false;
	}
	if($("#operPwd").val()==""){
	 	$("#msg").html("请输入密码");
	 	$("#operPwd").focus();
	 	return false;
	}
	$("#msg").html("");//清空
	$("#sub").hide();
	$("#loadDiv").show();
	//登录验证
	$.ajax({
		type: "POST",
		url: "<%=basePath %>sysLogin/checkSysLogin.do",
		data: $("#loginForm").serialize(),
		datatype: "json",
		success: function(data){
			if (data.flag) {//登录成功
				window.location.href="<%=basePath %>sysMenu/getLoginMenus.do";
				return;
			} else {
				$("#msg").html(data.msg);
				$("#loadDiv").hide();
				$("#sub").show();
			}
		}
   	});
}

/**回车事件*/
function enterEnvent(evt){
	evt = (evt) ? evt : ((window.event) ? window.event : "")
	keyCode = evt.keyCode ? evt.keyCode : (evt.which ? evt.which : evt.charCode);
	if (keyCode == 13){
		login();
	}
}

function clearPwd(){
	//alert(123);
	$("#operPwd").val("");
}

//返回顶层登录页面
if(top != self){
	top.location.href = self.location.href;
}

</script>
</head>
<body class="login">
<!------------------------HEADER---------------------------->
  <header class="navbar-wrapper">
      <div class="navbar navbar-blue">
          <div class="container-fluid cl">
              <a class="logo navbar-logo" href="#"><img src="img/logo.png" alt="logo"></a>  
          </div>
      </div>
  </header>
  
<!------------------------LOGIN---------------------------->   
  <div class="login-wrap">
     <h2 class="text-c c-blue mt-100">党员发展流程系统</h2>
      <section class="login-panel panel panel-default pos-f">
          <div class="panel-header"><h4>用户登录</h4></div>
          <div class="panel-body form-horizontal">
          <form id="loginForm"  method="post">
          	  <div class="form-group row cl">
                  <label class="form-label col-sm-2">账&nbsp;&nbsp;&nbsp;号：</label>
                  <div class="formControls col-sm-10">
                  <input class="input-text" id="operAccount" name="operAccount" type="text" value="" onkeyup="clearPwd()" onkeydown="enterEnvent(event)" placeholder="账号/手机号/邮箱" onblur="true">
                  </div>
              </div>
              <div class="form-group row cl">
                  <label  class="form-label col-sm-2" >密&nbsp;&nbsp;&nbsp;码：</label>
                  <div class="formControls col-sm-10">
                  <input class="input-text" id="operPwd" name="operPwd" type="password" value="" onkeydown="enterEnvent(event)" autocomplete="off" placeholder="请输入密码">
                  </div>
              </div>
              <div style="height: 20px; padding-left:20px;">
                  <label  class="form-label col-sm-1" >&nbsp;</label>
                  <div id="msg" style="color:red;"></div>
              </div>
             <div class="row cl">
                  <button type="button" id="sub" onclick="login()" class="btn btn-primary btn-block btn-login ">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
				  <div id="loadDiv" style="text-align:center;display:none;padding-top:30px;"><img id="loading" src="resources/images/loading.gif" /></div>
              </div>
          </form>
          </div>
      </section>
  </div>
  
  <!------------------------FOOTER--------------------------
  <footer class="footer footer-fixed footer-login">
      <div class="container-fluid">
		<p >Copyright &copy;1999-2016&nbsp;中国联通&nbsp;版权所有 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        经营许可编号：<a  href="http://www.miitbeian.gov.cn/" target="_blank" rel="nofollow">***ICP备****号</a><br>
		</p>
	</div>
  </footer>
 --> 
</body>
</html>