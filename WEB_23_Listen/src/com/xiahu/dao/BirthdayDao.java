package com.xiahu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.xiahu.domain.DBUser;
import com.xiahu.utils.DataSourceUtil;

public class BirthdayDao {

	public List<DBUser> findBirthdayByDate(String todayDate) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from user where birthday like ?";
		List<DBUser> DBUserList = qr.query(sql, new BeanListHandler<DBUser>(DBUser.class), "%"+todayDate+"%");
		return DBUserList;
	}

}
