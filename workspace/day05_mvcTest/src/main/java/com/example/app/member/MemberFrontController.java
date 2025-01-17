package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */
//@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public MemberFrontController() {
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
	   doProcess(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
	   request.setCharacterEncoding("UTF-8");
	   doProcess(request, response);
   }

   
   //get과 post를 구분하지 않고 사용할 것이다
   protected void doProcess(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("member 서블릿 실행");

      // request.getContextPath() URL 루트경로를 의미
      System.out.println(request.getContextPath());

      // request.getRequestURI 현재 요청의 URI를 의미
      System.out.println(request.getRequestURI());
      
      // 요청 url이 뭔지 구분하기
      // 우리가 필요한 것은 전체 URI에서 ContextPath를 제외시킨 부분
      String target = request.getRequestURI().substring(request.getContextPath().length());
      System.out.println(target);
      
      Result result = null; // 이거 Result.java에서 생성하고 JoinOkController.java에서 리턴으로 받았슴
      
      switch(target) {
      case "/member/join.me": // index.jsp 에서 회원가입 버튼을 클릭했을 때
    	  System.out.println("join!!");
    	  // 그냥 단순히 join.jsp 페이지만 띄워주면 된다.
    	  request.getRequestDispatcher("/app/member/join.jsp").forward(request, response);
    	  break;
      case "/member/joinOk.me": //join.jsp에서 사용자가 값을 다 입력하고 회원가입요청 버튼을 클릭했을 때
    	  System.out.println("joinOK!!");
    	  
    	  // +++ 추가 되었음
    	  result = new JoinOkController().execute(request, response); // 회원가입요청 버튼의 request와 response를 가지고 처리하러 간다.
    	  
    	  //    	  response.sendRedirect(request.getContextPath());
    	  
    	  
    	  
    	  //sqlSession을 이용한다
    	  
    	  //이 부분은 JoinOkController로 넘어갔음
//    	  MemberDTO memberDTO = new MemberDTO();
//    	  System.out.println(memberDTO);
//    	  // 여기서 이제 DB에 데이터를 시원하게 꽂아줘야한다
//    	  memberDTO.setMemberId(request.getParameter("memberId"));
//    	  memberDTO.setMemberPassword(request.getParameter("memberPassword"));
//    	  memberDTO.setMemberName(request.getParameter("memberName"));
//    	  memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
//    	  memberDTO.setMemberGender(request.getParameter("memberGender"));
//    	  //valueOf() : 문자열을 Interger타입으로 바꿔준다
//    	  //parseInt() 와의 차이는 parseInt()는 문자열이 숫자가 아닐 경우 numberFormatException이 발생하지만 valueOf()는 null을 반환한다(즉, 예외발생안함)
    	  
    	  // 이 부분은 memeber.DAO로 넘어갔음.
//    	  SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // 이거 그냥 드라이브랑 계정명이랑 패스워드같은거 넣어둔 곳이야. 이걸 기반으로 db랑 연결해준거임
//    	  sqlSession.insert("member.join", memberDTO); // 연결한 db에 쿼리문 실행시키는거고, 값은 memberDTO에 있음
//    	  response.sendRedirect(request.getContextPath()); // 사용자는 다 했으니, 리다이렉트를 이용해서 새로고침 시킨다.
    	  
    	  break;
    
    	  	//OK가 필요한 이유는 회원가입 페이지로 단순히 이동하는 것과 회원가입을 처리하는 URL을 나누기 위함이다.
      case "/member/login.me":
    	  System.out.println("login!!");
    	  request.getRequestDispatcher("/app/member/login.jsp").forward(request, response);
    	  break;
      case "/member/loginOk.me":
    	  System.out.println("loginOk!!");
//    	  Result result1 = null;
    	  result = new LoginOkController().execute(request, response);
    	  System.out.println("login에 입력된 값 DB와 비교는 완료!!");
    	  break;
      }
      
      if(result != null) {
    	  if(result.isRedirect()) {
    		  response.sendRedirect(result.getPath()); // 여기서 result는 객체의 주소값 result.getPath()는 버튼을 눌렀을 때 다음창으로 갈 곳
    		  System.out.println(request.getAttribute("memberId"));
    	  }else {
    		  request.getRequestDispatcher(result.getPath()).forward(request, response);
    		  System.out.println(request.getAttribute("memberId"));
    		  System.out.println(result.getPath());

    	  }
      }
     
      
   }

}
