<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%


	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	int readcount=0;
	Timestamp date = new Timestamp(System.currentTimeMillis());
	
	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://@localhost:3306/mydb";
	String dbuser="root";
	String dbpass="1234";
	Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
	
	int num=0;
	String sql="select max(num) from board";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	
	if(rs.next()){
		num=rs.getInt("max(num)")+1;
	}
	sql="insert into board values(?,?,?,?,?,?,?)";
	pstmt=con.prepareStatement(sql);
	pstmt.setInt(1, num);
	pstmt.setString(2, name);
	pstmt.setString(3, pwd);
	pstmt.setString(4, subject);
	pstmt.setString(5, content);
	pstmt.setInt(6, readcount);
	pstmt.setTimestamp(7, date);
	pstmt.executeUpdate();
	
	response.sendRedirect("list.jsp");
%>
</body>
</html>