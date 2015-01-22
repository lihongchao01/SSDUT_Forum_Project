package cn.com.ssdut.forum.common;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;



public class MessageSourcePart {
	
	private static final Log logger = LogFactory.getLog(MessageSourcePart.class);
	
	private MessageSource messageSource = null;
	private String[] basenames = null;
	
	private static Set<String> _basenames = new HashSet<String>();
	
	/**
	 * 获取当前类加载器中配置的资源文件基本名称
	 * @return
	 */
	public static String[] getBasenames(){
		synchronized (_basenames) {
			return _basenames.toArray(new String[0]);
		}
	}
	
	//不知道谁先注入，稳妥点
	public synchronized void setBasenames(String[] basenames){
		if (basenames != null) {
			this.basenames = new String[basenames.length];
			for (int i = 0; i < basenames.length; i++) {
				String basename = basenames[i];
				if(null == basename ||"".equals(basename)){
					logger.warn("i18n message config basename is empty.");
				}else{
					this.basenames[i] = basename.trim();
				}
			}
		}else {
			this.basenames = new String[0];
		}
		synchronized (_basenames) {
			for(int i = 0; i < basenames.length; i++){
				_basenames.add(basenames[i]);
			}
		}
		if(this.messageSource != null){
			mergedMessageSourceBasenames();
		}
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
		if(this.basenames != null){
			mergedMessageSourceBasenames();
		}
	}
	
	protected void mergedMessageSourceBasenames () {
		synchronized (_basenames) {
			if(this.messageSource instanceof ReloadableResourceBundleMessageSource){
				ReloadableResourceBundleMessageSource rrbm = (ReloadableResourceBundleMessageSource) this.messageSource;
				rrbm.setBasenames(_basenames.toArray(new String[0]));
			}else if(this.messageSource instanceof ResourceBundleMessageSource){
				ResourceBundleMessageSource rbm = (ResourceBundleMessageSource) this.messageSource;
				rbm.setBasenames(_basenames.toArray(new String[0]));
			}
		}
	}
}
