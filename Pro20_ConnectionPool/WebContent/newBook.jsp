<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title></title>
	</head>
	<body>
	<form action="newBook" method="post">
	book name : <input type="text" name="title"></br>
	book publisher : <input type="text" name="publisher"></br>
	book year : <input type="text" name="year"></br>
	book price : <input type="number" name="price"></br>
	
	<input type="submit" value="book register">
	</form>
	</body>
</html>