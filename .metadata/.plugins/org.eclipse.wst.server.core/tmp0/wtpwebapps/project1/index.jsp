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
				<td>�۾���</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pwd">
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="10" cols="20" name="content"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="�۾���"></td>
			</tr>
		</table>
	</form>
</body>
</html>