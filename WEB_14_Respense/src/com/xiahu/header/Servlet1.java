package com.xiahu.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 重定向设置
		// 1.设置状态为302
		//response.setStatus(302);

		// 2.设置Header属性为Location
		//response.setHeader("Location", "/WEB_14_Respense/servlet2");
		
		
		//现在有一个方法将重定向直接封装
		response.sendRedirect("/WEB_14_Respense/servlet2");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}