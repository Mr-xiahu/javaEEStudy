package com.xiahu.JDBC.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.xiahu.JDBC.DataSource.MyDataSource;
import com.xiahu.JDBC.DataSource.MyDataSource_V1;
import com.xiahu.JDBC.util.JDBCutil_V3;

public class TestMySource {
	@Test
	public void insertInfo() {
		Connection conn = null;
		PreparedStatement prep = null;
		// 创建自定义连接池对象
		MyDataSource datadource = new MyDataSource();
		try {
			// 连接数据库
			conn = datadource.getConnection();
			// 编写SQL语句
			String sql = "insert into tb_user values(?,?,?,?)";
			// 设置执行SQL语句的方法
			prep = conn.prepareStatement(sql);
			prep.setInt(1, 0);
			prep.setString(2, "大黑");
			prep.setString(3, "789");
			prep.setString(4, "99");
			int row = prep.executeUpdate();
			if (row > 0) {
				System.out.println("添加数据成功!");
			} else {
				System.out.println("添加数据失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			datadource.backConnection(conn);
		}
	}

	@Test
	public void insertInfo_v2() {
		Connection conn = null;
		PreparedStatement prep = null;
		// 创建自定义连接池对象
		MyDataSource_V1 data_v1 = new MyDataSource_V1();
		try {
			// 连接数据库
			conn = data_v1.getConnection();
			// 编写SQL语句
			String sql = "insert into tb_user values(?,?,?,?)";
			// 设置执行SQL语句的方法
			prep = conn.prepareStatement(sql);
			prep.setInt(1, 0);
			prep.setString(2, "小黑");
			prep.setString(3, "789");
			prep.setString(4, "99");
			int row = prep.executeUpdate();
			if (row > 0) {
				System.out.println("添加数据成功!");
			} else {
				System.out.println("添加数据失败!");
			}
		} catch (Exception e) {
			//throw new RuntimeException();
			System.out.println("数据库操作失败失败");
		} finally {
			JDBCutil_V3.close(conn, prep, null);
		}
	}
}
