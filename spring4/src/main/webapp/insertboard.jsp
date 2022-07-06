<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사용자 글쓰기 칸</h2>
	<form action="insertboard.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0">
		
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input name="title" type="text"> </td>
		</tr>
		
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left"><input name="writer" type="text"> </td>
		</tr>
		<tr>
			<td bgcolor="orange">내용 </td>
			<td align="left"><textarea name="content" rows="10" cols="40"> </textarea> </td>
		</tr>
		<tr>
			<td bgcolor="orange" width="70">업로드</td>
			<td><input type="file" name="uploadfile"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글쓰기"> </td>
		</tr>
	</table>
	
	</form>
	<a href="getlistboard.do">글목록</a>
</body>
</html>