<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signin Template for Bootstrap</title>
    
    <link href="../../../resources/css/shopEntry/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/shopEntry/shopEntry.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">입점 신청</h2>
        <label for="inputID" class="shopInfo">ShoppingMall ID</label>
        <input type="text" id="inputID" class="enrtyForm" placeholder="ID" required autofocus>
        <label for="inputPW" class="shopInfo">Password</label>
        <input type="password" id="inputPW" class="enrtyForm" placeholder="비밀번호" required autofocus>
        <label for="inputPW2" class="shopInfo">Password2</label>
        <input type="password" id="inputPW2" class="enrtyForm" placeholder="비밀번호 재입력" required autofocus>

        <label for="inputName" class="shopInfo">ShoppingMall Name</label>
        <input type="text" id="inputName" class="enrtyForm" placeholder="쇼핑몰명" required autofocus>
        
        
        
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
