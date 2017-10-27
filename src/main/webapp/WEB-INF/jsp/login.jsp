<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
-->
<body>
	<center>
		<font face="楷体" size="6" color="#000">登录界面</font>
		<form name="User" action="/library/user/login" method="post">
			<table width="300" height="180" border="5" bordercolor="#A0A0A0">
				<tr>
					<th>账 户：</th>
					<td><input type="text" name="username" value="请输入用户名"
						maxlength="16" onfocus="if(this.value == '请输入用户名') this.value =''">
					</td>
				</tr>
				<tr>
					<th>密 码：</th>
					<td><input type="password" name="password" maxlength="20">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit"name="submit" value="登       录"> 
						<input type="button" value="退       出" onclick="javascript:window.close()">
					</td>
				</tr>
			</table>
			<a href="/library/user/GoRegister"> 还没账号？注册 </a>
		</form>
		<font color=red>${msg} </font>
	</center>
</body>
</html>