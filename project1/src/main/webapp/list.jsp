<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.sql.*" %>
<%!
	Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	
			
	String dburl="jdbc:mysql://@localhost:3306/mydb";
	String dbuser="root";
	String dbpass="1234";
	String sql="select * from board";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>�۹�ȣ</td>
			<td>����</td>
			<td>�ۼ���</td>
			<td>��¥</td>
			<td>��ȸ��</td>
		</tr>
	<%
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbuser,dbpass);
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
		
	%>
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><a href="content.jsp?num="<%=rs.getInt(1) %>> <%=rs.getString(2) %></a></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getTimestamp(7) %></td>
		<td><%=rs.getInt(6) %></td>
	</tr>
	<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	</table>
</body>
</html>