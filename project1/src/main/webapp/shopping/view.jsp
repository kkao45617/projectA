<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/view.css?after" type="text/css" >
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>

<c:import url="nav.jsp"/>
<div class="view">
	<table class="teble" border="2">
		<tr>
			<td rowspan="4"><img src="imge/${view.photourl }" class="img"> </td>
			
		</tr>
		<tr>
			<td>상품 이름</td>
			<td><input type="text" value="${view.title }" disabled> </td>
		</tr>
		<tr>
			<td>금액</td>
			<td>
			<input type="text" value="${view.price } disabled"> 
			<br>
			<input type="button" value="구매하기">
			</td>
		</tr>
	</table>
	<div>
		<textarea rows="10" cols="40" disabled>${view.explanation} </textarea>
	</div>
	<div>
		<input type="button" value="삭제" onclick="location.href='shoppingservlet?link=delete&no=${view.no}'">
		<input type="button" value="목록" onclick="location.href='shoppingservlet?link=list'">
	</div>
</div>
</body>
</html>