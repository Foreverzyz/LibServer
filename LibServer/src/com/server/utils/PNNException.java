package com.server.utils;
/**
 * 
* @ClassName: PNNException 
* @Description: 自定义异常类
* @author 威风
* @date 2016年10月7日 上午12:34:17 
*
 */
public class PNNException extends Exception{

	/*
	 * 自定义异常类，打印错位msg
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PNNException(String msg){
		super(msg);
	}
}
