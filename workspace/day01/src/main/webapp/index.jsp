<!-- 꼭 존재해야함 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	method를 get을 작성하면 폼 데이터를 get방식으로 서버에 전송하고
	post로 작성하면 폼 데이터를 post방식으로 서버에 전송한다
	즉, 우리가 method에 get을 쓰면 서블릿의 doGet()메소드가 실행된다 
-->
	<h1>안녕하세요!!</h1>
	<form action="Hello" method="get"> <!-- 서블릿주소 /Hello 에 get방식으로 전송한다 -->
		<input type="text" name="user_Name" placeholder="이름">
		<button>전송</button>	
		
		
			
		<!-- 
		button 태그는 기본적으로 타입이 submit이다
		submit 버튼은 현재 form 태그의 action에 작성된 경로로 요청(request)을 보낸다 
		이 때 request에는 현재 폼에 속해있는 모든 폼 데이터를 가지고 있다
		
		index.jsp 파일인데 자바파일인 서블릿으로 요청을 보내기 위해서는 서블릿에 어노테이션으로 등록된 경로를 작성해주면된다-->
	 <!--  form 태그는 action과 method 속성이 있다 -->
	</form>
	
	<form action="/My" method="get"> <!-- 서블릿주소 /Hello 에 get방식으로 전송한다 -->
		<input type="text" name="userName" placeholder="이름">
		<button>전송</button>	
	</form>
	
</body>
</html>