package cn.com.higinet.dl.joa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String returnloginView(){
		return "/user/login";
	}
	@RequestMapping(value="/userinfoview",method=RequestMethod.GET)
	public String getUserInfoView(){
		return "/user/user_list";
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
		 String userId= (String)map.get("userId");

		 map.put("userId", userId);
		 
		 model.setRow(userService.getUserInfo(map));
		 return model;
		 
	}
	/**修改后保存用户信息
	 * 
	 * @param reqs
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/userInfoSave", method=RequestMethod.POST)
	public Model userInfoSave(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		Model model = new Model();
		String userId = reqs.get("userId").toString();
		Map<String, Object> conds = new HashMap<String, Object>();
		String realName = reqs.get("realName").toString();
		String userPwd = reqs.get("userPwd").toString();
		conds.put("userId", userId);
		reqs.put("realName", realName);
		reqs.put("userPwd", userPwd);
		model.set("result", userService.userInfoSave(reqs, conds));
		return model;
	}
	@RequestMapping(value="/user_info_edit",method=RequestMethod.GET)
	public String getUserinfoeditview(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");

		System.out.println("111userId : " + userId);
		
		request.setAttribute("userId", userId);
		
		return "/user/user_info_edit";
	}
	
	@RequestMapping(value="/getUserInfoDetail", method=RequestMethod.POST)
	public Model getUserInfoDetail(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		Model model = new Model();
		model.setRow(userService.getUserInfoDetail(reqs));
		return model; 
	}
	
	/*@RequestMapping(value="/getUserInfoDetail", method=RequestMethod.POST)
	public Model getUserInfoDetail(@RequestParam Map<String, Object> reqs) {
		System.out.println("userId");
		Model model = new Model();
		
		String userId = reqs.get("userId").toString();
		//System.out.println("userId");
		reqs.put("userId", userId);
		model.setRow(userService.getUserInfoDetail(reqs));
		return model;
	}*/
	
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	public Model addressDelete(@RequestParam Map<String, Object> reqs, HttpSession session) {
		Model model = new Model();
		
	    String userName = session.getAttribute("userName").toString();
	    String userId = userService.getUserIdByUsername(userName);
	    reqs.put("userId", userId);
		String result = userService.deleteUser(reqs);
		model.set("result", result);
		return model;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/getAllUser", method=RequestMethod.POST)
	public void getAllUser(@RequestParam Map<String, Object> reqs, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String userName = session.getAttribute("userName").toString();
		int userType =  userService.getUserType(userService.getUserIdByUsername(userName).toString());
		Map pageInfo = new HashMap();  
        pageInfo.put("page", 1);  
        pageInfo.put("total", 5); 
		String jsonStr = getJsonString(userService.getAllUser(userType), pageInfo);
		response.setContentType("html/txt");  
        response.setCharacterEncoding("utf-8");  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache, must-revalidate");  
        response.setHeader("Pragma", "no-cache");  
        response.getWriter().write(jsonStr); 
        response.getWriter().flush(); 
        response.getWriter().close();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })  
    private String getJsonString(List list, Map pageInfo) {  
		  List mapList = new ArrayList();  
	        for(int i = 0; i < list.size(); i++) {  
	        	Map<String, Object> map = (Map<String, Object>) list.get(i);
	        	
	            Map cellMap = new HashMap();  
	            cellMap.put("id", map.get("userId"));  
	            cellMap.put("cell", new Object[] {map.get("userName"), map.get("userPwd"), 
	            		map.get("realName") });     
	            mapList.add(cellMap);  
	        }  
	        pageInfo.put("rows", mapList);  
	        JSONObject object = new JSONObject();
	        object.putAll(pageInfo);
	        return object.toString();  
	}

}
