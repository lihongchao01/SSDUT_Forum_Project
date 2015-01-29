package cn.com.higinet.dl.joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getMain(){
		//return "user/account_info";
		return "main/index";
		//return "user/order/cert";
	}
	
	@RequestMapping(value="/main")
	public String getMainView(){
		return "main/index";
	}
	
	
	
}