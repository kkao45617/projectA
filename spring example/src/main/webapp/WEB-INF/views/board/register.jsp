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
							board title
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
		                        
		                        <form action="/board/register" role="form" method="post">
		                        	<div class="form-group">
		                        		<label>타이틀</label>
		                        		<input name="title" class="form-control">
		                        	</div>
		                        	<div class="form-group">
		                        		<label>내용</label>
										<textarea rows="3" cols="7" name="content"class="form-control" ></textarea>
		                        	</div>
		                        	<div class="form-group">
		                        		<label>작성자</label>
		                        		<input name="writer" class="form-control">
		                        	</div>
		                        	<button type="submit" class="btn btn-default" >누르지마라</button>
		                        	<button type="reset" class="btn btn-default">죽인다</button>
		                        </form>
                            
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

  <%@ include file="../includes/footer.jsp" %>