package com.si.project.Service;

import java.util.List;

import com.si.project.VO.BoardVO;
import com.si.project.VO.Criteria;
import com.si.project.VO.SearchCriteria;

public interface BoardService {

	public List<BoardVO> boardList(SearchCriteria scri) throws Exception;
	public int boardWrite(BoardVO vo) throws Exception;
	public int boardDelete(int b_idx) throws Exception;
	public BoardVO boardContent(int b_idx) throws Exception;
	public int boardUpdate(BoardVO vo) throws Exception;
	public int boardReadnum(int b_idx) throws Exception;
	public int listCount(SearchCriteria scri) throws Exception;
}
