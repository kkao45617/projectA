<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="../fontawesome/css/all.min.css">
<!-- https://fontawesome.com/ -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/c34800a0df.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/login.find.join.js"></script>
<style type="text/css">
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
.find {
	width: 40%;
	height: 600px;
	background: white;
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	border: 1px solid lightgray;
	margin: 0px 0px 50px;
}
h2 {
	color: aqua;
	font-size: 2em;
	margin-bottom: 50px;
}
.title {
	margin-bottom: 50px;
}
.find_question, .find_answer {
	margin-top: 50px;
	width: 80%;
}
.find_id input, .find_question input, .find_answer input {
	width: 100%;
	height: 50px;
	border-radius: 30px;
	margin-top: 10px;
	padding: 0px 20px;
	border: 1px solid gray;
	outline: none;
}
.find_id, .find_question, .find_answer {
	margin-top: 20px;
	width: 80%;
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
select {
   width: 85px;
   height: 25px;
   outline: none;
   background: #f5f6f7;
   border: 1px solid #999;
}
#checkquestion {
   width: 200px;
   height: 40px;
   border: 1px solid #dadada;
   outline: none;
   float: left;
   background-color: white;
   border-radius: 15px;
}
#signup-answer {
   width: 100%;
   height: 25px;
   border: none;
   outline: none;
}
.signup-input {
   display: flex;
   padding: 5px;
   border: solid 1px #dadada;
   background: #fff;
   cursor: pointer;
   border-radius: 15px;
}
.find_email
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<!-- header card -->
	<div class="card"></div>
	<br>
	<br>
	
	<form method="post" action="pwFind.do" name="frm">
		<div class="Wallpapers">
			<div class="find">
				<h2 class="title">비밀번호 찾기</h2>
				<div class="find_id">
					<input type="text" name="userId" placeholder="아이디">
				</div>
				<div class="find_question">
					 <span class="choice">
                  <h4>&nbsp;본인 확인 질문</h4> <select id="checkquestion"
                  class="selectbox" name="question">
	                     <option value="select">&nbsp;질문을 선택하세요.</option>
	                     <option value="초등학교">&nbsp;초등학교 이름은?</option>
	                     <option value="중학교">&nbsp;중학교 이름은?</option>
	                     <option value="고등학교">&nbsp;고등학교 이름은?</option>
	                     <option value="첫 휴대전화">&nbsp;처음 산 휴대전화 기종은?</option>
	                     <option value="첫 자동차">&nbsp;처음 산 자동차 기종은?</option>
	                     <option value="다시 태어난다면">&nbsp;다시 태어난다면?</option>
	               </select>
				</div>
				<div class="find_answer">
					<input type="text" name="answer" placeholder="답변">
				</div>
				<div class="submit">
					<input type="submit" value="비밀번호 찾기" onclick="return pwfindCheck()">
				</div>
				<jsp:include page="userIncludes/userFooter.jsp"></jsp:include>
			</div>
		</div>
	</form>
</body>
</html>