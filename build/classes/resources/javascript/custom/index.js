/**
 * 
 */
$(document).ready(function(){
	
	$.ajax({
	    type: "POST",
	    url: "/Dream_Art_Club_Web_Project/news/operate/getMain",
	    data: {},
	    dataType: "json",
	    success: function(data){
	    	for(var i=0;i<4;i++){
	    	    $(".news_list")[i].innerHTML=data.list[i].news_title;
	    	    $(".news_list")[i].href=data.list[i].link;
	    	}
        }
	});
	
	$.ajax({
	    type: "POST",
	    url: "/Dream_Art_Club_Web_Project/message/operate/getMain",
	    data: {},
	    dataType: "json",
	    success: function(data){
	    	for(var i=0;i<4;i++){
	    	    $(".message_list")[i].innerHTML=data.list[i].message_title;
	    	    $(".message_list")[i].href="message/operate/getOneMessage?message_id="+data.list[i].message_id;
	    	}
        }
	});
	
	$.ajax({
	    type: "POST",
	    url: "/Dream_Art_Club_Web_Project/serve/operate/getMainCourcesServe",
	    data: {},
	    dataType: "json",
	    success: function(data){
	    	for(var i=0;i<4;i++){
	    	    $(".course_list")[i].innerHTML=data.list[i].service_name;
	    	    $(".course_list")[i].href="serve/operate/getOneCourseServer?service_id="+data.list[i].service_id;
	    	}
        }
	});
	
	$.ajax({
	    type: "POST",
	    url: "/Dream_Art_Club_Web_Project/serve/operate/getMainExperienceServe",
	    data: {},
	    dataType: "json",
	    success: function(data){
	    	for(var i=0;i<4;i++){
	    	    $(".experience_list")[i].innerHTML=data.list[i].article_name;
	    	    $(".experience_list")[i].href="serve/operate/getOneExperienceServer?service_id="+data.list[i].article_id;
	    	}
        }
	});
	
	
});