package com.xiahu.JDBC.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.xiahu.JDBC.util.MyC3P0Util;
import com.xiahu.domain.User;

public class TestDBUtils {
	/**
	 * 查询所有信息
	 */
	@Test
	public void setectAll() {
		try {
			// 1. 新建核心类
			QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
			// 2.编写SQL代码
			String sql = "select * from tb_user";
			// 3.设置查询条件,没有就不填写
			Object[] obj = {};
			// 4.
			List<User> users = runner.query(sql, new BeanListHandler<User>(User.class), obj);
			// 5.遍历集合
			for (User user : users) {
				System.out.println(user.getuId() + "\t" + user.getuName() + "\t" + user.getuPassword() + "\t"
						+ user.getuAge() + "\t");
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 按ID查询信息
	 */
	@Test
	public void setectById() {
		try {
			// 1. 新建核心类
			QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
			// 2.编写SQL代码
			String sql = "select * from tb_user where uID=?";
			// 3.设置查询条件,没有就不填写
			Object[] obj = { 3 };
			// 4.
			List<User> users = runner.query(sql, new BeanListHandler<User>(User.class), obj);
			// 5.遍历集合
			for (User user : users) {
				System.out.println(user.getuId() + "\t" + user.getuName() + "\t" + user.getuPassword() + "\t"
						+ user.getuAge() + "\t");
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	
	/**
	 * 按表的列名查询信息
	 */
	@Test
	public void setectByName() {
		try {
			// 1. 新建核心类
			QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
			// 2.编写SQL代码
			String sql = "select * from tb_user ";
			// 3.设置查询条件,没有就不填写
			Object[] obj = { };
			// 4.
			List<Object> list=runner.query(sql, new ColumnListHandler("uPassword"));
			// 5.遍历集合
			for (Object s : list) {
				System.out.println(s);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}


	/**
	 * 查询表中的信息数量
	 */
	@Test
	public void setectCount() {
		try {
			// 1. 新建核心类
			QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
			// 2.编写SQL代码
			String sql = "select count(*) from tb_user ";
			// 3.设置查询条件,没有就不填写
			Object[] obj = {};
			// 4.
			long count = (long) runner.query(sql, new ScalarHandler(), obj);
			// 输出
			System.out.println(count);

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 用map集合查询
	 */
	@Test
	public void setectByMap() {
		try {
			// 1. 新建核心类
			QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
			// 2.编写SQL代码
			String sql = "select * from tb_user";
			// 3.设置查询条件,没有就不填写
			Object[] obj = {};
			// 4.
			List<Map<String, Object>> maps = runner.query(sql, new MapListHandler(), obj);
			// 5.遍历集合
			for (Map<String, Object> map : maps) {
				System.out.println(map);
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	// /**
	// * 添加信息
	// */
	// @Test
	// public static void insertInfo() {
	// try {
	// // 1. 新建核心类
	// QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
	// // 2.编写SQL代码
	// String sql = "insert into tb_user values(?,?,?,?)";
	// // 添加参数
	// Object[] obj = { 0, "风清扬", "想你", "林青霞" };
	// // 执行
	// int row = runner.update(sql, obj);
	// if (row > 0) {
	// System.out.println("操作数据库成功！");
	// } else {
	// System.out.println("操作数据库失败！");
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 修改信息
	// */
	// @Test
	// public static void updateInfo() {
	// try {
	// // 1. 新建核心类
	// QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
	// // 2.编写SQL代码
	// String sql = "update tb_user set uName=? where uId=?";
	// // 添加参数
	// Object[] obj = { "令狐冲", 5 };
	// // 执行
	// int row = runner.update(sql, obj);
	// if (row > 0) {
	// System.out.println("操作数据库成功！");
	// } else {
	// System.out.println("操作数据库失败！");
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 删除信息
	// */
	// @Test
	// public static void deleteInfo() {
	// try {
	// // 1. 新建核心类
	// QueryRunner runner = new QueryRunner(MyC3P0Util.getDataSource());
	// // 2.编写SQL代码
	// String sql = "delete from tb_user where uId=?";
	// // 添加参数
	// Object[] obj = { 4 };
	// // 执行
	// int row = runner.update(sql, obj);
	// if (row > 0) {
	// System.out.println("操作数据库成功！");
	// } else {
	// System.out.println("操作数据库失败！");
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

}
