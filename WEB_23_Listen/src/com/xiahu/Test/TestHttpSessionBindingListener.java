package com.xiahu.Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiahu.domain.User;

public class TestHttpSessionBindingListener extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session域
		HttpSession session = request.getSession();

		// 绑定二者
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123456");
		session.setAttribute("User", user);
		
		//解除绑定
		session.removeAttribute("User");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}