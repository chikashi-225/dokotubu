<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/dokotubu/Login" method="post">
ユーザー名:<input type="text" name="name"><br>
パスワード:<input type="text" name="pass"><br>
<input type="submit" value="ログイン">
</form>
アカウント登録をされていない方は<a href="/dokotubu/accountRegist.jsp">こちら</a>から。
</body>
</html>