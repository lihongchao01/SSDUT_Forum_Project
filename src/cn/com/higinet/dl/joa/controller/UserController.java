package cn.com.higinet.dl.joa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.higinet.dl.joa.common.SendMail;
import cn.com.higinet.dl.joa.service.UserService;
import cn.com.higinet.dl.joa.view.Model;

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
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getLoginView(){
		return "/user/login";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String getRegisterView(){
		return "/user/register";
	}
	@RequestMapping(value="/userinfoview",method=RequestMethod.GET)
	public String getUserInfoView(){
		return "/user/userinfo";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Model login(@RequestParam Map<String, Object> reqs,HttpSession session) {
		Model model = new Model();
		String userName = reqs.get("userName").toString();
		String userPwd = reqs.get("userPwd").toString();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("userPwd", userPwd);
		if (!userName.equals("") && !userPwd.equals("")) 
		{
			if (userService.user_login(map)) 
			{
				session.setAttribute("userName", userName);
				
				model.set("result", "success");
				
			} 
			else {
				model.set("result", "error");
			}
		} 
		else 
		{
			model.set("result", "null");
		}
		return model;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Model rigister(@RequestParam Map<String, Object> map) throws MessagingException{
		Model model=new Model();
		String userName=map.get("userName").toString();
		String userPwd=map.get("userPwd").toString();
		String repassword=map.get("repassword").toString();
		if(!userName.equals("")&&!userPwd.equals("")&&!repassword.equals(""))
		{
			if(!userService.user_register_samenametest(map)){
				if(userPwd.equals(repassword)){
					
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
	@RequestMapping(value="/userInfo",method=RequestMethod.POST)
	public Model getUserInfo(@RequestParam Map<String, Object> map,HttpSession session){
		Model model =new Model();
		 String userName= session.getAttribute("userName").toString();
		 map.put("userName", userName);
		 model.setRow(userService.getUserInfo(map));
		 return model;
		 
	}
}