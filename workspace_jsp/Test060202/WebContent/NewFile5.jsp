
<%@page import="java.util.ArrayList"%>
<%@page import="com.naver.MemberDTO"%>
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
		List<MemberDTO> list= new ArrayList<MemberDTO>();
		list.add(new MemberDTO("m001","kim",3,"1"));
		list.add(new MemberDTO("m002","lee",4,"1"));
		list.add(new MemberDTO("m003","park",5,"1"));
		list.add(new MemberDTO("m004","jung",6,"1"));
		list.add(new MemberDTO("m005","kang",7,"1"));
		
		pageContext.setAttribute("list"	, list);
		
	%>
	<table border="1">
	<thead>
	<tr>
	<th>id</th>
	<th>name</th>
	<th>age</th>
	<th>pw</th>
	
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="dto">
	<tr>
	<td>${ dto.id} </td>
	<td>${ dto.name} </td>
	<td>${ dto["age"]} </td>
	<td>${ dto["pw"]} </td>
	</tr>
	</c:forEach>
	</tbody>
	
	</table>
	
</body>
</html>