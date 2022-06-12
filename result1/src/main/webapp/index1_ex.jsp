<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String number= request.getParameter("number");
	String name= request.getParameter("name");
	String phone = request.getParameter("phone");
	String address= request.getParameter("address");
	String date = request.getParameter("date");
	String code = request.getParameter("code");
	String grade = request.getParameter("grade");
	
	String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
	PreparedStatement pstmt=null;
	Connection conn=null;
	String url= "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	String id = "root";
	String pwd="1234";
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,id,pwd);
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,number);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, date);
		pstmt.setString(6, grade);
		pstmt.setString(7, code);
		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		pstmt.close();
		conn.close();
	}
	
	response.sendRedirect("index3.jsp");
	
%>