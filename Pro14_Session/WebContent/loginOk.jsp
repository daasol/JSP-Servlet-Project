<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title></title>
	</head>
	<body>
	<%
	session = request.getSession();
	out.print("<p>memberId : "+session.getAttribute("memberId")+"</p>");
	%>
	
	<form action="logoutCon" method="post">
	
	<input type="submit" value="logout">
	</form>
	</body>
</html>