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
		<h1>회원 리스트</h1>
		<table border="3">
			<tr>
				<td colspan="5" style="text-align: right;"> <a href="employeesservlet?link=empoly_write_form">회사원 등록</a> </td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>권한</td>
				<td>성별</td>
				<td>전화번호</td>
			</tr>
			<c:forEach var="list" items="${empolylist}">
				<tr>
					<td>${list.id}</td>
					<td><a href="employeesservlet?link=employview&id=${list.id}">${list.name}</a> </td>
					<td>${list.lev}</td>
					
					<td>
						<c:choose>
							<c:when test="${list.gender==1}">남자</c:when>
							<c:when test="${list.gender==2}">여자</c:when>
						</c:choose>
					</td>
					<td>${list.phone}</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
</body>
</html>