package com.xiahu.lastAccess;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String time = sdf.format(date);

		// 创建Cookie,记录当前访问时间
		Cookie cookie = new Cookie("LastAccessTime", time);

		// 设置Cookie存在的时间
		cookie.setMaxAge(60 * 10 * 6);
		
		//将Cookie添加到客户端
		response.addCookie(cookie);
		
		
		//获得客户端携带的Cookie
		Cookie[] cookies = request.getCookies();
		String lastAccessTimes=null;
		if(cookies!=null){
			for (Cookie cookie2 : cookies) {
				String name = cookie2.getName();
				if(name.equals("LastAccessTime")){
					lastAccessTimes = cookie2.getValue();
				}
			}
		}
		
		//设置编码方式
		response.setContentType("text/html;charset=UTF-8");
		if(lastAccessTimes==null){
			response.getWriter().write("你是第一个访问");
		}else{
			response.getWriter().write("你上次登录的时间是:"+lastAccessTimes);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}