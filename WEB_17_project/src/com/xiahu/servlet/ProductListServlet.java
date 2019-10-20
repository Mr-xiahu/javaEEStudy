package com.xiahu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xiahu.Utils.DataSourceUtil;
import com.xiahu.domain.Product;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取数据库中的所有数据
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product";
		List<Product> productList = null;
		try {
			productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			System.out.println("数据库操作失败");

		}

		// 将数据添加到request域中
		request.setAttribute("ProductList", productList);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}