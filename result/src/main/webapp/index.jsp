<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		
	}
	header{
		font-size: 2em;
		height: 60px;
		color: white;
		background-color: blue;
		text-align: center;
	}
	.nav{
		background: navy;
		height: 30px;
	}
	.nav a{
		text-decoration: none;
		color: white;
		margin: 0 15px 0 15px;
	}
	.had{
		text-align: center;
		margin:0 0 20px 0;
		padding: 20px;
	}
	table {
	text-align: center;
	margin: 0 auto;
	
}
.td1{
	width: 300px;
}
.td2{
	width: 700px;
	text-align: left;
}
.board{

	background-color: gray;
	height: 1800px;
}
</style>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>




	<header>���θ� ȸ������ ver10</header>
	<div class="nav">
		<a href="#">ȸ�����</a>
		<a href="#">ȸ�������ȸ/����</a>
		<a href="#">ȸ��������ȸ</a>
		<a href="#">Ȩ����</a>
	</div>
	
	
	<div class="board">
		<div class="had">
			<h3>Ȩ���� ȸ�� ���</h3>
		</div>
			<form action="index_ex.jsp" method="get" name="frm">
				<table border="2">
					<tr >
						<td class="td1">ȸ����ȣ(�ڵ��߻�)</td>
						<td class="td2"><input type="text" name="custno"> </td>
					</tr>
					<tr >
						<td class="td1">ȸ������</td>
						<td class="td2"><input type="text" name="name"> </td>
					</tr>
					<tr>
						<td class="td1">ȸ���ּ�</td>
						<td class="td2"><input type="text" name="address" size="30"> </td>
					</tr>
					<tr>
						<td class="td1">��������</td>
						<td class="td2"><input type="text" name="join" size="50"> </td>
					</tr>
					<tr>
						<td class="td1">�����(a:vip,b:�Ϲ�,c:����)</td>
						<td class="td2"><input type="text" name="grade"> </td>
					</tr>
					<tr>
						<td class="td1">�����ڵ�</td>
						<td class="td2"><input type="text" name="city"> </td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="���">
							<input type="button" onclick="location='index3.jsp'"  value="��ȸ">
						</td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>