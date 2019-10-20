package com.xiahu.JDBC.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.xiahu.JDBC.util.JDBCutil_V3;

public class MyDataSource_V1 implements DataSource {
	// 1.创建一个JDBC连接池,综合考虑,用linkedlist较好
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	// 静态代码块
	static {
		// 2.创建5个连接对象添加到JDBC池中
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCutil_V3.conn();
			// 创建Connection对象
			MyConnection myconn = new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}

	/*
	 * 重写连接池方法
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		// 3.判断JDBC池
		if (pool.size() == 0) {
			// 4.如果没有对象,就重新创建并添加一次
			for (int i = 0; i < 5; i++) {
				// 创建Connection对象
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
			}
		}
		// 5.从池中移除一个Connection对象,并获取移除的这个对象
		conn = pool.remove(0);

		return conn;
	}

	public void backConnection(Connection conn) {
		pool.add(conn);
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
