<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="write.jsp">
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd">
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="20" name="content"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="글쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>