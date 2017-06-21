function checkValue() {
	
	var password = $("#c_pass").val();
	var password2 = $("#c_pass2").val();
	var passwordregExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	
	if(password.search(passwordregExp)==-1){
		alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
		return false;
		
	}else if(password != password2){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
		
	}else {
		return true;
	}
	
}

function pass_validation() {
	var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	var pass =$("#c_pass").val();
	var out = regExp.test(pass);
	if(out == false){
		$('#m_pw').html('비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.');
	}else{
		$('#m_pw').empty();
	}
}

function pass2_validation() {
	var pass =$("#c_pass").val();
	var pass2 =$("#c_pass2").val();
	
	if(pass != pass2){
		$('#m_pw2').html('비밀번호가 일치하지 않습니다.');
	}else{
		$('#m_pw2').empty();
	}
}

