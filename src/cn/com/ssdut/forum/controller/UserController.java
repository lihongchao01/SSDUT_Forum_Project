package cn.com.ssdut.forum.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import cn.com.ssdut.forum.service.UserService;
import cn.com.ssdut.forum.common.Constant;
import cn.com.ssdut.forum.view.Model;

@Controller("userController")
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="/getUsername")
	public Model getUsername(HttpSession session) {
		Model model = new Model();
		model.set("userName", session.getAttribute("userName").toString());
		return model;
	}
	@RequestMapping(value="/main",method=RequestMethod.POST)
	public Model rigister(@RequestParam Map<String, Object> map) throws MessagingException{
		Model model=new Model();
		String userName=map.get("userName").toString();
		String userPwd=map.get("userPwd").toString();
		String repassword=map.get("repassword").toString();
		if(!userName.equals("")&&!userPwd.equals("")&&!repassword.equals(""))
		{
			if(!userService.user_register_samenametest(map)){
				if(userPwd.equals(repassword)){
					String string="注册成功";
			
					model.set("result", userService.register(map));
					}
				else {
					model.set("result", "different");
					}
				}
		    else {
				 model.set("result", "exist");
			     }
		     }
		else {
			 model.set("result", "empty");
		}
		return model;
	}

}