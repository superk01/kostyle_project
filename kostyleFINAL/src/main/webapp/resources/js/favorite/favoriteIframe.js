$(function() {
	$('.shoplink').on('click',function(e){
		e.preventDefault();
		
		var url = $(this).attr('href');
		location.href = "#favoriteBodyTop";
		
		if($('#shopViewIframe').length > 0){
			$('#shopViewIframe').attr("src", url);
		}else{
			$('#favoriteBodyTop').remove();
			$('#favoritebackground').prepend('<div id="iframeRemove">쇼핑몰닫기</div>');
			$('#favoritebackground').prepend('<iframe id="shopViewIframe" width="100%" height="900" src='+'\"'+url+'\"></iframe>');
			$('#favoritebackground').prepend('<div id="favoriteBodyTop"></div>');
		}
		$('#iframeRemove').on('click', function(){
			$('#shopViewIframe').remove();
			$('#iframeRemove').remove();
		
		});
		
	});
});