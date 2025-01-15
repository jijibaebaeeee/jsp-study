<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=request.getAttribute("userName")%>님 환영합니다</h2>
	<h2><%=request.getAttribute("userName") %>님의 2025년 나이는 <%request.getAttribute("userAge"); %>살 입니다</h2>
	<h2>성별 : <%=request.getAttribute("gender") %></h2>
	<h2>취미 : <% 
		String[] hobbies = (String[]) request.getAttribute("hobbies");
		if(hobbies != null){
			for(String hobby : hobbies){
				out.print(hobby + " ");
			}
		}else{
			out.print("취미가 없습니다.");
		}
				%></h2>
</body>
</html>