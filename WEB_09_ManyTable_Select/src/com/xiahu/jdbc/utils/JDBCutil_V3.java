package com.xiahu.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 数据库的加载连接工具类
 * 
 * @author Administrator
 * @version 3.0
 * 
 *
 */
public class JDBCutil_V3 {
	private static String driver;
	private static String url;
	private static String DBname;
	private static String DBpwd;

	// 静态代码块加载配置信息
	static {
		try {
			// 1.通过当前类获取类加载器
			ClassLoader classLoader = JDBCutil_V3.class.getClassLoader();
			// 2.通过类加载器获取输入流
			InputStream is = classLoader.getResourceAsStream("DB.properties");
			// 3.创建一个properties对象
			Properties prop = new Properties();
			// 4.properties对象加载输入流对象
			prop.load(is);
			// 5.获取IS对象中的数据
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			DBname = prop.getProperty("username");
			DBpwd = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
