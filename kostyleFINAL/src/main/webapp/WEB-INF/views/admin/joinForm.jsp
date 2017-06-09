<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signin Template for Bootstrap</title>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link href="../../../resources/css/admin/shopJoin.css" rel="stylesheet">
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">입점 신청</h2>
        <label for="inputShopName" class="sr-only">ShoppingMall Name</label>
        <input type="text" id="inputShopName" class="form-control" name="s_sname" placeholder="쇼핑몰명" required autofocus>
        
        <label for="inputShopURL" class="sr-only">ShoppingMall URL</label>
        <input type="text" id="inputShopURL" class="form-control" name="s_shopurl" placeholder="쇼핑몰 URL" required>
        
        <label for="inputShopSearchURL" class="sr-only">ShoppingMall SearchURL</label>
        <input type="text" id="inputShopSearchURL" class="form-control" name="s_searchurl" placeholder="검색 URL" required>
        
        <label for="inputShopReg" class="sr-only">ShoppingMall Reg</label>
        <input type="text" id="inputShopReg" class="form-control" name="s_shopreg" placeholder="사업자등록번호" required>
        
        <label for="inputImage" class="sr-only">ShoppingMall Image</label>
        <input type="file" id="inputImage" class="form-control" name="s_image" required>
        
        <label for="inputAge" class="sr-only">ShoppingMall Age</label>
        <select class="form-control" id="inputAge" name="s_age">
        	<option value="0">연령대</option>
        	<option value="10">10대</option>
        	<option value="20">20대</option>
        	<option value="30">30대</option>
        	<option value="40">40대</option>
        </select>
        
        <label for="inputManager" class="sr-only">ShoppingMall Manager</label>
        <input type="text" id="inputManager" class="form-control" name="s_manager" placeholder="담당자 이름" required>
        
        <label for="inputEmail" class="sr-only">ShoppingMall Email</label>
        <input type="text" id="inputEmail" class="form-control" name="s_email" placeholder="이메일" required>
        
        <label for="inputPhoneNumber" class="sr-only">ShoppingMall Phone</label>
        <input type="text" id="inputPhoneNumber" class="form-control" name="s_phonenumber" placeholder="연락처" required>
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
