package com.xiahu.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class FileUpLoadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1、创建磁盘文件项工厂
			// 作用：设置缓存文件的大小 设置临时文件存储的位置
			String path_temp = this.getServletContext().getRealPath("temp");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024);// 设置缓存文件的大小
			factory.setRepository(new File(path_temp));// 设置缓存目录

			// 2、创建文件上传的核心类
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置上传文件的名称的编码
			upload.setHeaderEncoding("UTF-8");

			// ServletFileUpload的API
			boolean multipartContent = upload.isMultipartContent(request);// 判断表单是否是文件上传的表单
			if (multipartContent) {
				// 是文件上传表单
				// ***解析request获得文件项集合
				List<FileItem> parseRequest = upload.parseRequest(request);
				for (FileItem item : parseRequest) {
					// 判断是否是普通文件项
					boolean formField = item.isFormField();
					if (formField) {
						// 是普通表单项
						String fieldName = item.getFieldName();
						String fieldValue = item.getString("UTF-8");// 对普通表单项的内容进行编码
						System.out.println(fieldName + "-------" + fieldValue);

						// 当表单是enctype="multipart/form-data"时
						// request.getParameter相关的方法
						// String parameter = request.getParameter("username");
					} else {
						// 是文件上传项
						String fieldName = item.getFieldName();
						InputStream in = item.getInputStream();
						String path_store = this.getServletContext().getRealPath("upload");
						OutputStream out = new FileOutputStream(path_store + "/" + fieldName);
						IOUtils.copy(in, out);

						in.close();
						out.close();

						// 删除临时文件
						item.delete();

					}
				}
			} else {
				// 不是文件上传表单
				// 使用原始的表单数据的获得方式 request.getParameter();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}