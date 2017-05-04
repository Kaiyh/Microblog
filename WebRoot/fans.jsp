<%@ page language="java" import="java.util.*,dao.*" pageEncoding="UTF-8"%>
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

<title>我的粉丝</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="weibo.css">


</head>

<body id="main_bd">

	<%
		String ID = (String) session.getAttribute("ID");
		Vector<String> ve = UserDao.showFans(ID);
	%>

	<div id="container">

		<div id="menu">
			<div id="menu_item">
				<h2>User</h2>
				<ul>
					<li><%=ID%>
					<li><a href="loginView.action">退出登录</a>
				</ul>
			</div>
			<hr>
			<h2>Menu</h2>
			<ul>
				<li><a href="write_weiboView.action">写微博</a>
				</li>
				<li><a href="login_success.action">我的微博</a>
				</li>
				<li><a href="attentionView.action">我的关注</a>
				</li>
				<li><a href="fansView.action">我的粉丝</a>
				</li>
			</ul>
		</div>
		
		<div id="content">
			<div id="content-area" >
				我的粉丝：<br>
				<ul>
					<%
					int len = ve.size();
					for (int i = 0; i < len; i++) { %>
						<li><%= ve.get(i) %>
					<% } %>
					<%
					if (len == 0) { %>
						<span>尴尬(OO)一个粉丝都没有……</span>
					<% } %>
				</ul>
			</div>
		</div>

	</div>

</body>
</html>
