package com.xiahu.body;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方法体的参数
 * 
 * @author Administrator
 *
 */
public class BodyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.参数名获取参数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名:" + username + "\t" + "密码:" + password);
		System.out.println("-----------------------------------");

		// 2.获取所有的参数值（value）
		String[] hobbys = request.getParameterValues("hobby");
		for (String hobby : hobbys) {
			System.out.println(hobby);
		}
		System.out.println("-----------------------------------");

		// 3.获取所有的参数名(name),这个方法不常用
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		System.out.println("-----------------------------------");

		// 4.
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		for (Entry<String, String[]> sets : set) {
			String name = sets.getKey();
			for(String str:sets.getValue()){
				System.out.println(name+"----"+str);
			}
		}
		System.out.println("-----------------------------------");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}