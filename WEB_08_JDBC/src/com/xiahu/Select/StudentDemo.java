package com.xiahu.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDemo {
	Connection conn = null;
	Statement stat = null;
	PreparedStatement prep = null;
	ResultSet rs = null;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql:" + "//localhost:3306/shop";
	String DBname = "root";
	String DBpwd = "root";

	public void Select() throws ClassNotFoundException, SQLException {
		// 注册驱动
		Class.forName(driverName);
		// 连接数据库
		conn = DriverManager.getConnection(url, DBname, DBpwd);
		// 创建sql语句
		String sql = "select * from student";
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		System.out.println("----------------没有被修改前:------------------");
		while (rs.next()) {
			int id = rs.getInt("Id");
			String name = rs.getString("Name");
			String sex = rs.getString("Sex");
			int age = rs.getInt("Age");
			System.out.println("学号:" + id + "\t" + "姓名:" + name + "\t" + "性别:" + sex + "\t" + "年龄:" + age);
		}
	}

	public void insert() throws ClassNotFoundException, SQLException {
		// 键盘录入事件
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String one = sc.nextLine();
		System.out.println("请输入性别:");
		String two = sc.nextLine();
		System.out.println("请输入年龄:");
		int three = sc.nextInt();
		sc.close();
		// 注册驱动
		Class.forName(driverName);
		// 连接数据库
		conn = DriverManager.getConnection(url, DBname, DBpwd);
		// sql语句
		String sql = "insert into student values(?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, 0);
		prep.setString(2, one);
		prep.setString(3, two);
		prep.setInt(4, three);
		prep.executeUpdate();
	}

	public static void main(String[] args) {
		try {
			StudentDemo s = new StudentDemo();
			s.Select();
			s.insert();
			s.Select();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
