<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书列表</title>
</head>
<script type="text/javascript">
	function fun(){
		var obj1=document.getElementsByName("searchstr")[0].value;
		document.location.href= "/library/book/findBook?search=" +obj1;
	}
</script>
<body>
	<c:if test="${msg=='new'}">
	<script language='javascript'>
		alert("欢迎您加入图书管理系统！");
	</script>
	</c:if>
	<c:if test="${role==2}">
	<a href="/library/user/allUser">用户列表</a>
	</c:if>
	<c:if test="${role>0}">
	<a href="/library/book/toAddBook">增加图书</a>
	</c:if>
	<center>
		<input type="text" id="searchstr" name="searchstr" class="textbox" size="30">
		<input type="button" value="搜索" onclick="fun()">
	</center>
	
	<table border="1">
		<tr>
			<td>ISBN</td>
			<td>名字</td>
			<td>贡献者</td>
			<td>描述</td>
			<td>上传时间</td>
			<td>功能</td>
		</tr>
		<c:forEach items="${bookList}" var="book" varStatus="vs">
		<tr>
			<td align="center">${book.ISBN}</td>
			<td align="center">${book.name}</td>
			<td align="center">${book.uploader}</td>
			<td align="center">${book.description}</td>
			<td align="center">${book.uploaddate}</td>
			<td align="center">
				<a href="/library/book/downBook">下载</a>
				<c:if test="${role>0}"><a href="/library/book/toReviseBook?ISBN=${book.ISBN}">修改</a></c:if>
				<c:if test="${role>0}"><a href="/library/book/deleteBook?ISBN=${book.ISBN}">删除</a></c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
