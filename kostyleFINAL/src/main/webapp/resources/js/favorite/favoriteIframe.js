$(function() {
	$('.shoplink').on('click',function(e){
		e.preventDefault();
		
		var url = $(this).attr('href');
		location.href = "#favoriteBodyTop";
		
		if($('#CategorysearchIframe').length > 0){
			$('#CategorysearchIframe').attr("src", url);
		}else{
			$('#favoriteBodyTop').remove();
			$('#favoritebackground').prepend('<div id="iframeRemove">쇼핑몰닫기</div>');
			$('#favoritebackground').prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src='+'\"'+url+'\"></iframe>');
			$('#favoritebackground').prepend('<div id="favoriteBodyTop"></div>');
		}
		$('#iframeRemove').on('click', function(){
			$('#CategorysearchIframe').remove();
			$('#iframeRemove').remove();
		
		});
		
	});
});