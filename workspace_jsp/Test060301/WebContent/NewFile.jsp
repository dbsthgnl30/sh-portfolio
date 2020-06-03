<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	
		List<String> list= new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("good");
		list.add("morning");
		request.setAttribute("list", list);
		//selectCommand 간단히 구현
		
		
	%>
	<%--브라우저에 구현  --%>
	<c:forEach items="${list}" var="msg">
		${msg}<br>
	</c:forEach>



</body>
</html>