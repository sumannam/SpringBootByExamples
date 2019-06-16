package com.example.spring04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

		/**
		*
		* @fn 		public String home()
		* 
		* @brief 	기본주소설정 
		*
		* @author 	김성택
		* @date 	2019-06-16
		*
		* @param 	"home"
		*
		* @remark 	home이라는 파일을 기본주소로 설정		[2019-06-16; 김성택]
		* 		   	
		**/

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {

		return "home";
	}
}
