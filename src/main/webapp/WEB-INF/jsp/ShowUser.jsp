<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>用户列表</title>  
  </head>  
  
  <body>  
	<a href="/library/book/allBook?tag=2">图书列表</a>
	<a href="/library/user/toAddUser">添加用户</a>
    <table border="1">
		<tr>
			<td>用户名</td>
			<td>角色</td>
			<td>功能</td>
		</tr>
		<c:forEach items="${userList}" var="user" varStatus="vs">
		<tr>
			<td align="center">${user.username}</td>
			<td align="center">${user.role}</td>
			<td align="center">
				<a href="/library/user/toAlterUser?name=${user.username}">修改</a>
				<a href="/library/user/deleteUser?name=${user.username}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
  </body>  
</html>  