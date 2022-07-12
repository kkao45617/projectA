<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main2.css?after" type="text/css">

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:import url="nav.jsp"/>
<div class="main">
	<div class="form">
		<div>
			<input class="butten" type="button" value="쇼핑몰 글쓰기" onclick="location.href='shoppingservlet?link=write_form'">
		</div>
		
		<div>
			<c:forEach var="shopping" items="${shoppinglist}" >
			<a href="shoppingservlet?link=view&no=${shopping.no }"> <img  src="imge/${shopping.photourl }" class="img"></a>
			<input type="text" value="${shopping.title }" disabled>
			<input type="text" value="${shopping.price}" disabled>원
			
			
			</c:forEach>
		</div>
	</div>	
</div>
</body>
</html>