function checkform() {
		if(document.frm.custno.value.trim() == ""){
			alert("회원번호를 입력하세요")
			custno.focus();
			return false;
		}
		if(document.frm.name.value == ""){
			alert("이름을 입력하세요")
			custno.focus();
			return false;
		}
		if(document.frm.address.value == ""){
			alert("주소를 입력하세요")
			custno.focus();
			return false;
		}
		if(document.frm.join.value == ""){
			alert("가입일자를 입력하세요")
			custno.focus();
			return false;
		}
		if(document.frm.grade.value == ""){
			alert("고객등급을 입력하세요")
			custno.focus();
			return false;
		}
		if(document.frm.city.value == ""){
			alert("도시코드를 입력하세요")
			custno.focus();
			return false;
		}
	}