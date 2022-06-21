<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement ptsm=null;
	ResultSet rs= null;
	String url= "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	String id = "root";
	String pwd="1234";
	
	String sql="select m1.custno ,custname,grade, sum(price) from money_tbl_02 m1,member_tbl_02 m2 where m1.custno=m2.custno group by m2.custno, m2.custname,m2.grade";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="haede.jsp"/>
<section>
	<table border="2">
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,id,pwd);
		ptsm=conn.prepareStatement(sql);
		
		rs=ptsm.executeQuery();
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("</tr>");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		rs.close();
		ptsm.close();
		conn.close();
	}
%>
	</table>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>