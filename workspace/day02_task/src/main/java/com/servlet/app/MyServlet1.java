package com.servlet.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyTaskServlet
 */
//@WebServlet("/MyTaskServlet")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("userAge"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby"); // 체크박스같은 배열을 처리할때는 getParametetrValues 사용해야한다!
		
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("userName", name);
		request.setAttribute("userAge", age);
		request.setAttribute("gender", gender);
		request.setAttribute("hobbies", hobbies);
		
		//forward 방식으로 사용한다는 뜻!
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
