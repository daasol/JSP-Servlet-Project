<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title></title>
	</head>
	<body>
	<%!
		String m_name;
		String m_password;
		String[] m_hobby;
		
	%>
	
	<%
		m_name = request.getParameter("m_name");
		m_password = request.getParameter("m_pw");
		m_hobby = request.getParameterValues("m_hobby");
	
	%>
	m_name : <%= m_name %></br>
	m_pw : <%= m_password %></br>
	m_hobby : 
	<% for(int i=0; i<m_hobby.length; i++){
	%>
	
	<%= m_hobby[i] %>
		
	<% 
	}
	%></br>
	
	
	
	</body>
</html>