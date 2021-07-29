package com.si.project.DAO;

import java.util.List;

import com.si.project.VO.MemberVO;

public interface MemberDAO {

	public void memberJoin(MemberVO vo) throws Exception;
	public MemberVO memberLogin(MemberVO vo) throws Exception;
	public void memberUpdate(MemberVO vo) throws Exception;
	public int passChk(MemberVO vo) throws Exception;
	public void memberDelete(MemberVO vo) throws Exception;
	
	
}
