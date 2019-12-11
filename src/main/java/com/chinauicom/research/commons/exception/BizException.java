package com.chinauicom.research.commons.exception;

/**

 * @description: 统一异常处理类
 * @author zjl
 * @since 2016-7-29
 * @log:
 */
public class BizException extends Exception {


	private static final long serialVersionUID = -2804950003750376928L;
	
	private Integer state;
	
	private String messages;
	
	//成功
	public static final Integer SUCCESS = 1;
	//失败
	public static final Integer FAILURE = 0;
	
	public BizException () {
		super();
	}
	
	public BizException (Integer state, String messages) {
		super(messages);
		
		this.state = state;
		this.messages = messages;
	}
	
	public BizException (Integer state, String messages, Throwable cause) {
		super(cause);
		
		this.state = state;
		this.messages = messages;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}
