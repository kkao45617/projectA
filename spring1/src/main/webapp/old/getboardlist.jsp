<%@page import="com.springbook.biz.board.boardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.diz.board.impl.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	List<boardVO> boardlist = (List)session.getAttribute("boardlist");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>테스트님 환영합니다 <a href="logout_proc.jsp">로그아웃</a> </h3>
	<form action="getlistboard.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="serchcondition">
						<option value="title">제목
						<option value="content">내용
					</select>
					<input name="serchkeyword" type="text"/>
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1" celpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		<% for(boardVO board:boardlist) {%>
		<tr>
			<td><%=board.getSeq() %></td>
			<td align="left"><a href="getboard.do?seq=<%=board.getSeq() %>"> <%= board.getTitle() %></a></td>
			<td><%= board.getWriter() %></td>
			<td><%=board.getRegdate() %></td>
			<td><%=board.getCnt() %></td>
			
		</tr>
		<%} %>
	</table>
	<br>
	<a href="insertboard.jsp">새글등록</a>
	
</body>
</html>