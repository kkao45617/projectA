<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%
	String no = request.getParameter("no");

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('#delBtn').click(function(){
			let pwd = $('#pwd').val();
			if(pwd.trim()=="")){//비밀번호 입력값 확인,,,,,,,,,,,,,,#:id형태     .:class형태
				$('#pwd').focus();
			return;
			}
		})
		$.ajax({
			type:'POST',
			url:'delete_impl.jsp',
			data:{"no":$('#no').val,"pwd":pwd};
			success:function(res){
				let r= res.trim();
				if(r=0){
					alert("비밀번호가 틀립니다");
					$('#pwd').val("");
					$('#pwd').focus();
				}else{
					location.href="list.jsp";
				}
			}
		})
	})
</script>

<title>Insert title here</title>
</head>
<body>
	<div class="conteiner">
		<h1>수정페이지</h1>
		<div>
			<form method="get" action="delete_impl.jsp">
				<table class="table">
						<tr>
							<td class="text-center">
							비밀번호	<input type="password" name="pwd" size="10" class="input-sm">
								<input type="hidden" name="no" value=<%=no %> id="no">
							</td>
							
							<td colspan="2" class="text-center">
								<input type="submit" value="삭제" class="btn-sm btn-primary" id="delBtn">
								<input type="button" value="취소" class="btn-sm btn-primary" onclick="javascript:history.back()">
								 <!--no 키 값을 가지고 있는 hidden -->
							</td>
						</tr>
				</table>
				
			</form>
		</div>
	</div>
</body>
</html>