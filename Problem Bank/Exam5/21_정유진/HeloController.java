package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	/**
	 *	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief		웹 페이지 초기 페이지 설정
	 *	@derails
	 *
	 *	@author		정유진
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView	
	 *
	 * 	@remark		웹 페이지를 불러오기 위한 초기 페이지 설정 	[2019-05-16; 정유진]	
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("res","N의 값을 입력해주세요.");
		return mav;
	}
	
	/**
	 *	@fn		public ModelAndView send(@RequestParam("num") int num,ModelAndView mav)
	 *	@brief		1부터 N까지 홀수의 합 구하기
	 *	@derails	
	 *
	 *	@author		정유진
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView
	 *
	 * 	@remark		홀수 합 출력을 위해 result 선언 [2019-05-16; 정유진]			
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
				@RequestParam("num") int num
				,ModelAndView mav) {
		
		int result = 0;
		
		for (int i=0; i <= num; i++) {
			if(i%2==1) {
				result += i;
			}
		}
		
		mav.addObject("res","1부터" + num + "까지의 홀수 합은 " + result + "입니다.");		
		mav.setViewName("index");
		return mav;
		
	}
}