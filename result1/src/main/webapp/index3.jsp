<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs = null;
	String url= "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	String id = "root";
	String pwd="1234";
	String sql="select * from member_tbl_02";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<jsp:include page="haede.jsp"/>
<h2 class="first">ȸ����� ��ȸ/����</h2>
<section>
	<table border="2">
		<tr>
			<td>ȸ����ȣ</td>
			<td>ȸ������</td>
			<td>��ȭ��ȣ</td>
			<td>�ּ�</td>
			<td>��������</td>
			<td>�����</td>
			<td>��������</td>
		</tr>
		
<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,id,pwd);
		pstm=conn.prepareStatement(sql);
		rs=pstm.executeQuery();
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td><a href='indexup.jsp'>"+rs.getString(1)+"</a></td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("<td>"+rs.getString(6)+"</td>");
			out.println("<td>"+rs.getString(7)+"</td>");
			
			out.println("</tr>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		rs.close();
		pstm.close();
		conn.close();
	}


%>		
	</table>
</section>
<jsp:include page="footer.jsp"/>


</body>
</html>