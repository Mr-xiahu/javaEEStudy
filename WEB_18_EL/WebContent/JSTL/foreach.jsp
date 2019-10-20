<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.xiahu.domain.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- new一个User对象 -->
    <%
       User user=new User();
       user.setName("张三");
       user.setAge("23");
       session.setAttribute("user", user);
    
    %>


	<!-- foreach模拟
	    for(int i=0;i<5;i++){
             syso(i);
         }
     -->
     <c:forEach begin="0" end="5" var="i">
        ${i }<br>
     </c:forEach>
     <hr>
     
     <!-- foreach模拟增强for
          for(User user:users){
               sysou(user.getname());
          }
      
      -->
      <c:forEach items="user" var="u">
         ${user.name }<br>
         ${user.age }
      </c:forEach>
      
</body>
</html>