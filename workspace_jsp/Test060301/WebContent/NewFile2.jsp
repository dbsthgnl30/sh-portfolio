<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		Map<String,String> map  = new HashMap<String,String>();
		map.put("/select.bo", "SelectCommand");
		map.put("/insertui.bo", "InsertUICommand");
		map.put("/insert.bo", "InsertCommand");
		request.setAttribute("map", map);
		
	%>
	<c:forEach items="${map}" var="dto">
		${dto.key} :${dto.value}<br>
	</c:forEach>
</body>
</html>