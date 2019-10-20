<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 通过EL内置对象来获取数据 -->

	<!-- 使用el获得参数 -->
	${param.username } 
	<hr>
	${header["User-Agent"] } 
	<hr>
	${initParam.aaaa }
	<hr>
	${cookie.name.value }
	<hr>


	<!-- 通过el表达式获得request对象 -->
	${pageContext.request }
	<hr>
	
	<!-- 注意,下面该方法特别重要 -->
	${pageContext.request.contextPath }
	

</body>
</html>