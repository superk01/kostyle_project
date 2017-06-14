<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<% CustomerVO login = (CustomerVO)session.getAttribute("login"); %>
<c:set var="path" 
value="${pageContext.request.contextPath}"/>

<script>

$(document).ready(function(){
	$("#btncom").click(function(){
		
		var c_id=$("#c_id").val();
		alert(c_id);
		var c_pass=$("#c_pass").val();
		alert(c_pass);
		if(c_pass==""){
			alert("비밀번호를 입력하세요");
			$("#c_pass").focus();
			return;
		}		/* <a href = "${path}/board/view.do?bno=${row.bno}"> */
		document.form1.action=
			"${path}/mypage/modi_pass_check";
		document.form1.submit();
	});
});

</script>




		<div id="contents">
			<div id="cont_area">
				<h3>
				
					회원 정보 수정	
				</h3>
				
				<div id="context_in">
					<div class="myAdmin myid">
						<p class="findMsg">
							 고객님의 본인확인을 위해 비밀번호를 입력해주세요.
						</p>
						<form name="form1" method="post">
						<div class="findForm">
							<div class="findFormWrap">
								<p>
									<!-- <img src="img" alt="아이디"> -->
									<span>아이디</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- <input type="id" name="c_id"> -->
									
									
									<%=login.getC_id()%>

									
									<%
									
									//out.print("세션으로값받음");
									//session.getAttribute(arg0)
									%>
								</p>
								<p>
									<label for="passwd">
										<!-- <img src="img" alt="비밀번호"> -->
										<span>비밀번호</span>&nbsp;&nbsp;&nbsp;
									</label>
									<input type="password" name="c_pass" id="c_pass" title="비밀번호" class="Ty04" value="">
									<div style="color:red">${message }</div>
								</p>
							</div>
						</div>
						<div class="findBtn">
							<%-- <input name="c_id" type="hidden" value="${sessionScope.c_id}"/> --%>
							<!-- <input id="btncom" type="submit" value="확인"> -->
							<input name="c_id" id="c_id" type="hidden" value="<%=login.getC_id() %>" />
							<button type="button" id="btncom">확인</button>
						</div>
						</form>
					</div>
				</div>	
				
			</div>
		</div>
