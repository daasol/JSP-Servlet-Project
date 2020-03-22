<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title></title>
	</head>
	<body>
	<%!
		String nName;
		String nNickname;
		
	%>
	
	<%
		nName = request.getParameter("m_name");
		nNickname = request.getParameter("m_nickname");
	%>
	
	이름: <%=nName %>
	</br>
	별명 : <%=nNickname %>
	
	</body>
</html>