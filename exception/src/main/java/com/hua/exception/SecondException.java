/**
 * SecondException.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.exception;

/**
 * SecondException
 * 描述:  orm - 已检查 异常
 * @author  qye.zheng
 */
public final class SecondException extends Exception
{

	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public SecondException()
	{
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param message
	 */
	public SecondException(final String message)
	{
		super(message);
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param cause
	 */
	public SecondException(final Throwable cause)
	{
		super(cause);
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param message
	 * @param cause
	 */
	public SecondException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * 
	 * 描述:  获取(第一个)触发点信息
	 * @author  qye.zheng
	 * @return
	 */
	public String getTriggerInfo()
	{
		final StackTraceElement first = getStackTrace()[0];
		
		return first.toString();
	}

}
