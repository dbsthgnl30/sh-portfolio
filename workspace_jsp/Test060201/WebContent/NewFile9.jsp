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
	String id =	request.getParameter("id");
	out.print(id);
	request.setAttribute("id", id);
	
	 id = (String)request.getAttribute("id");
	


%>

${id}

<%

request.getRequestDispatcher("NewFile8.jsp").forward(request,response);


%>

<%

%>







</body>
</html>