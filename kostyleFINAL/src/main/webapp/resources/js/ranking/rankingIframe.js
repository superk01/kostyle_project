$(function() {
	$('.shoplink').on('click',function(e){
		e.preventDefault();
		
		var url = $(this).attr('href');
		location.href = "#rankingBodyTop";
		
		if($('#CategorysearchIframe').length > 0){
			$('#CategorysearchIframe').attr("src", url);
		}else{
			$('#rankingBodyTop').remove();
			$('#rankingbackground').prepend('<div id="iframeRemove">쇼핑몰닫기</div>');
			$('#rankingbackground').prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src='+'\"'+url+'\"></iframe>');
			$('#rankingbackground').prepend('<div id="rankingBodyTop"></div>');
		}
		$('#iframeRemove').on('click', function(){
			$('#CategorysearchIframe').remove();
			$('#iframeRemove').remove();
		
		});
		
	});
});