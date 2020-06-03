
<%@page import="com.naver.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("m001", "kim", 4, "1"));
		list.add(new MemberDTO("m002", "ha", 6, "1"));
		list.add(new MemberDTO("m003", "park", 14, "1"));
		list.add(new MemberDTO("m004", "sung", 7, "1"));
		request.setAttribute("list", list);
		
	%>
	<c:forEach  items="${list}" var="dto" varStatus="status">
	${status.index}:${status.count} : ${dto.id} : ${dto.name} : ${dto.age} <br> 
	</c:forEach>






</body>
</html>