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
/*	//히스토리 상품 추가
	$('.CategoryResult_oneItemBox').on('click',function(event){
		alert('히스토리');
		event.preventDefault();
		$.ajax({
			url : '/history/insert',
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			data : JSON.stringify({h_Prdurl:$(this).eq(0).find('a').attr('href'),
					h_Imgurl:$(this).eq(0).find('img').attr('src'),
					h_Name:$(this).children().eq(1).find('a').html(),
					h_Price:$(this).children().eq(2).find('a').html()}),
			success : function(result){
				$('.wing_fixed').remove();
				remoconList();
			}		
			});
		});
	//아이프레임 추가
	$('.CategoryResult_oneItemBox').click(function(event){
		alert('아이프레임');
		event.preventDefault();
		var link = $(this).find('a').eq(1).attr('href');
		var h_Name = $(this).children().eq(1).find('a').html();
		if($('#CategorysearchIframe').length>0){
			$('#CategorysearchIframe').remove();
		}
		location.href = "#CategoryResult_top";
		$('#TotalCategoryResult_Box').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
		$('#TotalCategoryResult_Box').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="'+link +'">');
		$('#TotalCategoryResult_Box').parent().prepend('<input type="hidden" name="productName" id="prdName" value="'+h_Name+'">');
		
		$('#IframeRemocon').click(function(){
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	});*/
	
});


$(function(){	
	CategoryItemClick();
	CategoryFilterClick();
});
//
function CategoryItemClick(){
	/*$('.CategoryResult_oneItemBox a').click(function(event){
		var link = $(this).attr('href');
		location.href = "#CategoryResult_top";
		event.preventDefault();
		$('#TotalCategoryResult_Box').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
		$('#TotalCategoryResult_Box').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="' +link +'">');
		
		
		$('#IframeRemocon').click(function(){
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	});	*/
	/*//히스토리 상품 추가
	$('.CategoryResult_oneItemBox').on('click',function(event){
		alert('히스토리');
		event.preventDefault();
		$.ajax({
			url : '/history/insert',
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			data : JSON.stringify({h_Prdurl:$(this).eq(0).find('a').attr('href'),
					h_Imgurl:$(this).eq(0).find('img').attr('src'),
					h_Name:$(this).children().eq(1).find('a').html(),
					h_Price:$(this).children().eq(2).find('a').html()}),
			success : function(result){
				$('.wing_fixed').remove();
				remoconList();
			}		
			});
		});
	//아이프레임 추가
	$('.CategoryResult_oneItemBox').click(function(event){
		alert('아이프레임');
		event.preventDefault();
		var link = $(this).find('a').eq(1).attr('href');
		var h_Name = $(this).children().eq(1).find('a').html();
		if($('#CategorysearchIframe').length>0){
			$('#CategorysearchIframe').remove();
		}
		location.href = "#CategoryResult_top";
		$('#TotalCategoryResult_Box').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
		$('#TotalCategoryResult_Box').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="' +link +'">');
		$('#TotalCategoryResult_Box').parent().prepend('<input type="hidden" name="productName" value="'+h_Name+'">');
		
		$('#IframeRemocon').click(function(){
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	});*/	
}
/*function CategoryItemClick(){
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
*/










function CategoryFilterClick(){
	
	$('.filteraclass').click(function(){
		var form = {
			keyword : $(this).attr("data-k"),
			filter : $(this).attr("data-f")
		};		
		   $.ajax({
               type : 'POST', 
               url : '/category/categoryResult/filter',              
               contentType: "application/json", 
               data: JSON.stringify(form),
               dataType : 'text',
               success : function(data){
            	   location = "/category/categoryResult";
               } 
      });		
	});
	
	$('#CateogyrFilterColor').click(function(){
		var check = $('.categoryOff').css("display");
		
		if( check == 'none') $('.categoryOff').css({"display" : "block"});
		else $('.categoryOff').css({"display" : "none"});
	});
	
}

