<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Expression Language</h1>
${111}<br>
${ "hello"}<br>
${1+2}<br>
${ 1-2}<br>
${ 1*2}<br>
${1/2}<br>
${ 1%2}<br>
<hr>
${1>2}<br>
${1=2}<br>
<hr>
${ true&&true}<br>
${(3>4) &&(5&6)}<br>
${true||false }<br>
<hr>
${3>4 ? 100:-5 }<br>




	<%
	request.setAttribute("a", 11);	
	%>
<a href='${a>3 ? "http://www.naver.com" : "http://www.google.com" }'> hello</a>




</body>
</html>