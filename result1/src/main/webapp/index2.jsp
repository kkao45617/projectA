<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="java.sql.*" %>
<%
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs= null;
	String url= "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	String id = "root";
	String pwd="1234";
	String sql="select max(custno) from member_tbl_02";
	int custno=0;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,id,pwd);
		pstm=conn.prepareStatement(sql);
		rs=pstm.executeQuery();
		if(rs.next()){
			custno=rs.getInt(1)+1;
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		rs.close();
		pstm.close();
		conn.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="haede.jsp"/>
	<h2 class="first">Ȩ���� ȸ�� ���</h2>
	
	<section>
	
		<form action="index1_ex.jsp">
			<table border="2">
				<tr>
					<td>ȸ����ȣ</td>
					<td><input type="text" name="number" value="<%=custno%>" readonly> </td>
				</tr>
				<tr>
					<td>ȸ������</td>
					<td><input type="text" name="name"> </td>
				</tr>
				<tr>
					<td>ȸ����ȭ</td>
					<td><input type="text" name="phone"> </td>
				</tr>
				<tr>
					<td>ȸ���ּ�</td>
					<td><input type="text" name="address"> </td>
				</tr>
				<tr>
					<td>��������</td>
					<td><input type="text" name="date"> </td>
				</tr>
				<tr>
					<td>�����</td>
					<td><input type="text" name="grade"> </td>
				</tr>
				<tr>
					<td>�����ڵ�</td>
					<td><input type="text" name="code"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="���">
						<input type="button" onclick="location.href='index3.jsp'" value="��ȸ">
					</td>
				</tr>
			</table>
			
		</form>
		
	</section>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>