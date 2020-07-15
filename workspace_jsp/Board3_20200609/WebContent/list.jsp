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
	<h1>게시글 목록</h1>
	<a href="insertui.do">글쓰기</a>
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>readcnt</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td width="300px"><c:forEach begin="1" end="${dto.repIndent}">
					&nbsp;&nbsp;
				
				</c:forEach> <a href="read.do?num=${dto.num}">${dto.title}</a></td>


					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
			        <!-- 현재페이지-1이 0보다 -->   <!--크면-현재페이지-1 작으면 1페이지 -->
	<a href="list.do?curPage=${to.curPage-1> 0 ? (to.curPage-1):1}">&laquo;</a>&nbsp;&nbsp;
						<!--시작페이지  --> 		    <!--마지막페이지  -->
	<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
						<!--현재페이지가   -->
		<c:if test="${to.curPage == idx }">
			<a style="font-size: 20px;" href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		
		</c:if>

		<c:if test="${to.curPage != idx }">
			<a href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>




	</c:forEach>
	&nbsp;&nbsp;<a href="list.do?curPage=${(to.curPage+1)<to.totalPage ? (to.curPage+1):to.totalPage}">&raquo;</a>



</body>
</html>