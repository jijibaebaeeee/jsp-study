package com.servlet.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("userId")); // login.jsp의 해당 input의 name값을 받아와야한다
		System.out.println(request.getParameter("userPw")); // login.jsp의 해당 input의 Pw값을 받아와야한다

		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

		// 아이디가 존재하는 경우
		// "결과값"이 하나인경우 selectOne 사용
		int userIdValue = sqlSession.selectOne("user.checkId", request.getParameter("userId")); // 요청받은 userId값을 쿼리문으로
																								// 보내서 중복확인
		System.out.println(userIdValue);
		// 아이디가 존재하지 않을경우
		if (userIdValue == 0) {
			request.setAttribute("message", "사용자가 존재하지 않습니다");
		} else {
			Map<String, String> userMap = new HashMap<>();
			userMap.put("userId", request.getParameter("userId"));
			userMap.put("userPw", request.getParameter("userPw"));
			// 로그인 쿼리 실행
			int count = sqlSession.selectOne("user.login", userMap);
			System.out.println(count);

			// 결과에 따라 메시지 출력
			if (count == 1) {
				request.setAttribute("message", request.getParameter("userId") + "님 환영합니다");
			} else {
				request.setAttribute("message", "비밀번호가 틀렸습니다.");
			}
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}

}
