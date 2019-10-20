package com.xiahu.listen;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MySessionContextListener implements HttpSessionListener  {

	@Override
	//创建
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session创建了");
		
	}

	@Override
	//销毁
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session销毁了");	
		
	}



}
