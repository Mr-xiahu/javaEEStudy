package com.xiahu.service;

import java.sql.SQLException;
import java.util.List;

import com.xiahu.dao.AdminProductDao;
import com.xiahu.domain.Category;
import com.xiahu.domain.Condition;
import com.xiahu.domain.Product;

public class AdminProductListService {

	// 查询所有的商品信息
	public List<Product> findAllProduct() throws SQLException {
		// 因为没有复杂业务 直接传递请求到dao层
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllProduct();

	}

	// 查询所有商品分类信息
	public List<Category> findAllCategory() throws SQLException {
		// 没有什么复杂的业务,直接传递参数到dao层
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllCategory();

	}

	// 添加商品信息到数据库中去
	public void addProduct(Product product) throws SQLException {
		// 没有什么复杂的业务,直接传递参数到dao层
		AdminProductDao dao = new AdminProductDao();
		dao.addProduct(product);

	}

	// 根据pid删除数据
	public void delProduct(String pid) throws SQLException {
		// 没有什么复杂的业务,直接传递参数到dao层
		AdminProductDao dao = new AdminProductDao();
		dao.delProduct(pid);

	}

	// 根据pid查询商品
	public Product findProductById(String pid) throws SQLException {
		// 没有什么复杂的业务,直接传递参数到dao层
		AdminProductDao dao = new AdminProductDao();
		Product product = dao.findProductById(pid);
		return product;
	}

	// 更新商品信息
	public void updateProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.updateProduct(product);

	}

	// 根据条件查询商品数据
	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductListByCondition(condition);

	}

}
