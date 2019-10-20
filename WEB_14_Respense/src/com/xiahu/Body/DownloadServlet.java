package com.xiahu.Body;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.获得要下载的文件名
		String name = request.getParameter("filename");
		

		// 要下载文件的类型-------通过设置客户端的MIME-Type设置
		response.setContentType(this.getServletContext().getMimeType(name));

		// 强制要求必须得下载，而不是在客户端内解析打开
		response.setHeader("Content-Disposition", "attachment;filename=" + name);

		// 2.获取要下载的文件路径
		String path = request.getServletContext().getRealPath("/download/" + name);
		// 3.加载该文件路径
		InputStream is = new FileInputStream(path);
		// 4.创建response.getOutputStream()对象
		ServletOutputStream sos = response.getOutputStream();
		int len = 0;
		byte[] bys = new byte[1024];
		// 读取信息
		while ((len = is.read(bys)) != -1) {
			// 写入信息
			sos.write(bys, 0, len);
		}
		// 释放资源
		is.close();
		sos.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}