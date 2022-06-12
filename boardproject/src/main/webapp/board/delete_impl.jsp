<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
<jsp:useBean id="dao" class="com.it.dao.boarddao"/>


<%
	String no = request.getParameter("no");
	String pwd = request.getParameter("pwd");
	
	boolean result = dao.boarddelete(Integer.parseInt(no),pwd);
	
	
%>
<%=result%>
<%
	if(result==true){
%>
<script type="text/javascript">
	alert("데이터가 삭제되었습니다.");
	location.href="list.jsp";
</script>
<%
	}
%>