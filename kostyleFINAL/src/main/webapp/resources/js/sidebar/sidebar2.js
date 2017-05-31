//시작 선언 변수

	//카테고리 박스 크기 조절
	var categoryBoxWidth_Close = "2.5%";
	var categoryBoxWidth = "11%";
	var categoryBoxWidth_Click = "40%";
	
	//카테고리 추가 부분 체크
	var categoryContentAdd_check = false;
	
	//카테고리 목록 체크 
	var categoryContentList_check = false;
	
	//카테고리 슬라이드 실행 현황 체크
	var sidebarCheck = false;
	
//함수 시작
$(function(){
	sidebarContentClick();
		
	//카테고리 슬라이드는 여기서 선언
	$('#sidebarTitle').click(function(){
		var sendDataaa = "";
		
		$.ajax({
			url : "../resources/js/sidebar/SelectCategoryList.jsp",
			type : "GET",
			data : sendDataaa,
			dataType : "text"
		});
		
		if( sidebarCheck == false){
			$('#sidebarTitle').css({"display" : "none"});
			$('#sildebarClose').css({"display" : "block"});
			$('#sidebarSubMenu').css({"display" : "block"});
			$('#sidebarContent').css({"display" : "block"});
			$('#sidebar').animate({"height" : "380px","width" : categoryBoxWidth },300,"swing",function(){
			sidebarCheck = true;    
			});
		}
	});
	$('.class_sildebarClose').click(function(){//닫기
		if( sidebarCheck ){
			$('#sidebar').animate({"height" : "100px", "width" : categoryBoxWidth_Close},300,"swing",function(){
				$('#sildebarClose').css({"display" : "none"});
				$('#sidebarSubMenu').css({"display" : "none"});
				$('#sidebarContent').css({"display" : "none"});			
				$('#sidebarTitle').css({"display" : "block"});
				$('#sidebarCategoryListTotal').css({"display":"none"});
				$('#sidebarContentAdd').css({"float" : "none"});
				$('#categoryContentAdd').remove();
				sidebarCheck = false;
	    	  });						
		}
	});
	
	//카테고리 서브메뉴
	//카테고리 리스트 클릭시 작동하는 이벤트
	$('.categorylist').click(function(){
		var name = $(this).text();
		location = "../category.csh?strkeyword="+name;
	});
	
	//카테고리 목록 부분
	$('#sidebarContentList').click(function(){
		if(categoryContentList_check == false){
			$('#sidebarCategoryListTotal').css({"display":"block"});
			$('#sidebar').animate({ "width" : categoryBoxWidth_Click},500,"swing",function(){				
	    	  });	
			categoryContentList_check = true;
			
			var sendData = "null";
			$.ajax({
				url : "../resources/js/sidebar/SelectCategoryList.jsp",
				type : "GET",
				data : sendData,
				dataType : "text"
			});
			
		}else{
			$('#sidebarCategoryListTotal').css({"display":"none"});
			$('#sidebar').animate({ "width" : categoryBoxWidth},500,"swing",function(){				
	    	  });
			categoryContentList_check = false;
		}							
	});
	

	//카테고리 추가 부분
	$('#sidebarContentAdd').click(function(){
		if(categoryContentAdd_check == false){			
			$('#sidebar').animate({ "width" : categoryBoxWidth_Click},500,"swing",function(){
				$('#sidebarContentAdd').css({"float" : "left"});
				$('#sidebarContentAdd').after('<div id="categoryContentAdd"><input type="text" id="categoryContentAddTextField" name="AddCategoryContent"/><input type="button" value="추가" onclick="addcategoryButton()"></div>');
	  	  	});			
			categoryContentAdd_check = true;			
		}else if(categoryContentAdd_check == true){ //한번 더 클릭시 닫기
			$('#sidebarCategoryListTotal').css({"display":"none"});
			$('#sidebar').animate({ "width" : categoryBoxWidth},500,"swing",function(){
				$('#sidebarContentAdd').css({"float" : "none"});			
	  	  	});
			$('#categoryContentAdd').remove();
			categoryContentAdd_check = false;
		}
	});
});

function sidebarContentClick(){
	$('#sidebarContentOuter').click(function(){
		  location = "../category.csh?keyword=200";
	});
	
	$('#sidebarContentTop').click(function(){
		  location = "../category.csh?keyword=200";
	});
	
	$('#sidebarContentBottom').click(function(){
		  location = "../category.csh?keyword=300";
	});
	
	$('.sidebarCategoryListTotalOneItem_click').click(function(){
		var sendData = $(this).text();
		location = "../category.csh?strkeyword="+sendData;
	});
}

function addcategoryButton(){
	var text = $('#categoryContentAddTextField').val();
	var sendData = "categoryAddList=" + text;
	
	$.ajax({
		url : "../resources/js/sidebar/addCategory_db.jsp",
		type : "GET",
		data : sendData,
		dataType : "text",
		success : addCategory_result
	});
}

function addCategory_result(data){
	if(data == "중복"){
		alert("중복되어 추가 불가능");
	}else{
		alert(data + " 목록 추가 완료");	
	}
	$('#sidebarCategoryListTotal').css({"display":"none"});
	$('#sidebar').animate({ "width" : categoryBoxWidth},500,"swing",function(){
		$('#sidebarContentAdd').css({"float" : "none"});			
	  	});
	$('#categoryContentAdd').remove();
	categoryContentAdd_check = false;
}
