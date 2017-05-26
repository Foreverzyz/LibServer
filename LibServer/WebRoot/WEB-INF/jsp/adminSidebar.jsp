<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>管理员侧边栏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>

<body>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">
				<font size=2>图书馆导航云平台</font>
			</div>
		</div>
		<div class="panel-body" style="line-height:20px; height:600px">
			<p>
				<font color=#747474><span class="glyphicon glyphicon-list"></span>&nbsp;图书管理</font>
			</p>
			<p style="text-indent: 20px;">
				<a href="add_jump_logic.action"><font color=#747474>添加图书</font> </a>
			</p>
			<p style="text-indent: 20px;">
				<a href="browseUserPaging.action"><font color=#747474 size=1>图书列表</font>
				</a>
			</p>
			<p style="text-indent: 20px;">
				<a href="searchUser.jsp"><font color=#747474>图书查询</font> </a>
			</p>
		</div>
	</div>
</body>
</html>
