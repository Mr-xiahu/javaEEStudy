package com.xiahu.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xiahu.Utils.DataSourceUtil;
import com.xiahu.domain.User;


public class LoginServlet extends HttpServlet {
	
	public User login(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
		return user;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		// 获取html页面输入的验证码
		String text = request.getParameter("checkCode");

		// 获取后台随机的验证码
		HttpSession session = request.getSession();
		String checkcode = (String) session.getAttribute("checkcode_session");

		// 将二者进行比较
		if (!text.equals(checkcode)) {
			request.setAttribute("Info", "您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			// 进行用户名密码登录校验
			// 1.获取用户名跟密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username + password);

			// 2.调用一个业务进行登录:
			User login = null;
			try {
				login = login(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 判断是否登录成功
			if (login != null) {
				// 登录成功
				// 跳转到首页
				response.sendRedirect(request.getContextPath());
			} else {
				// 登录失败
				// 跳回当前login.jsp
				// 使用转发 转发到login.jsp 向request域中存储错误信息
				request.setAttribute("info", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
