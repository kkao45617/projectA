<%@page import="com.springbook.diz.board.impl.boardDAO"%>
<%@page import="com.springbook.diz.board.boardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	boardVO board= (boardVO)session.getAttribute("board");
%>

<h1>글상세</h1>
<a href="logout_proc.jsp">로그아웃</a>
<hr>

<form action="updateboard.do" method="post">
<input type="hidden" name="seq" value="${board.seq }">
	<table border="1" cellpadding="0" cellspacing="0">
		
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input name="title" type="text" value="${board.title }"> </td>
		</tr>
		
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left">${board.writer } </td>
		</tr>
		<tr>
			<td bgcolor="orange">내용 </td>
			<td align="left"><textarea name="content" rows="10" cols="40">${board.content} </textarea> </td>
		</tr>
		<tr>
			<td bgcolor="orange">등록일</td>
			<td align="left">${board.regdate} </td>
		</tr>
		<tr>
			<td bgcolor="orange"> 조회수</td>
			<td align="left">${board.cnt } </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글수정"> </td>
		</tr>
	</table>

</form>
<a href="insertboard.do">글등록</a> 
<a href="deleteboard.do?seq=${board.seq }" > 글삭제</a> 
<a href="getlistboard.do">글목록</a>
</body>
</html>