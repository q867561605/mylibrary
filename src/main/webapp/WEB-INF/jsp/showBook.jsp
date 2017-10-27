<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书列表</title>
</head>

<body>
	<c:if test="${msg}=='新用户'">
		alert("欢迎您!");
	</c:if>
	<table border="1">
		<tr>
			<td>ISBN</td>
			<td>名字</td>
			<td>贡献者</td>
			<td>描述</td>
			<td>上传时间</td>
		</tr>
		<c:forEach items="${bookList}" var="book" varStatus="vs">
			<tr>
				<td align="center">${book.ISBN}</td>
				<td align="center">${book.name}</td>
				<td align="center">${book.uploader}</td>
				<td align="center">${book.description}</td>
				<td align="center">${book.uploaddate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
