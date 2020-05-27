<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 내장객체이면서 영역객체 -->
<%
String hello= (String)application.getAttribute("hello");
          List<StringBuffer> list = (List<StringBuffer>) application.getAttribute("list");
           Integer count= (Integer)application.getAttribute("count");
           
           out.print(count);
%>
</body>
</html>