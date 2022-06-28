<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
	<table border="2">
		<tr>
			<td rowspan="4"><img src="imge/${view.photourl }"> </td>
			
		</tr>
		<tr>
			<td>상품 이름</td>
			<td><input type="text" value="${view.title }"> </td>
		</tr>
		<tr>
			<td>금액</td>
			<td>
			<input type="text" value="${view.price }"> 
			<br>
			<input type="button" value="구매하기">
			</td>
		</tr>
	</table>
	<div>
		<textarea rows="10" cols="40">${view.explanation}</textarea>
	</div>
	<div>
		<input type="button" value="목록" onclick="location.href='shoppingservlet?link=list'">
	</div>
</body>
</html>