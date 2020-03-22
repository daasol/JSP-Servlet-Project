<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title></title>
	</head>
	<body>
	<%@ page import="java.util.*"  %>
	<%@ include file="/header.jsp" %>
	
	<%!
	 //내가 사용하고 싶은 자바 변수를 선언
	 //자바 문법과 같이 세미콜론을 붙여준다.
	 int num = 10;
	 String str = "jsp";
	 ArrayList<String> list = new ArrayList<String>();
	 
	 public void jspMethod(){
		 System.out.println("--jspMethod()--");
	 }
	
	%>
	
	<!-- 스크립트릿 태그 -->
	<%
		if(num>0){
	%>
		<p>num>0</p>
	<%	}else{
	%>
		<p>num <=0 </p>
	<%
		}
	%>
	
	<!-- html 주석태그  -->
	<%-- jsp주석태그  --%>
	
	<!--  표현식 태그 -->
	num is <%=num %>
	<!--  혹은  -->
	<p> num is <%=num %></p>
	
	<%@ include file="/footer.jsp" %>
	</body>
</html>