package com.xiahu.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDemo2 {
	Connection conn = null;
	PreparedStatement prep = null;
	ResultSet rs = null;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql:" + "//localhost:3306/shop";
	String user = "root";
	String pwd = "root";

	public void getDatebase() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		System.out.println("数据库加载成功！");
		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("数据库连接成功！");
	}

	public void Login(String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		System.out.println("数据库加载成功！");
		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("数据库连接成功！");
		String sql = "select * from user where username=? and password=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, username);
		prep.setString(2, password);
		rs = prep.executeQuery();
		if (rs.next()) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败");
		}
		if (rs != null) {
			rs.close();
		}
		if (prep != null) {
			prep.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public static void main(String[] args) {
		try {
			new LoginDemo2().Login("xiahu", "1111111");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
