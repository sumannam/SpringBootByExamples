package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	/**
	 *
	 * @fn 		public ModelAndView send(@PathVariable("year") int year , ModelAndView mav)
	 * 			
	 * @brief 	url에 입력된  연도값을 변수 year에 선언
	 *
	 * @author 	강석진
	 * @date 	2019-05-13
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	현재 연도값을 변수값에 저장 [2019-05-13; 강석진] \n 
	 *			addObject에서 처리 후 출력 [2019-05-13; 강석진] \n
	 *         
	 */
	@RequestMapping(value = "/{year}")
	public ModelAndView send(@PathVariable("year") int year , ModelAndView mav) {
		
		int now = 2019;
		
		mav.addObject("value", (now - year + 1));
		mav.addObject("msg", now + "년 기준");
		mav.setViewName("index");
		
		return mav;
	}
}