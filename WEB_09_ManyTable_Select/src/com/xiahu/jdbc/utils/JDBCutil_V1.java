package com.xiahu.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 加载连接数据库的工具类
 * 
 * @author Administrator
 *
 */
public class JDBCutil_V1 {

	/**
	 * 连接数据库的方法
	 * 
	 * @return
	 */
	public static Connection conn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/web_08_1", "root", "root");
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

}
