<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:url var="base" value="/"></c:url> 以及${base} 是为了解决路径问题 -->
<c:url var="base" value="/"></c:url>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Success</title>
		<link ref = "styles.css" type = "text/css" href = "${base}styles.css"/>
	</head>
	<body>
		<h6>${user.name}登录成功!</h6>
	</body>
</html>