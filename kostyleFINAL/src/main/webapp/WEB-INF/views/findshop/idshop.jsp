<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KOStylemall 아이디 찾기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- font awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/find/id_s.css"	media="screen" title="no title" charset="utf-8">

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>




</head>
<body>


<article class="container">

	<div class="col-md-12">

		<div class="page-header">
			<h1>
			<i class="fa fa-info-circle"></i> 쇼핑몰 아이디 찾기 <small>KOStyle</small>
			<a id="findshop" href="/find/id">회원 아이디 찾기를 원하시면 <b>여기</b>를 클릭해주세요.</a>
			</h1>
		</div>
		<form class="form-horizontal" action="idshopFindResult" method="post">
		
		<div id="memberJoin">
		<p id="idfind"><i class="glyphicon glyphicon-hand-right"></i> 본인확인 이메일 주소와 가입시 입력한 이메일 주소가 같아야, 아이디를 찾을 수 있습니다.</p>
			<div class="form-group">
			<br><br>
				<label class="col-sm-3 control-label" for="inputName">쇼핑몰 명</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputName" type="text" name="s_sname" required=""
					 placeholder="쇼핑몰 이름을 정확히 입력해 주세요" autocomplete="off">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">이메일</label>
				<div class="col-sm-6">
					<input class="form-control" id="inputEmail" type="email" name="s_email"	required=""
					 placeholder="ex) gildong@kostyle.com" autocomplete="off">
				</div>
			</div>
			
			<br><br>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button id="btn-join" class="btn btn-default btn-lg" type="submit" class="submit">
						아이디찾기 <i class="fa fa-info-circle"></i>
					</button>
					<button id="btn-cancle" class="btn btn-default btn-lg" onclick="location.href='/'">
						코스타일몰 홈 <i class="glyphicon glyphicon-home"></i>
					</button>
					<br>

				</div>
			</div>
		</div>	
		</form>
	</div>
	</article>

	
</body>
</html>