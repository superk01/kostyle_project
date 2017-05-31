function checkId() {
	var id_exp = /^[a-z][a-zA-Z0-9]{3,15}$/;
	
	if(!document.joinform.user_id.value.match(id_exp)){
		alert("영문자 소문자로 시작해서 4~16글자로 입력하세요.");
		return false;
	}else{
		alert("사용가능한 아이디 입니다.");
		return true;
	}
}

function checkValue() {
	
	var reg_exp=/^[a-z][a-zA-Z0-9]{3,15}$/; //4~16글자 범위
	if(!document.joinform.user_id.value.match(reg_exp)){
		alert("아이디를 4~16글자의 영소문자로 입력하세요.");
		return false;
	}//reg_exp값이 정규식과 일치하는 값이 있으면 배열을 출력, 아니면 alert창을 출력

	var pw_exp=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*|W)).{4,16}$/;
	if(!document.joinform.user_pw1.value.match(pw_exp)){
		alert("비밀번호를 4~16글자의 영소문자로 입력하세요.");
		return false;
	}
	
	if(!document.joinform.user_pw1.value.equals(document.joinform.user_pw2.value)){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	if(document.joinform.user_name.value==""){
		alert("이름을 입력하세요.");
		document.loginform.user_name.focus();
		return false;
		
	}else if(document.joinform.user_id.value==""){
		alert("아이디를 입력하세요.");
		document.loginform.user_id.focus();
		return false;
		
	}else if(document.joinform.user_pw1.value==""){
		alert("비밀번호를 입력하세요.");
		document.loginform.user_pw1.focus();
		return false;
		
	}else if(document.joinform.user_pw2.value==""){
		alert("비밀번호 확인을 입력하세요.");
		document.loginform.user_pw2.focus();
		return false;
		
	}else if(document.joinform.gender.value==""){
		alert("성별을 입력하세요.");
		document.loginform.gender.focus();
		return false;
		
	}else if(document.joinform.user_birth_year.value==""){
		alert("생일을 입력하세요.");
		document.loginform.user_birth_year.focus();
		return false;
		
	}else if(document.joinform.user_zip.value==""){
		alert("우편번호을 입력하세요.");
		document.loginform.user_zip.focus();
		return false;
		
	}else if(document.joinform.user_adress.value==""){
		alert("주소를 입력하세요.");
		document.loginform.user_adress.focus();
		return false;
		
	}else if(document.joinform.user_email1.value==""){
		alert("이메일 입력하세요.");
		document.loginform.user_email1.focus();
		return false;
		
	}else if(document.joinform.user_email2.value==""){
		alert("이메일을 입력하세요.");
		document.loginform.user_email2.focus();
		return false;
		
	}else if(document.joinform.user_p1.value==""){
		alert("휴대폰 번호를 입력하세요.");
		document.loginform.user_p1.focus();
		return false;
		
	}else if(document.joinform.user_p2.value==""){
		alert("휴대폰 번호를 입력하세요.");
		document.loginform.user_p2.focus();
		return false;
		
	}else if(document.joinform.user_p3.value==""){
		alert("휴대폰 번호를 입력하세요.");
		document.loginform.user_p3.focus();
		return false;
		
	}else if(document.joinform.sms.value==""){
		alert("sms 수신여부를 확인하세요.");
		document.loginform.user_sms.focus();
		return false;
		
	}else {
		alert("가입이 완료되었습니다.")
	}
	/*var tel_exp=/^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	if(!document.joinform.user_pw1.value.match(document.joinform.user_pw2.value)){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}*/
	
	return true;
}




