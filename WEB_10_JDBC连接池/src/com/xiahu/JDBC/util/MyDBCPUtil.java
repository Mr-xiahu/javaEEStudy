package com.xiahu.JDBC.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.xiahu.JDBC.Test.TestDBCP;

public class MyDBCPUtil {
	private static DataSource datasource;
	static {
		try {
			// 1.获取DB.properties对象
			InputStream is = TestDBCP.class.getClassLoader().getResourceAsStream("DB.properties");
			// 2.创建一个properties对象
			Properties prop = new Properties();
			// 3.加载DB.properties对象
			prop.load(is);
			datasource = BasicDataSourceFactory.createDataSource(prop);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
		}
	}

	public DataSource getDataSource() {
		return datasource;
	}

	public Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
