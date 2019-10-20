package com.xiahu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xiahu.domain.Category;
import com.xiahu.domain.Condition;
import com.xiahu.domain.Product;
import com.xiahu.utils.DataSourceUtil;

public class AdminProductDao {

	// 查询所有商品信息
	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

	// 查询所有商品分类信息
	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	// 添加商品信息
	public void addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(),
				product.getCid());

	}

	// 根据pid删除商品
	public void delProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "delete from product where pid=? ";
		qr.update(sql, pid);

	}

	// 根据pid查询商品
	public Product findProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product where pid=? ";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

	// 更新信息
	public void updateProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		qr.update(sql, product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(),
				product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCid(),
				product.getPid());

	}

	// 根据条件查询商品数据
	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		// QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		// List<String> list = new ArrayList<String>();
		// String sql = "select * from product where 1=1";
		// if (condition.getPname() != null &&
		// !condition.getPname().trim().equals("")) {
		// sql += " and pname like ? ";
		// list.add("%" + condition.getPname().trim() + "%");
		// }
		// if (condition.getIsHot() != null &&
		// condition.getIsHot().trim().equals("")) {
		// sql += " and is_hot=? ";
		// list.add(condition.getIsHot().trim());
		// }
		// if (condition.getCid() != null &&
		// condition.getCid().trim().equals("")) {
		// sql += " and cid=? ";
		// list.add(condition.getCid().trim());
		// }
		// List<Product> productList = qr.query(sql, new
		// BeanListHandler<Product>(Product.class), list.toArray());
		// return productList;

		QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
		// 定义一个存储实际参数的容器
		List<String> list = new ArrayList<String>();
		String sql = "select * from product where 1=1";
		if (condition.getPname() != null && !condition.getPname().trim().equals("")) {
			sql += " and pname like ? ";
			list.add("%" + condition.getPname().trim() + "%");
		}
		if (condition.getIsHot() != null && !condition.getIsHot().trim().equals("")) {
			sql += " and is_hot=? ";
			list.add(condition.getIsHot().trim());
		}
		if (condition.getCid() != null && !condition.getCid().trim().equals("")) {
			sql += " and cid=? ";
			list.add(condition.getCid().trim());
		}

		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class), list.toArray());

		return productList;
	}

}
