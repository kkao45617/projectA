<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>

<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Ŭ���̾�Ʈ ����Ʈ�� ����</h1>
<button onclick="location.href='/ptclient/basket?client_id=kkao45617'">��ٱ���</button>
<table border="1">
	<tr>
		<th>��ȣ</th>
		<th>�̸�</th>
	
		<th>���̵�</th>
		<th>������¥</th>
		<th>�ݾ�</th>
		<th>���� �ڵ�</th>
		<th>����</th>
		<th>����</th>
		<th>��¥1</th>
		<th>��¥2</th>

	</tr>
	<c:forEach items="${client}" var="client">
		<tr>
			<td>${client.PT_no }</td>
			<td>${client.pt_name} </td>
			
			<td>${client.PT_id}</td>
			<td><fmt:formatDate value="${client.PT_Registration}" pattern="yyyy-MM-dd"/></td>
			<td> ${client.PT_Price}</td>
			<td>${client.PT_code}</td>
			<td><a href="/ptclient/clientget?client_no=${client.PT_no }"> ${client.PT_title}</a></td>
			<td><img alt="�̹��� ����"  src="/ProjectRPA/src/main/webapp/resources/ptimg/${client.PT_photourl}"></td>
			<td>${client.calendar_before }</td>
			<td>${client. calendar_after}</td>
			<!-- pt_no���� �������� -->
			
		</tr>
	</c:forEach>
</table>

</body>
</html>