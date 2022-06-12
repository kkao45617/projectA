<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		
	}
	header{
		font-size: 2em;
		height: 60px;
		color: white;
		background-color: blue;
		text-align: center;
	}
	.nav{
		background: navy;
		height: 30px;
	}
	.nav a{
		text-decoration: none;
		color: white;
		margin: 0 15px 0 15px;
	}
	.had{
		text-align: center;
		margin:0 0 20px 0;
		padding: 20px;
	}
	table {
	text-align: center;
	margin: 0 auto;
	
}
.td1{
	width: 300px;
}
.td2{
	width: 700px;
	text-align: left;
}
.board{

	background-color: gray;
	height: 1800px;
}
</style>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>




	<header>쇼핑몰 회원관리 ver10</header>
	<div class="nav">
		<a href="#">회원등록</a>
		<a href="#">회원목록조회/수정</a>
		<a href="#">회원매출조회</a>
		<a href="#">홈으로</a>
	</div>
	
	
	<div class="board">
		<div class="had">
			<h3>홈쇼핑 회원 등록</h3>
		</div>
			<form action="index_ex.jsp" method="get" name="frm">
				<table border="2">
					<tr >
						<td class="td1">회원번호(자동발생)</td>
						<td class="td2"><input type="text" name="custno"> </td>
					</tr>
					<tr >
						<td class="td1">회원성명</td>
						<td class="td2"><input type="text" name="name"> </td>
					</tr>
					<tr>
						<td class="td1">회원주소</td>
						<td class="td2"><input type="text" name="address" size="30"> </td>
					</tr>
					<tr>
						<td class="td1">가입일자</td>
						<td class="td2"><input type="text" name="join" size="50"> </td>
					</tr>
					<tr>
						<td class="td1">고객등급(a:vip,b:일반,c:직원)</td>
						<td class="td2"><input type="text" name="grade"> </td>
					</tr>
					<tr>
						<td class="td1">도시코드</td>
						<td class="td2"><input type="text" name="city"> </td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<input type="button" onclick="location='index3.jsp'"  value="조회">
						</td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>