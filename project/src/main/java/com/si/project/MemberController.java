package com.si.project;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.si.project.Service.MemberService;
import com.si.project.VO.MemberVO;

@Controller
public class MemberController {

	@Inject
	MemberService memberService;
	
	//회원가입 폼
	@RequestMapping(value="/member/memberJoin.do",method = RequestMethod.GET)
	public void MemberJoinForm() throws Exception{
		
	}
	//회원가입
	@RequestMapping(value="/member/memberJoin.do",method = RequestMethod.POST)
	public String MemberJoin(MemberVO vo) throws Exception{
		
		memberService.memberJoin(vo);
		
		return null;
	}
	//로그인 폼
	@RequestMapping(value="/member/memberLogin.do",method = RequestMethod.GET)
	public String MemberLoginForm() throws Exception{
		return "member/memberLogin";
	}
	//로그인
	@RequestMapping(value="/member/memberLogin.do", method = RequestMethod.POST)
	public String MemberLogin(MemberVO vo,HttpServletRequest req, RedirectAttributes rttr, Model model) throws Exception{
		
		HttpSession session = req.getSession();
		MemberVO login = memberService.memberLogin(vo);
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("login", login);
			model.addAttribute("login", login);
		}
		return "redirect:/index.do";
	}
	//로그아웃
	@RequestMapping(value="/member/memberLogout.do", method = RequestMethod.GET)
	public String logout(HttpSession session,HttpServletRequest req) throws Exception{
		session=req.getSession();
		session.invalidate();
		return "redirect:/index.do";
	}
	//비밀번호 체크
	@ResponseBody
	@RequestMapping(value="/member/passChk.do", method = RequestMethod.POST)
	public int passChk(MemberVO vo,Model model) throws Exception{
		int result = memberService.passChk(vo);
		model.addAttribute("member",vo);
		return result;
	}
	//회원탈퇴
	@RequestMapping(value="/member/memberDelete.do", method = RequestMethod.GET)
	public String memberDeleteForm() throws Exception{
		return "member/memberDelete";
	}
	@RequestMapping(value="/member/memberDelete.do", method = RequestMethod.POST)
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		MemberVO member=(MemberVO) session.getAttribute("member");
		//세션에 있는 비밀번호
		String sessionPass = member.getMem_pass();
		//vo로 들어오는 비밀번호
		String voPass = vo.getMem_pass();
		
		if(!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/memberDelete.do";
		}
		memberService.memberDelete(vo);
		session.invalidate();
		return "redirect:/index.do";
	}
	
}
