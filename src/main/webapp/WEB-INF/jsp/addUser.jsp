<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/library/user/addUser?user=${user}" method="post">
		用户名：<input type="text" name="username"> <br>
		密码： <input type="text" name="password"><br>
		角色： <input type="text" name="role"><br>
		<input type="submit" value="新  增"> 
		<input type="reset" value="重  置">
	</form>
</body>
</html>