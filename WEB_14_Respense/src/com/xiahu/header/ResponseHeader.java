package com.xiahu.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseHeader extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date data = new Date();

		// 1.添加响应头的属性
		// 添加一个响应头
		response.addHeader("name", "zhangsan");
		response.addIntHeader("age", 20);
		response.addDateHeader("birthday", data.getTime());
		// 当再添加一个Header时,第一个Header不会被替代,而是叠加起来
		response.addHeader("name", "lisi");// name:"zhangsan,lisi"

		// 2.设置响应头的属性
		//前面的属性不管有多少,最后只剩下一个
		response.setHeader("name", "wangwu");//name:"wangwu"

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
