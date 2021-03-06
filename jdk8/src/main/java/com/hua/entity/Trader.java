/**
  * @filename Trader.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import lombok.Data;

/**
 * @type Trader
 * @description 交易员
 * @author qianye.zheng
 */
@Data
public class Trader
{
	
	private String name;
	
	private String city;
	
	private String remark;

	/**
	 * @description 构造方法
	 * @param name
	 * @param city
	 * @author qianye.zheng
	 */
	public Trader(String name, String city)
	{
		super();
		this.name = name;
		this.city = city;
	}
	
	public String getRemark()
	{
		
		return name + " | " + city;
	}
	
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return "[name] = " + name + ", [city] = " + city;
	}
	
}
