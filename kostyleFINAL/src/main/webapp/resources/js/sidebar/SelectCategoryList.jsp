
<%@page import="java.util.ArrayList"%>
<%@page import="kostyle.category.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//CategoryDao dao = CategoryDao.getDao();
	List<Category> categoryList = new ArrayList<Category>();		 
	//categoryList = dao.getCategoryList(); 		 
	if(session.getAttribute("categoryList") != null){
		session.removeAttribute("categoryList");
	}
	 session.setAttribute("categoryList", categoryList);
	 
	List<Category> categoryList_brother = new ArrayList<Category>();
//	categoryList_brother = dao.getCategorylist_brother();
	if(session.getAttribute("categroylist_brother") != null){
		session.removeAttribute("categroylist_brother");
	}
	session.setAttribute("categroylist_brother", categoryList_brother);
%>