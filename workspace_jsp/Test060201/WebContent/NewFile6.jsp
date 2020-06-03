<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <jsp:useBean id="login" class="com.naver.LoginBean"/>
 	<jsp:setProperty property="id "name="login" value="m003"/>
  	<jsp:setProperty property="pw" name="login" value="1"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=login.getId()%> : <%=login.getPw()%>
<hr>
${login.id} : ${login.pw}
<jsp:getProperty property="id" name="login"/>
<jsp:getProperty property="pw" name="login"/>
</body>
</html>