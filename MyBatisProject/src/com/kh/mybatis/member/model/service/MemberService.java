package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	
	public Member loginMember(Member m) {
		
		// connection 객체 반환
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = memberDao.loginMember(sqlSession , m);
		
		// connection 객체 종료
		sqlSession.close();
		
		return loginUser;
	}
	
	public int insertMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new MemberDao().insertMember(sqlSession, m);
		
		if(result > 0) { // 성공
			sqlSession.commit();
		}else { // 실패
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
}
