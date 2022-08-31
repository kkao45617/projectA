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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'yg-jalnan', cursive
}

.gd-container {
	max-width: 1100px;
	position: relative;
	margin: 0 auto;
	padding-left: 15px;
	padding-right: 15px;
}

ul>li>a {
	color: #212121;
}

#slider {
	width: 1000px;
	height: 1000px;
	margin: 0 auto;
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
	width: 250px;
	height: 150px;
}

ol, ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

a {
	color: inherit;
}

body {
	margin: 50px 0;
	color: var(- -black);
	font: 1rem/1.3 sans-serif;
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

#child {
	color: grey;
	font-size: 11pt;
}

.box_rightType {
	width: 950px;
	height: 50px;
	border: 1px solid #e6e6e6;
	background-color: #f7f7f7;
	line-height: 50px;
	border-radius: 2em;
}

.box_rightType ul li {
	margin: 0 20px 10px 10px;
	padding: 0 0 0 0;
	border: 0;
	float: left;
	font-size: 13pt;
}

.box_rightType ul li button {
	outline: 0;
}

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

#desListTable {
	
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	table-layout: fixed;
}

#desListTable td {
	vertical-align: middle;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
  
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<a style="display:scroll;position:fixed;bottom:20px;z-index: 999;right:60px;font-size: 40px;" href="#" title="âtop">
	<i class="fa-solid fa-circle-arrow-up"></i></a>
	<div class="card"></div>
	<br>
	<br>
	<div id="slider">
		<!-- 여기에 내용 넣으세요 -->

		<div class="box_rightType">
			<ul>
				<li style="margin-left: 25px" onclick="location.href='/destination/list.do?destinationAddress=서울'"><button>서울시</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=경기'">경기도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=강원'">강원도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=충청북'">충청북도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=충청남'">충청남도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=경상북'">경상북도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=경상남'">경상남도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=전라북'">전라북도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=전라남'">전라남도</button></li>
				<li><button onclick="location.href='/destination/list.do?destinationAddress=제주'">제주도</button></li>
			</ul>
		</div>
		<br>
			<table
				class="table table-striped table-bordered table-hover" id="desListTable">
					
				<c:forEach items="${list}" var="destination">
					<tr>
		
					<th rowspan="3" width="267px" height="160px"><a class='move' href=<c:out value="${destination.destinationNum}"/>>
						<img src="${destination.destinationFirstImg}"  width="500"></a></th>
						
						
		
					<td style="font-size: 16pt; height: 50px;">
					<a class='move' href=<c:out value="${destination.destinationNum}"/>>
						<c:out value="${destination.destinationTitle}"/></td>
					</tr>
						<td style="font-size: 12pt;">
						<a class='move' href=<c:out value="${destination.destinationNum}"/>>
						<c:out value="${destination.destinationContent}"/></td>
					<tr>
						<td>
						<a class='move' href=<c:out value="${destination.destinationNum}"/>>
						<c:out value="${destination.destinationAddress}"/></td>
					</tr>
					
				</c:forEach>
			</table>
			
			<!-- 검색 조건 Start-->
					<form id="searchForm" action="/destination/list.do" method="get">
						<select name="type">
							<option value=""   	<c:out value="${pageMaker.cri.type == null ? 'selected' : '' }"/>  	>--</option>
							<option value="T"
							<c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : '' }"/>
							>제목</option>
							<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }"/>>내용</option>
							<option value="A" <c:out value="${pageMaker.cri.type eq 'A' ? 'selected' : '' }"/>>지역</option>
							<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : '' }"/>>제목+내용</option>
							<option value="TA" <c:out value="${pageMaker.cri.type eq 'TA' ? 'selected' : '' }"/>>제목+지역</option>
							<option value="TCA"  <c:out value="${pageMaker.cri.type eq 'TCA' ? 'selected' : '' }"/> >제목+내용+지역</option>
						</select>
						
						<input type="text" name="keyword" />
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
						<button class="btn btn-primary">Search</button>
					</form>	
							
				<!-- 검색 조건 End -->
			
				<!-- 페이지 처리 Start -->
				<div class="pull-right" align="center">
					<ul class="pagination">

						<c:if test="${pageMaker.prev }">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1}"><</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }">
							<li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active" : "" }">
								<a href="${num }">${num }</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next }">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage+1}">></a></li>
						</c:if>
					</ul>
				</div>
				<!-- 페이지 처리 End -->
				
				<form id="actionForm" action="../destination/list.do" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					<input type="hidden" name="type" value="${pageMaker.cri.type}">
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
					<input type="hidden" name="destinationAddress" value="${pageMaker.city.address}">
				</form>
				
<%-- 			<c:choose>
				<c:when test="${user.admin==0}">
			<div>
			<button id="writebtn" type="button" style="float: left;">글등록</button>
			</div>
				</c:when>
			</c:choose> --%>
	</div>
	<script>
		$("#writebtn").on("click", function() {
			self.location = "/destination/register.do";
		});
		
		$(".move").on("click",function(e) {
			e.preventDefault();
			console.log('test-------------');
			actionForm.append("<input type = 'hidden' name = 'num' value= '"+ $(this).attr("href")+ "'>");
			actionForm.attr("action","/destination/get.do");
			actionForm.submit();
		});
		
		var actionForm = $("#actionForm");
		$(".paginate_button a").on(
				"click",
				function(e) {
					e.preventDefault();
					console.log('click');
					actionForm.find("input[name='pageNum']")
							.val($(this).attr("href"));
					actionForm.submit();
				});
		
		  window.onpageshow = function(e) {
		         if (e.persisted || (window.performance && window.performance.navigation.type == 2)) { //뒤로가기 감지
		            location.reload(); //현재 페이지 새로고침
		         }
		      }
			var searchForm = $("#searchForm");
			
			$("#searchForm button").on("click", function(e){
				e.preventDefault();
				
				if(!searchForm.find("option:selected").val()){
					alert("검색종류를 선택하세요.")
					return false;
				}

				if(!searchForm.find("[name='keyword']").val()){
					alert("키워드를 선택하세요.")
					return false;
				}
				
				searchForm.find("input[name='pageNum']").val(1);
				searchForm.submit();
			});
	</script>
</body>
</html>