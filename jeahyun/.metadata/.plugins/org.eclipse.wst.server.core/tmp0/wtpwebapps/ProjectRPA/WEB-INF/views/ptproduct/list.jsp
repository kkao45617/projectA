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
<script>
$(document).ready(function() {
	$("#ptbtn").on("click",function(){
		self.location = "/ptproduct/ptregister";
	});
});
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>�����ڿ� ����Ʈ�� ����</h1>
<button id="ptbtn" type="button">�۾���</button>
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
	<c:forEach items="${list }" var="pt">
		<tr>
			<td>${pt.PT_no }</td>
			<td>${pt.pt_name} </td>
			
			<td>${pt.PT_id}</td>
			<td><fmt:formatDate value="${pt.PT_Registration}" pattern="yyyy-MM-dd"/></td>
			<td> ${pt.PT_Price}</td>
			<td>${pt.PT_code}</td>
			<td><a href="/ptproduct/ptget?PT_no=${pt.PT_no }"> ${pt.PT_title}</a></td>
			<td><img alt="�̹��� ����"  src="/ProjectRPA/src/main/webapp/resources/ptimg/${pt.PT_photourl}"></td>
			<td>${pt.calendar_before }</td>
			<td>${pt. calendar_after}</td>
			<!-- pt_no���� �������� -->
			<td>
			<button onclick="location.href='/ptproduct/ptmodify?pt_no=${pt.PT_no}'">����</button>
			<button onclick="location.href='/ptproduct/ptremove?pt_no=${pt.PT_no}'">����</button>
			
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>