package com.xiahu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiahu.domain.PageBean;
import com.xiahu.domain.Product;
import com.xiahu.service.ProductListService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取当前的页数
		String currenPageStr = request.getParameter("currenPage");
		// 设置默认当前页
		if (currenPageStr == null) {
			currenPageStr = "1";
		}
		int currenPage = Integer.parseInt(currenPageStr);

		// 手动设置当前页的条数为12
		int currenCount = 12;

		// 传递数据
		ProductListService service = new ProductListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findPageBean(currenPage, currenCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}