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

<title>欢迎</title>

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
		String weibo = UserDao.showWeibo(ID);
		if (weibo == null || weibo.equals("") || weibo.equals("null")) {
			weibo = "这个主人很懒，什么都没有留下……";
		}
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
			<div id="content-area-ww" >
				<%= weibo %>
			</div>
		</div>

	</div>

</body>
</html>
