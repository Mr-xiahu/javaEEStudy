package com.xiahu.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Request域
		//向Request域中添加数据
		request.setAttribute("name", "xiahu,nishi zhen di shuai");

		// request请求转发数据
		// 将servlet1的数据请求转发给servlet2
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");
		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}