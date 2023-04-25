package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// sqlSession.selectList("boardMapper.selectList");
		
		// 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공한다.
		
		// * offset : 몇 개의 게시글을 건너뛰고 조회할 건지에 대한 값을 설정할 수 있음
		/*
		 * ex) boardLimit 5일 경우
		 * 									offset(건너뛸 숫자)			limit(조회할 숫자)
		 * currentPage : 1 => 1~5					0							5
		 * currentPage : 2 => 6~10					5							5
		 * currentPage : 3 => 11~15					10							5
		 */
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		// RowBounds 객체를 넘겨줘야 하는 경우, selectList 함수의 오버 로딩 된 메서드 중 매개변수가 3개인 메서드를 사용해야 함
		// 딱히 두 번째 자리에 파라미터로 넘길 값이 없더라도 null 값이라도 넘겨줘야 한다.(빈 값으로 두면 안 됨) 
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null ,rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, PageInfo pi, HashMap<String, String> map) {

//		int limit = pi.getBoardLimit();
//		int offset = (pi.getCurrentPage() - 1) * limit;
//		
//		RowBounds rowBounds = new RowBounds(offset, limit);
		
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage()-1)*pi.getBoardLimit(), pi.getBoardLimit());
		
		// RowBounds 객체를 넘겨줘야 하는 경우, selectList 함수의 오버 로딩 된 메서드 중 매개변수가 3개인 메서드를 사용해야 함
		// 딱히 두 번째 자리에 파라미터로 넘길 값이 없더라도 null 값이라도 넘겨줘야 한다.(빈 값으로 두면 안 됨) 
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map ,rowBounds);
	}
}
