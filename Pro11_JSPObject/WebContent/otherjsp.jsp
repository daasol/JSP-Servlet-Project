<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page errorPage="errorpage.jsp"  %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title></title>
	</head>
	<body>
	<%!
	String IP;
	String User;
	
	
	String error;
	//exception 객체를 확인하기 위해 의도적으로 초기화하지 않은 변수
	%>
	
	<%
	IP = (String)application.getAttribute("connectedIP");
	User = (String)application.getAttribute("connectedUser");
	%>
	
	<p>IP : <%=IP %></p>
	<p>User : <%=User %></p>
	
	<%
	out.print(error.toString());
	%>
	</body>
</html>