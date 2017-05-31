$(function(){	
	CategoryItemClick();
	CategoryFilterClick();
});

function CategoryItemClick(){
	$('.CategoryResult_oneItemBox a').click(function(event){
		var link = $(this).attr('href');
		location.href = "#CategoryResult_top";
		event.preventDefault();
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
		location = "../categoryfilter.csh?sortstandard=random";
	});
	
	$('#CategoryFiltermaxprice').click(function(){
		location = "../categoryfilter.csh?sortstandard=maxprice";
	});
	
	$('#CategoryFilterminprice').click(function(){
		location = "../categoryfilter.csh?sortstandard=minprice";
	});
	
	$('#CategoryFilterhotproduct').click(function(){
		location = "../categoryfilter.csh?sortstandard=hotproduct";
	});
	
}

