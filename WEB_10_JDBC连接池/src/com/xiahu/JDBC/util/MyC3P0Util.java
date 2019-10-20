package com.xiahu.JDBC.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyC3P0Util {
	static ComboPooledDataSource datasource = new ComboPooledDataSource();

	public MyC3P0Util() {

	}

	// public MyC3P0Util(String configured) {
	//
	// }

	public static DataSource getDataSource() {
		return datasource;
	}

	public static Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
