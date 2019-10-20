package com.xiahu.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.创建cookie对象
		Cookie cookie = new Cookie("name", "xiahu");

		// 2.设置cookie保存时间
		cookie.setMaxAge(60 * 10);

		// 1.2 为cookie设置携带的路径
		// cookie.setPath("/WEB_16_Cookie/sendCookie");//访问sendCookie资源时才携带这个cookie
		cookie.setPath("/WEB_16_Cookie");// 访问WEB16下的任何资源时都携带这个cookie
		// cookie.setPath("/");//访问服务器下的所有的资源都携带这个cookie

		// 添加到客户端
		response.addCookie(cookie);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}