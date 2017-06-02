
function id_validation() {
	var regExp = /^[a-z][a-zA-Z0-9]{3,15}$/;
	var id =document.joinform.c_id.value;
	var out = regExp.test(id);
	if(out == false){
		$('#m_id').html('아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.');
		//alert("아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.");
		
	}else{
		$('#m_id').empty();
	}
}

function id_validation2() {
	var regExp = /^[a-z][a-zA-Z0-9]{3,15}$/;
	var id =document.joinform.c_id.value;
	var out = regExp.test(id);
	if(out == false){
		alert("중복검사 : 아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.");
	}else{
		alert("중복검사 : 해당 아이디는 사용이 가능합니다.");
	}
}

function pass_validation() {
	var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
	var pass =document.joinform.c_pass.value;
	var out = regExp.test(pass);
	if(out == false){
		$('#m_pass').html('비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.');
		//alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
	}else{
		$('#m_pass').empty();
	}
}

function pass2_validation() {
	var pass =document.joinform.c_pass.value;
	var pass2 =document.joinform.c_pass2.value;
	
	if(pass != pass2){
		$('#m_pass2').html('비밀번호가 일치하지 않습니다.');
		//alert("비밀번호가 일치하지 않습니다.");
	}else{
		$('#m_pass2').empty();
	}
}

/*function year_validation() {
	var regExp = /^[1-2]{1}[0-9]{3}$/;
	var year =document.joinform.c_birth_year.value;
	var out = regExp.test(year);
	if(out == false){
		$('#m_year').html('4자리의 숫자로 입력해주세요.');
		//alert("4자리의 숫자로 입력해주세요.");
	}else{
		$('#m_year').empty();
	}
}*/

/*function zip_validation() {
	var regExp = /^\d{3}-?\d{3}$/;
	var zip =document.joinform.c_zipcode.value;
	var out = regExp.test(zip);
	if(out == false){
		$('#m_zip').html('우편번호는 6자리 숫자로 입력해주세요.');
		//alert("우편번호는 6자리 숫자로 입력해주세요.");
	}else{
		$('#m_zip').empty();
	}
}*/

/*function p2_validation() {
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
}*/

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
	
	var check1 = document.getElementById('check1');
	var check2 = document.getElementById('check2');
	var check1Result = check1.getAttribute("checked");
	var check2Result = check2.getAttribute("checked");
	
	var chk1 =document.joinform.check1.checked;
    var chk2 =document.joinform.check2.checked;
    
    var idregExp = /^[a-z][a-zA-Z0-9]{3,15}$/;
    var id =document.joinform.c_id.value;
    
    var passregExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,16}$/;
    var pass =document.joinform.c_pass.value;
    

    
    if(!chk1){
		alert("약관1에 동의해주세요.");
		document.joinform.check1.focus();
		return false;
		
	}else if(!chk2){
		alert("약관2에 동의해주세요.");
		document.joinform.check2.focus();
		return false;
		
	}else if(document.joinform.c_name.value==""){
		alert("이름을 입력하세요.");
		document.joinform.c_name.focus();
		return false;
		
	}else if(document.joinform.c_id.value==""){
		alert("아이디를 입력하세요.");
		document.joinform.c_id.focus();
		return false;
		
	}else if(idregExp.test(id)==false){
		alert("아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.");
		document.joinform.c_id.focus();
		return false;
		
	}else if(document.joinform.c_pass.value==""){
		alert("비밀번호를 입력하세요.");
		document.joinform.c_pass.focus();
		return false;
		
	}else if(passregExp.test(pass)==false){
		alert("비밀번호를 4~16자의 영문, 숫자, 특수문자의 조합으로 입력하세요.");
		document.joinform.c_pass.focus();
		return false;
		
	}else if(document.joinform.c_pass2.value==""){
		alert("비밀번호 확인을 입력하세요.");
		document.joinform.c_pass2.focus();
		return false;
		
	}else if(document.joinform.c_birth.value==""){
		alert("생일을 입력하세요.");
		document.joinform.c_birth.focus();
		return false;
		
	}else if(document.joinform.c_adress.value==""){
		alert("주소를 입력하세요.");
		document.joinform.c_adress.focus();
		return false;
		
	}else if(document.joinform.c_email.value==""){
		alert("이메일 입력하세요.");
		document.joinform.c_email.focus();
		return false;
		
	}else if(document.joinform.c_phonenumber.value==""){
		alert("휴대폰 번호를 입력하세요.");
		document.joinform.c_phonenumber.focus();
		return false;
		
	}else {
		return true;
	}
	
	
}




























