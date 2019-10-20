package com.xiahu.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.xiahu.Utils.DataSourceUtil;

public class dao {

	public static void out(String out, Double money) {
		// 获取当前线程上绑定的Conn
		Connection conn = DataSourceUtil.getCurrentConnection();

		// 进行数据库操作
		QueryRunner qr = new QueryRunner();
		String sql = "update user set age=age-? where name=?";
		try {
			qr.update(conn, sql, money, out);
		} catch (SQLException e) {
			System.out.println("转出失败！！！！！！");
		}

	}

	public static void in(String in, Double money) {
		// 获取当前线程上绑定的Conn
		Connection conn = DataSourceUtil.getCurrentConnection();

		// 进行数据库操作
		QueryRunner qr = new QueryRunner();
		String sql = "update user set age=age+? where name=?";
		try {
			qr.update(conn, sql, money, in);
		} catch (SQLException e) {
			System.out.println("转入失败！！！！");
		}
	}

}
