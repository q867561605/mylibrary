<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/library/book/addBook?book=${book}" enctype="multipart/form-data" method="post">
		ISBN：<input type="text" name="isbn"> <br>
		名字： <input type="text" name="name"><br>
		贡献者： <input type="text" name="uploader"><br>
		描述： <input type="text" name="description"><br>
		上传时间： <input type="text" name="uploaddate"><br>
		地址： <input type="file" name="file1"><br>
		<input type="submit" value="上  传"> 
		<input type="reset" value="重  置">
	</form>
</body>
</html>