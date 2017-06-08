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
               data: JSON.stringify(form)           
      });
	});	
}

