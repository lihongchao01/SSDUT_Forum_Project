<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息页面</title>
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	 	$.ajax({
            type : "POST",
            url  : "userInfo",
            data : {},
            dataType: "json",
            success:function(data){
            	var l="<h1>用户基本信息 ：</h1><br/><br/>"+"用户ID："+data.row.USERID+"<br/>"+"用户名："+data.row.USERNAME+"<br/>"+"密码： "+data.row.USERPWD;
				  $('#userinfo').append(l);
            }
     	}); 
		
	});

</script>
</head>
<body>
		<div id="userinfo">
		
		
		</div>
</body>
</html>