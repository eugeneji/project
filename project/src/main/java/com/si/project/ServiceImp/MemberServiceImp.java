package com.si.project.ServiceImp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.si.project.DAO.MemberDAO;
import com.si.project.Service.MemberService;
import com.si.project.VO.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Inject MemberDAO memberDao;
	
	@Override
	public void memberJoin(MemberVO vo) throws Exception {
		
		memberDao.memberJoin(vo);
	}
	
	@Override
	public MemberVO memberLogin(MemberVO vo) throws Exception {
		
		return memberDao.memberLogin(vo);
	}
	
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		memberDao.memberUpdate(vo);
		
	}
	
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result=memberDao.passChk(vo);
		return result;
	}
	
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		memberDao.memberDelete(vo);
		
	}

}
