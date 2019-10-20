<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.xiahu.domain.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  -->
	<%
		//添加数据到List<String>中
		List<String> list = new ArrayList<String>();
		list.add("itcast");
		list.add("itheima");
		list.add("boxuegu");
		list.add("shandingyu");
		request.setAttribute("strList", list);
		
		//添加数据到List<User>
		List<User> userList = new ArrayList<User>();
		User user1=new User();
		user1.setName("夏虎");
		user1.setAge("20");
		userList.add(user1);
		User user2=new User();
		user2.setName("杨铭");
		user2.setAge("19");
		userList.add(user2);
		session.setAttribute("userList", userList);
		
		//添加数据到Map<String,String>
		Map<String,String> map=new HashMap<String,String>();
		map.put("刘德华", "40");
		map.put("张学友", "45");
		map.put("郭富城", "35");
		map.put("黎明", "20");
		session.setAttribute("map", map);
		
		//添加数据到Map<String,User>
		Map<String,User> mapUser=new HashMap<String,User>();
		User user3=new User();
		user3.setName("夏Fu");
		user3.setAge("20");
		mapUser.put("帅哥", user3);
		User user4=new User();
		user4.setName("财鱼");
		user4.setAge("19");
		mapUser.put("美女", user4);
		session.setAttribute("mapUser", mapUser);
		
	%>




	<!-- 遍历List<String>的值 -->
	<h1>遍历List<String>的值 </h1>
	
	<c:forEach items="${strList }" var="str">
	   ${str }<br>
	</c:forEach>
	<hr>
	
	<!-- 遍历List<User>的值 -->
	<h1>遍历List<User>的值 </h1>
	<c:forEach items="${userList }" var="user">
	   ${user.name }----${user.age }<br>
	</c:forEach>
	<hr>
	
	<!-- 遍历Map<String,String>的值 -->
	<h1>遍历Map<String,String></h1>
	<c:forEach items="${map }" var="entry">
		${entry.key }====${entry.value }<br/>
	</c:forEach>
	
	 
	
	
	<!-- 遍历Map<String,User>的值的值 -->
	<h1>Map<String,User></h1>
	<c:forEach items="${mapUser }" var="entry">
	    ${entry.key}======${entry.value.name }======${entry.value.age }<br>
	</c:forEach>
</body>
</html>