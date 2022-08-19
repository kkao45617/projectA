<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	
<!-- ������Ʈ -->	
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!-- include summernote css/js-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>

<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Ŭ���̾�Ʈ ��ǰ ����������</h1>

<div>
	<label>�Ǹ���</label><input name="pt_no" readonly="readonly" value="${clinet_no.pt_name}">
</div>

<script type="text/javascript">
	function basketingchange(){
		const btnelement = document.getElementById('basketing');
		const htmlown = '<button id="basketed" onclick="basketedchange()">��ٱ��ϴ��</button>';
		alert("��ٱ��Ͽ� ��ҽ��ϴ�.");
		//��Ʈ�ѷ� �Ѱ��ִ� ���� �����ϱ�
		location.href="ptclient/basketinsert?"
				
		btnelement.innerHTML=htmlown;
	}
</script>

<script type="text/javascript">
	function basketedchange(){
		alert("�̹� ����ֽ��ϴ�");
	}
</script>

<button id="basketing"  onclick="basketingchange()">��ٱ���</button>

<script type="text/javascript">
function iamport(){
	//������ �ĺ��ڵ�
	const title=${clinet_no.PT_title};
	var price= ${clinet_no.PT_Price};
	
	IMP.init('imp56221238');
	IMP.request_pay({
	    pg : 'kcp',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : title , //����â���� ������ �̸�
	    amount :price, //���� �����Ǵ� ����
	    buyer_email : 'iamport@siot.do',
	    buyer_name :"kkao45617",
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '���� ������ ���',
	    buyer_postcode : '123-456'
	}, function(rsp) {
		console.log(rsp);
	    if ( rsp.success ) {
	    	var msg = '������ �Ϸ�Ǿ����ϴ�.';
	        msg += '����ID : ' + rsp.imp_uid;
	        msg += '���� �ŷ�ID : ' + rsp.merchant_uid;
	        msg += '���� �ݾ� : ' + rsp.paid_amount;
	        msg += 'ī�� ���ι�ȣ : ' + rsp.apply_num;
	    } else {
	    	 var msg = '������ �����Ͽ����ϴ�.';
	         msg += '�������� : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}
</script>

<button onclick="iamport()">�����ϱ�</button>



<div>
	<label>��ǰ����</label>
		<div> ${clinet_no.PT_content}</div>
</div>
<div>
	<label>��� ���̵�</label><input name="PT_id" readonly="readonly" value="${clinet_no.PT_id}">
</div>
<div>
	<label>��ǰ ����</label><input name="PT_State" readonly="readonly" value="${clinet_no.PT_State}">
</div>
<div>
	<label>��ǰ ����</label><input name="PT_title" readonly="readonly" value="${clinet_no.PT_title}">
</div>
<div>
	<label>��ǰ ����</label><input name="PT_price" readonly="readonly" value="${clinet_no.PT_Price}">
</div>
<div>
	<label>��ǰ ����</label><input name="PT_photourl" readonly="readonly" value="${clinet_no.PT_photourl}">
</div>

<div>
	<label>Ķ���� ��</label><input name="Calendar_before" readonly="readonly" value="${clinet_no.calendar_before}">
</div>
<div>
	<label>Ķ���� ��</label><input name="Calendar_after" readonly="readonly" value="${clinet_no.calendar_after}">
</div>


	
		<button id="ptlist">���</button>
	
<script>
	var operForm =$("#operForm");
	
	$(document).ready(function() {
		$("#ptlist").on("click",function(){
			self.location="/ptclient/clientlist";
		})
	});
</script>
</body>
</html>