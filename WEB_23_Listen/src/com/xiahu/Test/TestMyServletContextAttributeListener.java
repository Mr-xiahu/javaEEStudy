package com.xiahu.Test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMyServletContextAttributeListener extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext context = this.getServletContext();

		// 添加一组属性
		context.setAttribute("name", "Tom");

		// 修改(覆盖)同Key的属性
		context.setAttribute("name", "Mike");

		// 删除一组属性
		context.removeAttribute("name");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}