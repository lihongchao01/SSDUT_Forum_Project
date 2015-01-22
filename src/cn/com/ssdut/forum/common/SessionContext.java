package cn.com.ssdut.forum.common;

import java.util.*;

import javax.servlet.http.*;

public class SessionContext {

	public static void injectUserId(Map<String, Object> value, HttpSession session) {
		Object user_id = session.getAttribute(Constant.SESSION_KEY_USER_ID);
		if (user_id != null) {
			value.put("user_id", user_id);
		}
	}

	public static void injectUserId(Map<String, Object> value, HttpServletRequest request) {
		injectUserId(value, request.getSession());
	}

	public static String getUserId(HttpSession session) {
		return (String) session.getAttribute(Constant.SESSION_KEY_USER_ID);

	}

	public static String getUserId(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(Constant.SESSION_KEY_USER_ID);

	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getUser(HttpSession session) {
		return (Map<String,Object>) session.getAttribute(Constant.SESSION_KEY_USER);

	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getUser(HttpServletRequest request) {
		return (Map<String,Object>) request.getSession().getAttribute(Constant.SESSION_KEY_USER);

	}
	
}
