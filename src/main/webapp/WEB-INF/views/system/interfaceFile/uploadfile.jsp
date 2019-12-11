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
<title>上传接口文件页-中国联通研究院大数据运营后台管理系统</title>
  <base href="<%=basePath1 %>" />
<!--[if lt IE 9]>
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="js/kkpager/kkpager_blue.css"><link rel="stylesheet" href="js/jbox/jbox.css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validate/additional-methods.min.js"></script>
<script type="text/javascript" src="js/validate/messages_zh.js"></script>
<script type="text/javascript" src="js/kkpager/kkpager.min.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/modal/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script><script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>

  <script type="text/javascript" src="js/jquery.form.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="Lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('.pngfix,.icon');</script>
<![endif]-->
<script type="text/javascript">
  var sign=true;
  $(document).ready(function(){
    $("#upload").on("change",function(){
      var uploadfile=$("#uploadfile").val();
      var temp=uploadfile.split("\\");
      var temp1=(temp[2]).split("_");
      var flag=temp1[0]+"_"+temp1[1];
      sign=true;
      switch (flag){
        //case 'USER_AUTHAPLY':$("#fileType").val('租户账号权限申请接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        case 'USER_AUTHAPLYN':$("#fileType").val('租户账号权限申请结果接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'USER_SOUAPL':$("#fileType").val('租户IT资源申请接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        case 'USER_SOUAPLYN':$("#fileType").val('租户IT资源申请结果接口');$("#infName").val('租户IT资源申请结果接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'USER_DATAAPLY':$("#fileType").val('租户数据权限申请接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        case 'USER_DATAAPLYN':$("#fileType").val('租户数据权限申请结果接口');$("#infName").val('租户数据权限申请结果接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'USER_BUSDEL':$("#fileType").val('商户注销接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'USER_DEL':$("#fileType").val('租户账号注销接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'PRODUCT_REVIEW':$("#fileType").val('产品审核申请接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        case 'PRODUCT_DATASYN':$("#fileType").val('数据服务信息同步接口');$("#infName").val('数据服务信息同步接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        //case 'ORDER_APPLY':$("#fileType").val('工单申请接口');$("#infName").val('租户账号权限申请接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        case 'DATA_NOTICE':$("#fileType").val('工单结果数据已生成通知接口');$("#infName").val('工单结果数据已生成通知接口');$("#fileName").val(temp[2]);$("#fileTime").val(temp1[2]);break;
        default: $.jBox.error('选择文件命名错误！', '提示');sign=false;return false;
      }
    })
  });

    function save(){
      var uploadfile=$("#uploadfile").val();
      if(!sign || uploadfile==null && ""==uploadfile){
      		$.jBox.error('请检查上传文件！', '提示');
      		return false;
      }
      if(uploadfile.substring(uploadfile.indexOf(".")+1) !="txt"){
      		$.jBox.error('请上传txt文件！', '提示');
      		return false;
      }
      $("#queryForm").attr("enctype","multipart/form-data");
      $("#queryForm").ajaxSubmit({
        type:"post",
        url:'InfFile/uploadFile.do',
        datatype: "json",
        success: function(data){
			if(data.success==true){
				jBox.tip("上传成功!", 'success');
                setTimeout("history.go(0)",2500);
            }else{
				$.jBox.error(data.message, '提示');
				return false;
			}
        },
        error : function(){
          $.jBox.error(data.message, '提示');
          return false;
        }
      });
    }
</script>
</head>
<body>

<!-------------------------CONT---------------------------->
<div class="Edit-cont box-cont">
  <div class="panel panel-default">
    <div class="panel-header">
      <h4>接口文件管理</h4>
    </div>
    <div class="panel-body">
      <div class="panel panel-primary">
        <div class="panel-header">
          <h4>上传接口文件</h4>
        </div>
        <div class="panel-body">
          <div class="file-form">
            <form id="queryForm" method="post" enctype="multipart/form-data">
              <div class="form-group">
                <label class="form-label" for="">接口文件：</label>
                                    <span class="btn-upload">
									<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly="" >
									<c:if test="${sessionScope.funOperate['UPLOAD_FILE_UPLOAD'] }">
									<a  class="btn btn-primary-outline upload-btn ml-20 f-12"> 上传</a>
									<input type="file"  name="upload" id="upload" accept=".txt" onchange="document.getElementById('uploadfile').value=this.value;" class="input-file valid">
									</c:if>
									</span>

              </div>

              <div class="form-group">
                <label class="form-label" for="">接口类型：</label>
                <input type="text" class="input-text" name="fileType" id="fileType" disabled="" value="" >
              </div>
              <div class="form-group">
                <label class="form-label" for="">接口文件名：</label>
                <input type="text" class="input-text" disabled="" name="fileName" id="fileName" value="">
                <input type="hidden" name="infName" id="infName"/>
              </div>
              <div class="form-group">
                <label class="form-label" for="">接口生成时间：</label>
                <input type="text" class="input-text" disabled="" name="fileTime" id="fileTime" value="">
              </div>

            </form>
          </div>
        </div>
      </div>
      <div class="btn-wrap pl-60 mt-20">
	  <c:if test="${sessionScope.funOperate['UPLOAD_FILE_RUN'] }">
	  <a class="btn btn-primary " onclick="save()">执行</a>
	  </c:if>
      </div>
    </div>
  </div>
</div>

</body>
</html>