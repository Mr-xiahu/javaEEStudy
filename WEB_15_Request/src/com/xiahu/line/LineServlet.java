package com.xiahu.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request请求行相应内容
 * @author Administrator
 *
 */
public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取客户端请求方式:
		String method = request.getMethod();
		System.out.println(method);

		// 2.获取请求资源
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URI:" + requestURI);
		System.out.println("URl:" + requestURL);

		// 3.获取WEB应用名称
		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		// 4.get提交URI地址后的参数字符串,post无效
		String queryString = request.getQueryString();
		System.out.println(queryString);
		
		
		//5.获取客户机的相关内容
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		System.out.println("IP:"+remoteAddr);
		System.out.println("Host:"+remoteHost);
		System.out.println("Port:"+remotePort);
		System.out.println("User:"+remoteUser);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}