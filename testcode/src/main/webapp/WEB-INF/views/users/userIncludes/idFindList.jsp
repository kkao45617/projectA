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
				<td><h2>회원가입된 아이디</h2></td>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td><c:out value="${user.userId}"/></td>
				</tr>
			</c:forEach>
			<c:if test="${list == null}">
				<td><h4>회원가입된 아이디가 없습니다.</h4></td>
			</c:if>
		</tbody>
	</table>
</body>
</html>