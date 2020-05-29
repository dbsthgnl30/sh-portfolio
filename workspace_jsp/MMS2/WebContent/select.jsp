<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





<a href="${empty login ? 'loginui.do':'logout.do'}"> ${empty login ? '로그인':'로그아웃'}</a>
<!--<a href="loginUI.do">로그인</a>  위것있으니필요없뜸-->
<a href="insertui.do"> 회원등록</a><br><br>






<c:forEach items="${list}" var="dto">
<a href="selectById.do?id=${dto.id}">${dto.id} :${dto.name}</a>
<br>
</c:forEach>

<!-- 화면에 있는 것들을 출력 -->
<%-- 
<%
	List<MemberDTO> list =(List<MemberDTO>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
		MemberDTO dto= list.get(i);
		
		out.print("<a href='selectById.do?id="+dto.getId()+"'>");/* 띄어쓰기하면  url에 %20 나옴   */
		out.print(dto.getId());
		out.print(":");
		out.print(dto.getName());
		out.print("</a>");
		out.print("<br>");
		
		
		
	}
%> --%>


</body>
</html>