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
	<h1>회원 등록</h1>
	<form name="frm" method="post" action="employeesservlet">
	
		<!-- 핸들러 하기위한 input name== 핸들러 ?(name)=(value)값 -->
		<input type="hidden" name="link" value="empoly_write">
		<table>
			<tr>
				<td>아이디</td>
				<td> <input type="text" name="id">*필수 </td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass">*필수 수정 삭제시 필요 </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name">*입력해주세요 </td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="lev">
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
				<td><input type="text" name="phone"> </td>
			</tr>
		</table>
		<br>
		<input type="submit" value="등록" >
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='employeesservlet?link=list'">	
	</form>
</div>
</body>
</html>