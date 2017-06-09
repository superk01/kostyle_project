<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../../../resources/js/mypage/join1.js"></script>
<script type="text/javascript" src="../../../resources/js/mypage/modify.js"></script>    
<%
	String birth = (String)session.getAttribute("c_birth");
	int p_powernum = (Integer)session.getAttribute("p_powernum");
 	String year = birth.substring(0,4);
	String month = birth.substring(5,7);
	String day = birth.substring(8,10);  
	String check = (String)session.getAttribute("c_sms");
%>

<form name="form1" onsubmit="return checkValue()">
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
												<input id="passText" class="passText1" name="c_pass" value="${dto.c_pass}" onkeyup="checkByte(this, '20');" placeholder="비밀번호를 입력해주세요" type="text" onblur="pw_validation();"><br>
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
												<input id="checkPass" class="checkPass2" name="c_pass2"  onkeyup="checkByte(this, '20');" placeholder="비밀번호를 입력해주세요" type="text" onblur="pw2_validation();"><br>
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
											<input id="zip" name="c_zipcode" value="${dto.c_zipcode}" onkeypress="onlyNum();" onBlur="zip_validation();" placeholder="우편번호" type="text" autocomplete="off"> &nbsp;<input type="button" value="우편번호"/>
											<span id="m_zip"></span>
											<br>
											<input id="ad" name="c_adress" value="${dto.c_adress}"	onkeyup="checkByte(this, '20');" placeholder="주소를 입력하세요" type="text" size='60'>
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
												<input id="emailText" class="inputTxt2" name="c_email" value="${dto.c_email}" placeholder="이메일을 입력해 주세요" type="text">
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
												 <input id="approveSmsYn1" name="c_sms" value="on" type="radio" <%=("on".equals(check))?"checked":""%>>
													<label for="approveSmsYn1">수신함</label>
												<input id="approveSmsYn2" name="c_sms" value="off"  type="radio" <%=("off".equals(check))?"checked":""%>>
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
						
							<input type="submit" value="변경완료" class="submit">
							
							<input type="button" value="취소" onclick = "location.href = 'MypageBody.jsp?body=ModifyMyInfoCheck.jsp' ">
						</div>
					</div>
				</div>	
			</div>
		</div>
</form>
