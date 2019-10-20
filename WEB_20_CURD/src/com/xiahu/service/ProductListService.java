package com.xiahu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiahu.dao.ProductListDao;
import com.xiahu.domain.PageBean;
import com.xiahu.domain.Product;

public class ProductListService {

	public List<Product> findAllProductList() throws SQLException {
		ProductListDao dao = new ProductListDao();
		return dao.findAllProductList();

	}

	public PageBean findPageBean(int currenPage, int currenCount) throws SQLException {
		ProductListDao dao = new ProductListDao();
		PageBean pageBean = new PageBean<>();
		// 目的：封装一个完整的PageBean实体类返回

		// private int currenPage; 当前页
		pageBean.setCurrenPage(currenPage);

		// private int currenCount;当前页的条数(数据量)
		pageBean.setCurrenCount(currenCount);

		// private int totalCount;总条数
		//从数据库中获取
		int totalCount = dao.findAllProductListForCount();
		pageBean.setTotalCount(totalCount);

		// private int totalPage;总页数
		/*
		 * 举例:
		 * 每页条数             总条数              总页数          
		 *  4           10        3
		 *  4           11        3
		 *  4           12        3
		 *  4           13        4   
		 *  
		 *  总页数=Math.ceil(1.0*总条数/每页条数)
		 */
		int totalPage = (int) Math.ceil(1.0*totalCount/currenCount);
		pageBean.setTotalPage(totalPage);

		// private List<T> product = new ArrayList<T>();每页显示的数据
		/*
		 * 页数与limit起始索引的关系
		 * 例如 每页显示4条
		 * 页数		其实索引		每页显示条数
		 * 1		0			4
		 * 2		4			4
		 * 3		8			4
		 * 4		12			4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currenPage-1)*currenCount;
		List<Product> productList = dao.findProductListForPageBean(index,currenCount);
		pageBean.setProduct(productList);
		return pageBean;
	}

}
