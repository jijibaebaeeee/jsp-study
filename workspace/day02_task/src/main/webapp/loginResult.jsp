<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 : <%=request.getAttribute("userId") %></h2>
	<h2>비밀번호 : <%=request.getAttribute("userPw") %></h2>
</body>
</html>