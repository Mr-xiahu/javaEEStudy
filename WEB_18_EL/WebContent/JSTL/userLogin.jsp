<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xiahu.domain.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 模拟用户登录成功 -->
    <%
       User user =new User();
       user.setId("111");
       user.setName("夏虎");
       user.setAge("123");
       session.setAttribute("user", user);
    
    %>
</body>
</html>