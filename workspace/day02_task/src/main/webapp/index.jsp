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
	<form action="MyServlet1" method="get">
		<label for=id>이름 입력</label>
		<input type="text" id="id" name="userName" required><br>
		
		<label for="age">나이 입력</label>
		<input type="text" id="age" name="userAge" required><br>
	
	<!-- 5번 문제 : 메뉴드롭에 매치-->
		<label>성별 : </label> <!-- 라디오 버튼은 바로 매치하지않음. 이것이 우선 무엇인지 알려야함 -->
		<input type="radio" id="none" name="gender" value="선택안함">
		<label for="none">선택안함</label>
		<input type="radio" id="none" name="gender" value="남자">
		<label for="none">남자</label>
		<input type="radio" id="none" name="gender" value="여자">
		<label for="none">여자</label><br>
		
	<!-- 6번 문제 : 체크박스는 서블릿과 result 페이지에서 배열로 처리한다-->
		<label>취미 : </label>
		<input type="checkbox" name="hobby" value="운동">운동<br>
      	<input type="checkbox" name="hobby" value="독서">독서<br>
      	<input type="checkbox" name="hobby" value="여행">여행<br>
      	<input type="checkbox" name="hobby" value="영화보기">영화보기<br>
		
		<button type="submit">접속</button>
	</form>
	
	
	
	
	
<!-- 	<form action="resultServlet2" method="post">
		<label for="hobby1">탁구</label>
		<input type="checkbox" id="hobby1" name="checked">
		<label for="hobby2">클라이밍</label>
		<input type="checkbox" id="hobby2" name="checked">
		<label for="hobby3">이중격투기</label>
		<input type="checkbox" id="hobby3" name="checked">
		<label for="hobby4">파쿠르</label>
		<input type="checkbox" id="hobby4" name="checked">
	</form> -->


</body>
</html>