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
				<td><h2>��й�ȣ</h2></td>
			</tr>
			<c:choose>
				<c:when test="${id == null}">
					<p>�������� �ʴ� ���̵��Դϴ�.</p>
				</c:when>
				<c:when test="${user == null}">
					<p>������ �亯�� ��ġ���� �ʽ��ϴ�.</p>
				</c:when>
			</c:choose>
			<tr>
				<td>${user.userPass}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>