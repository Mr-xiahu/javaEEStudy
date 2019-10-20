package com.xiahu.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 防盗链接
 * @author Administrator
 *
 */
public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 要经过判断
		String header = request.getHeader("referer");
		if (header != null && header.startsWith("http://localhost")) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("你可以看到这条新闻");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("你是盗链者！！！！滚出去");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
