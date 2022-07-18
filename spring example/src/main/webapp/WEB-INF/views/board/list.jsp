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
							board list page
							<button id="regBtn" type="button" class="btn btn-xs pull-right">이걸 누르면 뿅간다</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성일</th>
                                        <th>작성자</th>
                                        <th>변경일</th>
                                    </tr>
                                </thead>
                                
	                                <c:forEach items="${list }" var="board">
	                                    <tr class="odd gradeX">
	                                        <td><c:out value="${board.bno }"></c:out> </td>
	                                        <td>
	                                        	<a href="get?bno=${board.bno }">
	                                        	<c:out value="${board.title }"></c:out> 
	                                        	</a>
	                                        </td>
	                                        <td><c:out value="${board.content }"></c:out>  </td>
	                                        <td class="center"><c:out value="${board.writer }"></c:out> </td>
	                                        <td class="center"><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/> </td>
	                                     
	                                    </tr>
	                                   </c:forEach>
                                
                            </table>
                            <!-- /.table-responsive -->
                            <!-- modal 창 추가 -->
                            <div  id="myModal" class="modal" tabindex="-1" role="dialog">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title">Modal title</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								        <p>처리가 완료됬습니다.</p>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-primary">Save changes</button>
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
                            	<!-- 모달 종료 -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
<script>
   $(document).ready(function(){
      var result = '<c:out value="${result}"/>';
      console.log("result" + result);
      
      checkModal(result);
      
      history.replaceState({},null,null);
      function checkModal(result){
    	  if(result===''||history.state){
    		  return;
    	  }
    	  if(ParseInt(result)>0){
    		  $(".modal-body").html("게시글"+parseint(result)+"번이 등록되었습니다.");
    	  }
    	  $("#myModal").modal("show");
      }
      $("#regBtn").on("click",function(){
    	  self.location="register";
      })
   });
</script>
  <%@ include file="../includes/footer.jsp" %>