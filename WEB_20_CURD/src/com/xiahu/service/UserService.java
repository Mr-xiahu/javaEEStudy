package com.xiahu.service;

import java.sql.SQLException;

import com.xiahu.dao.UserDao;

public class UserService {

	public boolean findUsername(String username) throws SQLException {
		// 将数据传递到dao层
		UserDao dao = new UserDao();
		Long count = dao.findUsername(username);
		return count > 0 ? true : false;
	}

}
