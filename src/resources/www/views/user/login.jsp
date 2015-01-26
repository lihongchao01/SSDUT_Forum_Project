<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#login_submit').click(function(){
		 var userName = $('#userName').val();
		 var userPwd = $('#userPwd').val();
		
		   	 $.ajax({
		            type : "POST",
		            url  : "login",
		            data : {"userName":userName,"userPwd":userPwd},
		            dataType: "json",
		            success:function(data){
		            	if(data.result=="success"){
		            		 jcl.go("/SSDUT_Forum/userinfoview"); 
		            		/* alert("登陆成功 "); */
		            	}else if(data.result=="error"){
		            		alert("用户名或密码错误");
		            	}else if(data.result=="null"){
		            		alert("用户名或密码为空");
		            	}
		            }
		     }); 
		 
	   });
	$('#register_submit').click(function(){
		  jcl.go("/SSDUT_Forum/register"); 
	   });
});
</script>
</head>
<body>	
	<div class="login_form" >
      <span>账号 : </span>
      <input type="text" name="userName" id="userName"  /><br/><br/>
      <span>密码 : </span>
      <input type="password" name="userPwd" id="userPwd"/><br/><br/>
      <input type="button" value="登陆" id="login_submit"/>
      <input type="button" value="注册" id="register_submit"/>
    </div>

</body>
</html>