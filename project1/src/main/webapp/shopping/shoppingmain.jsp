<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.main{
		width: 1100px;
		margin: 0 auto;
	}
	.img{
		width: 100px;
		height: 100px;
		display: block;
	}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="main">
	
	<div>
		<input type="button" value="쇼핑몰 글쓰기" onclick="location.href='shoppingservlet?link=write_form'">
	</div>
	
	<div>
		<c:forEach var="shopping" items="${shoppinglist}" >
		
		<a href="shoppingservlet?link=view&no=${shopping.no }"> <img  src="imge/${shopping.photourl }" class="img"></a>
		<input type="text" value="${shopping.title }">
		<input type="text" value="${shopping.price}">원
		
		</c:forEach>
	</div>	
</div>
</body>
</html>