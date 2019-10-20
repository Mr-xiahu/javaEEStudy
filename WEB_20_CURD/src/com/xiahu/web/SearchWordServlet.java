package com.xiahu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xiahu.domain.Product;
import com.xiahu.service.SearchWordService;

import net.sf.json.JSONArray;

public class SearchWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取JSP页面传递过来的参数
		String word = request.getParameter("word");

		// 2.将数据传递到service层
		SearchWordService service = new SearchWordService();
		List<Object> productList = null;
		try {
			productList = service.findProductListByWord(word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.将返回值封装
		// 3.1:使用json的转换工具将对象或集合转成json格式的字符串
		// JSONArray fromObject = JSONArray.fromObject(productList);
		// String string = fromObject.toString();

		// 3.2:使用Gson转换工具封装对象
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		//System.out.println(json);
		
		//4.防止中文乱码
		response.setContentType("text/html;charset=UTF-8");
		
		//5.将返回值转发给客户端
		response.getWriter().write(json);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}