<%@page import="java.util.ArrayList"%>
<%@page import="kostyle.category.domain.Category"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String data = request.getParameter("categoryAddList");
	System.out.println(data);
//	CategoryDao dao = CategoryDao.getDao();
	//받아온 데이터 중복 검사후 insert 하기.
	List<Category> categoryList = new ArrayList<Category>();
	//categoryList = dao.getCategoryList();
	
	for(int i=0; i<categoryList.size(); i++){
		if(categoryList.get(i).getName().equals(data)){
			data = "중복";
			System.out.println("중복된값이 있습니다");
		}
	}
	
	if(!(data.equals("중복"))){
	//	dao.insertCategoryList(data);
	}
%>

<%= data %>