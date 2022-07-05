<%@page import="com.springbook.diz.board.boardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.diz.board.impl.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${username }님 환영합니다 <a href="logout.do">로그아웃</a> </h3>
	<form action="getlistboard.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="serchcondition">
						<c:forEach items="${conditionmap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>
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
		<%--  <% for(boardVO board:boardlist) {%>--%>
		
		<c:forEach items = "${boardlist}" var = "board">
		<tr>
			<td>${board.seq}</td>
			<td align="left"><a href="getboard.do?seq=${board.seq}"> ${board.title} </a></td>
			<td>${board.writer}></td>
			<td>${board.regdate}></td>
			<td>${board.cnt}</td>
			
		</tr>
		</c:forEach>
		<%-- <%} %> --%>
	</table>
	<br>
	<a href="insertboard.jsp">새글등록</a>
	
</body>
</html>