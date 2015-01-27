<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<link href="${ctx}/css/common/user_center.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
	    url : "getUserInfoDetail",
	    type : "post",
	    dataType : "json",
	    data : {},
	    success : function(data) {
	    	document.getElementById("userName").value = data.row.USERNAME;
	    	document.getElementById("realName").value = data.row.REALNAME;
	    	var sex = data.row.SEX;
	    	if(sex == "男")
	    		$("#sex option[value='0']").attr("select","selected");
	    	else
	    		$("#sex option[value='1']").attr("select","selected");
	    	
	    		
	    	
	    }
	   
	});
	
	$("#info_edit").click(function(){
		var userName = $("#userName").val();
		var userPwd = $("#userPwd").val();
		var realName = $("#realName").val();
	
		var sex = $("#sex").val();

		$.ajax({
			url : "userInfoSave",
			type : "post",
			dataType : "json",
			data : {"userName":userName,"userPwd":userPwd,"realName":realName,"age":age,"sex":sex},
			success : function(data){
				if(data.result == "success") {
					alert("信息保存成功!");
					jcl.go("/SSDUT_Forum/user_list");
				}
				else
					alert("网站异常,请稍后再试！");
			}
		});
	});
	
});
</script>
</head>
<body>

<div class="main">

    <div class="person_top">
        <span style="font-size:22px; color:#018079"><u>个人基本信息</u></span>
    </div>
    <div class="person_main">
        <span style="font-size:16px;position:relative; left:35px; top:25px; color:#AB0039;">完善您的个人信息，让我们更好的了解您的需求</span>
        <div class="info_detail">
          <span>用户姓名 : </span><span class="content" id="userName"> </span><br/><br/>
          <span>真实姓名 : </span><span class="content" id="realName"> </span><br/><br/>
          <span>用户性别 : </span><span class="content" id="sex"> </span><br/><br/>

          <input type="button" id="info_edit" value="保存修改"/>
        </div>
    </div>
</div>
<div style="position:relative; top:20px;">

</div>
</body>
</html>