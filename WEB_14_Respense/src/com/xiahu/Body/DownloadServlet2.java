package com.xiahu.Body;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 文件名是中文名称的下载
 * 
 * @author Administrator
 *
 */
public class DownloadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得要下载的文件名
		String name = request.getParameter("filename");// å¼ ä¸.zip
		// 将response缓冲的ISO8859-1码表改变成UFT-8的码表
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");// 张三.zip

		// 获取Request响应头中的User-agent数据
		String agent = request.getHeader("User-agent");

		// 根据不同浏览器进行不同的编码
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE浏览器
			filenameEncoder = URLEncoder.encode(name, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(name.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			filenameEncoder = URLEncoder.encode(name, "utf-8");
		}

		// 要下载文件的类型-------通过设置客户端的MIME-Type设置
		response.setContentType(this.getServletContext().getMimeType(name));

		// (重点)
		// 告诉客户端该文件不是直接解析 而是以附件形式打开(下载)----filename="+name 客户端默认对名字进行解码
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);

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
