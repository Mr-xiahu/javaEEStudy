package com.xiahu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.xiahu.Utils.DataSourceUtil;

/*
 * 使用DButil进行事务操作
 */
public class DButilDemo {
	public static void main(String[] args) throws SQLException {
		QueryRunner rq = new QueryRunner();
		// 获取一个Connection对象
		Connection conn = DataSourceUtil.getConnection();
		// 开启事务
		conn.setAutoCommit(false);

		try {
			rq.update(conn, "update user set age='3000' where name='张三'");
			// 提交事务
			conn.commit();
		} catch (SQLException e) {
			// 事务回滚
			conn.rollback();

		}

	}
}
