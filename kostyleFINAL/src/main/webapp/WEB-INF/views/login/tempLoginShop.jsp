<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		$(function(){
			var html;
			if(request.getAttribute("msg") != null ){
//				var html += '<div class="fail_info"><strong>'+request.getAttribute("msg")+'</strong></div>';
				html += '<strong>'+${msg}+'</strong>';
				$('#msg').append(html);
			}
		});
			
/* <div class="fail_info"> <strong>회원 아이디 또는 비밀번호가 일치하지 않습니다. (5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)</strong> <p></p> </div> */

</script>
</head>
<body>
	<div> </div>
	<form action="/shoplogin/loginCheck" method="post">
    <input type="text" name="adshop_id" value="${dto.adshop_id }" class="form-control" placeholder="SHOP ID"/>
    <input type="password" name="user_pass" class="form-control" placeholder="Password"/>
        <label>
          <input type="checkbox" name="useCookie"> 자동로그인
        </label>
      <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
</form>
</body>
</html>