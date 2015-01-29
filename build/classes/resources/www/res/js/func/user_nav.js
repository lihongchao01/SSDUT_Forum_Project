// JavaScript Document
$(function(){
		
		$('#ui_indexTabDeal_01 #xianxia li a').hover(function(){
			TabSelect("#ui_indexTabDeal_01 #xianxia li a", ".xianxiaCom", "slc", $(this))
		});
		$('#ui_indexTabDeal_01 #xianxia li a').eq(0).trigger("mouseover");
		
		
		
		$('#LiangshenInfo .shipinTab .tvBtn a').click(function(){
			TabSelect("#LiangshenInfo .shipinTab .tvBtn a", ".LiangshenInfoCom", "select", $(this))
		});
		$('#LiangshenInfo .shipinTab .tvBtn a').eq(0).trigger("click");
		
		
		

		function TabSelect(tab,con,addClass,obj){
			var $_self = obj;
			var $_nav = $(tab);
			$_nav.removeClass(addClass),
			$_self.addClass(addClass);
			var $_index = $_nav.index($_self);
			var $_con = $(con);
			$_con.hide(),
			$_con.eq($_index).show();
		}})





// <![CDATA[
	function changemenu(ele){
		var ul=ele.parentNode.getElementsByTagName("ul")[0];
		if(ul.style.display=="none"){
			ul.style.display="";
			ele.getElementsByTagName("img")[0].src="http://www.gimiwear.com:80/images/biz_left_sw_on.gif";
		}else{
			ul.style.display="none";	
			ele.getElementsByTagName("img")[0].src="http://www.gimiwear.com:80/images/biz_left_sw_off.gif";	
		}
	}	
	// ]]>



$(function(){
		   
	$('.list02 tbody>tr:odd').addClass('odd')
	$('.list02 tbody>tr:even').addClass('even')	
	
});


$(function() {
    		   
	$("#dingdanshuoming_id #winClose_qx").click(function(){
		$("#dingdanshuoming_id #dialog_shezi").hide()
	})
	$("#dingdanshuoming_id #winClose").click(function(){
		$("#dingdanshuoming_id #dialog_shezi").hide()
	})
});
function show_dingdanshuoming() {
	$("#dingdanshuoming_id #dialog_shezi").show();
}

function show(x) {
	$(x).show();
}


$(document).ready(function(){
	$(".tixingBox001 > div:first").show();
	$(".choosetixingBox001 li").each(function(index){
		$(this).click(function(){
			addrssid = $(this).attr("id");
			id = addrssid.replace('jian','');
			if($("#jianbu"+id).attr("checked")) {
				$(".choosetixingBox001 li").removeClass('cur');
				$("#jian"+id).addClass('cur');
				$(".tixingBox001 > div:visible").hide();
				$(".tixingBox001 > div:eq(" + index + ")").show();	
			}
		});
	});											
});



$(document).ready(function(){
	$(".tixingBox002 > div:first").show();
	$(".choosetixingBox002 li").each(function(index){
		$(this).click(function(){
			addrssid = $(this).attr("id");
			id = addrssid.replace('xiong','');
			if($("#xiongbu"+id).attr("checked")) {
				$(".choosetixingBox002 li").removeClass('cur');
				$("#xiong"+id).addClass('cur');
				$(".tixingBox002 > div:visible").hide();
				$(".tixingBox002 > div:eq(" + index + ")").show();	
			}
		});
	});											
});


$(document).ready(function(){
	$(".tixingBox003 > div:first").show();
	$(".choosetixingBox003 li").each(function(index){
		$(this).click(function(){
			addrssid = $(this).attr("id");
			id = addrssid.replace('fu','');
			if($("#fubu"+id).attr("checked")) {
				$(".choosetixingBox003 li").removeClass('cur');
				$("#fu"+id).addClass('cur');
				$(".tixingBox003 > div:visible").hide();
				$(".tixingBox003 > div:eq(" + index + ")").show();	
			}
		});
	});											
});




$(document).ready(function(){
	$(".tixingBox004 > div:first").show();
	$(".choosetixingBox004 li").each(function(index){
		$(this).click(function(){
			addrssid = $(this).attr("id");
			id = addrssid.replace('bei','');
			if($("#beibu"+id).attr("checked")) {
				$(".choosetixingBox004 li").removeClass('cur');
				$("#bei"+id).addClass('cur');
				$(".tixingBox004 > div:visible").hide();
				$(".tixingBox004 > div:eq(" + index + ")").show();	
			}
		});
	});											
});






