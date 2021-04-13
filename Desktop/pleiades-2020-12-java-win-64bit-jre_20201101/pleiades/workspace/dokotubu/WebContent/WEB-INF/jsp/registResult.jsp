<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録</title>
<link rel="stylesheet" url="/dokotubu/css/dokotubu.css">
</head>
<body>
	<h1>アカウント登録</h1>
	<c:choose>
		<c:when test="${loginUser != null }">
			<p>アカウント登録が完了しました。</p>
			<p>ようこそ${loginUser.name }さん！</p>
			<a href="/dokotubu/Main">つぶやき投稿・閲覧へ</a>
		</c:when>
		<c:otherwise>
			<p>${errorMasege2 }</p>
			<a href="/dokotubu/accountRegist.jsp">アカウント登録へ</a>
		</c:otherwise>
	</c:choose>
</body>
</html>