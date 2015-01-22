/**
 * 
 */
$(document).ready(function(){

	
	$("#nav2").mouseover(function(){
		$("#nav2_hidden").css("display","block");
		$("#nav3_hidden").css("display","none");
		$("#nav4_hidden").css("display","none");
		$("#nav5_hidden").css("display","none");
	});
	$("#nav3").mouseover(function(){
		$("#nav3_hidden").css("display","block");
		$("#nav2_hidden").css("display","none");
		$("#nav4_hidden").css("display","none");
		$("#nav5_hidden").css("display","none");
	});
	$("#nav4").mouseover(function(){
		$("#nav4_hidden").css("display","block");
		$("#nav2_hidden").css("display","none");
		$("#nav3_hidden").css("display","none");
		$("#nav5_hidden").css("display","none");
	});
	$("#nav5").mouseover(function(){
		$("#nav5_hidden").css("display","block");
		$("#nav2_hidden").css("display","none");
		$("#nav3_hidden").css("display","none");
		$("#nav4_hidden").css("display","none");
	});

	$(".nav").mouseleave(function(){
		$("#nav2_hidden").css("display","none");
		$("#nav3_hidden").css("display","none");
		$("#nav4_hidden").css("display","none");
		$("#nav5_hidden").css("display","none");
	});
	
	$("#login_submit").click(function(){
		var user_name = $("#user_name").val();
		var password = $("#password").val();
		var pattern = /^\w+$/;
		if(user_name.length<6 || user_name.length>20 || !user_name.match(pattern))
		{
			alert("用户名输入不合法");
			return;
		}
		else if(password.length<6 || password.length>20 || !password.match(pattern))
		{
			alert("密码格式输入不合法");
			return;
		}
		else{
			$.ajax({
	            type: "POST",
	            url: "/Dream_Art_Club_Web_Project/login",
	            data: $("#login_form").serialize(),
	            dataType: "json",
	            success: function(data){
	            	if(data.result.result=='success'){
	            		var username = data.result.user_name;
	            		$("#user").html(username);
	            		$("#login_div").css("display","none");
	            		$("#welcome").css("display","block");
	            	}
	            	else{
	            		alert('用户名或密码错误！请重新登录');
	            	}
	            }
	        });
		}
		
	});
	
	$("#logout").click(function(){
		$.ajax({
			type: "POST",
			url: "/Dream_Art_Club_Web_Project/logout",
			data: {},
			dataType: "json",
			success :function(data){
				$("#login_div").css("display","block");
        		$("#welcome").css("display","none");
			}
		});
	});
	
	$.ajax({
	    type: "POST",
	    url: "/Dream_Art_Club_Web_Project/user/operate/isUserLogin",
	    data: {},
	    dataType: "json",
	    success: function(data){
        	if(data.result.result=='success'){
        		var username = data.result.user_name;
        		$("#user").html(username);
        		$("#login_div").css("display","none");
        		$("#welcome").css("display","block");
        	}
        }
	});
});