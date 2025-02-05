package com.servlet.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet") // 서블릿 경로인데 주석처리 할 것이다.
public class ForwardHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// 1. index.jsp에서 받은 입력을 forwardResult라는 jsp로 보내주기 위해서 forward를 사용한다.!!!!!!! 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String forwardName = request.getParameter("forwardName"); // 이 요청에는 4개의 form 태그 값이 있음
		System.out.println(forwardName);
		response.setContentType("text/html; charset=UTF-8"); // 한글깨짐 방지
		request.setAttribute("forwardName", forwardName); // setAttribute로 값을 넣어줌 jsp에서 getParameter를 쓰는 것은 좋은 방법이 아니기 때문이다.
														  // setAttribute를 통해서 1개의 값만 필터해서 보내줄 수 있음 (보안)
		//Forward 요청 처리
		request.getRequestDispatcher("/forwardResult.jsp").forward(request, response);
		
		
	}

}
