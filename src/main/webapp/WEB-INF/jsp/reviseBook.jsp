<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书</title>
</head>
<body>
	<form action="/library/book/reviseBook?book=${book}" method="post">
		ISBN：<input type="text" name="isbn" value="${book.isbn}"> <br>
		名字： <input type="text" name="name" value="${book.name}"><br>
		贡献者： <input type="text" name="uploader" value="${book.uploader}"><br>
		描述： <input type="text" name="description" value="${book.description}"><br>
		上传时间： <input type="text" name="uploaddate" value="${book.uploaddate}"><br>
		<input type="submit" value="修  改">
		<input type="reset" value="重  置">
	</form>
</body>
</html>