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
		if(session.getAttribute("memberId")!=null){
			response.sendRedirect("loginOk.jsp");
		}
		%>
	
		<form action="loginCon" method="post">
		ID : <input type="text" name="m_id"></br>
		PW : <input type="password" name="m_pw"></br>
		<input type="submit" value="log in">
		
		</form>
	</body>
</html>