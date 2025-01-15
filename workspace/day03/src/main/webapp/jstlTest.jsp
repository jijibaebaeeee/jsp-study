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
	<!-- 스코프를 명시하지 않으면 다음과 같은 순서로 찾는다 -->
	<!-- page -> request -> session -> application -->

	<h1>결과출력</h1>
	<h3>${name}</h3> <!-- JSTL태그  서블릿에서 setAttribute로 설정된 값 출력 -->
	<h3><%=request.getAttribute("name") %></h3> <!-- JSP 태그 -->
	<% pageContext.setAttribute("name", "홍길동"); %>
	<h3>${name}</h3> <!-- JSP태그에 의해 바뀐 값이 출력 -->
	<h3>${param.name}</h3> <!-- 서블릿에서 QueryString을 이용해서 설정된 값을 출력하는 방법 -->
	<h3>${requestScope.name}</h3> <!-- 서블릿에서 setAttribute로 설정된 값 출력 (처음과동일) -->
</body>
</html>