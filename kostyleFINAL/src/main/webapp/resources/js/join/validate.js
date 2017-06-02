/*function checkValue() {
	
	var check1 = $("#check1").val();
	var check2 = $("#check2").val();
	var name = $("#inputName").val();
	var birth = $("#inputBirth").val();
	var phonenumber = $("#inputNumber").val();
	var email = $("#inputEmail").val();
	var id = $("#inputId").val();
	var password = $("#inputPassword").val();
	var passwordCheck = $("#inputPasswordCheck").val();
	var zipcode = $("#inputPostcode").val();
	var adress = $("#inputAdress").val();
	
	
}*/



function id_validation() {
	var regExp = /^[a-z][a-zA-Z0-9]{3,15}$/;
	var id = $("#inputId").val();
	var out = regExp.test(id);
	if(out == false){
		$('#m_id').html('아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.');
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
	var regExp = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
	var phone =$("#inputNumber").val();
	var out = regExp.test(phone);
	if(out == false){
		$('#m_phone').html('핸드폰번호 형식이 아닙니다.');
	}else{
		$('#m_phone').empty();
	}
}
