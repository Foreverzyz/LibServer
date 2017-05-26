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


<title>图书添加</title>

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
</style>
<body>
	<div>
		<jsp:include page="adminNavbar.jsp" flush="true" />
	</div>
	<div class="all">
		<p align="left">
			您现在的位置： <a href="adminNavbar.jsp">后台管理</a> > <b>添加会员</b>
		</p>
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
							<font size=2>添加图书</font>
						</div>
					</div>
					<div class="panel-body">
						<form name="register" method="post" action="registerUser.action">
							添加图书<font color=grey> - - -
								- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
								- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
								- - - - - - - - - - - - - - - - - - - </font>								
								<button class="btn btn-default btn-xs" type="submit"><span class="glyphicon glyphicon-check"></span>保存</button>
                               <button class="btn btn-default btn-xs" type="reset"><span class="glyphicon glyphicon-share-alt"></span>撤销</button>
							<center>
								<br>
								<br>
								<table style="line-height:30px">
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>书籍名：</label></td>
										<td><input class="form-control" style="height:25px"  name="user.username" type="text"
											placeholder="书籍名"/>
										</td>
									</tr>
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>登录密码：</label>
										</td>
										<td><input class="form-control" style="height:25px" name="user.password" type="password"
											placeholder="请设置您的登录密码" /></td>

									</tr>
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>确认密码：</label></td>
										<td><input class="form-control" style="height:25px"  type="password" placeholder="再次输入您的登录密码" /></td>
									</tr>
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>姓名：</label>
										</td>
										<td><input  class="form-control" style="height:25px"  name="user.realname" type="text"
											placeholder="请输入姓名" />
										</td>
									</tr>
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>证件类型：</label>
										</td>
										<td>
										<select class="form-control"  name="user.certifiType" id="soption">
												
										</select>
										</td>
									</tr>
									<tr>
										<td><label><span><font color="red">*&nbsp;</font>
											</span>证件号码：</label>
										</td>
										<td><input class="form-control" style="height:25px"  name="user.certifiNum" type="text"
											placeholder="请输入您的证件号码" />
										</td>
									</tr>
									<tr>
										<td align=right><label>邮箱：</label></td>
										<td><input class="form-control" style="height:25px"  name="user.email" type="text"
											placeholder="请正确填写邮箱地址" />
										</td>
									</tr>
									<tr>
										<td align=right><label><span><font
													color="red">*&nbsp;</font> </span>手机号码：</label>
										</td>
										<td><input class="form-control" style="height:25px"  name="user.phone" type="text"
											placeholder="请输入您的手机号码" />
										</td>
									</tr>

								</table>
								
							</center>
						</form>
						<br> <br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function addItems(){
			$.ajax({
				type: "post",  
                url: "setSelectOption.action",  
                dataType:"json",  
                success: function(data){
                	var content = "";
                	for(var j = 0; j < data.length; j++){
                		content += "<option value=\"" + data[j].bookname + "\" >" + data[j].bookname + "</option>";
                	}
                	$("#soption").html("<option value='请选择'>请选择...</option> " + content);
                },  
                error: function(data){
                    alert("请求出错");
                }
			});
		}
		$(document).ready(function(){
			addItems();
		});
	</script>
</body>
</html>
