<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--  EL表达式（Expression Language） 
		${}
		page,request, session, application
		如果没有前缀，EL表达式会按照以下顺序依次查找，如果找到就取出，停止，没找到就继续往后找
		page < request < session < application
		
		前缀, 指定从哪个作用域里面获取值：
		pageScope, requestScope, sessionScope, applicationScope
		
		比较符：
		>	<	>=	<=	==	!=	!
		gt	lt	ge	le	eq	ne	not
		
		组合
		&&	||
		and	or
		
	 --%>
	${1>10}
	<%-- <%
		String user = (String)request.getAttribute("user");
		out.write(user);
	%> --%>
	${requestScope.loginUser.userId ne 10}
	<br /> ${not (requestScope.loginUser.userName eq "lisi")}
	<br /> ${requestScope.loginUser.addr.city}
	<br /> ${requestScope.loginUser.addr.street}
	<br /> ${sessionScope.count}
	<br /> ${applicationScope.count}


	<!-- JSTL(Java Standard Tag Lib)
	
	 -->

	<!-- 类似switch case, 可以实现if else的功能
	 可以写多个when，可以没有otherwise -->
	<c:choose>
		<c:when test="${count lt 60}">
			<h1>不及格</h1>
		</c:when>
		<c:when test="${count ge 60 and count lt 90}">
			<h1>及格</h1>
		</c:when>
		<c:otherwise>
			<h1>优秀</h1>
		</c:otherwise>
	</c:choose>

	<!-- if语句，没有else -->
	<c:if test="${count gt 50}">
		<h1>1==1： true</h1>
	</c:if>
	<c:if test="${not (count gt 50)}">
		<h1>1==1： false</h1>
	</c:if>


	${1<10}
	<%-- <c:choose>
	<c:when test="${111 eq 111}">
		<h1>111</h1>
	</c:when>
</c:choose> --%>
	<c:choose>
		<c:when test="${1 eq 1}">
			<h2>xxxx</h2>
		</c:when>
	</c:choose>
	<br /> ${user.addr.city}
</body>
</body>
</html>