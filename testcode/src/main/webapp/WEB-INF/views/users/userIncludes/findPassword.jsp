<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tbody>
			<tr>
				<td><h2>비밀번호</h2></td>
			</tr>
			<c:choose>
				<c:when test="${id == null}">
					<p>존재하지 않는 아이디입니다.</p>
				</c:when>
				<c:when test="${user == null}">
					<p>질문과 답변이 일치하지 않습니다.</p>
				</c:when>
			</c:choose>
			<tr>
				<td>${user.userPass}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>