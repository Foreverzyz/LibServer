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

<title>管理员导航栏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

</head>

<style>
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}

ul {
	list-style: none;
}

img {
	border: none;
}

body {
	font-size: 12px;
	/*line-height: 5px;
			text-align:center;*/
	background: #FFFFFF;
	font-family: "微软雅黑";
}

.all {
	width: 950px;
	margin: 0 auto;
}

.navColor {
	width: 950px;
	margin: 0 auto;
	background-color: #204D74;
}

.enter {
	text-align: center;
	margin: 0 0 10px 0;
}

.bottom {
	width: 60px;
	height: 25px;
	background-color: orangered;
	color: white;
}

.label1 {
	color: #065FB9;
	font-weight: 500;
}

#SearchBox {
	width: 950px;
	background: whitesmoke;
	margin: 30px auto;
	text-align: left;
}

#SearchBox div label {
	float: left;
	width: 400px;
	text-align: right;
	padding: 0 10px 0 0;
}

#SearchBox div {
	clear: both;
	padding: 5px 0 2px 0;
}

h1 {
	height: 25px;
	line-height: 25px;
	background: #CCCCCC;
	font-size: 14px;
	border-bottom: 1px solid #CCCCCC;
	text-indent: 5px;
	/*首行缩进5像素*/
}
</style>

<body>
	<div>
		<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div
				style="display: flex;width: 950px;margin: auto;align-items: center;justify-content: space-between;">
				<ul class="nav navbar-nav navbar-left">
					<li style="font-size: 23px;">图书馆导航后台服务管理平台</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li style="margin-top:15px">
						<span class="glyphicon glyphicon-user"></span> <span>${sessionScope.username}</span>
					</li>
					<li>
						<a href="logout.action"> 
							<span class="glyphicon glyphicon-log-out"></span> 退出系统
						</a>
					</li>
				</ul>
			</div>
		</div>
		</nav>
	</div>
</body>
</html>
