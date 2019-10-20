package com.xiahu.service;

import java.sql.SQLException;
import java.util.List;

import com.xiahu.dao.BirthdayDao;
import com.xiahu.domain.DBUser;

public class BirthdayService {

	public List<DBUser> findBirthdayByDate(String todayDate) throws SQLException {
		//没有什么业务,直接传递到dao层
		BirthdayDao dao=new BirthdayDao();
		return dao.findBirthdayByDate(todayDate);
		 
	}

}
