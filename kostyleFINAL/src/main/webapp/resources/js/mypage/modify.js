

function pw_validation() {
	var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	var pw =document.modifyform.c_pass.value;
	var out = regExp.test(pw);
	if(out == false){
		$('#m_pw').html('비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.');
		//alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
	}else{
		$('#m_pw').empty();
	}
}

function pw2_validation() {
	var pw =document.modifyform.c_pass.value;
	var pw2 =document.modifyform.c_pass2.value;
	
	if(pw != pw2){
		$('#m_pw2').html('비밀번호가 일치하지 않습니다.');
		//alert("비밀번호가 일치하지 않습니다.");
	}else{
		$('#m_pw2').empty();
	}
}



function zip_validation() {
	var regExp = /^\d{3}-?\d{3}$/;
	var zip =document.modifyform.c_zipcode.value;
	var out = regExp.test(zip);
	if(out == false){
		$('#m_zip').html('우편번호는 6자리 숫자로 입력해주세요.');
		//alert("우편번호는 6자리 숫자로 입력해주세요.");
	}else{
		$('#m_zip').empty();
	}
}

function p2_validation() {
	var regExp = /^\d{3,4}$/;
	var p2 =document.joinform.c_p2.value;
	var out = regExp.test(p2);
	if(out == false){
		$('#m_phone').html('핸드폰 번호를 확인해주세요.');
		//alert("핸드폰 번호를 확인해주세요.");
	}else{
		$('#m_phone').empty();
	}
}

function p3_validation() {
	var regExp = /^\d{4}$/;
	var p3 =document.joinform.c_p3.value;
	var out = regExp.test(p3);
	if(out == false){
		$('#m_phone').html('핸드폰 번호를 확인해주세요.');
		//alert("핸드폰 번호를 확인해주세요.");
	}else{
		$('#m_phone').empty();
	}
}

function onlyNum() {

	if(event.keyCode<48 || event.keyCode>57){ // keyCode 아스키코드 값을 리턴해주느 함수
		if(navigator.appName=="Netscape"){
			event.preventDefault(); //FF(이벤트를 무효화시킴) -> 숫자외에 입력을 불가능하게 한다는 말
		}
		else{
			event.returnValue=false; // IE(이벤트를 무효화시킴)	
		}
			
	}
}//텍스트 칸에 숫자만 입력할 수 있도록



function checkValue() {
	

    
    var pwregExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
    var pw =document.modifyform.c_pass.value;

    
    var zipregExp = /^\d{3}-?\d{3}$/;
    var zip =document.modifyform.c_zipcode.value;

    

	if(document.modifyform.c_pass.value==""){
		alert("비밀번호를 입력하세요.");
		document.modifyform.c_pass.focus();
		return false;
		
	}else if(pwregExp.test(pw)==false){
		alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
		document.modifyform.c_pass.focus();
		return false;
		
	}else if(document.modifyform.c_pass2.value==""){
		alert("비밀번호 확인을 입력하세요.");
		document.modifyform.c_pass2.focus();
		return false;
		
	}else if(document.modifyform.c_zipcode.value==""){
		alert("우편번호을 입력하세요.");
		document.modifyform.c_zipcode.focus();
		return false;
		
	}else if(zipregExp.test(zip)==false){
		alert("우편번호는 6자리입니다.");
		document.modifyform.c_zipcode.focus();
		return false;
		
	}else {
		alert("변경이 완료되었습니다.");
		return true;
	}
	
	
}




























