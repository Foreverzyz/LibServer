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


<title>查询书籍</title>

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
			您现在的位置： <b>图书查询</b>
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
							<font size=2>查询书籍</font>
						</div>
					</div>
					<div class="panel-body">
						<form id="queryUser" name=queryUser method="post" action="queryUser.action">
						<div class="panel panel-default" style="text-indent:30px">
								<br>
								<table style="line-height:30px">
									<tr>
										<div style="padding: 50px 50px 5px;">
										    <form class="bs-example bs-example-form" role="form">
										        <div class="row">
										            <div class="col-lg-5">
										                <div class="input-group">
										                    <span class="input-group-btn">
										                        <button class="btn btn-default" type="button">图书搜索</button>
										                    </span>
										                    <input type="text" class="form-control">
										                </div><!-- /input-group -->
										            </div><!-- /.col-lg-6 -->
										            <div class="col-lg-3"><label style="padding-left:25px;line-height: 34px;font-size: 14px;">搜索类型</label></div>
										           	<div class="col-lg-4">										           		
										           		<select class="form-control" name="user.certifiType" id="option_search_type">
															<option>--请选择--</option>
															<option value="bookname">书籍名称</option>
															<option value="booknum">索书号</option>
															<option value="booktype">书籍类型</option>
														</select>
										           	</div>										   
										        </div><!-- /.row -->
										    </form>
										</div>																			    		
									</tr>
								</table>				
							<br> <br>
						</div>

						<div>
							<table cellpadding="6" cellspacing="1" bgcolor="#dddddd"
								align="center" width="756px" border=1 style="line-height:35px;">
	
								<tr>
									<td align="center"><label>书架编号</label>
									</td>
									<td align="center"><label>书籍名称</label>
									</td>
									<td align="center"><label>索书号</label>
									</td>
									<td align="center"><label>书籍类型</label>
									</td>
									<td align="center"><label>修改</label>
									</td>	
									<td align="center"><label>删除</label>
									</td>								
								</tr>
								<s:iterator value="#request['users']" id="u" status="b">
									<tr onmouseover="this.style.backgroundColor='whitesmoke'"
										onmouseout="this.style.backgroundColor='white'" bgColor=white>
	
										<td align="center">${bookinfo.id}</td>
										<td align="center">${bookinfo.bookname}</td>
										<td align="center">${bookinfo.bookindex}</td>
										<td align="center">${bookinfo.booktype}</td>										
										<td align="center">
										<s:a href="updateUser?user.id=%{#u.id}&user.username=%{#u.username}
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
								<div class="page">${bookpage}</div>
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
							<s:property value="#pager.currentPage"/>
							页，总共
							<s:property value="#pager.totalPage"/>
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
