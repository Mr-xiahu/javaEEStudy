package com.xiahu.transfer.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiahu.transfer.service.Transfer;

public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取页面数据
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		Double money = Double.parseDouble(moneyStr);

		// 调用service层的转账方法
		boolean isTransferSuccess = true;
		try {
			isTransferSuccess = Transfer.isTransferSuccess(out, in, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 设置中文乱码问题
		response.setContentType("text/html;charset=UTF-8");
		// 进行判断,成功与否,都显示
		if (isTransferSuccess) {
			response.getWriter().write("转账成功！！！！！");
		} else {
			response.getWriter().write("转账失败！！！！！");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}