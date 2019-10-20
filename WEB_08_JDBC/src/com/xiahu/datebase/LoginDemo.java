package com.xiahu.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import java.sql.PreparedStatement;

public class LoginDemo {

	Connection conn = null;
	PreparedStatement prep = null;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql:" + "//localhost:3306/shop";
	String name = "root";
	String psd = "root";

	public void login(String username, String password) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName(driverName);
		System.out.println("数据库加载成功");
		// 2.连接数据库
		conn = DriverManager.getConnection(url, name, psd);
		System.out.println("数据库连接成功");
		// 3.创建执行sql语句的对象
		Statement stmt = conn.createStatement();
		// 4.添加SQL语句
		String sql = "select * from user where " + "username='" + username + "' and password = '" + password + "'";
		// 5.执行SQL语句
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			System.out.println("恭喜你登录成功！");
			System.out.println(sql);
		} else {
			System.out.println("登录失败");
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	@Test
	public void TestLogin() {
		LoginDemo l = new LoginDemo();
		try {
			l.login("xiahu", "1111111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
