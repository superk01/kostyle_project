$(function(){
	$('.CategoryResult_oneItemBox').click(function(){
		var getuserClick = $(this).find("a").attr('href');
		// send ajax
		var sendData = "user_taste_url=" + getuserClick;
		$.ajax({
			url : "../resources/js/customer_taste_stack/customer_taste_stack_check.jsp",
			post : "get",
			data : sendData
		});
	});
});