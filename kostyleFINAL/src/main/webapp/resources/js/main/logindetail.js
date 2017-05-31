	
	var time = 100;//마우스오버에서 벗어나서 보여지는 시간
	var currentLayer = null;
	var currentitem = null;
	var noClose = 0;
	var closeTimer = null;
	
	// Open Hidden Layer
	function m_over(){
   		var mouse_id  = document.getElementById("mouse_id");
    	var login_id = document.getElementById("login_id");
    	
    	if(mouse_id){
       		cancelclosetime();
        
       		mouse_id.style.visibility='visible';
        	if(currentLayer){
            	currentLayer.style.visibility='hidden';
        	}
        	currentLayer = mouse_id;
        	currentitem = login_id;
        	
    	}else if(currentLayer){
        	currentLayer.style.visibility='hidden';
        	currentitem = null;
        	currentLayer = null;
    	}
	}
	
	// Turn On Close Timer
	function closetime(){
   	 	closeTimer = window.setTimeout(mclose, time);
	}
	
	// Cancel Close Timer
	function cancelclosetime(){
	    if(closeTimer){
       		window.clearTimeout(closeTimer);
        	closeTimer = null;
    	}
	}	
	
	// Close Showed Layer
	function mclose(){
    	if(currentLayer && noClose!=1){
       		currentLayer.style.visibility='hidden';
        	currentLayer = null;
        	currentitem = null;
    	}else{
        	noClose = 0;
    	}
    	currentLayer = null;
    	currentitem = null;
	}
	
	// Close Layer Then Click-out
	document.onclick = mclose;
	