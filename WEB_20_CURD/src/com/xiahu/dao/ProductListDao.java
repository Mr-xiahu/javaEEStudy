package com.xiahu.dao;

import java.sql.SQLException;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xiahu.domain.Product;
import com.xiahu.utils.DataSourceUtil;

public class ProductListDao {

	public List<Product> findAllProductList() throws SQLException {
		return new QueryRunner(DataSourceUtil.getDataSource()).query("select * from product",
				new BeanListHandler<Product>(Product.class));
	}

	// 查询商品信息的所有数量
	public int findAllProductListForCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select count(*) from product";
		Long query = (Long) qr.query(sql, new ScalarHandler());
		return query.intValue();
	}

	public List<Product> findProductListForPageBean(int index, int currenCount) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), index,currenCount);
	}

}
