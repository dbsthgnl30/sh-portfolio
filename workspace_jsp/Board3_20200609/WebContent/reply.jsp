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
<h1> 답글쓰기</h1>
<%

String num =	request.getParameter("num");

%>
	<form action="reply.do" method="post">
	<input type="hidden" name="num" value="${param.num}">
	writer:<input name="writer"><br>
	title:<input name="title"><br>
	content:<br>
	<textarea rows="5" name="content">${dto.content}</textarea>
	<br>
	<input type="submit" value="답글 달기">
	
	</form>
</body>
</html>