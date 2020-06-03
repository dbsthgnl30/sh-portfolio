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
	<% 
		pageContext.setAttribute("m", null);
	
	
	%>
	
	${dto}<br>
	${ m}<br>
	<hr>
	${m.id }<br>
	<hr>
	${empty m}<br>
	${m==null}<br>
	
	
	
	<hr>
	${not empty m }<br>
	${m!=null }S
</body>
</html>