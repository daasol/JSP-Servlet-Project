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
	 //���� ����ϰ� ���� �ڹ� ������ ����
	 //�ڹ� ������ ���� �����ݷ��� �ٿ��ش�.
	 int num = 10;
	 String str = "jsp";
	 ArrayList<String> list = new ArrayList<String>();
	 
	 public void jspMethod(){
		 System.out.println("--jspMethod()--");
	 }
	
	%>
	
	<!-- ��ũ��Ʈ�� �±� -->
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
	
	<!-- html �ּ��±�  -->
	<%-- jsp�ּ��±�  --%>
	
	<!--  ǥ���� �±� -->
	num is <%=num %>
	<!--  Ȥ��  -->
	<p> num is <%=num %></p>
	
	<%@ include file="/footer.jsp" %>
	</body>
</html>