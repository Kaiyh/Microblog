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

<title>写微博</title>

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
				<form action="write.action">
					<textarea name="message" rows="15" cols="60" placeholder="分享新鲜事……"
						required="required"></textarea>
					<div>
						<input type="submit" value="发送">
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>
