package com.example.spring04.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.member.dto.MemberDTO;
import com.example.spring04.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login"; //login.jsp로 이동
	}
	@RequestMapping("login_check.do")
	public ModelAndView login_check(
			String _id, String passwd
			,HttpSession session) {
		MemberDTO dto=memberService.loginCheck(_id, passwd);
		String message="";
		String url="";
		if(dto==null) { //로그인 실패
			message="로그인 정보가 정확하지 않습니다.";
			url="member/login";
		}else { //로그인 성공
			message=dto.getName()+"님 환영합니다.";
			url="home";
			//세션에 등록
			session.setAttribute("userid", _id);
			session.setAttribute("name", dto.getName());
		}
		Map<String,Object> map=new HashMap<>();
		map.put("message", message);
		return new ModelAndView(url, "map", map);
	}
	
	@RequestMapping("join.do")
	public String join() {
		return "member/join"; //join.jsp 회원가입페이지로 이동
	}
	@RequestMapping("member_join.do")
	public String member_join(String _id, String passwd
			, String name) {
		MemberDTO dto=new MemberDTO();
		dto.set_id(_id);
		dto.setPasswd(passwd);
		dto.setName(name);
		memberService.join(dto); //mongodb에 insert됨
		return "redirect:/member/login.do"; //로그인 화면으로 이동
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		//세션 정보 초기화
		session.invalidate();
		//로그인 페이지로 이동
		return "redirect:/member/login.do";
	}
}









