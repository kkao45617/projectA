<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*" %>
<jsp:useBean id="dao" class="com.it.dao.boarddao"/>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="vo" class="com.it.dao.boardvo">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>

<%
boolean chk=dao.boardupdate(vo);
	
	if(chk==true){
		response.sendRedirect("detail.jsp?no="+vo.getNo());
		
	}else{
%>
		<script>
			alert("비밀번호가 틀렸습니다");
			history.back();
		</script>
<% 
	}
%>
 
 <!-- 컨텐츠 새팅하는과정 -->
<%--<%
	boardvo vo= new boardvo();
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String pwd = request.getParameter("pwd");
	
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	
	//dao 연결
	boarddao dao = new boarddao();
	dao.boardinsert(vo);
	
	//화면 이동
	response.sendRedirect("list.jsp");
	%>
--%>
 