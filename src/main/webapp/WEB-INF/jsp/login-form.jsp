<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Form</title>
		<link rel = "stylesheet" type = "text/css" href = "${base}styles.css">
	</head>
	<body>
		<h6>${message}</h6>
		<form method = "post" action="${base}login/login-action1.form">
			<div>
				<h2>登录 login-action1.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
		
		<form method = "post" action="${base}login/login-action2.form">
			<div>
				<h2>登录 login-action2.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
		
		<form method = "post" action="${base}login/login-action3.form">
			<div>
				<h2>登录 login-action3.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
		
		<form method = "post" action="${base}login/login-action4.form">
			<div>
				<h2>登录 login-action4.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
		
		<form method = "post" action="${base}login/login-action5.form">
			<div>
				<h2>登录 login-action5.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
		
		<form method = "post" action="${base}login/login-action6.form">
			<div>
				<h2>登录 login-action6.form</h2>
				<p><label>用户</label><input type = "text" name = "name"/></p>
				<p><label>密码</label><input type = "password" name = "pwd"/></p>
				<h3><input type = "submit" value = "登录"/></h3>
			</div>
		</form>
	</body>
</html>