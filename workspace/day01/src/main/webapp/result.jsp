<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 태그영역을 자바 명령어를 작성할 수 있으며 스크립틀릿이라고 부른다
	<h1><%=request.getParameter("user_Name") + "님 환영합니다" %></h1> --%>
	<h1><%=request.getAttribute("user_Name") + "님 환영합니다!!" %></h1> <!--  TestServlet 에서 request에 userName을 넣었었다. 그 객체에 getAttribute(키의값)을 가지고 해당 value를 받아와서 출력한다. -->
</body>
<!--  getParameter() 방식은 jsp에서 사용하기 적합하지 않음 -->
</html>
