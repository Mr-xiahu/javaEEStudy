package com.xiahu.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Administrator
 * @version 2.0
 */
public class JDBCutil_V2 {
	private static String driver;
	private static String url;
	private static String DBname;
	private static String DBpwd;

	// 静态代码块加载配置信息
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("DB");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		DBname = bundle.getString("username");
		DBpwd = bundle.getString("password");
	}

	/**
	 * 连接数据库的方法
	 * 
	 * @return
	 */
	public static Connection conn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("数据库加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, DBname, DBpwd);
			System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 数据库释放资源的方法
	 * 
	 * @param conn
	 * @param prep
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement prep, ResultSet rs) {
		if (prep != null) {
			try {
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// public static void main(String[] args) {
	// System.out.println(driver);
	// System.out.println(url);
	// System.out.println(DBname);
	// System.out.println(DBpwd);
	// }

}
