<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="employeesservlet">
			<input type="hidden" name="link" value="employ_update">
			<input type="hidden" name="id" value="${updateform.id}">
			
			<table border="2">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="id" value="${ updateform.id}" readonly="readonly"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pass" value="${updateform.pass }"> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${updateform.name }"> </td>
				</tr>
				
				<tr>
				<td>권한</td>
				<td>
					<select name="lev" >
						<option value="A">운영자</option>
						<option value="B">일반사원</option>
					</select>
				 </td>
				</tr>
				
				<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${updateform.phone}"> </td>
			</tr>
			
			</table>
			<br>
			<input type="submit" value="등록" >
			<input type="reset" value="다시등록">
			<input type="button" value="목록" onclick="location.href='employeesservlet?link=list'">
		</form>
	</div>
</body>
</html>