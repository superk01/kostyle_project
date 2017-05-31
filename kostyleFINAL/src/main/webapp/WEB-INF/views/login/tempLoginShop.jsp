<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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