package com.xiahu.jdbc.TextUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.xiahu.jdbc.utils.JDBCutil_V1;
import com.xiahu.jdbc.utils.JDBCutil_V2;
import com.xiahu.jdbc.utils.JDBCutil_V3;

/**
 * 测试工具类
 * 
 * @author Administrator
 *
 */
public class TestUtils {

	@Test
	public void TestUpdateInfo() {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1.连接数据库
			conn = JDBCutil_V3.conn();
			// 2.编写SQL语句
			String sql = "update tb_user set uPassword=? where uId=? ";
			// 3.设置执行sql语句的方法
			prep = conn.prepareStatement(sql);
			prep.setString(1, "666");
			prep.setInt(2, 6);
			int row = prep.executeUpdate();
			if (row > 0) {
				System.out.println("数据修改成功！");
			} else {
				System.out.println("数据修改失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil_V3.close(conn, prep, null);
		}
	}

	/**
	 * 添加用户信息
	 */
	@Test
	public void TestInsertInfo() {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1.连接数据库
			conn = JDBCutil_V2.conn();
			// 2.编写SQL语句
			String sql = "insert into tb_user values(?,?,?,?)";
			// 3.获取执行sql语句的对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, 0);
			prep.setString(2, "林青霞");
			prep.setString(3, "999999");
			prep.setString(4, "27");
			prep.executeUpdate();
			System.out.println("数据添加成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil_V2.close(conn, prep, null);
		}

	}

	/**
	 * 查询用户的信息
	 */
	@Test
	public void testFindInfo() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			// 1. 连接数据库
			conn = JDBCutil_V1.conn();
			// 2.编写SQL语句
			String sql = "select * from tb_user";
			// 3.获取执行sql语句对象
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("uId");
				String name = rs.getString("uName");
				String password = rs.getNString("uPassword");
				String age = rs.getString("uAge");
				System.out.println(
						"编号:" + id + "\t" + "姓名:" + name + "\t" + "密码:" + password + "\t" + "年龄:" + age + "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			JDBCutil_V1.close(conn, prep, rs);
			System.out.println("释放资源成功!");
		}
	}

}
