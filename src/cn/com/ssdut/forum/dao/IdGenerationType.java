package cn.com.ssdut.forum.dao;

/**
 * 主键生成类型枚举
 * 
 */
public enum IdGenerationType {

	/**
	 * 使用数据库内置机制自动生成主键
	 */
	AUTO,
	
	/**
	 * 手动指定
	 */
	ASSIGN,
	
	/**
	 *  使用32位16进制字符串，无中划线分隔符 的UUID作为主键
	 */
	UUID,
	
	/**
	 *  数据库序列，各数据库不一致
	 */
	SEQUENCE
}
