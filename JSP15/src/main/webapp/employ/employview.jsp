<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>회원정보 상세보기</h1>
	<table border="2">
		<tr>
			<th>아이디</th><td>${selectview.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${selectview.pass }</td>
		</tr>
		<tr>
			<th>이름</th><td>${selectview.name}</td>
		</tr>
		<tr>
			<th>권한</th><td>${selectview.lev}</td>
		</tr>
		<tr>
			<th>성별</th><td>${selectview.gender}</td>
		</tr>
		<tr>
			<th>전화번호</th><td>${selectview.phone}</td>
		</tr>
		<tr>
			<th>가입일</th><td><fmt:formatDate value="${selectview.enter }"/></td>
		</tr>
	</table>
	<br>
	<input type="button" value="게시글 수정" onclick="location.href='employeesservlet?link=employupdate&id=${selectview.id}'">
	<input type="button" value="게시글 삭제" onclick="location.href='employeesservlet?link=employdelete&id=${selectview.id}'">
	<input type="button" value="목록" onclick="location.href='employeesservlet?link=list'">
	<input type="button" value="등록" onclick="location.href='employeesservlet?link=empoly_write_form'">
	
</div>
</body>
</html>