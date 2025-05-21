<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>${news.title}</h2>
		<hr>
		<c:if test="${error == null}">
			<p><img src="/img/${news.img}" alt="image"></p>
		</c:if>
		<p>${news.date}</p>
		<p>${news.content}</p>
	</div>
	<c:if test="${error != null}">
		<p>${error}</p>
	</c:if>
</body>
</html>