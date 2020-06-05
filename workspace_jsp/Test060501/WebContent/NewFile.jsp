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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<form action="insert.do" method="post">
		ID:<input name="id" id="id">
		<button>id 중복체크</button><br>
		<p></p>
		 ~~~~~~~~~~~~<br> <input type="submit" value="회원가입">
	</form>



	<script type="text/javascript">
		$(document).ready(function() {
			$("button").click(function(event) {
				event.preventDefault();
				var id = $("#id").val();
				
				$.ajax({
					type : "get",
					url : "idcheck",
					data : {
						id : id
					},
					dataType : "text",
					success : function(result){
						$("p").text(result);
					}
				});
			});
		});
		$(document).ready(function)(){
			$("button").click(function(event)){
				tupe
			}
		}
	</script>
</body>
</html>