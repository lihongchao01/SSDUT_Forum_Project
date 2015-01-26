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
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
	    url : "getUserInfoDetail",
	    type : "post",
	    dataType : "json",
	    data : {},
	    success : function(data) {
	    	document.getElementById("userName").innerHTML = data.row.USERNAME;
	    	document.getElementById("realName").innerHTML = data.row.REALNAME;
	    	document.getElementById("sex").innerHTML = data.row.SEX;
	    	document.getElementById("age").innerHTML = data.row.AGE;
	    	
	    }
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
        <div class="info_detail">
          <span>用户姓名 : </span><span class="content" id="userName"> </span><br/><br/>
          <span>真实姓名 : </span><span class="content" id="realName"> </span><br/><br/>
          <span>用户性别 : </span><span class="content" id="sex"> </span><br/><br/>
          <span>用户年龄 : </span><span class="content" id="age"> </span><br/><br/>
         
          <a href="/SSDUT_Forum/userInfoEdit" id="info_edit" style="display:block; width:125px; height:35px; line-height:35px; text-align:center;">修改信息</a>
        </div>
    </div>
</div>
<div style="position:relative; top:20px;">
</div>
</body>
</html>