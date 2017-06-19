$(function(){	
	CategoryItemClick();
	CategoryFilterClick();
});

function CategoryItemClick(){
	$('.CategoryResult_oneItemBox a').click(function(event){
		$.ajax({
			url : '/history/insert',
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			data : JSON.stringify(
					{h_Prdurl:$(this).eq(0).find('a').attr('href'),
					h_Imgurl:$(this).eq(0).find('img').attr('src'),
					h_Name:$(this).children().eq(1).find('a').html(),
					h_Price:$(this).children().eq(2).find('a').html()}),
			success : function(data){
					$('.wing_fixed').remove();
					remoconList();
			}		
		});
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

