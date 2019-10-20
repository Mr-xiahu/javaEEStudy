<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.xiahu.domain.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//在request域中添加一个数据
		request.setAttribute("name", "张三");

		//在session域中添加一个User对象
		User user = new User();
		user.setId("1001");
		user.setName("夏虎");
		user.setAge("20");
		session.setAttribute("user", user);

		//在contentServlet中添加一个集合
		List<User> list = new ArrayList<User>();

		User user2 = new User();
		user2.setId("1003");
		user2.setName("杨铭");
		user2.setAge("19");
		list.add(user2);

		User user3 = new User();
		user3.setId("1004");
		user3.setName("财鱼");
		user3.setAge("21");
		list.add(user3);
		application.setAttribute("list", list);
	%>

	<!-- 传统方式调用域中的数据 -->

	<!-- 调用request中的数据 -->
	<%=request.getAttribute("name")%>
	<hr>
	<%
		//调用session域中的数据
		User sessionUser = (User) session.getAttribute("user");
		out.write(sessionUser.getName());
	%>
	<!-- 集合中的数据用传统的方法没办法调用,只能用EL表达式 -->
	<hr>
	<!-- EL表达式调用 -->
	${requestScope.name }
	${sessionScope.user.name }
	${applicationScope.list[1].name} 
	<hr>
    <!-- 使用el表达式 全域查找 -->
	${name }
	${user.age }
	${list[1].id}


</body>
</html>