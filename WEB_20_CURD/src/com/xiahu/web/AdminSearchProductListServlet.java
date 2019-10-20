package com.xiahu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xiahu.domain.Category;
import com.xiahu.domain.Condition;
import com.xiahu.domain.Product;
import com.xiahu.service.AdminProductListService;

public class AdminSearchProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单数据
		Map<String, String[]> parameters = request.getParameterMap();

		// 将散装的数据封装到VO实体中
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, parameters);
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		AdminProductListService service = new AdminProductListService();
		List<Product> productList = null;
		try {
			productList = service.findProductListByCondition(condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 准备商品类别
		// 获得所有的商品分类数据
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("condition", condition);
		// 将categoryList放到request域
		request.setAttribute("categoryList", categoryList);

		// product放到request域
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}