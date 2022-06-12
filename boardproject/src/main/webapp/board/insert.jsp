<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
	<div class="conteiner">
		<h1>글쓰기</h1>
		<div>
			<form method="get" action="inert_impl.jsp">
				<table class="table">
					<tr>
						<td class="text-right" width="15%">이름</td>
						<td>
							<input type="text" name="name" size="15" class="input-sm">
						</td>
					</tr>
					<tr>
						<td class="text-right" width="15%">제목</td>
						<td>
							<input type="text" name="subject" size="65" class="input-sm">
						</td>
					</tr>
					<tr>
						<td class="text-right" width="15%">내용</td>
						<td>
							<textarea rows="10" cols="50" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td class="text-right" width="15%">비밀번호</td>
						<td>
							<input type="password" name="pwd" size="10" class="input-sm">
						</td>
					</tr>
					<td colspan="2" class="text-center">
						<input type="submit" value="글쓰기" class="btn-sm btn-primary">
				<input type="button" value="취소" class="btn-sm btn-primary" onclick="javascript:history.back()">
					</td>
				</table>
				
			</form>
		</div>
	</div>
</body>
</html>