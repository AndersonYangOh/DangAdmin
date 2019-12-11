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
<link rel="Bookmark" href="img/favorite.png" > 
<link rel="Shortcut Icon" href="img/favorite.png" />
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="js/kkpager/kkpager_blue.css">
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.min.js"></script> 
<script type="text/javascript" src="js/validate/additional-methods.min.js"></script> 
<script type="text/javascript" src="js/validate/messages_zh.js"></script> 
<script type="text/javascript" src="js/kkpager/kkpager.min.js"></script> 
<script type="text/javascript" src="js/modal/bootstrap-modal.js"></script> 
<script type="text/javascript" src="js/modal/bootstrap-modalmanager.js"></script> 

<%-- main.js用于获取当前登录用户可操作功能数据 --%>
<script type="text/javascript" src="resources/easyui13/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resources/easyui13/locale/easyui-lang-en.js"></script>
<script type="text/javascript" src="resources/common/easyui-expand.js"></script>
<script type="text/javascript" src="resources/common/easyui-validate.js"></script>

<script type="text/javascript" src="resources/js/menu.js"></script>
<script type="text/javascript" src="resources/js/system/main.js"></script>
<link rel="stylesheet" href="js/jbox/jbox.css">
<script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script> 
<script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>
<script type="text/javascript">
	jQuery.browser={};
	(function(){
		jQuery.browser.msie=false; 
		jQuery.browser.version=0;
		if(navigator.userAgent.match(/MSIE ([0-9]+)./)){
		 jQuery.browser.msie=true;
		 jQuery.browser.version=RegExp.$1;
		 }})();
</script>
<script type="text/javascript">
	$(function(){
		getList();
	});
	
	var totalPage;
	var totalRecords;
	var page = 1;
	var rows = 6;
	var param = {};
	function getList(){
		param["page"] = page;
		param["rows"] = rows;
		getData();
	}
	function changPage(){
			page = $(".curr").text()==undefined||$(".curr").text()==""?1:$(".curr").text();
	  		param["page"] = page;
	  		getData();
	}
	
	function getData(){
		$.ajax({
			type: "POST",
			url: "InfFile/getFileIFDownList.do",
			data:param,
			dataType: "json",
			success: function(data){
				if (data != null){
					var downFileList = data.fileDownList;
					totalPage = data.totalPage;
					totalRecords = data.totalNumber;
					$("#fileDownList").empty();
					var temp = "";
					for(i in downFileList){
						var time = FormatDate(downFileList[i].createTime);
						temp += "<tr>"
							 +  "<td><input type=\"checkbox\" name=\"fileInCheckBox\" value='"+downFileList[i].bussId+"="+downFileList[i].infFileName+"'></td>"
							 +  "<td>"+downFileList[i].bussAccount+"</td>"
							 +  "<td>"+downFileList[i].infName+"</td>"
							 +  "<td>"+downFileList[i].infFileName+"</td>"
							 +  "<td>"+downFileList[i].creator+"</td>"
							 +  "<td>"+time+"</td>"
							 +  "</tr>"
					}
					$("#fileDownList").append(temp);
					toPage();
				}else{
					$("#fileDownList").empty();
	  				$("#kkpager").hide();
	  				addStr =  "<div class=\"panel panel-secondary empty\"><section><div class=\"panel-body\"><p class=\"text-c c-orange\">无任何记录！</p></div></<section></div>";
					$("#fileDownList").append(addStr);
				}
		}
		
		});
	}
	
	<!-- 加载分页控件 -->
	function toPage(){
		kkpager.total = totalPage;
		kkpager.totalRecords = totalRecords;
		kkpager.pno = page;
		kkpager.hasPrv = (kkpager.pno > 1)
		kkpager.hasNext = (kkpager.pno < kkpager.total);
		kkpager.generPageHtml({
		     pno : page,
		     mode : 'click', 
		     total : totalPage,  
		     totalRecords : totalRecords,
		     click : function(n){
		         this.selectPage(n);
		  		 changPage();
		         return false;
		     },
		     getHref : function(n){
		         return 'javascript:void(0)';
		     }
			 },true);
		}
		
		//格式化时间
	  function FormatDate (strTime) {
		  
	      var date = new Date(strTime);
	      var mon;var day;var hour;var min;var secs;
	      var  temp=date.getMonth()+1;
	      if(temp<10){mon="0"+temp;}else {mon=temp;}
	      if(date.getDate()<10){day="0"+date.getDate();}else {day=date.getDate();}
	      if(date.getHours()<10){hour="0"+date.getHours();}else {hour=date.getHours();}
	      if(date.getMinutes()<10){min="0"+date.getMinutes();}else {min=date.getMinutes();}
	      if(date.getSeconds()<10){secs="0"+date.getSeconds();}else {secs=date.getSeconds();}
	      return date.getFullYear()+"-"+mon+"-"+day+"<br>"+hour+":"+min+":"+secs;
	  }
	  	  
	  /***下载接口文件***/
	  function downLoadFile(){
	  		var boxArray = document.getElementsByName("fileInCheckBox");
	  		var params = "";
	  		if (boxArray.length <= 0){
	  			$.jBox.error('请选择下载接口文件!', '提示');
	  		}else{
	  			for (var i=0;i<=boxArray.length-1;i++ ){
		  			if(boxArray[i].checked){
		  				var dd = boxArray[i].value;
		  				params += dd+";";
		  			}
	  			}
		  		$("#params").val(params);
		  		$("#downFile").submit();
	  		}
	  }
</script>
</head>
<body>

<!-------------------------CONT---------------------------->
<div class="List-cont box-cont">
            <div class="panel panel-default">
                   <div class="panel-header">
                     <h4>接口文件管理</h4>
                   </div>
                   <div class="panel-body">
                        <div class="panel panel-primary">
                            <div class="panel-header">
                                <h4>下载接口文件</h4>
                            </div>
                            <div class="panel-body">
                                  <!-- 列表--->
                                  <table class="table table-primary">
                                      <thead>
                                         <tr>
                                          <th></th>
                                          <th>商户名称</th>
                                          <th>接口名称</th>
                                          <th>接口文件名</th>
                                          <th>操作员</th>
                                          <th>生成时间</th>  
                                          </tr>                
                                      </thead>
                                      <tbody id="fileDownList"></tbody>
                                  </table>
                                  <!--分页-->
                                  <div id="kkpager" ></div>
                            </div>
                        </div>
            			<div class="btn-wrap pl-60 mt-20">
	  					<c:if test="${sessionScope.funOperate['DOWNLOAD_FILE_DOWNLOAD'] }">
            				<a class="btn btn-primary " onclick="downLoadFile()" href="javascript:void(0)" >下载</a> 
            			</c:if>
                    	</div>
                 </div>
                 <form style="display:none;" id="downFile" name="downFile" action="InfFile/downFileInterface.do" method="post">
					<input id="params" name="params" value="" />
				</form>
                  
             </div>                                      
        </div>

</body>
</html>