package com.example.app.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.app.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

//DAO에는 쿼리 실행하는 부분만 작성한다
public class MemberDAO {
	public SqlSession sqlSession; // 필드에 SqlSession 타입으로 참조변수를 선언함

	// 생성자
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // 그 선언한 참조변수에 DB에 접근할 수 있는 Session을 만든다.
	}

	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}

	public int login(Map HashMap) {
		return sqlSession.selectOne("member.login", HashMap);
	}

	public MemberDTO login(String memberId, String memberPassword) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPassword(memberPassword);
		return sqlSession.selectOne("member.login", memberDTO); //값이 1개라는 뜻이 행이 하나라는 뜻이구나
	}

}
