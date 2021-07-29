package com.si.project.ServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.si.project.DAO.BoardDAO;
import com.si.project.Service.BoardService;
import com.si.project.VO.BoardVO;
import com.si.project.VO.Criteria;
import com.si.project.VO.SearchCriteria;

@Service
public class BoardServiceImp implements BoardService {

	@Resource
	private BoardDAO boardDao;
	
	@Override
	public List<BoardVO> boardList(SearchCriteria scri) throws Exception {
		
		return boardDao.boardList(scri);
	}
	
	@Override
	public int boardWrite(BoardVO vo) throws Exception{
		int count = boardDao.boardWrite(vo);
		return count;
	}
	
	@Override
	public int boardDelete(int b_idx) throws Exception{
		int count = boardDao.boardDelete(b_idx);
		return count;
	}
	
	@Override
	public BoardVO boardContent(int b_idx) throws Exception{
		return boardDao.boardContent(b_idx);
	}
	
	@Override
	public int boardUpdate(BoardVO vo) throws Exception{
		int count = boardDao.boardUpdate(vo);
		return count;
	}
	
	@Override
	public int boardReadnum(int b_idx) throws Exception{
		int count = boardDao.boardReadnum(b_idx);
		return count;
	}
	
	@Override
	public int listCount(SearchCriteria scri) throws Exception{
		return boardDao.listCount(scri);
	}	
}
