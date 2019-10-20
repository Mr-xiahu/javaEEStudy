package com.xiahu.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得Cookie
		Cookie[] cookies = request.getCookies();
		 for (Cookie cookie : cookies) {
			 String name = cookie.getName();
			if(name.equals("name")){
				String value = cookie.getValue();
				System.out.println(value);
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}