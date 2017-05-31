<%@page import="Category.model.Customer_taste_stack"%>
<%@page import="Category.model.CategoryDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Category.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	CategoryDao dao = CategoryDao.getDao();
	//취향 사전
	String taste[] = {
		"골지",
		"슬림",
		"오버",
		"루즈",
		"시크",
		"모던",
		"캐주얼",
		"댄디"
	};
	String p_name = "";
	
	String c_click_keyword = "";
	String c_num = (String)session.getAttribute("c_num");
	String p_url = request.getParameter("user_taste_url");
	
	if(c_num != null){
		List<Product> product_list = new ArrayList<Product>();
		product_list = (List<Product>)session.getAttribute("product_list");
		
		if(p_url.indexOf("http://") != -1){
			p_url = p_url.substring(8,p_url.length());
		}
		
		for(int i=0; i<product_list.size(); i++){
			if(product_list.get(i).getProduct_link().indexOf(p_url) != -1){
				p_name = product_list.get(i).getProduct_name();
				p_url = product_list.get(i).getProduct_link();
				break;
			}
		}
		
		for(int i=0; i<taste.length; i++){
			if( p_name.indexOf(taste[i]) != -1){
				c_click_keyword = taste[i];
				Customer_taste_stack ct = new  Customer_taste_stack(c_num, c_click_keyword, p_url);
				dao.insertCustomer_taste_stack(ct);
				break;
			}	
		}
	}	
%>