<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행가기 좋은날</title>
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
 #slider {width: 1000px; height: 800px; margin: 0 auto;}


</style>
	

	<script>
	$(document).ready(function() {
	    $('#summernote').summernote({
	        placeholder: '내용을 입력하세요',
	        tabsize: 2,
	        height: 500,
	        lang : 'ko-KR',
	        disableResizeEditor: true,
	        toolbar: [
	            // 글꼴 설정
	            /* ['fontname', ['fontname']], */
	            // 글자 크기 설정
	            ['fontsize', ['fontsize']],
	            // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
	            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
	            // 글자색
	            ['color', ['forecolor','color']],
	            // 표만들기
	            ['table', ['table']],
	            // 글머리 기호, 번호매기기, 문단정렬
	            ['para', ['ul', 'ol', 'paragraph']],
	            // 줄간격
	            ['height', ['height']],
	            // 그림첨부, 링크만들기, 동영상첨부
	            ['insert',['picture','link','video']],
	            // 코드보기, 확대해서보기, 도움말
	            ['view', ['codeview','fullscreen', 'help']]
	            ],
	            // 추가한 글꼴
	            /* fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'], */
	            // 추가한 폰트사이즈
	            fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
	        })

	        var setting = {
	                height : 300,
	                minHeight : null,
	                maxHeight : null,
	                focus : true,
	                lang : 'ko-KR',
	                toolbar : toolbar,
	                callbacks : { //여기 부분이 이미지를 첨부하는 부분
	                onImageUpload : function(files, editor,
	                welEditable) {
	                for (var i = files.length - 1; i >= 0; i--) {
	                uploadSummernoteImageFile(files[i],
	                this);
	                        }
	                    }
	                }
	             };

	    $('#summernote').summernote(setting);
	});

	function uploadSummernoteImageFile(file, el) {
	    data = new FormData();
	    data.append("file", file);
	    $.ajax({
	        data : data,
	        type : "POST",
	        url : "uploadSummernoteImageFile",
	        contentType : false,
	        enctype : 'multipart/form-data',
	        processData : false,
	        success : function(data) {
	            $(el).summernote('editor.insertImage', data.url);
	        }
	    });
	};

</script>
 
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="card">
   
	</div>
	<br><br>
<div id="slider">
	
		<!-- 여기에 내용 넣으세요 -->
				<form role="form" action="../destination/update.do" method="post">
				
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
					<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
					<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
					<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
					
					<input type="hidden" name="destinationNum" value='<c:out value="${destination.destinationNum}"/>'>
					<input type="hidden" name="userNum" value='<c:out value="${destination.userNum}"/>'>
					
					<div class="form-group">
						<input name="destinationTitle" class="form-control" value='<c:out value="${destination.destinationTitle}"/>'><br>
					</div>
					<div class="form-group">
						<input name="destinationAddress" class="form-control" value='<c:out value="${destination.destinationAddress}"/>'>
						<br>
					</div>
					<div class="form-group">
						<input name="destinationFirstImg" class="form-control" value='<c:out value="${destination.destinationFirstImg}"/>'>
						<br>
					</div>
					<div class="form-group">
						<input name="destinationContent" class="form-control" value='<c:out value="${destination.destinationContent}"/>'>
						<br>
					</div>

					<button type="submit" data-oper='update' class="btn btn-default">수정</button>
					<button type="submit" data-oper='delete' class="btn btn-danger">삭제</button>
					<button type="submit" data-oper='list' class="btn btn-info">목록</button>
		</form>
</div>

<script type="text/javascript">
 		$(document).ready(function(){
 			
 			var formObj = $("form");
 			
 			$('button').on("click", function(e){
 				e.preventDefault();
 				
 				var operation = $(this).data('oper');
 				console.log(operation);
 				
 				if(operation === 'delete'){
 					formObj.attr("action", "../destination/delete.do");
 				}else if(operation === 'list'){
 					formObj.attr("action","../destination/list.do").attr("method","get");
 					var pageNumTag = $("input[name='pageNum']").clone();
 					var amountTag = $("input[name='amount']").clone();
 					var typeTag = $("input[name='type']").clone();
 					var keywordTag = $("input[name='keyword']").clone();
 					formObj.empty();
 					formObj.append(pageNumTag);
 					formObj.append(amountTag);
 					formObj.append(typeTag);
 					formObj.append(keywordTag);
 				}
 				formObj.submit();
 			});
 		});
 </script>

<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>