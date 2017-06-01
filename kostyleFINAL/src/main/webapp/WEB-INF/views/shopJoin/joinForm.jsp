<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signin Template for Bootstrap</title>
    
    <link href="../../../resources/css/shopJoin/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/shopJoin/shopJoin.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">입점 신청</h2>
        <label for="inputShopName" class="sr-only">ShoppingMall Name</label>
        <input type="text" id="inputShopName" class="form-control" placeholder="쇼핑몰명" required autofocus>
        
        <label for="inputShopURL" class="sr-only">ShoppingMall URL</label>
        <input type="text" id="inputShopURL" class="form-control" placeholder="쇼핑몰 URL" required>
        
        <label for="inputShopSearchURL" class="sr-only">ShoppingMall SearchURL</label>
        <input type="text" id="inputShopSearchURL" class="form-control" placeholder="검색 URL" required>
        
        <label for="inputShopReg" class="sr-only">ShoppingMall Reg</label>
        <input type="text" id="inputShopReg" class="form-control" placeholder="사업자등록번호" required>
        
        <label for="inputImage" class="sr-only">ShoppingMall Image</label>
        <input type="file" id="inputImage" class="form-control" name="file" required>
        
        <label for="inputAge" class="sr-only">ShoppingMall Age</label>
        <select class="form-control" id="inputAge">
        	<option value="0">연령대</option>
        	<option value="10">10대</option>
        	<option value="20">20대</option>
        	<option value="30">30대</option>
        	<option value="40">40대</option>
        </select>
        
        <label for="inputManager" class="sr-only">ShoppingMall Manager</label>
        <input type="text" id="inputManager" class="form-control" placeholder="담당자 이름" required>
        
        <label for="inputEmail" class="sr-only">ShoppingMall Email</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="이메일" required>
        
        <label for="inputPhoneNumber" class="sr-only">ShoppingMall Phone</label>
        <input type="text" id="inputPhoneNumber" class="form-control" placeholder="연락처" required>
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
