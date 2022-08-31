<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행지 추천</title>
   <link rel="stylesheet" href="../fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="../css/magnific-popup.css"> 
     <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/animate.css">
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

a {
  color: inherit;
}

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

</style>
  
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<a style="display:scroll;position:fixed;bottom:20px;z-index: 999;right:60px;font-size: 40px;" href="#" title="âtop">
	<i class="fa-solid fa-circle-arrow-up"></i></a>
<div class="card">
   
	</div>
	<br><br>
<div id="slider">
         <!-- 여기에 내용 넣으세요 -->
        <div class="panel-body">
        <%-- <span class="text-dark mb-0" th:utext="${destination.destinationFirstImg}"></span> --%>
				<div class="form-group">
					<label>여행지</label>
					<input name="destinationTitle" class="form-control" readonly="readonly" value='<c:out value="${destination.destinationTitle}"/>'><br>
				</div>
				<div class="form-group">
					<label>주소</label>
					<input name="destinationAddress" class="form-control" readonly="readonly" value='<c:out value="${destination.destinationAddress}"/>'><br>
				</div>
				<div class="form-group">
					<label>사진</label>
					<img src="${destination.destinationFirstImg}"  width="1500">
				</div>
				<div class="form-group">
					<label>내용</label>
					 <textarea name="destinationContent" rows="10" class="form-control" readonly="readonly" style="resize: none;">${destination.destinationContent}</textarea>	
				</div>
				

				<button data-oper='update' class="btn btn-default">수정하기</button>
				<button data-oper='list' class="btn btn-info">목록</button>
				
				<form id='operForm' action="/destination/list.do" method="get">
					<input type="hidden" id="destinationNum" name="destinationNum" value='<c:out value="${destination.destinationNum}"/>'>
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
					<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
					<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
					<input type="hidden" name="keyword"	value='<c:out value="${cri.keyword}"/>'>
				</form>
			</div>
<script>
	var operForm=$("#operForm");
	
	$("button[data-oper='update']").on("click",function(e){
		operForm.attr("action","../destination/update.do").submit();
	});
	
	$("button[data-oper='list']").on("click",function(e){
		operForm.find("#num").remove();
		operForm.attr("action","../destination/list.do").submit();
	});
</script>

<%-- <jsp:include page="../includes/footer.jsp"></jsp:include> --%>
</body>
</html>