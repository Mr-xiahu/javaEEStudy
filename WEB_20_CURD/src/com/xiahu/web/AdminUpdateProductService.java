package com.xiahu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xiahu.domain.Product;
import com.xiahu.service.AdminProductListService;

public class AdminUpdateProductService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 获取数据
		Map<String, String[]> properties = request.getParameterMap();

		// 封装数据
		Product product = new Product();
		try {
			BeanUtils.populate(product, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}


		// 2.private String pimage;
		product.setPimage("products/1/c_0010.jpg");

		// 3.private String pdate;上架日期
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		product.setPdate(date);

		// 4.private int pflag;是否下架？-----0代表尚未下架，1代表已下架
		product.setPflag(0);

		// 传递数据给Service
		AdminProductListService service = new AdminProductListService();
		try {
			service.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/adminProductList");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}