<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/fontawesome/css/all.min.css">
<!-- https://fontawesome.com/ -->
<link rel="stylesheet" href="/resources/css/magnific-popup.css">
<link rel="stylesheet" href="/resources/css/templatemo-ocean-vibes.css">
<link rel="stylesheet" href="/resources/css/nav.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/animate.css">
<script src="https://kit.fontawesome.com/c34800a0df.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 서머노트링크 -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- /서머노트링크 -->
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
   font-family: 'yg-jalnan', cursive
}
html, body {
   width: 100%;
   height: 100%;
}
.head_container {
   position: absolute;
   margin: auto;
   top: 0;
   left:1300px;
   right: 0px;
   bottom: 0;
   width: 200px;
   height: 100px;
}
.head_container .search {
   position: absolute;
   margin: auto;
   top: 0;
   right: 0;
   bottom: 0;
   left: 0;
   width: 40px;
   height: 40px;
   background: #98a6c3;
   border-radius: 50%;
   transition: all 0.5s;
   z-index: 4;
}
.head_container .search:hover {
   cursor: pointer;
}
.head_container .search::before {
   content: "";
   position: absolute;
   margin: auto;
   top: 22px;
   right: 0;
   bottom: 0;
   left: 22px;
   width: 12px;
   height: 2px;
   background: white;
   transform: rotate(45deg);
   transition: all 0.5s;
}
.head_container .search::after {
   content: "";
   position: absolute;
   margin: auto;
   top: -5px;
   right: 0;
   bottom: 0;
   left: -5px;
   width: 25px;
   height: 25px;
   border-radius: 50%;
   border: 2px solid white;
   transition: all 0.5s;
}
.head_container input {
   position: absolute;
   margin: auto;
   top: 0;
   right: 0;
   bottom: 0;
   left: 0;
   width: 50px;
   height: 50px;
   outline: none;
   border: none;
   color: black;
   padding: 0 80px 0 20px;
   border-radius: 30px;
   box-shadow: 0 0 25px 0 #98b2cd, 0 20px 25px 0 rgba(0, 0, 0, 0.2);
   transition: all 0.5s;
   opacity: 0;
   z-index: 5;
   font-weight: bolder;
   letter-spacing: 0.1em;
}
.head_container input:hover {
   cursor: pointer;
}
.head_container input:focus {
   width: 200px;
   opacity: 1;
   cursor: text;
}
.head_container input:focus ~ .search {
   right: -150px;
   background: #98a6c3;
   z-index: 6;
}
.head_container input:focus ~ .search::before {
   top: 0;
   left: 0;
   width: 25px;
}
.head_container input:focus ~ .search::after {
   top: 0;
   left: 0;
   width: 25px;
   height: 2px;
   border: none;
   background: white;
   border-radius: 0%;
   transform: rotate(-45deg);
}
.head_container input::placeholder {
   color: white;
   opacity: 0.5;
   font-weight: bolder;
}
.btn-group .btn {
	margin-top: 10px; border-radius: 5em;
}
</style>
<title>Insert title here</title>
</head>
<body>
<header>
   <nav class="navbar">
      <div class="navbar_logo">
         <i class="fa-solid fa-map-location-dot"></i> <a href="../home.do">여행가기
            좋은날</a>
      </div>
      <div class="head_container">
         <form action="/destination/list.do">
         	<input type="hidden" name="type" value="TCA" <c:out value="${pageMaker.cri.type eq 'TCA' ? 'selected' : '' }"/>>
            <input type="text" name="keyword" placeholder="Search...">
			<input type="hidden" name="pageNum" value="1">
			<input type="hidden" name="amount" value="10">
               <div class="search">
               </div>
         </form>
         
      </div>
      <ul class="navbar_menu">
         <li><a href="/destination/list.do">호텔/음식점</a></li>
         <li><a href="/destination/list.do">여행지 추천</a></li>
         <li><a href="/course/list.do">코스 추천</a></li>
         <li><a href="/festival/page.do">축제</a></li>
         <li><a href="/board/list.do">자유게시판</a></li>
         <c:choose>
			<c:when test="${user == null}">
       			<li><a href="/users/login.do">로그인</a></li>
			</c:when>
			
			<c:when test="${user.admin == 1}">
				<div class="btn-group">
					<button type="button" class="btn btn-secondary" data-toggle="dropdown">마이페이지</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/users/mypage.do">내 정보 보기</a></li>
						<li><a href="#">내 글 보기</a></li>
						<li><a href="/logout.do">로그아웃</a></li>
					</ul>
				</div>
			</c:when>
			
			<c:when test="${user.admin == 0}">
				<div class="btn-group">
					<button type="button" class="btn btn-secondary" data-toggle="dropdown">마이페이지</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/users/list.do">회원 목록 조회</a></li>
						<li><a href="#">내 글 보기</a></li>
						<li><a href="/logout.do">로그아웃</a></li>
					</ul>
				</div>
			</c:when>
			
		</c:choose>
      </ul>
   </nav>
</header>
</body>
</html>