package com.xiahu.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// String name = request.getParameter("name");
		// String str = (Math.random() * 1000 + name);
		// // response.getWriter().write(str);
		 String name = request.getParameter("name");
		 String age= request.getParameter("age");
		
		// System.out.println(name + "\t" + age);
		// response.getWriter().write(name+"\t"+age);
		request.setCharacterEncoding("UTF-8");

		

		System.out.println(name + "  " + age);

		// java代码只能返回一个json格式的字符串
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}