<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>축제 상세보기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/c34800a0df.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6f7f2591af5145e97bd2969fcf925e6f"></script>
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
	height: 1800px;
	margin: 0 auto;
}

</style>

</head>
<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>
	<a
		style="display: scroll; position: fixed; bottom: 20px; z-index: 999; right: 60px; font-size: 40px;"
		href="#" title="âtop"> <i class="fa-solid fa-circle-arrow-up"></i></a>

	<!-- header card -->

	<div class="card"></div>
	<br>
	<br>
	
	<div id="slider">
		
		<h1>${data.title }</h1>
		
		<br><br>
		
		<div>

<ul class="nav nav-tabs nav-fill">
  <li class="nav-item">
  <h3>  <a class="nav-link active" aria-current="page" href="#content_pic">사진보기</a></h3>
  </li>
  <li class="nav-item">
   <h3> <a class="nav-link disabled" href="#content_inf">행사정보</a></h3>
  </li>
  <li class="nav-item">
   <h3> <a class="nav-link disabled" href="#content_place">지도보기</a></h3>
  </li>
  
</ul>

</div>
<br><br>
	<img src="${data.firstimg}" style="display: block; margin:0 auto;">
	
	
	<br><br>
	<hr>	
	<h3><a id="content_inf" name="content_inf"></a>행사정보</h3>
	<hr>	
	<p>행사 시작일 : ${data.startdate }</p>
	<p>행사 종료일 : ${data.enddate }</p>
	<p>주소 : ${data.address} &nbsp;(*하단 상세 지도 확인)</p>
	
	

	<br><br>
	<hr>
	<h3><a id="content_place" name="content_place"></a>지도보기</h3>
	<hr>
	
 <div id = "map" style="width: 900px; height: 500px;"></div>
 <hr>
 <br>
<div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
  <button type="button" class="btn btn-outline-primary btn-lg"><a href="../festival/page.do">목록으로</a></button> 
 <div>
	<script type="text/javascript" 
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=70d0289eba5f802b9a96043f6181b686"></script>
		<script type="text/javascript" >
	     var mapContainer = document.getElementById('map'); // 지도를 표시할 div
        var mapOption = {
                center: new kakao.maps.LatLng('${data.mapy}','${data.mapx}'), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

        // //마커가 표시될 위치입니다
        var markerPosition  = new kakao.maps.LatLng('${data.mapy}','${data.mapx}');

        //마커를 생성합니다
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        //마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        //아래 코드는 지도 위의 마커를 제거하는 코드입니다
        //marker.setMap(null);
	
</script>
	</div>
     
</body>
</html>