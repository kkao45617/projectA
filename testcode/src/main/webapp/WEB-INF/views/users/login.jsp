<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/c34800a0df.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/login.find.join.js"></script>
<style>
@font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
@import url("https://fonts.googleapis.com/css?family=Inconsolata:700");
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'yg-jalnan', cursive;
}
html, body {
	width: 100%;
	height: 100%;
}
ul>li>a {
	color: #212121;
}
.gd-container {
	max-width: 1100px;
	position: relative;
	margin: 0 auto;
	padding-left: 15px;
	padding-right: 15px;
}
#gtco-header {
	height: 700px;
	width: 100%;
}
#gtco-header>ul {
	display: inline;
}
#gtco-header .bg {
	position: relative;
}
#gtco-header .bg>img {
	height: 700px;
	width: 100%;
}
#gtco-header .bg .text>h1 {
	display: inline-block;
	z-index: 999;
	position: absolute;
	top: 200px;
	left: 200px;
	width: 100%;
	margin: 0 auto;
	font-size: 50px;
	height: 70px;
	line-height: 700px;
}
.bg:hover {
	opacity: 0.7;
}
.Wallpapers {
	width: 100%;
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
}
.login {
	width: 40%;
	height: 700px;
	background: white;
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	border: 1px solid lightgray;
	margin: 0px 0px 50px;
}
.login h2 {
	color: #212121;
	font-size: 2em;
	margin-bottom: 50px;
}
.login_id {
	margin-top: 50px;
	width: 80%;
}
.login_id input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid gray;
	outline: none;
}
.login_pw {
	margin-top: 20px;
	width: 80%;
}
.login_pw input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid gray;
	outline: none;
}
.submit {
	margin-top: 50px;
	width: 80%;
}
.submit input {
	width: 100%;
	height: 50px;
	border: 0;
	outline: none;
	border-radius: 40px;
	background: #337ab7;
	color: white;
	font-size: 1.2em;
}
.threelinks {
	text-align: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	
	<!-- header card -->

	<div class="card"></div>
	<br>
	<br>
	
	<form method="post" action="login.do" name="loginfrm">
		<div class="Wallpapers">
			<div class="login">
				<h2>로그인</h2>
				<label>
					<input type="radio" name="admin" value="1"checked> 일반회원 &nbsp;&nbsp;
					<input type="radio" name="admin" value="0"> 관리자
				</label>
					<h4>${message}</h4>
				<div class="login_id">
					<h4>아이디</h4>
					<input type="text" name="userId" id="userId" placeholder="아이디">
				</div>
				<div class="login_pw">
					<h4>비밀번호</h4>
					<input type="password" name="userPass" id="userPass" placeholder="비밀번호">
				</div>
				<div class="submit">
					<input type="submit" value="로그인" onclick="return loginCheck()">
				</div>
				<div class="submit"  align="center">
				<a href="https://kauth.kakao.com/oauth/authorize?client_id=accbd8d322bc5b0248a5ea6eb444cd28&redirect_uri=http://localhost:8081/users/kakaoLogin.do&response_type=code">
				<img src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" 
				style = "height: 50px; width:auto;"></a>			
				</div>
				<jsp:include page="userIncludes/userFooter.jsp"></jsp:include>
			</div>
		</div>
	</form>
	
</body>
</html>