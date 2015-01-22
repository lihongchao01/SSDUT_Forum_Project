package cn.com.ssdut.forum.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import cn.com.ssdut.forum.common.Constant;
import cn.com.ssdut.forum.service.SysService;
import cn.com.ssdut.forum.service.UserService;
import cn.com.ssdut.forum.view.Model;


/**
 * 系统主控制类
 */
@Controller("sysController")
public class SysController {
	@Autowired  
    private LocaleResolver localeResolver; 
	@Autowired
	private SysService sysService;
      
	//语言类型转换
    @RequestMapping("/changeLang")  
    public String changeLocal(HttpServletRequest request, HttpServletResponse response){ 
    	String locale = request.getParameter("locale").toString();
        Locale l = new Locale(locale);  
        localeResolver.setLocale(request, response, l);  
        return "others/main";  
    }   

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getMain(){
		return "others/main";
	}


	@Autowired
	private UserService userService;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Model login(@RequestParam Map<String, Object> reqs, HttpSession session){
		Model model = new Model();
		if(!reqs.containsKey("user_name") || !reqs.containsKey("password")){
			model.set("error", "请输入正确的用户名和密码！");
		}
		else {
			Map<String, Object> result = sysService.login(reqs);
			if(result.get("result").toString() == "success"){
				session.setAttribute(Constant.SESSION_KEY_USER_ID, result.get("user_id").toString());
				session.setAttribute(Constant.SESSION_KEY_USER_NAME, result.get("user_name").toString());
			}
			model.set("result", result);
		}
		return model;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public Model logout(HttpSession session){
		Model model = new Model();
		if(null != session.getAttribute("user_id")){
			session.removeAttribute("user_id");
			session.removeAttribute("user_name");
		}
		return model;
	}
}
