
function getSelectValue(frm){//select option에서 선택한 내용이 text에 들어가게하는 함수
 frm.user_email2.value = frm.user_email3.options[frm.user_email3.selectedIndex].text;
}


$(document).ready(function() {
	$(".accordion .accordion_title").click(function() {
		if($(this).next("div").is(":visible")){
			$(this).next("div").slideUp("fast");
		} else {
			$(".accordion .accordion_sub").slideUp("slow");
            $(this).next("div").slideToggle("fast");
		}
	});
});

