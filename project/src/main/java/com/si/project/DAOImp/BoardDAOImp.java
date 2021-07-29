package com.si.project.DAOImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.si.project.DAO.BoardDAO;
import com.si.project.VO.BoardVO;
import com.si.project.VO.Criteria;
import com.si.project.VO.SearchCriteria;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Resource
	private SqlSession sqlSession;
	
	//게시판 리스트
	@Override
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception {
		
		return sqlSession.selectList("boardList", scri);
	}

	
	//게시판 글쓰기
	@Override
	public int boardWrite(BoardVO vo) {
		
		return sqlSession.insert("boardWrite", vo);
	}
	
	//게시판 글삭제
	@Override
	public int boardDelete(int b_idx) {
		return sqlSession.delete("boardDelete", b_idx);
	}
	
	//게시글 정보
	@Override
	public BoardVO boardContent(int b_idx) {
		return sqlSession.selectOne("boardContent", b_idx);
	}
	//게시글 수정
	@Override
	public int boardUpdate(BoardVO vo) {
		return sqlSession.update("boardUpdate", vo);
	}
	//게시글 조회수
	@Override
	public int boardReadnum(int b_idx) {
		return sqlSession.update("boardReadnum", b_idx);
	}
	//페이징을 위한 게시글 총갯수
	@Override
	public int listCount(SearchCriteria scri) {
		return sqlSession.selectOne("listCount", scri);
	}

}
