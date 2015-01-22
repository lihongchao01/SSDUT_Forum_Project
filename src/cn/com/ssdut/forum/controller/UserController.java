package cn.com.ssdut.forum.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.ssdut.forum.common.Constant;
import cn.com.ssdut.forum.view.Model;

@Controller("userController")
@RequestMapping(value="/user/operate")
public class UserController{

	
	@RequestMapping(value="/isUserLogin", method=RequestMethod.POST)
	public Model isUserLogin(HttpSession session){
		Model model = new Model();
		Map<String, Object> result = new HashMap<>();
		if(null == session.getAttribute(Constant.SESSION_KEY_USER_ID) || "" == session.getAttribute(Constant.SESSION_KEY_USER_ID))
			result.put("result", "fail");
		else{
			result.put("result", "success");
			result.put(Constant.SESSION_KEY_USER_ID,session.getAttribute("userId"));
			result.put(Constant.SESSION_KEY_USER_NAME, session.getAttribute("userName"));
		}
		model.set("result", result);
		return model;
	}
}
