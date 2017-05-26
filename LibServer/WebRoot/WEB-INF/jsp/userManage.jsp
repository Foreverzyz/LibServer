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


<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
			您现在的位置： <a href="adminIndex.jsp">后台</a> > 用户管理 > <b>会员列表</b>
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
							<font size=2>会员列表</font>
						</div>
					</div>
					<div class="panel-body">
						<br>
						<br>
						<div align=center>
							<s:form theme="simple" action="delAllUser" method="post">
								<table cellpadding="6" cellspacing="1" bgcolor="#dddddd"
									align="center" width="740px" border=1 style="line-height:35px;">
									<tr><td colspan="11" align="center">会员列表</td></tr>
									<tr>
										<td align="center"><label>序号</label>
										</td>
										<td align="center"><label>全/否</label>
										</td>
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
									</tr>
									<s:iterator value="#request['users']" id="u" status="b">
										<tr onmouseover="this.style.backgroundColor='whitesmoke'"
											onmouseout="this.style.backgroundColor='white'" bgColor=white>

											<td align="center"><s:property value="#b.index+1" /></td>
											<td align="center" width="30"><s:checkbox name="ids"
													value="false" fieldValue="%{#u.id}"></s:checkbox>
											</td>
											<td align="center">${u.id}</td>
											<td align="center">${u.username}</td>
											<td align="center">${u.password}</td>
											<td align="center">${u.realname}</td>
											<td align="center">${u.certifiType}</td>
											<td align="center">${u.certifiNum}</td>
											<td align="center">${u.email}</td>
											<td align="center">${u.phone}</td>
											<td align="center">
													<s:a
														href="updateUser?user.id=%{#u.id}&user.username=%{#u.username}
									&user.password=%{#u.password}&user.realname=%{#u.realname}&user.certifiType=%{#u.certifiType}
									&user.certifiNum=%{#u.certifiNum}&user.email=%{#u.email}&user.phone=%{#u.phone}">
														<span class="glyphicon glyphicon-edit"></span>&nbsp;</s:a>
												
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td></td>
										<td align="center"><s:checkbox name="chkAll"
												onclick="CheckAll(this.form)"></s:checkbox></td>
										<td colspan="12" align="left">&nbsp;
											<button class="btn btn-danger btn-xs" type="submit">
												<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
											</button></td>
									</tr>
								</table>
							</s:form>
							<br>
							<center>
								<div class="page">${userpage}</div>
							</center>
							<s:set name="pager" value="#request.pager" />
							<s:if test="#pager.hasFirst">
								<button class="btn btn-default btn-xs">
									<a href="browseUserPaging.action?currentPage=1">首页</a>
								</button>
							</s:if>
							<s:if test="#pager.hasPrevious">
								<button class="btn btn-default btn-xs">
									<a
										href="browseUserPaging.action?currentPage=<s:property value="#pager.currentPage-1"/>">上一页</a>
								</button>
							</s:if>
							<s:if test="#pager.hasNext">
								<button class="btn btn-default btn-xs">
									<a
										href="browseUserPaging.action?currentPage=<s:property value="#pager.currentPage+1"/>">下一页</a>
								</button>
							</s:if>
							<s:if test="#pager.hasLast">
								<button class="btn btn-default btn-xs">
									<a
										href="browseUserPaging.action?currentPage=<s:property value="#pager.totalPage"/>">尾页</a>
								</button>
							</s:if>
						</div>
						<br>
						<center>
							当前第
							<s:property value="#pager.currentPage" />
							页，总共
							<s:property value="#pager.totalPage" />
							页 ，总共<strong> ${totalSize}</strong> 条记录
						</center>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
