package com.xiahu.Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestMyHTTPSessionAttributeLietenerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取Session对象
		HttpSession session = request.getSession();

		// 添加一组属性
		session.setAttribute("name", "Tom");

		// 修改(覆盖)同Key的属性
		session.setAttribute("name", "Mike");

		// 删除一组属性
		session.removeAttribute("name");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}