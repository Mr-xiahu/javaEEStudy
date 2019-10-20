package com.xiahu.XML.Servlet;

import org.junit.Test;

public class TestMyServlet {

	@Test
	public void TestMyServlet() {
		MyServlet ms = new MyServletImpl();// 多态的使用
		ms.init();
		ms.service();
		ms.destory();

	}

	// 使用反射来运用
	@Test
	public void TestMyServlet2() {
		try {
			String className = "com.xiahu.XML.Servlet.MyServletImpl";
			Class clazz = Class.forName(className);
			MyServletImpl ms = (MyServletImpl) clazz.newInstance();
			ms.init();
			ms.service();
			ms.destory();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
