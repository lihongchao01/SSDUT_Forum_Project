package cn.com.ssdut.forum.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.com.ssdut.forum.view.Model;

/**
 * Controller层的异常处理类
 * @see org.springframework.web.servlet.HandlerExceptionResolver
 * 
 */
public class ControllerHandlerExceptionResolver implements HandlerExceptionResolver {

	private static final Log logger = LogFactory.getLog(ControllerHandlerExceptionResolver.class);
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
//		String contentType = request.getContentType();
		if(logger.isDebugEnabled())
			logger.debug("contentType: "+ request.getContentType());
		Model model = new Model();
		model.addError(ex + ": " + ex.getMessage());
		//打印更多信息,帮助定位错误
		String msg = "uri: "+request.getRequestURI();
		msg = msg + ", handler: "+handler;
		logger.error(msg, ex);
		return model;
	}

}
