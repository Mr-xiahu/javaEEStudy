package com.xiahu.datebase;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class ConnectionDatebase {
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql:" + "//localhost:3306/web_08_1";
	String username = "root";
	String password = "root";

	public Connection getDateBase() {
		try {
			Class.forName(driverName);
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static void main(String[] args) {
		ConnectionDatebase c=new ConnectionDatebase();
		c.getDateBase();
	}

}
