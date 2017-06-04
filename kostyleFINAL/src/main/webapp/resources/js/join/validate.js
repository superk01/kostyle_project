function checkValue() {
	
	//일치하지 않으면 -1
	var id = $("#inputId").val();
	var idregExp = /^.*(?=.{6,16})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var result=id.search(idregExp);
	
	var password = $("#inputPassword").val();
	var password2 = $("#inputPasswordCheck").val();
	var passwordregExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	
	var phonenumber = $("#inputNumber").val();
	var phonenumberregExp = /^01[0-9]{8,9}$/;

	if(id.search(idregExp)==-1){
		alert("아이디를 영문, 숫자 혼합하여 6~16자리 이내로 입력하세요.");
		return false;
		
	}else if(password.search(passwordregExp)==-1){
		alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
		return false;
		
	}else if(phonenumber.search(phonenumberregExp)==-1){
		alert("핸드폰 번호의 형식에 맞지 않습니다.");
		return false;
		
	}else if(password != password2){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
		
	}else {
		return true;
	}
	
}


function id_validation() {
	var regExp = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	var id = $("#inputId").val();
	var out = regExp.test(id);
	if(out == false){
		$('#m_id').html('아이디를 영문, 숫자 혼합하여 6~16자리 이내로 입력하세요.');
	}else{
		$('#m_id').empty();
	}
}


function pass_validation() {
	var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	var pass =$("#inputPassword").val();
	var out = regExp.test(pass);
	if(out == false){
		$('#m_pass').html('비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.');
	}else{
		$('#m_pass').empty();
	}
}

function pass2_validation() {
	var pass =$("#inputPassword").val();
	var pass2 =$("#inputPasswordCheck").val();
	
	if(pass != pass2){
		$('#m_pass2').html('비밀번호가 일치하지 않습니다.');
	}else{
		$('#m_pass2').empty();
	}
}

function phone_validation() {
	var regExp = /^01[0-9]{8,9}$/;
	var phone =$("#inputNumber").val();
	var out = regExp.test(phone);
	if(out == false){
		$('#m_phone').html('핸드폰번호 형식이 아닙니다.');
	}else{
		$('#m_phone').empty();
	}
}
