package com.xiahu.Servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet implements Servlet {

	@Override
	public void init(ServletConfig conf) throws ServletException {
		// 1.获取servlet的name----------><servlet-name>QuickStartServlet</servlet-name>
		String servletName = conf.getServletName();
		System.out.println(servletName);// QuickStartServlet

		// 2.获取servlet的初始化参数--------><init-param> .....</inir-param>
		String param = conf.getInitParameter("aaa");
		System.out.println(param);// jdbc:mysql///123132

		System.out.println("init   runtime.....");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("QuickStartServlet runtime.....");
		res.getWriter().write("hello,woxiangni ya ");

	}

	@Override
	public void destroy() {

		System.out.println("destroy   runtime.....");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
