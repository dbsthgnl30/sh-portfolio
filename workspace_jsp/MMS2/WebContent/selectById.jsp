<%@page import="kr.co.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 자세히 보기</h1>
<%
	MemberDTO dto= (MemberDTO)request.getAttribute("dto");
	
	%>
 
ID:<%= dto.getId() %><br>
Name:<%= dto.getName() %><br>
Age:<%= dto.getAge() %>

<!-- 아이디가 주키 이기 때문에 id를 불러와서 수정 -->
<a href="updateui.do?id=<%= dto.getId()%>">수정</a> | <a href="delete.do?id=${dto.id}">삭제</a> | <a href="select.do">목록</a>
</body>
</html>