package com.xiahu.JDBC.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiahu.JDBC.util.MyC3P0Util;

public class TestMyC3P0Util {
	@Test
	public void selectInfo() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		MyC3P0Util datadource=new MyC3P0Util();
		try {
			// 连接数据库
			conn = datadource.getConnection();
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
