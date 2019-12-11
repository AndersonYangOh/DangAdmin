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
 <base href="<%=basePath1 %>" /> 
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>组织机构管理页-中国联通研究院大数据运营后台管理系统</title>
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
 	<script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
    <!--[if IE 6]> 
      <script type="text/javascript" src="Lib/DD_belatedPNG_0.0.8a-min.js" ></script>
      <script>DD_belatedPNG.fix('.pngfix,.icon');</script> 
    <![endif]-->
    
  <script language="JavaScript">
	    //点击组织管理加载页面
	    $(document).ready(function() {
	       		 getOrganizeTree();
	    });
	    // 加载左侧组织机构树结构
		function getOrganizeTree() {
		    $.ajax({
		        type : 'POST',
		        url : 'organize/getOrganizeTree.do',
		        datatype : 'text',
		        success : function(result) {
		            $.fn.zTree.init($("#organizeTree"), {
		                data : {
		                    simpleData : {
		                        enable : true
		                    }
		                },
		                callback : {
		              
		                }
		            }, result);
		        }
		    });
		}
		
  
       function parentOrgCodeShow(){
      
		       	$.ajax({
		        type : 'POST',
		        url : 'organize/getOrganizeTree.do',
		        datatype : 'text',
		        success : function(result) {
		            $.fn.zTree.init($("#organizeTree1"), {
		                data : {
		                    simpleData : {
		                        enable : true
		                    }
		                },
		                callback : {
		                    onClick : zTreeOnClickNum
		                }
		            }, result);
		        }
		    });
       }
       
       // 树点击事件
		function zTreeOnClickNum(event, treeId, treeNode) {
		  /*   $("#organizeTable1").datagrid('load', {
		        parentOrgCode : treeNode.pkId == "-1" ? "" : treeNode.pkId
		    }); */
		    $('#parentOrgCode').val(treeNode.pkId == "-1" ? "-1" : treeNode.pkId);
		    $('#Modal-select').modal('hide');
		     changeTip(); 
		   /*  $('#orgName').val("");
		    $('#orgCode').val("");
		    $('#status').val(""); */
		}
		// 保存
		function save() {
		    var orgName = $("#orgName").val();
		    if (orgName == null || orgName == "") {
		    	 $("#orgNameTip").show();
			     return false;
			}
		    var orgCode = $("#orgCode").val();
		    if (orgCode == null || orgCode == "") {
		        $("#orgCodeTip").show();
		        return false;
		    }
		  
		    var parentOrgCode = $("#parentOrgCode").val();
		    if (parentOrgCode == null || parentOrgCode == "") {
		    	$("#parentOrgCodeTip").show();
		        return false;
		    }
		    var orgCode = $("#orgCode").val();
		    var orgName = $("#orgName").val();
		    var parentOrgCode = $("#parentOrgCode").val();
		    var orgDesc = $("#orgDesc").val();
		    var status = $("#status").val();
		    var type = $("#type").val();
		   
		    $.ajax({
		        type : 'POST',
		        url : 'organize/update.do',
		        data : {
		            orgCode : orgCode,
		            orgName : $.trim(orgName),
		            parentOrgCode : parentOrgCode,
		            status : status,
		            type : type,
		            orgDesc : orgDesc
		        },
		        datatype : 'json',
		        success : function(msg) {
		            if (msg.flag) {
		                $.jBox.tip(msg.msg,'提示');
		                getOrganizeTree();
		                setTimeout("window.location.href='organize/index.do'",500);
		            }else {
						$.jBox.error(msg.msg, '提示');
						return false;
					}
		           
		            //history.go(-1);
		        },
		        error : function () {
					$.jBox.error(msg.msg, '提示');
					return false;
				}
		    });
		}
  </script>
  
  
</head>

<body>
    <!-------------------------CONT---------------------------->
    <div class="box-cont">
        <div class="panel panel-default">
           <div class="panel-header">
               	  <h4>组织机构管理</h4>   
           	  </div>
            <div class="panel-body cl">
               
	
                <div class="fl sub-sidebar">
                    <!--树状菜单-->
                    <ul id="organizeTree" class="ztree"></ul>
                </div>
                <div class="fl sub-cont">
                <div class="panel panel-primary">
                    <!--机构模块-->
                       <div class="panel-header">
                   			<h4>修改组织机构</h4>
             			</div>
                        <div class="panel-body">
                            <div class="organization-form">
                           <form id="orgAddForm" action=""method="post" >
                                <div class="form-group">
                                    <label class="form-label" for="" onchange="changeTip()">机构名称：</label>
                                    <div class="formControls">
                                        <input type="hidden"  class="input-text" id="type" name="type"  maxlength="64" value="${type}">
                                        <input type="text" class="input-text" id="orgName" maxlength="64" onchange="changeTip()"value="${sysOrganize.orgName}">
                                      
                                    </div>
                                      <span class="c-red" style="display:none" id="orgNameTip" name="orgNameTip" >请输入机构名称</span>
                                </div>
                                <div class="form-group">
                                    <label class="form-label" for="">机构编码：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text"  id="orgCode"  maxlength="32"  onchange="changeTip()" value="${sysOrganize.orgCode}" readonly disabled="">
                                    </div>
                                        <span class="c-red" style="display:none" id="orgCodeTip" name="orgCodeTip" >请输入机构编码</span>
                                </div>
                                <div class="form-group">
                                    <label class="form-label fl" for="">上级机构编码：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text input-min fl" id="parentOrgCode" maxlength="32"onchange="changeTip()" style="width:170px" value="${sysOrganize.parentOrgCode}" >
                                        <input  type="hidden" class="input-text input-min fl" id="status" name="status" maxlength="32"  value="${sysOrganize.status}">
                                        <a href="#Modal-select" data-toggle="modal" class="btn btn-third fl" onclick="parentOrgCodeShow()">选择上级机构</a>
                                    </div>
                                         <span class="c-red" style="display:none"id="parentOrgCodeTip" name="parentOrgCodeTip" >请选择上级机构编码</span>
                                    
                                </div>
                             
                                <div class="form-group">
                                    <label class="form-label"  >机构描述：</label>
                                    <div class="formControls">
                                        <textarea class="textarea" name="orgDesc" id="orgDesc" cols="40" rows="5" maxlength="500" value="">${sysOrganize.orgDesc}</textarea>
                                    </div>
                                </div>
                                
                             
                            </form>
                    </div>
                        </div>
                </div>
                <div class="btn-wrap pl-60 mt-20">
                    <a class="btn btn-primary  ml-10" onclick="save()">提交</a> <a href="javascript:history.go(-1);" class="btn btn-secondary  ml-10">取消</a>
                </div>
            </div>


            </div>
        </div>
    </div>

    <!--------------------------MODAL---------------------------->

    <!--删除对话框--->
    <div id="Modal-select" class="modal w300 hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-header">
            <h3 id="myModalLabel">选择上级机构</h3><a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();"><i class="fa fa-times"></i></a>
        </div>
        <div class="modal-body">
            <!--树状菜单-->
            <ul id="organizeTree1" class="ztree"></ul>
        </div>
       
    </div>


</body>

</html>