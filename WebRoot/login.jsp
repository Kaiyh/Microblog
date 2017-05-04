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

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="weibo.css">

<style type="text/css">
#tittle01 {
	font-family: 楷体_gb2312;
	font-size: 78px;
	font-weight: 600;
	color: #4455FF;
}

#tittle02 {
	font-size: 26px;
}
</style>
</head>

<body id="bd">
	<%
		session.setAttribute("ID", "");
	%>

	<div id="form-wrapper">
		<div id="tittle01">微博</div><br><br>
		<div id="tittle02">随时随地&nbsp;&nbsp;发现新鲜事</div>
		<form action="login.action" method="post">
			<div id="form">
				<div id="form-item">
					<input type="text" name="userName" required="required"
						placeholder="用户名" autocomplete="off">
				</div>
				<div id="form-item">
					<input type="password" name="userPsw" required="required"
						placeholder="密码" autocomplete="off">
				</div>
				<div id="button-panel">
					<input type="submit" value="登录" id="button">
				</div>
			</div>
		</form>
		<br>
		<div>
			还没有微博？<a href="registerView.action">立即注册</a>
		</div>
	</div>

	<script>
		solid();
	</script>
</body>
</html>
