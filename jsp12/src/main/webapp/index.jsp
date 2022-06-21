<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
</head>
<body>
<form action="#" name="frm"  method="post">
	<input type="button" value="주소검색" onclick="goPopup()">
	주소:<input type="text" name="addr" size="100">
</form>

<script language="javascript">
		function goPopup(){
			var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		function jusoCallBack(roadFullAddr){
				document.frm.addr.value = roadFullAddr;
				}
</script>
</body>
</html>