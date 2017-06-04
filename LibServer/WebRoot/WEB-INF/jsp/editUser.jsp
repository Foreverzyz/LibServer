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


<title>修改会员信息</title>

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

<style type="text/css">
*,html,body {
	font-size: 12px;
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
</style>
<body>
	<div>
		<jsp:include page="adminNavbar.jsp" flush="true" />
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script
			src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</div>
	<div class="all">
		<p align="left">
			您现在的位置： <a href="adminIndex.jsp">图书管理</a> > <b>修改图书信息</b>
		</p>
	</div>
	<div class="all">
		<div class="row">
			<div class="col-lg-2">
				<jsp:include page="adminSidebar.jsp" flush="true" />
			</div>
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							<font size=2>修改图书信息</font>
						</div>
					</div>
					<div class="panel-body">
						<form name="update" method="post" action="saveUpdateUser.action">
						<font color=red>*&nbsp;</font>图书信息<font color=grey> - - -
								- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
								- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
								- - - - - - - - - - - - - - - - -  </font>								
								<button class="btn btn-default btn-xs" type="submit"><span class="glyphicon glyphicon-check"></span>保存</button>
                               <button class="btn btn-default btn-xs" type="reset"><span class="glyphicon glyphicon-share-alt"></span>撤销</button>
							<center>
								<input name="user.id" type="hidden"
									value="<s:property value='user.id'/>" /> <input
									name="user.username" type="hidden"
									value="<s:property value='user.username'/>" />
								<table style="line-height:30px">
									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>用户名：</label></td>
										<td><strong><s:property value='user.username' />
										</strong>
										</td>
									</tr>

									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>姓名：</label></td>
										<td><input class="form-control" style="height:25px" name="user.realname" type="text"
											value="<s:property value='user.realname'/>" /></td>
									</tr>
									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>密码：</label></td>
										<td><input class="form-control" style="height:25px" name="user.password" type="text"
											value="<s:property value='user.password'/>" /></td>
									</tr>
									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>证件类型：</label></td>
										<td><select class="form-control" name="user.certifiType" style="width:150px">
												<option value="二代身份证">二代身份证</option>
												<option value="港澳通行证">港澳通行证</option>
												<option value="台湾通行证">台湾通行证</option>
												<option value="护照">护照</option>
										</select></td>
									</tr>

									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>证件号码：</label></td>
										<td><input class="form-control" style="height:25px" name="user.certifiNum" type="text"
											value="<s:property value='user.certifiNum'/>" /></td>
									</tr>
									<tr>
										<td align=right><label>邮箱：</label></td>
										<td><input class="form-control" style="height:25px" name="user.email" type="text"
											value="<s:property value='user.email'/>" /></td>
									</tr>
									<tr>
										<td align=right><label><font color=red>*&nbsp;</font>手机号码：</label></td>
										<td><input class="form-control" style="height:25px" name="user.phone" type="text"
											value="<s:property value='user.phone'/>" /></td>
									</tr>
								</table>
								<br> 
							</center>
						</form>
						<br>
						
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
