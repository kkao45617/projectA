<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
        <div id="page-wrapper">
        <script
  src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous">
        </script>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
							수정페이지
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
		                        <form role="form" action="modify" method="post">
		                       
		                        	<div class="form-group">
		                        		<label>bno</label>
		                        		<input name="bno" class="form-control" value='<c:out value="${board.bno }"/>' readonly="readonly" >
		                        	</div>
		                        	<div class="form-group">
		                        		<label>title</label>
		                        		<input name="title" class="form-control" value="${board.title }">
		                        	</div>
		                        	<div class="form-group">
		                        		<label>내용</label>
										<textarea rows="3" cols="7" name="content"class="form-control" ><c:out value="${board.content }"></c:out> </textarea>
		                        	</div>
		                        	<div class="form-group">
		                        		<label>작성자</label>
		                        		<input name="writer" class="form-control" value="${board.writer }">
		                        	</div>
		                        	
		                        	
									<button type="submit" data-oper='modify' class="btn btn-default" >수정하기</button>
									<button type="reset" data-oper='remove' class="btn btn-danger" >글삭제</button>
									<button type="button" data-oper='list' class="btn btn-info">목록으로</button>
		                        </form>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
<script type="text/javascript">
$(document).ready(function(){
   
      var formObj=$("form");
      
      $('button').on("click",function(e){
         e.preventDefault();
         
         var operation=$(this).data('oper');
         
         if(operation==='remove'){
            formObj.attr("action","/board/remove");
         }else if(operation==='list'){
            self.location="/board/list";
            return;
         }
         formObj.submit();
      });
      
   });
  <%@ include file="../includes/footer.jsp" %>