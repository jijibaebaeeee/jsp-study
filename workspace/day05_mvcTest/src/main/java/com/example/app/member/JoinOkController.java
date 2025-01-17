package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dto.MemberDTO;
import com.example.app.member.dao.MemberDAO;

//public class JoinOkController {
//	// 프론트 컨트롤러에 작성한 코드를 처리할건데
//	// 일반 클래스는 request, response가 없다
//	// 메소드를 만들어 매개변수로 전달받아 처리한다
//
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDAO memberDAO = new MemberDAO(); // DAO객체를 만들어줘야한다 DAO에 있는 join 호출하기 위해서
//		MemberDTO memberDTO = new MemberDTO();
//		System.out.println(memberDTO);
//		// 여기서 이제 DB에 데이터를 시원하게 꽂아줘야한다
//		memberDTO.setMemberId(request.getParameter("memberId"));
//		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
//		memberDTO.setMemberName(request.getParameter("memberName"));
//		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
//		memberDTO.setMemberGender(request.getParameter("memberGender"));
//		// valueOf() : 문자열을 Interger타입으로 바꿔준다
//		// parseInt() 와의 차이는 parseInt()는 문자열이 숫자가 아닐 경우 numberFormatException이 발생하지만
//		// valueOf()는 null을 반환한다(즉, 예외발생안함)
//		
//		memberDAO.join(memberDTO); // +++ memberDAO에 있는 join 메소드 호출
//		
//	}
//}

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO memberDAO = new MemberDAO(); // DAO객체를 만들어줘야한다 DAO에 있는 join 호출하기 위해서
		MemberDTO memberDTO = new MemberDTO();
		Result result = new Result();
		System.out.println(memberDTO);
		
		// 여기서 이제 DB에 데이터를 시원하게 꽂아줘야한다
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		memberDTO.setMemberGender(request.getParameter("memberGender"));
		// valueOf() : 문자열을 Interger타입으로 바꿔준다
		// parseInt() 와의 차이는 parseInt()는 문자열이 숫자가 아닐 경우 numberFormatException이 발생하지만
		// valueOf()는 null을 반환한다(즉, 예외발생안함)

		memberDAO.join(memberDTO); // +++ memberDAO에 있는 join 메소드 호출

		result.setRedirect(true); // redirect로 갈지 forward로 갈지 설정 ... 이거 위해서 Result.java 만들었음
		result.setPath(request.getContextPath()); // 어느 경로로 가는지 설정
		
		return result;
	}

}