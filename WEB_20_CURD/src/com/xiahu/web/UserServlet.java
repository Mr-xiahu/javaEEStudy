package com.xiahu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiahu.service.UserService;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取JSP页面传来的数据
		String username = request.getParameter("username");

		// 将数据传递到service层
		UserService service = new UserService();
		boolean isExist = false;
		try {
			isExist = service.findUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 将返回值传递给JSP
		response.getWriter().write("{\"isExist\":" + isExist + "}");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}