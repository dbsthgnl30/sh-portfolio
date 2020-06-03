<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
    <jsp:useBean id="login" class="com.naver.LoginBean"/>
     <%--login .setId("m001");  --%>
    <jsp:setProperty property="id" name="login" param="idTest"/>
    <%-- login.setPw("1");--%>
    <jsp:setProperty property="pw" name="login" param="PWTest"/>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${login.id}:${login.pw}
</body>
</html>