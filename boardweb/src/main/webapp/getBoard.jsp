<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.diz.board.BoardVO"%>
<%@ page import="java.util.List" %>

<%
	BoardVO board = (BoardVO)session.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout_proc.jsp">Log-out</a>
<hr>
	<!-- <form action="updateBoard_proc.jsp" method="post"> -->
	<form action="updateBoard.do" method="post">
	<input type="hidden" name="seq" value="<%= board.getSeq() %>"/>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" type="text" value="<%= board.getTitle()%>"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><%= board.getWriter() %></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea cols="40" rows="10" name="content"><%= board.getContent() %></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><%= board.getRegdate() %></td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left"><%= board.getCnt() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 수정"/>
				</td>	
			</tr>
		</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글목록</a>
</center>
</body>
</html>