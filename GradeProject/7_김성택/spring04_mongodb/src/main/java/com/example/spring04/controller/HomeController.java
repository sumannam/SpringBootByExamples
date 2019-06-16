package com.example.spring04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러 빈으로 등록
public class HomeController {
	// http://localhost
	@RequestMapping("/")
	public String home() {
		// /WEB-INF/view/home.jsp
		return "home";  // home.jsp로 포워딩
	}
}
