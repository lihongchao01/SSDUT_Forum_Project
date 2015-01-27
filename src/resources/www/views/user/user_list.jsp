<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"  scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
</style>
<link href="${ctx}/css/common/flexigrid.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="${ctx}/js/common/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="${ctx}/js/common/jcl.js"></script>
<script type="text/javascript" src="${ctx}/js/common/flexigrid.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		
      $(function(){
		$("#user_list").flexigrid({  
			width: 680,
			height: 250,
			singleSelect : true,
	        url: "getAllUser",
	        dataType: 'json',  
	        colModel : [  
	                {display:"用户名", name:"userName", width:70, sortable:false, align:'center'}, 
	                {display:"密码", name:"userPwd", width:85, sortable:false, align:'center'}, 
	                {display:"真实姓名", name:"realName", width:165, sortable:false, align:'center'},  
	               
	                
	        ],  
	        buttons : [  
	            {name: '添加用户', bclass: 'add', onpress :toolbar},  
	            {separator: true},
	            {name: '修改用户信息', bclass: 'modify', onpress :toolbar}, 
	            {separator: true},
	            {name: '删除用户', bclass: 'delete', onpress : toolbar}, 
	        ],  
	          
	        errormsg: '发生异常',  
	        sortname: "register_time",  
	        sortorder: "desc",  
	        usepager: false,  
	        title: '用户列表', 
	        useRp: true,  
	        rp: 10,  
	        rpOptions: [10, 15, 20], //可选择设定的每页结果数  
	        nomsg: '没有符合条件的记录存在',  
	        minColToggle: 1, //允许显示的最小列数  
	        showTableToggleBtn: true,  
	        autoload: true, //自动加载，即第一次发起ajax请求  
	        resizable: false, //table是否可伸缩  
	        procmsg: '加载中, 请稍等 ...',  
	        hideOnSubmit: true, //是否在回调时显示遮盖  
	        blockOpacity: 0.5,//透明度设置  
	        rowbinddata: true,  
	        showcheckbox: true,
	        checkbox:true,
	        autoScroll:true
	        //gridClass: "bbit-grid"//样式  
	    }); 
		
		function toolbar(com,grid){
			if(com == '添加用户')
    			jcl.go('/SSDUT_Forum/addUser');
			else if(com == '删除用户') {
    			if($('.trSelected',grid).length == 0)
    				alert('请选择要删除的数据');
    			else {
    				if(confirm('是否删除这 ' + $('.trSelected',grid).length + ' 条记录吗?')){
                        var id = $('.trSelected', grid).attr("id").replace("row","");
                       
                        $.ajax({
                			type : 'post',
                			url : "delete",
                			data : {'userId':id},
                			dataType : 'json',
                			success : function(data){
                			    if(data.result=='success'){
                			  
                			    	alert('已成功删除用户!');
                			    	
                			    	jcl.go('/SSDUT_Forum/userinfoview');
                			    }
                			    else {
                			
                			    	alert('操作失败,请稍后再试!');
                			    }
                			}
                		});
    				}
    			}
			}
			else if(com == '修改用户信息') {
    			if($('.trSelected',grid).length == 0)
    				alert('请选择要修改的数据!');
    			else {
    				var id = $('.trSelected', grid).attr("id").replace("row","");
                    jcl.go('/SSDUT_Forum/user_info_edit?userId='+id);
    			}
    		}
		}
      })
});
</script>
</head>
<body>
<input type="hidden" id="userId" value=<%=request.getParameter("userId")%>>
<div id="ptable" style="margin:10px;float:left;width: 730px; font-size:18px;"> 
    <table id="user_list" style="display:none"></table> 
     
</div>
</body>
</html>