<%@page import="java.util.ArrayList"%>
<%@page import="kostyle.category.domain.Category"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String data = request.getParameter("categoryAddList");
	System.out.println(data);
//	CategoryDao dao = CategoryDao.getDao();
	//�޾ƿ� ������ �ߺ� �˻��� insert �ϱ�.
	List<Category> categoryList = new ArrayList<Category>();
	//categoryList = dao.getCategoryList();
	
	for(int i=0; i<categoryList.size(); i++){
		if(categoryList.get(i).getName().equals(data)){
			data = "�ߺ�";
			System.out.println("�ߺ��Ȱ��� �ֽ��ϴ�");
		}
	}
	
	if(!(data.equals("�ߺ�"))){
	//	dao.insertCategoryList(data);
	}
%>

<%= data %>