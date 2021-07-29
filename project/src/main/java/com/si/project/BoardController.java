package com.si.project;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.si.project.Service.BoardService;
import com.si.project.VO.BoardVO;
import com.si.project.VO.Criteria;
import com.si.project.VO.PageMaker;
import com.si.project.VO.SearchCriteria;

@Controller
public class BoardController {

	@Resource
	private BoardService service;
	
	@RequestMapping(value="/board/boardList.do", method = RequestMethod.GET)
	public String getBoardList(Criteria cri, Model model, @ModelAttribute("scri") SearchCriteria scri ) throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", service.boardList(scri));
		return "board/boardList";
	}
   //게시물 작성 폼
	@RequestMapping(value="/board/boardWrite.do", method = RequestMethod.GET)
	public void getBoardWrite()throws Exception {
		
	}
	//게시물 작성
	@RequestMapping(value="/board/boardWrite.do", method = RequestMethod.POST )
	public String boardWrite(BoardVO vo, Model model)throws Exception {
		int count=service.boardWrite(vo);
		String msg = count > 0 ? "작성완료!":"작성실패..";
		model.addAttribute("msg", msg);
		return "/board/boardMsg";
	}
	//게시물 삭제
	@RequestMapping(value="/board/boardDelete.do",method = RequestMethod.GET)
	public String boardDelete(@RequestParam (value="b_idx")int b_idx, Model model)throws Exception {
		int count=service.boardDelete(b_idx);
		String msg = count==1 ?"삭제완료!":"삭제실패..";
		model.addAttribute("msg", msg);
		return "/board/boardMsg";
	}
	//게시물 정보
	@RequestMapping(value="/board/boardContent.do")
	public String getBoardContent(@RequestParam (value="b_idx")int b_idx, 
			Model model)throws Exception {
		BoardVO vo = service.boardContent(b_idx);
		service.boardReadnum(b_idx);
		model.addAttribute("vo", vo);
		model.addAttribute("b_idx", b_idx);
		return "/board/boardContent";
	}
	//게시물 수정폼
	@RequestMapping(value="/board/boardUpdate.do",method = RequestMethod.GET)
	public String boardUpdateForm(int b_idx,Model model) throws Exception {
		BoardVO vo = service.boardContent(b_idx);
		model.addAttribute("vo", vo);
		return"board/boardUpdate";
	}
	@RequestMapping(value="/board/boardUpdate.do",method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo, Model model) throws Exception {
		int result=service.boardUpdate(vo);
		String msg = result>0?"수정완료!":"수정실패..";
		model.addAttribute("msg", msg);
		return"board/boardMsg";
	}
}









