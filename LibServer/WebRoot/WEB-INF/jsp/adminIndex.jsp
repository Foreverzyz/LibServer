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


<title>图书馆云平台</title>

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
<script type="text/javascript">
	function CheckAll(thisform) {
		for ( var i = 0; i < thisform.elements.length; i++) {
			var e = thisform.elements[i];
			if (e.Name != "chkAll" && e.disabled != true)
				e.checked = thisform.chkAll.checked;
		}
	}
</script>
<style type="text/css">
*,html,body {
	font-size: 12px;
}

.td1 {
	background: #eeeeee;
	height: 30px;
}

.td2 {
	background: #fefefe;
	height: 25px;
}
</style>
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
	<jsp:include page="adminNavbar.jsp" flush="true" />
</div>
	
<div class="all">
	<div class="row">
		<div class="col-lg-2">
			<jsp:include page="adminSidebar.jsp" flush="true" />
		</div>
		<div class="col-lg-10" >
			<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="panel-title">
									<font size=2>平台信息</font>
							</div>
						</div>
						<div class="panel-body">
							
						</div>
					<br>
			</div>
		</div>
	</div>
</div>
</body>
</html>
