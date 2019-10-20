package com.xiahu.web;

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

public class FileUpLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1、创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 2、创建文件上传的核心类
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 3、解析request---获得文件项集合
			List<FileItem> parseRequest = upload.parseRequest(request);
			// 4、遍历文件项集合
			for (FileItem item : parseRequest) {
				// 5、判断普通表单项或者是文件上传项
				boolean formField = item.isFormField();
				if (formField) {
					// 普通表单项
					String fieldName = item.getFieldName();
					String fileValue = item.getString();
					System.out.println(fieldName + "------" + fileValue);
				} else {
					// 文件上传项
					// 获得文件上传项的名称
					String fieldName = item.getFieldName();
					// 获得文件上传项的内容
					InputStream in = item.getInputStream();
					// 将in中的数据拷贝服务器上
					String Path = this.getServletContext().getRealPath("upload");
					OutputStream out = new FileOutputStream(Path + "/" + fieldName);
					int len = 0;
					byte[] bys = new byte[1024];
					while ((len = in.read(bys)) != -1) {
						out.write(bys, 0, len);
					}
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}