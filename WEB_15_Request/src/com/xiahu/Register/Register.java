package com.xiahu.Register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.xiahu.Utils.DataSourceUtil;
import com.xiahu.domain.User;

/**
 * 页面注册
 * 
 * @author Administrator
 *
 */
public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单数据
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// String email = request.getParameter("email");
		// String name = request.getParameter("name");
		// String inlineRadioOptions =
		// request.getParameter("inlineRadioOptions");
		// String birthday = request.getParameter("birthday");

		// 封装数据
		// User user=new User();
		// user.setUsername(username);
		// user.setPassword(password);
		// user.setEmail(email);
		// user.setName(name);
		// user.setSex(inlineRadioOptions);
		// user.setBirthday(birthday);
		// 这种做法太麻烦了,现在与方法直接调用即可

		// 如何解决乱码?这种方式只能是Post提交
		request.setCharacterEncoding("UTF-8");

		// get方式怎么提交呢？
		// 先用ios8859-1码表进行编码,然后用UTF-8进行解码
		// username=new String(username.getBytes("ios8859-1"),"UTF-8");

		// 1.创建bean对象
		User user = new User();
		// 2.创建Request集合对象
		Map<String, String[]> properties = request.getParameterMap();

		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 3.因为Uid在页面不能被写入，所以我要在这里手动添加一个字符串
		// 有一个方法直接添加
		user.setUid(UUID.randomUUID().toString());

		// 获取数据库连接,对数据进行存储
		try {
			regist(user);
		} catch (SQLException e) {
			System.out.println("数据更新失败");
		}

	}

	public void regist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		// 编写SQL语句
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), null,
				user.getBirthday(), user.getSex(), null, null);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}