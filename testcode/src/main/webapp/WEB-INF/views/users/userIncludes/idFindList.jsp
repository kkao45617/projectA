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
				<td><h2>ȸ�����Ե� ���̵�</h2></td>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td><c:out value="${user.userId}"/></td>
				</tr>
			</c:forEach>
			<c:if test="${list == null}">
				<td><h4>ȸ�����Ե� ���̵� �����ϴ�.</h4></td>
			</c:if>
		</tbody>
	</table>
</body>
</html>