package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * @brief	초기 페이지 설정
	 *
	 * @author	강석진
	 * @date 	2019-05-09
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 강석진] \n
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "계산할 숫자를 입력해주세요");
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView send(@RequestParam("num") int num, ModelAndView mav)
	 *                              
	 * @brief	FORM에 있는 정수 num을 받아옴
	 *
	 * @author 	강석진
	 * @date	2019-05-16
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	반복과 조건문을 사용하여 홀수들을 odd_sum에 더함	[2019-05-16; 강석진] \n 
	 *
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("num") int num, ModelAndView mav) {
		
		int odd_sum = 0;
		
		for(int i = 0; i <= num; i++) {
			if(i % 2 == 1) {
				odd_sum += i;
			}
		}

		mav.addObject("msg", "홀수의 합 : " + odd_sum);
		mav.setViewName("index");
		
		return mav;
	}
}