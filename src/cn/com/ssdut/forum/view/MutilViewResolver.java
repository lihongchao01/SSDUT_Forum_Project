package cn.com.ssdut.forum.view;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * 多视图解析器;
 * 解决Spring的多视图集成配置中的问题：
 * 先查找视图再进行类型匹配顺序;
 * VelocityViewResolver 找不到指定视图会记录一条ERROR日志;
 * 
 * @author chenr
 * @version 2.0.1, 2011-7-5
 * 
 * @ses {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver}
 */
public class MutilViewResolver extends WebApplicationObjectSupport implements ViewResolver, Ordered {

	private static final Log logger = LogFactory.getLog(MutilViewResolver.class);
	
	private ConcurrentMap<String, MediaType> mediaTypes = new ConcurrentHashMap<String, MediaType>();

	private static final String ACCEPT_HEADER = "Accept";

	private int order = Ordered.HIGHEST_PRECEDENCE;

	private boolean favorParameter = false;

	private String parameterName = "format";

	private boolean ignoreAcceptHeader = false;

	private MediaType defaultContentType;
	
	
	/**
	 * 设置文件后缀到媒体类型的映射关系
	 * @param mediaTypes Map&lt;后缀字符串, 媒体类型字符串&gt;
	 * 
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setMediaTypes(Map)}
	 */
	public void setMediaTypes(Map<String, String> mediaTypes) {
		Assert.notNull(mediaTypes, "'mediaTypes' must not be null");
		for (Map.Entry<String, String> entry : mediaTypes.entrySet()) {
			String extension = entry.getKey().toLowerCase(Locale.ENGLISH);
			MediaType mediaType = MediaType.parseMediaType(entry.getValue());
			logger.info("MediaTypes: " + mediaType + ", extension = " + extension);
			this.mediaTypes.put(extension, mediaType);
		}
	}
	
	/**
	 * 设置视图解析器映射列表
	 * @param viewResolverMappings List&lt;视图解析器映射&gt;
	 */
	public void setViewResolverMappings(
			List<ViewResolverMapping> viewResolverMappings) {
		for(ViewResolverMapping m: viewResolverMappings) {
			logger.info("supported media type: " + m.getMediaType() + ", corresponding resolver: " + m.getViewResolver().toString());
		}
	}

	/**
	 * 设置默认视图列表
	 * @param defaultViews List&lt;视图&gt;
	 * 
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setDefaultViews(List)}
	 */
	public void setDefaultViews(List<View> defaultViews) {
		for(View v: defaultViews) {
			logger.info("default views deal content type: " + v.getContentType()) ;
		}
	}

	/**
	 * 设置启动顺序
	 * @param order 整数
	 * 
	 * @see {@link org.springframework.core.Ordered}
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * 设置是否从请求参数中获取媒体类型
	 * @param favorParameter
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setFavorParameter(boolean)}
	 */
	public void setFavorParameter(boolean favorParameter) {
		this.favorParameter = favorParameter;
		logger.info("favorParameter : " + favorParameter);
	}

	/**
	 * 设置请求参数名称，此请求参数被用来获取媒体类型
	 * @param parameterName
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setParameterName(String)}
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	/**
	 * 设置在未找到对应视图的情况下是否返回HTTP406状态
	 * @param useNotAcceptableStatusCode
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setUseNotAcceptableStatusCode(boolean)}
	 */
	public void setUseNotAcceptableStatusCode(boolean useNotAcceptableStatusCode) {
	}

	/**
	 * 设置是否忽略请求头中设置的接收媒体类型
	 * @param ignoreAcceptHeader
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setIgnoreAcceptHeader(boolean)}
	 */
	public void setIgnoreAcceptHeader(boolean ignoreAcceptHeader) {
		this.ignoreAcceptHeader = ignoreAcceptHeader;
	}

	/**
	 * 设置默认的媒体类型
	 * @param defaultContentType
	 * @see {@link org.springframework.web.servlet.view.ContentNegotiatingViewResolver#setDefaultContentType(MediaType)}
	 */
	public void setDefaultContentType(MediaType defaultContentType) {
		this.defaultContentType = defaultContentType;
	}

public View resolveViewName(String viewName, Locale locale)	throws Exception {
		
		View view = null;
		if ("jsonView".equals(viewName)) {
			return (View) getApplicationContext().getBean("jsonView");
		}

		// 先看看是否有format参数，
		RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) attrs).getRequest();
		String format = (String) request.getParameter(parameterName);
		

		if (format != null && format.length() > 0) {
			if ("json".equals(format)) {
				System.out.println("json  view!!!!!!!!!!!!!!!!!!!!!!!!");
				return (View) getApplicationContext().getBean("jsonView");
			} else if ("download".equals(format)) {
				System.out.println("download  view!!!!!!!!!!!!!!!!!!!!!!!!");
				return (View) getApplicationContext().getBean("downloadView");
			} else if ("xml".equals(format)) {
				System.out.println("xnl  view!!!!!!!!!!!!!!!!!!!!!!!!");
				return (View) getApplicationContext().getBean("xmlView");
			} else if ("excel".equals(format)) {
				return (View) getApplicationContext().getBean("excelView");
			}
		}
		
		 // 先使用jsp解析，如果没有则使用velocity
		if(viewName.equals("common/data")) {
			return (View) getApplicationContext().getBean("jsonView");
		}
		
		ViewResolver velocityViewResolver = (ViewResolver) getApplicationContext().getBean("velocityViewResolver");
		view = velocityViewResolver.resolveViewName(viewName,locale);
		if (view != null) {
			return view;
		}
	
		return NOT_ACCEPTABLE_VIEW;

	}
	
	/**
	 * 从请求参数中获取媒体类型
	 * @param request
	 * @return
	 */
	protected List<MediaType> getMediaTypes(HttpServletRequest request) {
		if (this.favorParameter) {
			if (request.getParameter(this.parameterName) != null) {
				String parameterValue = request.getParameter(this.parameterName);
				MediaType mediaType = getMediaTypeFromParameter(parameterValue);
				if (mediaType != null) {
					if (logger.isDebugEnabled()) {
						logger.debug("Requested media type is '" + mediaType + "' (based on parameter '" +
								this.parameterName + "'='" + parameterValue + "')");
					}
					return Collections.singletonList(mediaType);
				}
			}
		}
		if (!this.ignoreAcceptHeader) {
			String acceptHeader = request.getHeader(ACCEPT_HEADER);
			if (StringUtils.hasText(acceptHeader)) {
				List<MediaType> mediaTypes = MediaType.parseMediaTypes(acceptHeader);
				MediaType.sortByQualityValue(mediaTypes);
				if (logger.isDebugEnabled()) {
					logger.debug("Requested media types are " + mediaTypes + " (based on Accept header)");
				}
				return mediaTypes;
			}
		}
		if (this.defaultContentType != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Requested media types is " + this.defaultContentType +
						" (based on defaultContentType property)");
			}
			return Collections.singletonList(this.defaultContentType);
		}
		else {
			return Collections.emptyList();
		}
	}
	
	
	protected MediaType getMediaTypeFromParameter(String parameterValue) {
		return this.mediaTypes.get(parameterValue.toLowerCase(Locale.ENGLISH));
	}

	public int getOrder() {
		return this.order;
	}
	
	private static final View NOT_ACCEPTABLE_VIEW = new View() {

		public String getContentType() {
			return null;
		}

		public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	};
}
