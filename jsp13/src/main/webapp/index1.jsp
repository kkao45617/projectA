<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align: center;">리스트</h2>
	<table border="2">
		<tr>
			<td colspan="6"><a href="moviewrite.do">영화등록</a></td>
		</tr>
		<tr>
			<td>제목</td>
			<td>감독</td>
			<td>배우</td>
			<td>가격</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="movielist" items="${movie}">
			<tr>
				<td>${movielist.title}</td>
				<td>${movielist.director}</td>
				<td>${movielist.actor}</td>
				<td>${movielist.price}</td>
				<td><a href="movieupdate.do?code=${movielist.code}">영화수정</a></td>
				<td><a href="moviedelete.do?code=${movielist.code}">영화삭제</a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>