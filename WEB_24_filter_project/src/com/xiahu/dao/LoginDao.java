package com.xiahu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xiahu.domain.User;
import com.xiahu.utils.DataSourceUtil;

public class LoginDao {

	public User login(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
		return user;
	}

}
