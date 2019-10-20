package com.xiahu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[] args) throws SQLException {
		String driver = "jdbc:mysql:///web19";
		String user = "root";
		String pwd = "root";
		Connection conn = null;
		try {
			// 获得数据库的加载
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			conn = DriverManager.getConnection(driver, user, pwd);

			// 手动开启事务
			conn.setAutoCommit(false);

			// 获得执行平台
			Statement statement = conn.createStatement();

			// 执行SQL语句
			String sql = "insert into user values(null,'财鱼','20')";
			statement.execute(sql);
			
			//完成了就提交事务
			conn.commit();
			statement.close();
			conn.close();
			
			
		} catch (Exception e) {
			// 如果没有完成这个事务,就进行事务回滚
			conn.rollback();
		}

	}

}
