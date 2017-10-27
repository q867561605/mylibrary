<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>用户列表</title>  
  </head>  
    
  <body>  
    <table border="1">
		<tr>
			<td>用户名</td>
			<td>角色</td>
		</tr>
		<c:forEach items="${userList}" var="user" varStatus="vs">
			<tr>
				<td align="center">${user.username}</td>
				<td align="center">${user.role}</td>
			</tr>
		</c:forEach>
	</table>
  </body>  
</html>  