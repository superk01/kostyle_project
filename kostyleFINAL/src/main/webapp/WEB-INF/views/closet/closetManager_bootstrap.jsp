<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

    <title>옷장 편집</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
<!--     <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
    
    <style type="text/css">
	   .trash { color:rgb(209, 91, 71); }
		.flag { color:rgb(248, 148, 6); }
		.panel-body { padding:0px; }
		.panel-footer .pagination { margin: 0; }
		.panel .glyphicon,.list-group-item .glyphicon { margin-right:5px; }
		.panel-body .radio, .checkbox { display:inline-block;margin:0px; }
		.panel-body input[type=checkbox]:checked + label { text-decoration: line-through;color: rgb(128, 144, 160); }
		.list-group-item:hover, a.list-group-item:focus {text-decoration: none;background-color: rgb(245, 245, 245);}
		.list-group { margin-bottom:0px; }
    </style>
<style>
#fisrttr{
	height: 56px;
	background-color: #f5f5f5;
}
img.folder_clo_num{
	float:left;
	margin-left: -4px;
}
img.folder_clo_num + input{
	margin-top : -15px;
}

.panel-primary>.panel-heading{
	color: #fff;
    background-color: #B58DB3  !important;
    border-color: #B58DB3  !important;
}
</style>
    
    
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
    <!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="../../../resources/js/closet/closetManager_bootstrap.js"></script>
    
  
  
<!-- <style type="text/css" id="igtranslator-color"></style> -->
</head>



<body>
	<section class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-list"></span>옷장 매니저
<!--                     <div class="pull-right action-buttons">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-cog" style="margin-right: 0px;"></span>
                            </button>
                            <ul class="dropdown-menu slidedown">
                                <li><a href=""><span class="glyphicon glyphicon-pencil"></span>Edit</a></li>
                                <li><a href=""><span class="glyphicon glyphicon-trash"></span>Delete</a></li>
                                <li><a href=""><span class="glyphicon glyphicon-flag"></span>Flag</a></li>
                            </ul>
                        </div>
                    </div> -->
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                    	 <li id="fisrttr" class="list-group-item">
                    	                
           	  	         	<div class="checkbox col-xs-6 col-sm-6 col-md-4">
           	  	         		<input type="checkbox" class="checkCloset allcheckCloset" value="allCheckCloset" /><label for="checkbox">전체선택<b>(삭제시)</b></label>
           	  	         	</div> 
                    	    <div id="media_1_div">	
                        	<!--  <span>전체선택<b>(삭제시)</b></span>
	                         -->   
	                 		</div>
                        </li>
                    
				<c:forEach var="tab"  items="${sessionScope.closetTab}" >
					<c:choose >
								<c:when test="${tab.clo_num == 1}">
					              <li class="list-group-item">
				                         <tr>
											<td><img class="folder_clo_num" src="../resources/images/closetImg/locked-1.png" alt= "" value="${tab.clo_num }" ></td>
											<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="${tab.clo_name }" readonly="readonly"> </td>
										</tr>		
			                        </li>	
                      	    </c:when>
				   			<c:otherwise>
			   					 <li class="list-group-item">
			                        <tr>
										<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
										<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" ></td>
									</tr>	
			                      </li>
                        	</c:otherwise>
					</c:choose>
				</c:forEach>   
							
						              <li class="list-group-item">
				                         <tr>
											<td><img class="folder_clo_num" src="../resources/images/closetImg/locked-1.png" alt= "" value="${tab.clo_num }" ></td>
											<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="기본 옷장" readonly="readonly"> </td>
										</tr>		
			                        </li>	
			                        
							    <li class="list-group-item">
			                        <tr>
										<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
										<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="옷장1"></td>
									</tr>	
			                        </li>
							  
                        <!--
                        <li class="list-group-item">
                            <div class="checkbox">
                                <input id="checkbox5" type="checkbox">
                                <label for="checkbox5">
                                    List group item heading 4
                                </label>
                            </div>
                           <div class="pull-right action-buttons">
                                <a href=""><span class="glyphicon glyphicon-pencil"></span></a>
                                <a href="" class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                <a href="" class="flag"><span class="glyphicon glyphicon-flag"></span></a>
                            </div>
                        </li>-->
                    </ul> 
                </div>
                <div class="panel-footer" >
                    <div class="row " style="padding: 10px 15px;">
     <!--                    <div class="col-md-6">
                            <h6>
                                Total Count <span class="label label-info">25</span></h6> 
                        </div> -->
                        <div class="checkbox col-xs-6 col-sm-6 col-md-4">
                        	<input type="checkbox" class="checkCloset allcheckCloset" value="allCheckCloset" />&nbsp&nbsp전체선택<b>(삭제시)</b>
                        </div>	
                        <div id="media_2_div">	
                        	<!--  <span>전체선택<b>(삭제시)</b></span>
	                         -->   
	                 </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

	<script type="text/javascript">
	
	</script>


<div class="igtranslator-main-div"></div></body></html>