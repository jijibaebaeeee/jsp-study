package com.servlet.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPostHandler
 */
@WebServlet("/GetPostHandler")
public class GetPostHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPostHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // get방식으로 요청을 받았을 때 실행되는 메소드 form태그로 전달된 모든 것이 request로 전달된다!!!!!!!!!
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("userName"); // 브라우저의 요청으로부터 받은 name을 저장한다.  input의 값은 name에 저장되어있음을 항상 생각하자.
		System.out.println(name); // 우선 출력해보자
		response.setContentType("text/html; charset=UTF-8"); // 어떤방식으로 보내줄것인지 정하기, 한글깨지니까 넣어줌
		response.getWriter().println("<h1>GET 요청 처리</h1>");
		response.getWriter().println("<p>이름 : " + name + "</p>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // post방식으로 요청을 받았을 때 실행되는 메소드
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email = request.getParameter("email");
		System.out.println(email);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>POST 요청 처리</h1>");
		response.getWriter().println("<p>이메일 : " + email + "</p>");
		
		
		
	}

}
