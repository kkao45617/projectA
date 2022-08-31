<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>코스추천</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="https://kit.fontawesome.com/c34800a0df.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6f7f2591af5145e97bd2969fcf925e6f"></script>
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

.dotOverlay {color:#747474; position:relative;bottom:-30px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;font-size:12px;padding:5px;background:#fff;}
.dotOverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.customoverlay {position:relative;bottom:55px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;}
.customoverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}
.customoverlay a {display:block;text-decoration:none;color:#000;text-align:center;border-radius:6px;font-size:14px;font-weight:bold;overflow:hidden;background: #d95050;background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;}
.customoverlay .title {display:block;text-align:center;background:#fff;margin-right:35px;padding:10px 15px;font-size:14px;font-weight:bold;}
.customoverlay:after {content:'';position:absolute;margin-left:-12px;left:50%;bottom:-12px;width:22px;height:12px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}

#courseTitle h1 {text-align: center;}
#courseTitle p {text-align: center;}

#desListView {background-color: #D5D5D5; height: 650px; margin: 30px 0 30px 0;
overflow: auto; overflow-y: hidden; white-space: nowrap}

.btn_good .ico {
    background: url(https://cdn.visitkorea.or.kr/resources/images/sub/ico_mpost01_on.png);
    width: 42px; height: 36px;
    display: inline-block;
    test-indent: -9999px;
    }
.btn_good { width: 75px; height: 55px; border: none; background-color: #FFFFFF; }

.desBoard { width: 250px; height: 450px; background-color: white;
	display: inline-block; margin: 75px 0 0 60px; border: 1px solid black;
	position: relative; white-space: normal;}
.card-body {position: absolute;}

.nonDiv	{ height: 100px; background-color: white; }
</style>
     
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<a style="display:scroll;position:fixed;bottom:20px;z-index: 999;right:60px;font-size: 40px;" href="#" title="âtop">
<i class="fa-solid fa-circle-arrow-up"></i></a>
	
<!-- header card -->
	
	<div class="card">
	   
	</div>
	<br><br>
	<div id="slider">
	     <!-- title, city 입력 -->
	     <div id="courseTitle">
	     	<h1>${course.courseTitle}</h1>
	     	<p>${course.courseCity}</p>
	     	<button data-oper='likes' class="btn_good">
	     		<span class="ico"></span>
	     		<span class="numLike" id="numLike">${course.courseLike}</span>
	     	</button>
	     	
	     	<hr>
	     </div>
	     
	     <!-- 맵 view -->  
	     <div id="map" style="width:900px;height:500px; margin: 0 auto;"></div>
	     <p>총 거리</p><span id="i_result"></span>
	     
	     <input id="num" type="hidden" value="${course.courseNum}">
	     <input id="resultMapX" type="hidden" value="${resultMapX}">
	     <input id="resultMapY" type="hidden" value="${resultMapY}">
	     <input id="likes" type="hidden" value="${course.courseLike}">
	
	<hr>
		
		<!-- 여행지 리스트 view -->
		<div id="desListView">
			<c:forEach items="${course.desList}" var="destination">
				<div class="card desBoard">
					<div class="card-body">
						<h4 class="card-title">${destination.destinationTitle}</h4>
						<img class="card-img-top" src="<c:out value="${destination.destinationFirstImg}"/>" alt="Card image"
						style="width: 100%">
						<p class="card-text">Some example text some example text. John
							Doe is an architect and engineer</p>
						<a href="/destination/get.do?num=<c:out value="${destination.destinationNum}"/>" class="btn btn-primary stretched-link">여행지 상세보기</a>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<!-- 아래 여백 -->
		<div class="nonDiv">
		</div>
		
	
	</div>
	
	<script type="text/javascript" src="/resources/js/courseService.js"></script>
	
	<script>
	
 	var num = document.getElementById('num').value;
	var resultMapX = document.getElementById('resultMapX').value;
	var resultMapY = document.getElementById('resultMapY').value;
	var likes = parseInt(document.getElementById('likes').value);
	
	var courseList = new Array();
	var totalMapX;
	var totalMapY;
	courseService.desList(num, function (list) {
		for(var i=0, len = list.length || 0; i<len; i++){
			console.log(list[i]);
		}
		courseList = list;
		console.log(courseList);
	
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(resultMapY, resultMapX), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		var distanceOverlay;
		var dots = {};
	    
		for (var i=0; i<courseList.length; i++) {
			var latlng = new kakao.maps.LatLng(courseList[i].destinationMapY, courseList[i].destinationMapX)
			var imageSrc = "/resources/img/marker/marker-icon" + (i+1) +".png"; 
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(40, 45); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: latlng, // 마커를 표시할 위치
		        title : courseList[i].destinationTitle, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		    
		 // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    var content = '<div class="customoverlay">' +
		        '  <a href="/destination/get.do?num='+courseList[i].destinationNum+'">' +
		        '    <span class="title">'+ courseList[i].destinationTitle +'</span>' +
		        '  </a>' +
		        '</div>';
		    
		    var customOverlay = new kakao.maps.CustomOverlay({
		        map: map,
		        position: latlng,
		        content: content,
		        yAnchor: 1 
		    });
		}

		var linePath;
		var lineLine = new kakao.maps.Polyline();
		var distance;
		var totalDistance = 0;

		for (var i = 0; i < courseList.length; i++) {
			if (i != 0) {
				linePath = [ new kakao.maps.LatLng(courseList[i-1].destinationMapY, courseList[i-1].destinationMapX),
							 new kakao.maps.LatLng(courseList[i].destinationMapY, courseList[i].destinationMapX) ]
			}
			;
			lineLine.setPath(linePath);

			var drawLine = new kakao.maps.Polyline({
				map : map,
				path : linePath,
				strokeWeight: 3, // 선의 두께입니다 
            	strokeColor: '#db4040', // 선의 색깔입니다
            	strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
            	strokeStyle: 'solid' // 선의 스타일입니다
			});
			

			distance = Math.round(lineLine.getLength());
			totalDistance = totalDistance + distance; 
			displayCircleDot(new kakao.maps.LatLng(courseList[i].destinationMapY, courseList[i].destinationMapX), distance);
		}
		if(7500< totalDistance && totalDistance < 12500) {
		 	map.setLevel(5);
		} else if(12500<= totalDistance && totalDistance < 20000){
			map.setLevel(6);
		} else if(20000<= totalDistance && totalDistance < 30000){
			map.setLevel(7);
		} else if(30000<= totalDistance && totalDistance < 40000){
			map.setLevel(8);
		} else if(40000<= totalDistance && totalDistance < 80000){
			map.setLevel(9);
		} else if(80000<= totalDistance){
			map.setLevel(10);
		}
		
	    
		function displayCircleDot(position, distance) {
			if (1000 > distance && distance > 0) {
				// 마커까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
				var distanceOverlay = new kakao.maps.CustomOverlay(
					{
						content : '<div class="dotOverlay">거리 <span class="number">'
								+ distance + '</span>m</div>',
						position : position,
						yAnchor : 1,
						zIndex : 2
					});

				// 지도에 표시합니다
				distanceOverlay.setMap(map);
			} else if (distance > 999) {
				distance = Math.round(distance / 100)/10;
				var distanceOverlay = new kakao.maps.CustomOverlay(
					{
						content : '<div class="dotOverlay">거리 <span class="number">'
								+ distance + '</span>km</div>',
						position : position,
						yAnchor : 1,
						zIndex : 2
					});
				// 지도에 표시합니다
				distanceOverlay.setMap(map);
			}
		}
		totalDistance = Math.round(totalDistance / 100)/10;
		
		var result = totalDistance + "km";
		document.getElementById("i_result").innerHTML=result;
	})
	
	$("button[data-oper='likes']").on("click", function(e){
		courseService.like(num,
			function(result){
				alert("좋아요");
			}
		)
		likes += 1;
		document.getElementById("numLike").innerHTML=likes;
	});
	</script>
    
</body>
</html>