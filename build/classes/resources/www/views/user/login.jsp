<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link href="${ctx}/css/common/login.css" rel="stylesheet" type="text/css">
<link href="${ctx}/css/common/bootstrap.css" rel="stylesheet" type="text/css">

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
<body style="background-image:url(${ctx}/images/backn.jpg); background-repeat:no-repeat;"></body>
	<div class="container" >

<div class="top" >
 <h1 class="h6">ssduToipc</h1>
</div>
<div class="frame" style="background-image:url(${ctx}/images/login.png)">
<%-- <img  class="logo"  src="${ctx}/images/登陆框.png"> --%>
<div class="apDiv1" >
 <ul >

			<li class="mb_10"><span class="l_tit">ID  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>
			  <input type="text" class="login_input user_icon" name="userName" id="userName">
			</li>
			<li class="mb_10"></li>
            <li class="mb_10"></li>
 </ul>
 <ul >
   <li class="mb_10" ><span  class="l_tit">PassWord</span><input type="password" class="login_input user_icon" name="userName" id="userPwd">
     &nbsp;</li>
   <li class="mb_10" ></li>
   <li class="mb_10" >&nbsp;     
     
     <button  class="btn  btn-primary" id="login_submit">登陆</button>   <button  class="btn  btn-primary" id="register_submit">注册</button> 
   </li>
   
   
   
 </ul>
</div>
        <div class="Login">
          
         
        
        </div>

</div>

</div>
	
</body>
</html>