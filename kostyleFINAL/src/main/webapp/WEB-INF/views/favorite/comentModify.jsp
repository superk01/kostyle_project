<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="../../../resources/css/favorite/bootstrap.min.css"	media="screen" title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/favorite/favoriteCommentStyle.css"	media="screen" title="no title" charset="utf-8">


<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>

<div class="page-header">
			<h1>
				즐겨찾기
			</h1>
</div>
		

<div class="box">


		<form role="form" method="post">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		
		<div class="box-body">
		<br><br>
		<div class="form-group">
			<label for="exampleInputEmail1">즐겨찾기 추가 날짜</label> 
			
			<input type="text" name='f_date' class="form-control" value="${favorite.f_date}" readonly="readonly">
		</div>
		<br><br>
		<div class="form-group">
			<label for="exampleInputPassword1">Comment</label>
			
			<textarea class="form-control" name="f_coment" rows="5" onkeyup="fc_chk_byte(this,490);">${favorite.f_coment}</textarea>
			<br><br>
		</div>
		</div>
		</form>
</div>
<!-- /.box-body -->

<br><br>
<div class="box-footer">
	<button type="submit" id="btn-modify" class="btn btn-default">수정완료</button>
	<button type="submit" id="btn-list" class="btn btn-default">취소</button>
	<br><br>
</div>


<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$("#btn-list").on("click", function() {
			self.location = "/favorite/favoriteList?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});

		$("#btn-modify").on("click", function() {
			formObj.submit();
		});

	});
</script>

<script type="text/javascript">
/*
' ------------------------------------------------------------------
' Function : fc_chk_byte(aro_name)
' Description : 입력한 글자수를 체크
' Argument : Object Name(글자수를 제한할 컨트롤)
' Return : 
' ------------------------------------------------------------------
*/
	function fc_chk_byte(aro_name,ari_max){
		var ls_str = aro_name.value; // 이벤트가 일어난 컨트롤의 value 값
		var li_str_len = ls_str.length; // 전체길이

		// 변수초기화
		var li_max = ari_max; // 제한할 글자수 크기
		var i = 0; // for문에 사용
		var li_byte = 0; // 한글일경우는 2 그밖에는 1을 더함
		var li_len = 0; // substring하기 위해서 사용
		var ls_one_char = ""; // 한글자씩 검사한다
		var ls_str2 = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다.

		for(i=0; i< li_str_len; i++){
			// 한글자추출
			ls_one_char = ls_str.charAt(i);
			// 한글이면 2를 더한다.
			if (escape(ls_one_char).length > 4){
				li_byte += 3;
			}else{// 그 밖의 경우는 1을 더한다.
				li_byte++;
			}

			// 전체 크기가 li_max를 넘지않으면
			if(li_byte <= li_max){
				li_len = i + 1;
			}
		}

		// 전체길이를 초과하면
		if(li_byte > li_max){
			alert( 500 + " 글자를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. ");
			ls_str2 = ls_str.substr(0, li_len);
			aro_name.value = ls_str2;
		}
		aro_name.focus(); 
	}
</script>

