package com.xiahu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();

	// 创建ThreadLocal
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static DataSource getDataSource() {
		return datasource;
	}

	public static Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	// 获得当前线程绑定的Conn
	public static Connection getCurrentConnection() {
		// 从ThreadLocal寻找当前线程是否有对应的Connection
		Connection conn = tl.get();
		// 判断是否为空
		if (conn == null) {
			// 获取一个Connection
			conn = getConnection();
			// 绑定到ThreadLocal线程
			tl.set(conn);
		}
		return conn;
	}

	// 事务开启
	public static void setAutoCommit() throws SQLException {
		getCurrentConnection().setAutoCommit(false);

	}

	// 事务回滚
	public static void rollback() throws SQLException {
		getCurrentConnection().rollback();

	}

	public static void commit() throws SQLException {
		getCurrentConnection().commit();

	}

}
