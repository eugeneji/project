package com.si.project.DAOImp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.si.project.DAO.MemberDAO;
import com.si.project.VO.MemberVO;

@Repository
public class MemberDAOImp implements MemberDAO {

	
	@Inject SqlSession session;
	
	//회원가입
	@Override
	public void memberJoin(MemberVO vo) throws Exception {		
		session.insert("memberJoin", vo);
	}
	
	//로그인
	@Override
	public MemberVO memberLogin(MemberVO vo) throws Exception {
		return session.selectOne("memberLogin", vo);
	}
	
	//회원정보 수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		session.update("memberUpdate", vo);
		
	}
	
	//비밀번호 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result= session.selectOne("passChk", vo);
		return result;
	}
	//회원 탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		session.delete("memberDelete", vo);
		
	}
}