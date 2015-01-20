<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆</title>
</head>
<body>
		<form name="login" method="post" action="/Servlet_test1/welcome.jsp">
		用户名：<input type="text" name="username" id="username"><br/>
		密码：<input type="password" name="password" id="password">
		<input type="submit" value="提交">
		</form>
		<%
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			Map<String,String> map=new HashMap<String,String>();
			map.put("username",name);
			map.put("password", password);
			request.setAttribute("Info", map);
			
		%>
		
</body>
</html>