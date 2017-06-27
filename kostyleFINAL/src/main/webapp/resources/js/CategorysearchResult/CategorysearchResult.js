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


$(function(){	
	CategoryItemClick();
	CategoryFilterClick();
});
//
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

