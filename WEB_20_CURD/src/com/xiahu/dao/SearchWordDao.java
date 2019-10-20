package com.xiahu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.xiahu.domain.Product;
import com.xiahu.utils.DataSourceUtil;

public class SearchWordDao {

	public List<Object> findProductListByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product where pname like ? limit 0,6";
		List<Object> query = runner.query(sql, new ColumnListHandler("pname"), "%"+word+"%");
		return query;
	}

}
