package com.xiahu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();

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

}
