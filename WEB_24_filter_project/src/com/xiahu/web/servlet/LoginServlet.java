package com.xiahu.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiahu.domain.User;
import com.xiahu.service.LoginService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		// 2.将数据传递到service层
		LoginService service = new LoginService();
		User user = null;
		try {
			user = service.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 获得返回值user,进行判断
		if (user != null) {
			// 登录成功
			// 判断是否勾选登录成功checkbox
			String autologin = request.getParameter("autologin");
			if (autologin != null) {// 证明勾选了自动登录
				// 创建cookie存储username,password
				Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				// 设置cookie持久化事件
				cookie_username.setMaxAge(60 * 60);
				cookie_password.setMaxAge(60 * 60);
				// 设置携带访问路径-----整个WEB应用
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				// 发布cookie
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);

			}

			// 将user添加到session域,以便供其他调用
			session.setAttribute("user", user);
			// 重定向跳转到主页面
			response.sendRedirect(request.getContextPath());

		} else {
			// 登录失败
			// 书写提示语句
			request.setAttribute("loginInfo", "你的用户名或密码错误");
			// 转发到登录界面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}