package com.xiahu.XML.Servlet_V1;

public class MyServletImpl1 implements MyServlet {

	@Override
	public void init(String s) {
		System.out.println("我是1中的第一个" + s);

	}

	@Override
	public void service() {
		System.out.println("我是1中的第二个");

	}

	@Override
	public void destory() {
		System.out.println("我是1中的第三个");

	}

}
