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


<title>查询会员</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
			您现在的位置： <a href="adminIndex.jsp">用户管理</a> > <b>查询会员</b>
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
							<font size=2>查询会员</font>
						</div>
					</div>
					<div class="panel-body">

						<form id="queryUser" name=queryUser method="post"
							action="queryUser.action">

							<div class="panel panel-default" style="text-indent:30px">
								<br>

								<table style="line-height:30px">
									<tr>
										<td align=right>用户名：</td>
										<td><input style="height:25px" name=username type=text
											value="${username}" placeholder="请输入要查询的用户名" />
										</td>
									</tr>

									<tr>
										<td align=right>真实姓名：</td>
										<td><input style="height:25px" name=realname type=text
											value="${realname}" placeholder="请输入要查询的真实姓名" />
										</td>
									</tr>

									<tr>
										<td align=right>证件号码：</td>
										<td><input style="height:25px" name=certifiNum type=text
											value="${certifiNum}" placeholder="请输入要查询的证件号码" />
										</td>
									</tr>

									<tr>
										<td align=right>手机号码：</td>
										<td><input style="height:25px" name=phone type=text
											value="${phone}" placeholder="请输入要查询的手机号码" /></td>
									</tr>
								</table>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-warning btn-xs" type="submit"
									style="width:148px;height:25px">
									<span class="glyphicon glyphicon-search"></span>&nbsp;查询
								</button>
						
						<br> <br>
					</div>

					<div>

							<table cellpadding="6" cellspacing="1" bgcolor="#dddddd"
								align="center" width="756px" border=1 style="line-height:35px;">

								<tr>
									<td align="center"><label>用户编号</label>
									</td>
									<td align="center"><label>用户名</label>
									</td>
									<td align="center"><label>密码</label>
									</td>
									<td align="center"><label>真实姓名</label>
									</td>
									<td align="center"><label>证件类型</label>
									</td>
									<td align="center"><label>证件号码</label>
									</td>
									<td align="center"><label>邮箱</label>
									</td>
									<td align="center"><label>手机号码</label>
									</td>
									<td align="center"><label>修改</label>
									</td>
									<td align="center"><label>删除</label>
									</td>
								</tr>
								<s:iterator value="#request['users']" id="u" status="b">
									<tr onmouseover="this.style.backgroundColor='whitesmoke'"
										onmouseout="this.style.backgroundColor='white'" bgColor=white>

										<td align="center">${u.id}</td>
										<td align="center">${u.username}</td>
										<td align="center">${u.password}</td>
										<td align="center">${u.realname}</td>
										<td align="center">${u.certifiType}</td>
										<td align="center">${u.certifiNum}</td>
										<td align="center">${u.email}</td>
										<td align="center">${u.phone}</td>
										<td align="center"><s:a
												href="updateUser?user.id=%{#u.id}&user.username=%{#u.username}
									&user.password=%{#u.password}&user.realname=%{#u.realname}&user.certifiType=%{#u.certifiType}
									&user.certifiNum=%{#u.certifiNum}&user.email=%{#u.email}&user.phone=%{#u.phone}">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;</s:a>
										</td>
										<td align="center"><s:a href="delUser?id=%{#u.id}">
												<span class="glyphicon glyphicon-trash"></span>&nbsp;</s:a>
										</td>
									</tr>
								</s:iterator>

							</table>

						<br>
						<center>
							<div class="page">${userpage}</div>
						</center>
						<center>
						<s:set name="pager" value="#request.pager" />
						<s:if test="#pager.hasFirst">
							<button class="btn btn-default btn-xs">
								<a href="queryUser.action?currentPage=1">首页</a>
							</button>
						</s:if>
						<s:if test="#pager.hasPrevious">
							<button class="btn btn-default btn-xs">
								<a
									href="queryUser.action?currentPage=<s:property value="#pager.currentPage-1"/>">上一页</a>
							</button>
						</s:if>
						<s:if test="#pager.hasNext">
							<button class="btn btn-default btn-xs">
								<a
									href="queryUser.action?currentPage=<s:property value="#pager.currentPage+1"/>">下一页</a>
							</button>
						</s:if>
						<s:if test="#pager.hasLast">
							<button class="btn btn-default btn-xs">
								<a
									href="queryUser.action?currentPage=<s:property value="#pager.totalPage"/>">尾页</a>
							</button>
						</s:if>
						</center>
					</div>
					<br>
					<center>
						当前第
						<s:property value="#pager.currentPage" />
						页，总共
						<s:property value="#pager.totalPage" />
						页 ，总共<strong> ${totalSize}</strong> 条记录
					</center>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>
