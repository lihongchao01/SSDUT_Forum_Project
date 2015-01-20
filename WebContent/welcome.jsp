<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("username");
	String password=request.getParameter("password");
	Date date=new Date();
	%>
	<h1>尊敬的用户<%=name %>,欢迎您的登陆</h1>
	     <h2>当前时间为<%=date %></h2>
</body>
</html>