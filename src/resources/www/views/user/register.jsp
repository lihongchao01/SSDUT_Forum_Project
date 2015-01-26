<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${ctx}/css/common/user_center.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var reg = /(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}/;
	$("#register_submit2").click(function(){
		var userName = $('#userName').val();
		var userPwd = $('#userPwd').val();
		var repassword = $('#repassword').val();
		var realName = $('#realName').val();
		
		if(""==userName)
			alert("用户名不能为空！");
		else if(!reg.test(userPwd) || userPwd.length>20)
			alert("密码必须为8-20位，由数字、字母、下划线中至少两种组成！");
		else if(userPwd!=repassword)
			alert("密码与确认密码不一致");
		else {
			$.ajax({
	            type : "post",
	            url  : "register",
	            data : {'userName':userName,'userPwd':userPwd,'repassword':repassword,'realName':realName},
	            dataType: "json",
	            success: function(data){
	            	if(data.result=="success"){
	            		alert("您已成功注册!");
	            		jcl.go('/SSDUT_Forum/user_infoview');
	            	}
	            	else if(data.result=="different"){
	            		alert("两次输入的密码不相同，请重新输入");
	            	}
	            	else if(data.result=="empty"){
	            		alert("用户名或密码不能为空");
	            	}
	            	else if(data.result=="exist"){
	            		alert("用户名已存在 ");
	            	}
	            }
	        }); 
		}
	
   });
})
</script>
</head>
<body>

  
  <div class="register">
    <span class="register_tip">用户注册</span>
    <div class="register_form">
      <span>用户账号 : </span>
      <input type="text" name="userName" id="userName" value="" /><br/><br/>
      <span>登陆密码 : </span>
      <input type="password" name="repassword" id="repassword" value="" /><br/><br/>
      <span>重复密码 : </span>
      <input type="password" name="userPwd" id="userPwd" value="" /><br/><br/>
      <span>真实姓名 : </span>
      <input type="text" name="realName" id="realName" value="" /><br/><br/>
      <input type="button" id="register_submit2" value="submit" />
    </div>
  </div>

</body>
</html>