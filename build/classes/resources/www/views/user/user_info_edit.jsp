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
	    data : {
	    	userId : $("#userId").val()
	    },
	    success : function(data) {
	    
	    	document.getElementById("userName").innerHTML = data.row.USERNAME;
	    	document.getElementById("realName").data = data.row.REALNAME;
	    }
	});
	
	$("#info_edit").click(function(){
		var userPwd = $("#userPwd").val();
		var realName = $("#realName").val();
		$.ajax({
			url : "userInfoSave",
			type : "post",
			dataType : "json",
			data : {"userPwd":userPwd,"realName":realName,userId : $("#userId").val()},
			success : function(data){
				if(data.result == "success") {
					alert("信息保存成功!");
					jcl.go("/SSDUT_Forum/userinfoview");
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
		   
		<input type="hidden" id="userId" value="<%=(String)request.getAttribute("userId")%>">
		
        <span style="font-size:20px; color:#018079"><u>个人基本信息</u></span><br/><br/>
    
       
           	<span>用户名 : </span><span class ="content" id="userName"></span><br/><br/>
           	
            <span>密码 : </span>
      		<input type="password" name="userPwd" id="userPwd"  /><br/><br/>
       		
       		<span>真实姓名 : </span>
      		<input type="text" name="realName" id="realName"  /><br/><br/>
      		      		
          <input type="button" id="info_edit" value="保存修改"/>
          
        </div>

<div style="position:relative; top:20px;">
<%-- <input type="hidden" id="userId" name="userId" value=<%=request.getParameter("userId")%>> --%>
</div>
</body>
</html>