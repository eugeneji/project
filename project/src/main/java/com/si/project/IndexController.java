package com.si.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.si.project.DAO.MemberDAO;

@Controller
public class IndexController {

	@Resource
	private MemberDAO memberDao;
	
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
	
	
}
