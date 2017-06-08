<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko-kr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ºÎÆ®½ºÆ®·¦</title>

    <!-- Bootstrap -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>

name<input type="text" id="name"> <br>
tel<input type="text" id="tel"> <br>
email<input type="text" id="email"><br> 
water<input type="text" id="water"><br> 
black<input type="text" id="black"><br> 
<button id="changeSubmitBtn">button</button>
123
</body>


<script>

$('#changeSubmitBtn').click(function(e){
    var data = {};
    data["name"] = $('#name').val();
    data["tel"] = $('#tel').val();
    data["email"] = $('#email').val();
    
//    var data2 = JSON.stringify(data);
    
    var data2 = {};
    data2["water"] = $('#water').val();
    data2["black"] = $('#black').val();
    
    var data3 = {};
    data3["shop"] = JSON.stringify(data);
    data3["adshop"] = JSON.stringify(data2);
    
    $.ajax({
        contentType:'application/json',
        dataType:'json',
        data:JSON.stringify(data3),
        url:'/admin/test',
        type:'POST',
        success:function(response){
                alert(response.message);
            },
        error:function(request,status,error){
                alert(response.message);
            }
        });
});




</script>
</html>