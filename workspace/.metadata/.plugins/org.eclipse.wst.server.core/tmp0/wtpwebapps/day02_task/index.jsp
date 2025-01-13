<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  2번 문제  -->
	<form action="task" method="get">
		<label for=id>이름 입력</label>
		<input type="text" id="id" name="userName" required><br>
		
		<label for="age">나이 입력</label>
		<input type="text" id="age" name="userAge" required><br>
		
		<button type="submit">접속</button>
	</form>
	
	<!-- 5번 문제 -->
	
	
	<!-- 6번 문제 -->
	<form action="resultServlet2" method="post">
		<label for="hobby1">탁구</label>
		<input type="checkbox" id="hobby1" name="checked">
		<label for="hobby2">클라이밍</label>
		<input type="checkbox" id="hobby2" name="checked">
		<label for="hobby3">이중격투기</label>
		<input type="checkbox" id="hobby3" name="checked">
		<label for="hobby4">파쿠르</label>
		<input type="checkbox" id="hobby4" name="checked">
	</form>


</body>
</html>