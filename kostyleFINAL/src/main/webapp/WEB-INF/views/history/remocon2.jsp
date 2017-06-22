<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="wing_fixed">
	<div id="wingBanner" class="wing_relative">
		<c:if test="${not empty login }">
			<div id="wingBanner" class="wing_banner">
				<div id="wingRecentWrap" class="wing_prd_wrap">
					<div class="hwrap">
						<strong class="tit">
							<a id="wingRecentCount" href="/history/list/${login.c_num }">
								<span class="tx">최근 본상품</span>
								<span class="count">${history_Num }</span>
								<span class="ico"></span>
							</a>
						</strong>
					</div>
					<div id="wingRecentRrdList" class="wing_prd_list">
						<ul id="1234" style="" class="wingRecentPrd">
							<c:forEach var="remocon" items="${remoconList }" varStatus="status">
								<li id="${Math.floor((status.index)/3)+1 }-${status.index)%3+1}" class="wing_prd">
									<a href="${remocon.h_Prdurl }" target="_blank">	
										<span class="wing_prd_img">
											<img alt="" src="${remocon.h_Imgurl }">
										</span>
										<span class="wing_prd_info">
											<span class="p_name">${remocon.h_Name}</span>
										</span>
									</a>
									<button class="wing_btn_delete" value="${remocon.h_Num }">상품제거버튼</button>
									</li>
									<c:if test="${(status.index%3)+1==3 }"></c:if>
										</ul><ul style="display: none;" class="wingRecentPrd" id="${Math.floor((status.index)+1/3)}">
									</c:if>
							</c:forEach>
							</ul>
						
						</ul>
					
					
					
					</div>
				
				</div>
			
			</div>
		
		
		
		
		
		
		
		
		</c:if>
	
	
	</div>

</div>
</body>
</html> --%>