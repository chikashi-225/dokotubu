<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link rel="stylesheet" href="/dokotubu/css/dokotubu.css">
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name }"/>さん、ログイン中
<a href="/dokotubu/Logout">ログアウト</a>
</p>
<p><a href="/dokotubu/Main">更新</a></p>
<form action="/dokotubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${errorMsg != null }">
	<p class="error">${errorMsg }</p>
</c:if>
<p>
<c:forEach var="mutter" items="${mutterList }">
	<br><c:out value="${mutter.userName }"/>:<br>
			<c:out value="${mutter.text }"/>			
</c:forEach>
<c:forEach var="count" items="${countList }">
	<form action="/dokotubu/GoodCountMethod" method="post">
		<button type="submit" name="good" value="1">good</button></form>
	<br><c:out value="${count.good }"></c:out><br>
</c:forEach>
</p>
</body>
</html>