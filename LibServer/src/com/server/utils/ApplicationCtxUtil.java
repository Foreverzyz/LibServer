package com.server.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationCtxUtil {
	public static ApplicationContext getContext(){
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("classpath:applicationContext-beans.xml");
		return context;
	}
}
