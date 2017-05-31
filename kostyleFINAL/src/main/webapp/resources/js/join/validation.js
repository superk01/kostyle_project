/*function fnReturn() {

	if(event.keyCode==13)

		document.forms[0].user_id.focus(); // focus() 커서가 해당 칸으로 옴김

}*///엔터치면 자동으로 다음입력칸에 커서

/*function nameCheck() {
	var regExp = / /;
	var n =document.getElementById("name").value;
	var out = regExp.test(n); //이름칸이 입력X => 정규표현식과 일치 => true
	
	if(out == false){
		alert(out);
	}
}*/

function id_validation() {
	var regExp = /^[a-z][a-zA-Z0-9]{3,15}$/;
	var n =document.getElementById("id").value;
	var out = regExp.test(n);
	if(out == false){
		alert("아이디를 4~16글자의 영소문자와 숫자조합으로 입력하세요.");
	}
	
}

function pw1_validation() {
	var regExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*|W)).{4,16}$/;
	var n =document.getElementById("pw1").value;
	var out = regExp.test(n);
	if(out == false){
		alert("비밀번호를 4~16글자의 영소문자로 입력하세요.");
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





