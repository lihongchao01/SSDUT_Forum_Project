package cn.com.ssdut.forum.exception;

/**
 * 基础运行时异常
 * 
 */
public class BaseRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 1431341934573539432L;

	/**
	 * 实例化一个基础运行时异常
	 * @param msg 异常消息
	 */
	public BaseRuntimeException(String msg) {
		super(msg);
	}
	
	/**
	 * 实例化一个基础运行时异常
	 * @param cause 异常
	 */
	public BaseRuntimeException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 实例化一个基础运行时异常
	 * @param msg 异常消息
	 * @param cause 异常
	 */
	public BaseRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
