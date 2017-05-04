<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<title>注册新用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="weibo.css">

<style type="text/css">
#tittle {
    top: 100px;
	font-size: 45px;
	font-weight: 300;
}
</style>
</head>

<body id="bd">
<div id="form-wrapper">
	<div id="tittle">注册新用户</div><br>
	
	
	<s:form action="register.action" method="post">
		<div id="form">
			<div id="form-item">
				<s:textfield name="newUser" required="required" placeholder="用户名" autocomplete="off" />
			</div>
			<div id="form-item">
				<s:password name="newPsw" required="required" placeholder="密码" autocomplete="off" />
			</div>
			<div id="form-item">
				<s:password required="required" placeholder="确认密码" autocomplete="off" />
			</div>
			<div id="button-panel">
				<s:submit value="注册" id="button" />
			</div>
		</div>
	</s:form>
	
	
	<%-- <form action="register.action" method="post">
		<div id="form">
			<div id="form-item">
				<input type="text" name="newUser" required="required" placeholder="用户名" autocomplete="off" />
			</div>
			<div id="form-item">
				<input type="password" name="newPsw" required="required" placeholder="密码" autocomplete="off" />
			</div>
			<div id="form-item">
				<input type="password" required="required" placeholder="确认密码" autocomplete="off" />
			</div>
			<div id="button-panel">
				<s:submit value="注册" id="button" />
			</div>
		</div>
	</form>
	 --%>
	
	<br>
	<div><a href="loginView.action">返回登陆</a></div>
</div>

<script>
    solid();
</script>
</body>
</html>
