<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>관리자 글쓰기 페이지</h2>
<!-- 네비게이션바 호출 -->


<form action="shoppingservlet" method="post" name="frm">
	<input type="hidden" name="link" value="shopping_write">
	
	<div>
		<h4>제품명 : </h4>
		<input type="text" name="title">
	</div>
	<div>
		<h4>금액 : </h4>
		<input type="number" name="price">
	</div>
	<div>
		<h4>내용 : </h4>
		<textarea rows="20" cols="50" name="explanation"></textarea>
	</div>
	
	<div>
		<h4>사진등록 : </h4>
		<input type="file" name="photourl" value="사진등록">
		<br>
		<br>
	</div>
	<div>
		<input type="submit" value="등록">
		<input type="button" value="목록" onclick="location.href='shoppingservlet?link=list'">
	</div>
</form>

</body>
</html>