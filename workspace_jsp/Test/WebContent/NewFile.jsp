
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재시각 :2020년 05월 25일 오후 2시 10분

<hr>
<%

Date d= new Date();
out.print(d.toLocaleString());

%>



</body>
</html>