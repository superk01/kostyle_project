$(function(){
	menuBarEvent();
	openSubMenu();
});

function menuBarEvent(){
	$('#statsMenuSlider .barMenuImg').click(function(){
		var barOpen = $(this).attr('id');

		if(barOpen== 'barOpenIcon'){
			$('#barOpenIcon').addClass('hidden');
			$('#barCloseIcon').removeClass('hidden');
			$('.barMenuText').removeClass('hidden');
			$('#statsbody').animate({left:'300px'});
			menuOpen();
		}else if(barOpen == 'barCloseIcon'){
			$('#barOpenIcon').removeClass('hidden');
			$('#barCloseIcon').addClass('hidden');
			$('.barMenuText').addClass('hidden');
			$('#statsbody').animate({left:'110px'});
			menuClose();
		}
		
		return false;
	});
}

function menuOpen(){
	$('#statsMenuBar').animate({width:'255px'});
	$('#statsbody').animate({width:'729px'});
}

function menuClose(){
	$('#statsMenuBar').animate({width:'66px'});
	$('#statsbody').animate({width:'918px'});
}


function openSubMenu(){
	$('.barMenuDiv').click(function(){
		$(this).find('.barMenuSubDiv').slideToggle('slow');
		$(this).nextAll().find('.barMenuSubDiv').slideUp('slow');
	});
	return false;
}

	
