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
		int a = 10;
		if (a > 9) {
	%>
	<h1>a는 9보다 크다</h1>
	<%
		} else if (a > 7) {
	%>
	<h2>a는 7보다 크다</h2>
	<%
		} else {
	%>
	<h3>a는 7이하이다</h3>
	<%
		}
	%>

</body>
</html>