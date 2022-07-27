package com.spring.shop.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("content", "signup.jsp");
		return "home";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(Model model) {
		model.addAttribute("content", "signin.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model) {
		model.addAttribute("content", "mypage.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest req) {
		req.getSession().removeAttribute("loginUser");
		model.addAttribute("MSG", "�α׾ƿ��Ǿ����ϴ�.");
		model.addAttribute("content", "main.jsp");
		
		return "home";
	}

	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public String registryMember(MemberDto memberDto, Model model) throws Exception {
		int result = memberService.registryMember(memberDto);
		if(result > 0) {
			model.addAttribute("MSG", "ȸ�����Լ���");
		}else {
			model.addAttribute("MSG", "ȸ�����Խ���");
		}
		model.addAttribute("content", "signin.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMember(MemberDto memberDto, Model model, HttpServletRequest req) throws Exception {
		LoginDto loginUser = memberService.loginMember(memberDto);
		if(loginUser != null) {
			model.addAttribute("MSG", loginUser.getMi_name() + "���� �α����Ͽ����ϴ�.");
			req.getSession().setAttribute("loginUser", loginUser);
			model.addAttribute("content", "main.jsp");
		} else {
			model.addAttribute("MSG", "�α��ο� �����Ͽ����ϴ�. �ٽ� �õ��� �ּ���.");
			model.addAttribute("content", "signin.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editMember(MemberDto memberDto, Model model) throws Exception {
		int result = memberService.editMember(memberDto);
		if(result > 0) {
			model.addAttribute("MSG", "ȸ������������ �����Ͽ����ϴ�.");
			model.addAttribute("content", "main.jsp");
		} else {
			model.addAttribute("MSG", "ȸ������������ �����Ͽ����ϴ�.");
			model.addAttribute("content", "mypage.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdrawMember(Model model, HttpServletRequest req) throws Exception {
		LoginDto loginDto = (LoginDto)req.getSession().getAttribute("loginUser");	
		int result = memberService.withdrawMember(loginDto);
		if(result > 0) {
			req.getSession().removeAttribute("loginUser");
			model.addAttribute("MSG", "ȸ��Ż�� �����Ͽ����ϴ�.");
			model.addAttribute("content", "main.jsp");
		} else {
			model.addAttribute("MSG", "ȸ��Ż�� �����Ͽ����ϴ�.");
			model.addAttribute("content", "mypage.jsp");
		}
		return "home";
	}
}
