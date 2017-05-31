
$(document).ready(function(){
	var ab = setInterval(function(){
		
		var now = new Date();
		var hr = now.getHours();
		var min = now.getMinutes();
		var sec = now.getSeconds();
		var secc = "";
		
		if(hr % 10 == 0){
			
		}
		
		if( hr < 10){
			var hrr = "0";
			hrr += parseInt(hr);
	
			$("#maintimehr").text(hrr).animate({"font-size" : "30"},300, "swing",function(){
			});		
		}else{

			$("#maintimehr").text(hr).animate({"font-size" : "30"},300, "swing",function(){
			});
		}
		
		if(sec % 60 == 0){
			$("#maintimemin").css({"font-size" : "0px"});
		}
		
		if(min < 10){
			var minn = "0";
			minn += parseInt(min);

			$("#maintimemin").text(minn).animate({"font-size" : "30"},300, "swing",function(){
			});
		}else{

			$("#maintimemin").text(min).animate({"font-size" : "30"},300, "swing",function(){
			});
		}
		
		
		if(sec % 10 == 0){
			$("#maintimesec_first").css({"font-size" : "0px"});
		}
		
		if(sec < 10){
			secc = parseInt(sec);
			$("#maintimesec_first").text("0").animate({"font-size" : "30"},300, "swing",function(){
			});
			$("#maintimesec").css({"font-size" : "0px"});
			$("#maintimesec").text(secc).animate({"font-size" : "30"},300, "swing",function(){
			});
			
		}else{
			secc = parseInt(sec);
			secc += "";
			var secc_first = secc.substring(0,1);
			var secc_last = secc.substring(1,2);
			$("#maintimesec_first").text(secc_first).animate({"font-size" : "30"},300, "swing",function(){
			});

			$("#maintimesec").css({"font-size" : "0px"});
			$("#maintimesec").text(secc_last).animate({"font-size" : "30"},300, "swing",function(){
			});
		
		}
	},1000);
});

//jquery 시작
$(function(){
	clickTodayView();
});

function clickTodayView(){
	$('#mainshowpage_view').click(function(){
		$('#mainshowpage').animate({"height" : "0px"},600,"swing",function(){
			$('#mainshowpage').css({"display" : "none"});
		});
		$('#contentBox').css({"display" : "block"});
	});
}

