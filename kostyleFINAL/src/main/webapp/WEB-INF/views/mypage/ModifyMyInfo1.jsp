<%@page import="kostyle.login.domain.CustomerVO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/jquery/jquery-3.2.1.js"></script>


<script type="text/javascript" src="../../../resources/js/mypage/joinAPI.js"></script>
<script type="text/javascript" src="../../../resources/js/mypage/validate.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- <script type="text/javascript" src="../../../resources/js/mypage/join1.js"></script>
<script type="text/javascript" src="../../../resources/js/mypage/modify.js"></script>      -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<% CustomerVO login = (CustomerVO)session.getAttribute("login"); %>
<c:set var="path" 
value="${pageContext.request.contextPath}"/>

<script>
$(document).ready(function(){
	$("#completecng").click(function(){
		
		var c_id = $("#c_id").val();
		alert(c_id);
		var c_pass = $("#c_pass").val();
		var c_adress = $("#c_adress").val();
		var c_email = $("#c_email").val();
		var c_sms = $("#c_sms").val();
	    var c_zipcode = $("#c_zipcode").val();
		
	    alert(c_zipcode);
	    
		document.form1.action=
			"${path}/mypage/modifyMyInfo";
		document.form1.submit();
		
	});
	
	$("#cancel").click(function(){
		alert("di");
		document.form1.action=
			"${path}/mypage/MypageMain";
		document.form1.submit();
	});
	
});
</script>





<%
	String birth = login.getC_birth();
	int p_powernum = login.getP_powernum();
 	String year = birth.substring(0,4);
	String month = birth.substring(5,7);
	String day = birth.substring(8,10);  
	int check1 = login.getC_sms();
	String check = check1 + "";
	%>

<form name="form1" method="post">
<style type="text/css">
	@IMPORT url("../resources/css/mypage/MypageBody.css");
