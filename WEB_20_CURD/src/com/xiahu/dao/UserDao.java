package com.xiahu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xiahu.utils.DataSourceUtil;

public class UserDao {

	public Long findUsername(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select count(*) from user where username=?";
		Long query = (Long) qr.query(sql, new ScalarHandler(), username);
		return query;
	}

}
