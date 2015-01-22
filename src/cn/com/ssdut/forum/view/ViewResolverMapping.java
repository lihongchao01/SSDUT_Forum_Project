package cn.com.ssdut.forum.view;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;

/**
 * 视图解析器映射
 * @author chenr
 * @version 2.0.1, 2011-7-5
 * 
 */
public class ViewResolverMapping {

	private MediaType mediaType;
	private ViewResolver viewResolver;
	
	public MediaType getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaTypeStr) {
		this.mediaType = MediaType.parseMediaType(mediaTypeStr);
	}
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	public ViewResolver getViewResolver() {
		return viewResolver;
	}
	public void setViewResolver(ViewResolver viewResolver) {
		this.viewResolver = viewResolver;
	}
	
	
}
