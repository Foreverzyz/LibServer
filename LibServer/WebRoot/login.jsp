<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>管理员登录</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/signin.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>

<body>
	<div style="text-align:center; margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
		<h3>图书馆导航后台登录</h3>
	</div>
	<div class="signin">
		<div class="signin-head">
			<img src="img/test/head_120.png" alt="" class="img-circle">
		</div>
		<form action="login.action" method="post" class="form-signin" role="form">
			<input type="text" class="form-control" placeholder="用户名" required autofocus name="username"/> 
			<input type="password" class="form-control" placeholder="密码" required name="password" />
			<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		</form>
	</div>
</body>
</html>
