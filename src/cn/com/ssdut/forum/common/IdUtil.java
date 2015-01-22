
package cn.com.ssdut.forum.common;

import java.util.UUID;

/**
 * 主键操作工具
 * 
 */
public class IdUtil {

	/**
	 * 产生一个不含分隔符的32位长度字符串
	 * @return 字符串
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}
