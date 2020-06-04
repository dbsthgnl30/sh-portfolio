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
<h1>본문입니다.</h1>
<%@ include file ="part1.jsp"%>
<hr>
<jsp:include page="part2.jsp"/>
<hr>
<jsp:include page="part3.jsp">

<jsp:param value ="teacheryo" name="id"/>
<jsp:param value ="kim" name="name"/>
<jsp:param value ="안녕" name="hello"/>
</jsp:include>

</body>
</html>