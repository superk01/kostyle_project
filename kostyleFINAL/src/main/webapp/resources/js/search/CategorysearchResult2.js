$(function(){	
	CategoryItemClick();
	CategoryFilterClick();
});

function CategoryItemClick(){
	$('.CategoryResult_oneItemBox a').click(function(event){
		alert('이벤트 걸림요?');
		event.preventDefault();
		var link = $(this).attr('href');
		if($('#CategorysearchIframe').length>0){
			$('#CategorysearchIframe').remove();
		}
		location.href = "#CategoryResult_top";
		$('#TotalCategoryResult_Box').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
		$('#TotalCategoryResult_Box').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="' +link +'">');
		
		
		$('#IframeRemocon').click(function(){
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	});	
}

function CategoryFilterClick(){
	$('#CategoryFilterrandom').click(function(){
		location = "../categoryfilter2.csh?sortstandard=random";
	});
	
	$('#CategoryFiltermaxprice').click(function(){
		location = "../categoryfilter2.csh?sortstandard=maxprice";
	});
	
	$('#CategoryFilterminprice').click(function(){
		location = "../categoryfilter2.csh?sortstandard=minprice";
	});
	
	$('#CategoryFilterhotproduct').click(function(){
		location = "../categoryfilter2.csh?sortstandard=hotproduct";
	});
	
}

