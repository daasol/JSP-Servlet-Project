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
	 	String adminId;
	 	String adminPw;
	 	
	 	String imgDir;
	 	String testServerIP;
	 	
	 	
	 	String connectedIP;
	 	String connectedUser;
	 	%>
	
		<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
		
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServer");
		%>
		
		<% 
		application.setAttribute("connectedIP", "68.20.9.3");
		application.setAttribute("connectedUser", "hwang");
		
		%>
		
		<p> adminId : <%=adminId %></p>
		<p> adminPw : <%=adminPw %></p>
		<p> imgDirectory : <%=imgDir %></p>
		<p> testServerIP : <%=testServerIP %></p>
		<p> IP : <%=connectedIP %></p>
		
		
		
		
		
	</body>
</html>