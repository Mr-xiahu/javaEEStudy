package com.xiahu.service;

import java.sql.SQLException;

import com.xiahu.dao.LoginDao;
import com.xiahu.domain.User;

public class LoginService {

	public User login(String username, String password) throws SQLException {
		LoginDao dao=new LoginDao();
		return dao. login(username, password);
		 
	}

}
