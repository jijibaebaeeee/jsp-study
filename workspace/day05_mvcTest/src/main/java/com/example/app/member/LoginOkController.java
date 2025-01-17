package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dto.MemberDTO;
import com.example.app.member.dao.MemberDAO;

public class LoginOkController implements Execute {

//	@Override
//	public Result execute(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		Result result = new Result(); // 다음 페이지 결과 방식 알려주는 객체
//		MemberDAO memberDAO = new MemberDAO(); // 쿼리실행할 객체
//		
//		Map<String, String> userMap = new HashMap<>(); // Id PW 저장할 곳
//		
//		userMap.put("memberId", request.getParameter("memberId"));
//		userMap.put("memberPw", request.getParameter("memberPassword"));
//		
//		request.setAttribute("memberId", request.getParameter("memberId"));
//		
//		int num = memberDAO.login(userMap); // 값이 있으면 1 , 없으면 0
//		
//		// 결과에 따라 메시지 출력
//		if (num == 1) {
//			request.setAttribute("message", request.getParameter("memberId") + "님 환영합니다");
//		} else {
//			request.setAttribute("message", "비밀번호가 틀렸습니다.");
//		}
//	
//		result.setRedirect(false); // forward 방식으로 하니까 loginOk.me로 나온다. 아하 서블릿이구나!
////		result.setPath(request.getContextPath() + "loginFinish.jsp");
//		
////		result.setPath(request.getContextPath()); // redirect 방식일때 새로고침하면서 루트경로로 보낸다.
//		result.setPath("/app/member/loginFinish.jsp"); // Forward 방식일때 성공
//		
//		
//		return result;
//	}	
//}

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result(); // 다음 페이지 결과 방식 알려주는 객체
		MemberDAO memberDAO = new MemberDAO(); // 쿼리실행할 객체
		MemberDTO memberDTO = new MemberDTO();
		
		
//		memberDTO.setMemberId(request.getParameter("memberId"));
//		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		memberDTO = memberDAO.login(memberId, memberPassword);
		
		
		if(memberDTO != null) {
			//로그인 성공시 세션에 사용자 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("memberDTO", memberDTO); 
			
			//쿠키에 사용자 Id 저장
			Cookie cookie = new Cookie("memberId", memberId);
			cookie.setMaxAge(60 * 60 * 24); // 유효기간 1일
			response.addCookie(cookie);
			
			result.setPath(request.getContextPath() + "/main.jsp");
			result.setRedirect(true); // 로그인 성공했을때는 새로운 페이지를 띄워주니까???
		}else {
			//로그인 실패시 로그인 페이지로 이동
			result.setPath(request.getContextPath() + "/member/login.jsp");
			result.setRedirect(true); // 로그인 실패했는데 계속 그 정보를 들고가면 안된다.
		}
		
		
		return result;
	}
}
