<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	

<script type="text/javascript">
$(document).ready(function() {
    $('#summernote').summernote({
       height : 300,
       lang : 'ko-KR',
       placeholder : '내용을 입력하세요',
       minHeight : 400,
       disableResizeEditor:true,
       focus:true,
       callbacks : {
          onImageUpload : function(files, editor, welEditable) {
             for (var i = files.length - 1; i >= 0; i--) {
                uploadSummernoteimageFile(files[i],this);
             }
          }
       }
    });
 });
 function uploadSummernoteimageFile(file,editor){
    data=new FormData();
    data.append("file",file);
    $.ajax({
       url:"summernoteImage.do",
       data : data,
       type : "POST",
       enctype : 'multipart/form-data',
       dataType:'JSON',
       contentType:false,
       processData:false,
       success: function(data){
          $(editor).summernote('insertImage',data.url);
       }
    });
 }
</script>
 
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="card">
   
	</div>
	<br><br>
<div id="slider">
	
		<!-- 여기에 내용 넣으세요 -->
		<h3>여행지 추천 글 쓰기</h3>
		<br>

		<form method="post" action="/destination/register.do" enctype="multipart/form-data">
		<%-- <input type="hidden" name="userNum" value='<c:out value="${user.userNum}"/>'> --%>
			<table border=1 width="100%">
				<tr>
					<td align="center">여행지 이름</td>
					<td><input type="text" name="destinationTitle" style="width: 100%"></td>
				</tr>
				<tr>
					<td align="center">여행지 주소</td>
					<td><input type="text" name="destinationAddress" style="width: 100%"></td>
				</tr>
				<tr>
					<td align="center">썸네일</td>
					<td><input type="file" name="destinationFirstImg" style="width: 100%"></td>
				</tr>
				<tr>
				<td colspan="2"><textarea class="form-control" id="summernote" name="destinationSecondImg"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="등록">
		</form>
		
		

</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>