<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   table {width:800px; margin:10px auto 0;}
   section {width: 1000px; height: 750px; background-color: #D5D5D5; margin:0 auto;}
   section > h1 {text-align: center; line-height: 100px;}
   table, th, td  { border:1px solid #666; }
   th, td { height: 50px; text-align: center; }
   
   #buttons {margin-left : 450px; margin-top: 25px;}
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
      <section>
         <h1>내 정보 조회</h1>
         <table>
            <tr>
               <td>글 번호</td>
               <td><c:out value="${board.board_num}"></c:out></td>
            </tr>
            <tr>
               <td>별명</td>
               <td>${board.user.nickName}</td>
            </tr>
            <tr>
               <td>제목</td>
               <td>${board.board_title}</td>
            </tr>
            <tr>
               <td>내용</td>
               <td style="overflow:scroll;">
               ${board.board_content}
               </td>
            </tr>
            <tr>
               <td>작성일</td>
               <td><fmt:formatDate pattern="yyyy-MM-dd"
                           value="${board.board_date}"/></td>
            </tr>
         </table>
         <div id="buttons">
            <button data-oper='modify' class="btn btn-default">수정</button>
               <button data-oper='remove' class="btn btn-info">삭제</button>
         </div>
      </section>
      
      <form id="operForm" name="frm" action="/board/modify.do" method="get">
         <input type="hidden" name="num" value="${board.board_num}">
      </form>
   </div>

<script>
   var operForm = $("#operForm");
   var num = document.frm.num.value;
   
   console.log(num);
   
   
   $("button[data-oper='modify']").on("click", function(e){
      operForm.attr("action", "/board/modify.do?" + num).submit();
   });
   
   $("button[data-oper='remove']").on("click", function(e){
      operForm.attr("action", "/board/remove.do?" + num);
      operForm.submit();
   });
</script>   
</body>
</html>