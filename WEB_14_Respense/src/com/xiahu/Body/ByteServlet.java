package com.xiahu.Body;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将服务器上的图片显示在客户端上
		// 1.获取图片位置
		String path = this.getServletContext().getRealPath("a.jpg");
		InputStream is = new FileInputStream(path);
		// 2.读取图片
		int len = 0;
		byte[] bys = new byte[1024];
		while ((len=is.read(bys))!=-1) {
			// 3.写入图片
			response.getOutputStream().write(bys, 0, len);
		}
		// 释放资源
		is.close();
		response.getOutputStream().close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}