<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common/zhuce.css" rel="stylesheet" type="text/css">
<title>注册</title>
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#register_submit2").click(function(){
		var userName = $('#userName').val();
		var userPwd = $('#userPwd').val();
		var repassword = $('#repassword').val();
		var realName = $('#realName').val();
		$.ajax({
            type : "post",
            url  : "register",
            data : {'userName':userName,'userPwd':userPwd,'repassword':repassword,'realName':realName},
            dataType: "json",
            success: function(data){
            	if(data.result=="success"){
            		alert("注册成功");
            		jcl.go("/SSDUT_Forum/login"); 
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
	});
});

</script>
</head>
<body>
<div class="headerBar">
	<div class="logoBar login_logo">
		
			<div class=" fl">
				<a href="#"  class="logotit">SSDUTTOPIC</a>
                <img  class="logo"  src="${ctx}/images/临临临时logo.png">
			</div>
			<button class="btn  btn_login">LOGIN</button>
		
	</div>
</div>
<div class="container">
<div class="loginBox">
	<div class="login_cont">
		<ul class="login">
			
			<li class="mb_10"><span class="l_tit">账号</span><input type="text" class="login_input user_icon  form-control" name="userName" id="userName"></li>
			 
			<li class="mb_10"><span  class="l_tit">密码</span><input type="password" class="login_input user_icon	form-control" name="userPwd" id="userPwd"></li>
			
			<li class="mb_10"><span class="l_tit">确认密码</span><input type="password" class="login_input user_icon	form-control" name="repassword" id="repassword"></li>
            
            <li class="mb_10"><span class="l_tit">真实姓名</span><input type="text" class="login_input user_icon	form-control" name="realName" id="realName"></li>
			<li class="mb_10"><span class="l_tit">验证码</span><input type="text" class="login_input_1 user_icon "><img src="#"><input type="button" class="btn" value="换一张"></li>
			<label >
            <input type="checkbox" class="checkbox1" ><span class="l_tit">大连理工大学协议</span>
           </label>
            </br>
            <input type="button"  class="btn  btn-primary " value="同意协议" />
            <input type="button"  class="btn  btn-primary btn-lg btn-block" value="注册" id="register_submit2">       
         </ul>
	</div>
	
</div>
</div>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>