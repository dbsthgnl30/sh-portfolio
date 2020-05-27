<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test6" method="get">
		당신의 취미는?<br> 
		<input type="checkbox" name="h" value ="축구"> 축구<br>
		<input type="checkbox" name="h" value ="야구"> 야구<br>
		<input type="checkbox" name="h" value ="농구"> 농구<br>
		<input type="submit" value="get방식">
	</form>

	<form action="test3" method="post">
		<input type="submit" value="post방식">
	</form>

</body>
</html>