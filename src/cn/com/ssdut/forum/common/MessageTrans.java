package cn.com.ssdut.forum.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class MessageTrans extends AcceptHeaderLocaleResolver{
	private Locale myLocal;
	public Locale resolveLocale(HttpServletRequest request) {
		if(null == request.getParameter("locale"))
			myLocal = new Locale("zh_CN");
		else
    		myLocal = new Locale(request.getParameter("locale"));
	    return myLocal;
	}
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
	    locale = new Locale(request.getParameter("locale"));
	    myLocal = locale;
	}
}
