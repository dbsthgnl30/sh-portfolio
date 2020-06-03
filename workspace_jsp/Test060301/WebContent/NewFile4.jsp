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
	<c:if test ="${3 < 4}">
		3은 4보다 작다.
		
	</c:if>
	
	<c:if test="${empty m}">
	m은 null입니다.
	</c:if>
	
	<c:if test="${not empty m}">
	m은 null 아입니다.
	</c:if>
	
	
	<hr>
	<c:choose>
		<c:when test="${param.age>10}">
		 나이가10보다 큽니다
		</c:when>
		
		<c:when test="${param.age>8}">
		나이가 8보다 큽니다
		</c:when>
		
		<c:when test="${param.age>6}">
		나이가 6보다 큽니다
		</c:when>
		
		<c:otherwise>
		해당되는 나이가 없습니다.
		</c:otherwise>
		
		
	</c:choose>
</body>
</html>