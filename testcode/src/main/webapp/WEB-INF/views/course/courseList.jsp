<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>코스추천</title>
    <link rel="stylesheet" href="/resources/fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="/resources/css/magnific-popup.css"> 
     <link rel="stylesheet" href="/resources/css/nav.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/animate.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
     <script src="https://kit.fontawesome.com/c34800a0df.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
    @font-face {
    font-family: 'yg-jalnan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
      
   * {font-family: 'yg-jalnan', cursive }
  .gd-container {
  max-width: 1100px;
  position: relative;
  margin: 0 auto;
  padding-left: 15px;
  padding-right: 15px;
}
ul > li > a {color: #212121;}
 #slider {width: 1000px; height: 1000px; margin: 0 auto;}
 
 
:root {
  --black: #1a1a1a;
  --white: #fff;
  --gray: #ccc;
  --darkgreen: #18846C;
  --lightbrown: antiquewhite;
  --minRangeValue: 280px;
}
* {
  margin: 0;
  padding: 0;  
  outline: none;
  border: none;
}
button {
  cursor: pointer;
  background: none;
}
img {
  display: block;
  width: 290px;
  height: 193px;
}
ol,
ul {
  list-style: none;
  margin:0;
  padding:0;
}
a div p, a div h5{text-decoration: none; color: black;}
body {
  margin: 50px 0;
  color: var(--black);
  font: 1rem/1.3 sans-serif;
}
.gallery {
  padding: 0 2rem;
}
.container {
  max-width: 1030px;
  margin: 0 auto;
}
.d-none {
  display: none;
}
.image-list {
  margin: 3rem 0;
}
.image-list li {
  color: var(--darkblack);
}
.grid-view {
  display: grid;
  grid-gap: 80px;
  grid-template-columns: repeat(auto-fit, minmax(var(--minRangeValue), 1fr));
}
li div p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 290px;
  height: 20px;
  color: black;
  font-size: 13pt;
}
#child{
color:grey;
font-size: 11pt;
}
.box_rightType{width:950px; height:50px; border:1px solid #e6e6e6; background-color:#f7f7f7; line-height: 50px;border-radius: 2em;}
.box_rightType ul li {
    margin: 0 20px 10px 10px;
    padding: 0 0 0 0;
    border : 0;
    float: left;
    font-size: 13pt;
}
.box_rightType ul li button{outline: 0;}
#writebtn {
  background-color: #e7e7e7;
  border: none;
  padding: 13px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  float: right;
  outline: 0;
}
.card {float: left; margin: 20px 30px 0 20px; width: 19.1em;}
     
</style>
     
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<a style="display:scroll;position:fixed;bottom:20px;z-index: 999;right:60px;font-size: 40px;" href="#" title="âtop">
	<i class="fa-solid fa-circle-arrow-up"></i></a>
	
	<!-- header card -->

	<hr>
	<br>
	<br>
	<div id="slider">
	
		<div class="box_rightType">
			<ul>
				<li style="margin-left: 25px"><button onclick="location.href='/course/list.do?city=서울'">서울시</button></li>
				<li><button onclick="location.href='/course/list.do?city=경기'">경기도</button></li>
				<li><button onclick="location.href='/course/list.do?city=강원'">강원도</button></li>
				<li><button onclick="location.href='/course/list.do?city=충청북도'">충청북도</button></li>
				<li><button onclick="location.href='/course/list.do?city=충청남도'">충청남도</button></li>
				<li><button onclick="location.href='/course/list.do?city=경상북도'">경상북도</button></li>
				<li><button onclick="location.href='/course/list.do?city=경상남도'">경상남도</button></li>
				<li><button onclick="location.href='/course/list.do?city=전라북도'">전라북도</button></li>
				<li><button onclick="location.href='/course/list.do?city=전라남도'">전라남도</button></li>
				<li><button onclick="location.href='/course/list.do?city=제주'">제주도</button></li>
			</ul>
		</div>
		<br>
		<c:forEach items="${list}" var="course">
		
		<div class="card">
		<a class='move' href="page.do?num=<c:out value="${course.courseNum}"/>">
			<img src="<c:out value="${course.desList.get(0).destinationFirstImg}"/>" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${course.courseTitle}</h5>
				<p class="card-text">${course.courseContent}</p>
				<p class="card-text">${course.courseCity}</p>
			</div>
		</a>
			<ul class="list-group list-group-flush">
			<c:forEach items="${course.desList}" begin="0" end="2" var="destination">
				<li class="list-group-item">* ${destination.destinationTitle}</li>
			</c:forEach>
			<c:if test="${fn:length(course.desList) > 3}">
				<li class="list-group-item" style="text-align: center; height: 20px;">* * *</li>
			</c:if>
			</ul>
		</div>
		
		</c:forEach>
		<div class="card">
		<a href="page.do">
			<img src="/resources/img/pet.jpg" class="card-img-top" alt="...">
		</a>
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
			</ul>
			<div class="card-body">
				<a href="page.do" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>
		<div class="card">
		<a href="page.do">
			<img src="/resources/img/pet.jpg" class="card-img-top" alt="...">
		</a>
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
			</ul>
			<div class="card-body">
				<a href="page.do" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>
		<div class="card">
		<a href="page.do">
			<img src="/resources/img/pet.jpg" class="card-img-top" alt="...">
		</a>
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
			</ul>
			<div class="card-body">
				<a href="page.do" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>
		<div class="card">
		<a href="page.do">
			<img src="/resources/img/pet.jpg" class="card-img-top" alt="...">
		</a>
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
			</ul>
			<div class="card-body">
				<a href="page.do" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>

	</div>
	
<script>
$(document).ready(function(){
	
	var result='<c:out value="${result}"/>';
	console.log("result" + result);
	
	checkModal(result);
	
	// 뒤로가기시 modal화면 뜨는 문제 해결
	$(".move").on("click", function(e){
		e.preventDefault();
		console.log("test------------------")
		actionForm.append("<input type = 'hidden' name='courseNum' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action", "/page.do");
		actionForm.submit();
	})
});
</script>
</body>
</html>