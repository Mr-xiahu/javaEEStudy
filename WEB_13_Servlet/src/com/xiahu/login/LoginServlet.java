package com.xiahu.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.xiahu.domain.User;
import com.xiahu.utils.DataSourceUtil;

public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// 记录登录成功的次数
		// 1.一开始为0
		int count = 0;
		// 2.将其存入至域对象
		this.getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取用户名跟密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2.从数据库中验证该用户名跟密码是否正确
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from User where username=? and password=?";
		Object obj[] = { username, password };
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3.根据返回的结果给出不同的用户信息
		if (user != null) {
			// 3.当其登录成功时,从域对象中取出count
			ServletContext context = getServletContext();
			Integer count = (Integer) context.getAttribute("count");
			// 4.次数++
			count++;
			// 5.用户登录成功,并将登录成功的总次数输出
			response.getWriter().write(user.toString() + "you login successful is :" + count);

			// 6.将这个count重新添加到域对象中
			context.setAttribute("count", count);
		} else {
			// 用户登录失败
			response.getWriter().write("sorry your username or password is wrong!!");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}