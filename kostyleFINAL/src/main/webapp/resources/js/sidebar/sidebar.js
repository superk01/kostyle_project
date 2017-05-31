/*$(function(){
	sidebarContentClick();
	
	//카테고리 슬라이드는 여기서 선언 
	var sidebarCheck = false;
	$('#sidebar').click(function(){
		if( sidebarCheck ){
			$(this).animate({"height" : "100px", "width" : "2.5%"},300,"swing",function(){
				$('#sildebarClose').css({"display" : "none"});
				$('#sidebarContent').css({"display" : "none"});			
				$('#sidebarTitle').css({"display" : "block"});
				sidebarCheck = false;
	    	  });						
		}else{
			$('#sidebarTitle').css({"display" : "none"});
			$('#sildebarClose').css({"display" : "block"});
			$('#sidebarContent').css({"display" : "block"});
			$(this).animate({"height" : "330px","width" : "11%" },300,"swing",function(){
				sidebarCheck = true;
	    	  });						
		}
	});
});

function sidebarContentClick(){
	$('#sidebarContentOuter').click(function(){
		  location = "../category.csh?keyword=100";
	});
	
	$('#sidebarContentTop').click(function(){
		  location = "../category.csh?keyword=200";
	});
	
	$('#sidebarContentBottom').click(function(){
		  location = "../category.csh?keyword=300";
	});
	
	$('#sidebarContentGer').click(function(){
		  location = "../category.csh?keyword=101";
	});
	$('#sidebarContentBarge').click(function(){
		  location = "../category.csh?keyword=301";
	});
	
	$('#sidebarContentZipup').click(function(){
		  location = "../category.csh?keyword=102";
	});
	$('#sidebarContentJumper').click(function(){
		  location = "../category.csh?keyword=103";
	});
	$('#sidebarContentJacket').click(function(){
		  location = "../category.csh?keyword=104";
	});
	$('#sidebarContentCoat').click(function(){
		  location = "../category.csh?keyword=105";
	});
	$('#sidebarContentShirt').click(function(){
		  location = "../category.csh?keyword=201";
	});
	$('#sidebarContentBlouse').click(function(){
		  location = "../category.csh?keyword=202";
	});
	$('#sidebarContentSkirt').click(function(){
		  location = "../category.csh?keyword=302";
	});
	$('#sidebarContentOnepice').click(function(){
		  location = "../category.csh?keyword=303";
	});
}
*/
