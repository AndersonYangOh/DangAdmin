<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>My JSP 'index.jsp' starting page</title>
<%@include file="/commons/pages/common.jsp" %>
<link rel="stylesheet" type="text/css"href="resources/css/jump_break.css" />
<link rel="stylesheet" type="text/css"href="resources/css/select_forall.css" />
</head>

<body>

<div class="window no_pd_br_mg_trbl" style="width:400px;">
  	<div class="win_tree7 otherWin7" style=" width:94%; height:130px;">
    	<ul class="text3part1">
        	<li>
            	<div class="lt">新密码：</div>
                <div class="rt"><input id="pwd" name="" class="inputclass" type="password" maxlength="12" size="12" onblur="macthCode(this)"/>
                <span class="tx grayFont" id="pwdSpan"></span>
                </div>
            </li>
            <li>
            	<div class="lt">确认密码：</div>
                <div class="rt"><input id="pwd1" name="" class="inputclass" type="password" maxlength="12" size="12" onblur="macthCode(this)"/>
                <span class="tx grayFont" id="pwd1Span"></span>
                </div>
            </li>
        </ul>
        <ul>
        	<li style="text-align: center;"><font color="red" size="2">(密码只能由字母、数字、下划线组成)</font></li>
        </ul>
   </div>
   
</div>
</body>
<script >


/* 下面的代码为内容页value04.html页面里的代码，请自行打开此文件查看代码 */
var api = frameElement.api, W = api.opener;
api.button({
    id:'valueOk',
    name:'确定',
    callback:ok,
    cancelVal: '关闭',
    cancel: true /*为true等价于function(){}*/
});
/* 函数ok即为上面添加按钮方法中callback回调函数调用的函数 */
function ok(){
	var id='${id}';
	var pwd=$('#pwd').val();
	if(checkEmpty(pwd)){
		checkCompont('pwd','','请输入新密码');
		return false;
	}
	var pwd1=$('#pwd1').val();
	if(checkEmpty(pwd1)){
		checkCompont('pwd1','','请输入确认密码');
		return false;
	}
	if(pwd!=pwd1){
		checkCompont('pwd1','','两次的密码不一样');
		return false;
	}
	//重置密码时，密码设置时建议给出提示语如“由数字、下划线、字母组成组成，12个字符”
	if(pwd.length < 6 || pwd.length > 12){
		checkCompont('pwd','','长度只能是 6-12');
		return false;
	}
	/*var reg = /^[a-zA-Z0-9_]+$/;
	if(!reg.test(pwd)){
		checkCompont('pwd','','只能由数字、下划线、字母组成组成，');
		return false;
	}*/
	$.ajax({
        type : 'POST',
        url : 'operator/operatorPwdUpdate.do',
        data : 'id='+id+'&newPwd='+pwd,
		datatype : 'json',
		async : false,
        success : function(msg) {
        	alert(msg.msg);
        	W.location.href = rootPath+'/operator/sysOperatorIndex.do';
        }
	});
};

</script>
</html>
