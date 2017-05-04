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

<title>我的关注</title>

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
		Vector<String> ve = UserDao.showAttens(ID);
		Vector<String> ve2 = (Vector<String>)request.getAttribute("ve2");
		if (ve2 == null) {
			ve2 = new Vector<String>();
		}
	%>

	<div id="container">

		<div id="menu">
			<div id="menu_item">
				<h2>User</h2>
				<ul>
					<li><%= ID %>
					<li><a href="loginView.action">退出登录</a>
				</ul>
			</div>
			<hr>
			<h2>Menu</h2>
			<ul>
				<li><a href="write_weiboView.action">写微博</a></li>
				<li><a href="login_success.action">我的微博</a></li>
				<li><a href="attentionView.action">我的关注</a></li>
				<li><a href="fansView.action">我的粉丝</a></li>
			</ul>
		</div>

		<div id="content">
			
			<div id="content-area">
			我的关注：<br>
			<form action="noatten.action" method="post">
				<%
				int len = ve.size();
				for (int i = 0; i < len; i++) { %>
					<input type="radio" name="atten" value="<%= ve.get(i) %>"/><%= ve.get(i) %><br><br>
				<% } %>
				<%
				if (len > 0) { %>
					<input type="submit" name="button" value="取消关注" />
				<% } else { %>
					<span>没有关注任何人……</span>
				<% } %>
			</form>
			</div>

			<div id="content-area">
			搜索的用户不存在！<br><br>可能感兴趣的人：<br>
			<form action="">
				<%
				int len2 = ve2.size();
				for (int i = 0; i < len2; i++) { %>
					<input type="radio" name="atten" value="<%= ve2.get(i) %>"/><%= ve2.get(i) %><br><br>
				<% } %>
				<input type="submit" name="button" value="关注Ta" />
			</form>
			</div>
			
		</div>

	</div>

</body>
</html>
