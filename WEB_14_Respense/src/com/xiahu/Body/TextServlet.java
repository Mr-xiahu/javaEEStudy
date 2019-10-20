package com.xiahu.Body;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 3.我现在设置response查询编码
		response.setCharacterEncoding("UTF-8");
		// 输出语句
		PrintWriter writer = response.getWriter();
		// writer.write("hello, javaEE!");
		
		// 1.我现在输入中文
		// writer.write("你好");// 但是显示的是??
		
		// 2.这是为什么呢？编码问题
		
		// 4.重新输入一下
		writer.write("你好");//但是显示的是"浣犲ソ"
		//这是为什么呢？因为你的服务器端设置了编码，但是客户端的码表与服务器端不一样
		
		//5.通过一个头Content-Type告知客户端使用何种码表
		//response.setHeader("Content-Type", "text/html;Charset=UTF-8");
		
		//其实java里面有一个方法直接将其封装
		response.setContentType("text/html;Charset=UTF-8");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