</style>
<h3>
<%-- 이름 : ${param.c_id}<br> --%><%-- 
이름3: <%=c_id %> --%>
</h3>
		<div id="contents">
			<div id="cont_area">
				<h3>
					 개인정보 수정/관리
				</h3>
				
				<div id="context_in">
					<div class="memberJoin">
						<div class="agreement"> 
							<table class="dataAdd" summary="정보입력">
								<colgroup>
									<col width="118">
									<col width="*">
								</colgroup>
								
								<tbody>
									<tr>
										<th scope="row">
											<label for="nameText"><!-- 
												<img src="/img/front/member/th_name.gif" alt="이름"> -->
												<p>이름</p>
											</label>
										</th>
										<td>
											<label for="name">
											<%-- 	<input id="nameText" class="inputTxt1" name="c_name" value="${c_name}" onkeyup="checkByte(this, '20');" placeholder="이름을 입력해 주세요" type="text">
											 --%>
											 ${dto.c_name}
											 </label>
											<span id="nameMsg" style="display: block; color:red"></span>
										</td>
									</tr>
								
								
	
									<tr>
										<th scope="row">
											<label for="idText">
												<!-- <img src="/img/front/member/th_id.gif" alt="아이디"> -->
												<p>아이디</p>
											</label>
										</th>
										<td>
										${dto.c_id} 
										</td>									
									</tr>
									
									<tr>
										<th scope="row">
											<label for="passText">
												<!-- <img src="/img/front/member/th_id.gif" alt="비밀번호"> -->
												<p>비밀번호</p>
											</label>
										</th>
										<td>
											<label for="name">
												<input  class="passText1" id="c_pass" name="c_pass"  onkeyup="pass_validation();" placeholder="비밀번호를 입력해주세요" type="text" onblur="pw_validation();"><br>
												<span id="m_pw"></span>
											</label>
											<span id="nameMsg" style="display: block; color:red"></span>
										</td>									
									</tr>
									
										<tr>
										<th scope="row">
											<label for="passText">
												<!-- <img src="/img/front/member/th_id.gif" alt="비밀번호 확인"> -->
												<p>비밀번호확인</p>
											</label>
										</th>
										<td>
											<label for="name">
												<input class="checkPass2" id="c_pass2" name="c_pass2"  onkeyup="pass2_validation();" placeholder="비밀번호를 입력해주세요" type="text" onblur="pw2_validation();"><br>
												<span id="m_pw2"></span>
											</label>
											<span id="nameMsg" style="display: block; color:red"></span>
										</td>									
									</tr>
				
								
									<tr>
										<th scope="row">
											<label for="birthY">
												<!-- <img src="/img/front/member/th_mon.gif" alt="생년월일"> -->
												<p>생년월일</p>
											</label>
										</th>
										<td>
											 <%=year %>년 <%=month %>월 <%=day %>일
											<span id="birthMsg" style="display: block; color:red"></span>	
										</td>
									</tr>
									
									<tr>
										<th scope="row">
											<label for="address">
												<!-- <img src="/img/front/member/th_mon.gif" alt="주소"> -->
												<p>주소</p>
											</label>
										</th>
										<td>
										<input class="form-control1" id="inputPostcode" value="${dto.c_zipcode }" type="text" required="" readonly="readonly"
										 name="c_zipcode" placeholder="우편번호">
											
											 &nbsp; <input type="button" value="우편번호" onclick="sample6_execDaumPostcode()"/>
											<span id="m_zip"></span>
											<input class="form-control1" id="inputAdress" value="${dto.c_adress }"	 type="text" required="" name="c_adress"
					 						autocomplete="off" size='60'>
										</td>
									</tr>
									
									<tr>
										<th scope="row">
											<label for="emailText">
												<!-- <img src="/img/front/member/th_email.gif" alt="이메일"> -->
												<p>이메일</p>
											</label>
										</th>
										<td>
											<label for="email">
												<input  class="inputTxt2" id="c_email" name="c_email" value="${dto.c_email}" placeholder="이메일을 입력해 주세요" type="text">
											</label>
												<p class="gray textS" style="margin-top:6px;">* 코스타일몰 이벤트 및 쇼핑몰 정보등은 입력하신 이메일로 발송됩니다.</p>
												<span id="emailMsg" style="display: block; color:red"></span>
										</td>
									</tr>
									
									<tr>
									<th scope="row">
										<label for="tmobile">
											<!-- <img src="/img/front/member/th_tmobile.gif" alt="휴대폰"> -->
											<p>휴대폰</p>
										</label>
									</th>
										<td>
											<span id="mobileNoArea">${dto.c_phonenumber}</span>
												<a href="javascript:;" onclick="javascript:mobileAuthPopup();">
												</a>
											<input id="mobileNoText" name="mobileNoText" value="01089108300" type="hidden">
										</td>
									</tr>
									<tr>
										<th scope="row">
											<!-- <img src="/img/front/member/th_sms.gif" alt="sms 수신여부"> -->
											<p>SMS 수신</p>
										</th>
										<td class="confirm">
											<p class="gray">
												 <input id="c_sms" name="c_sms" value="on" type="radio" <%=("on".equals(check))?"checked":""%>>
													<label for="approveSmsYn1">수신함</label>
												<input id="c_sms" name="c_sms" value="off"  type="radio" <%=("off".equals(check))?"checked":""%>>
													<label for="approveSmsYn2">수신안함</label> 
											</p>
												<p class="gray textS" style="margin-top:3px;">* 코스타일몰에서 진행하는 이벤트 및 쇼핑몰 정보 등의 내용을 수신하는데 동의합니다.</p>
											<span id="approveSmsYnMsg" style="display: block; color:red"></span>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="btn_mySite">
							
							<input type="hidden" name="c_id" id="c_id" value="<%=login.getC_id() %>"/>
							<button type="button" id="completecng">변경완료오</button>
							
							
							<button type="button" id="cancel">취소</button>
						</div>
					</div>
				</div>	
			</div>
		</div>
</form>
