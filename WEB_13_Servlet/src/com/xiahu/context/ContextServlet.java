package com.xiahu.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * //两种获取文件的方式:
 *   A:
 *    ServletContext context = getServletContext();
 *    String path1 = context.getRealPath("a.txt");
 *   B:
 *    String path2 = ContextServlet.class.getClassLoad().getResour("a.txt").getPath();
 *    
 *    
 *    path1====path2
 */
public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取Context对象
		ServletContext context = getServletContext();
		// 2.作用:
		// A:获取xml文件中的初始化参数
		String parameter = context.getInitParameter("driver");
		System.out.println(parameter);// com.mysql.jdbc.Driver
		// B:获取WEB应用下的任何资源的绝对路径
		// 我要获取a ,b ,c ,d 四个文件的路径
		// a.txt
		String realPath_A = context.getRealPath("a.txt");
		System.out.println(realPath_A);
		// b.txt
		String realPath_B = context.getRealPath("WEB-INF/lib/b.txt");
		System.out.println(realPath_B);
		// c.txt
		String realPath_C = context.getRealPath("WEB-INF/lib/classes/c.txt");
		System.out.println(realPath_C);
		// d.txt无法获取

		// 用类加载器同样可以获取文件
		// getResource("")这个方法也是一个相对路径,相对于这个classes
		String path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(path);
		

		// C:域对象----一个WEB应用只有一个ServletContext对象,但是有很多个Servlet,现在可以把ServletContext当做一个域对象,
		// 由ServletA存入一个信息到ServletContext中,再由ServletB拿出来
		// 通过:
		context.setAttribute("name", "zhangsan");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}