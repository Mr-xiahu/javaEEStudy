package com.xiahu.XML.Servlet;

public class MyServletImpl implements MyServlet {

	@Override
	public void init() {
		System.out.println("你好呀，我已经加载完成");

	}

	@Override
	public void service() {
		System.out.println("你好呀，我可以被使用");

	}

	@Override
	public void destory() {
		System.out.println("你好呀，我已经不能使用了");

	}

}
