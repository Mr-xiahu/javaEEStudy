package com.xiahu.JDBC.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestDBCP {
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

	@Test
	public void InsertInfo() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
//		// 新建对象
//		datasource = new ComboPooledDataSource();
		try {
			// 连接数据库
			conn = datasource.getConnection();
			// 编写SQL语句
			String sql = "select* from tb_user;";
			// 设置执行SQL语句的方法
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			System.out.println("----------------没有被修改前:------------------");
			while (rs.next()) {
				int id = rs.getInt("uId");
				String name = rs.getString("uName");
				String sex = rs.getString("uPassword");
				String age = rs.getString("uAge");
				System.out.println("学号:" + id + "\t" + "姓名:" + name + "\t" + "密码:" + sex + "\t" + "年龄:" + age);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
