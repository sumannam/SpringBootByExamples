package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController2 {
	/**
	 *
	 * @fn public ModelAndView index(ModelAndView mav)
	 * 
	 * @brief 초기 페이지 설정
	 *
	 * @author 강석진
	 * @date 2019-05-09
	 *
	 * @param mav ModelAndView
	 *
	 * @remark 웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 강석진] \n
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		
		mav.setViewName("index3");
		mav.addObject("msg", "정수 두개를 입력하세요");
		
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView send(@RequestParam("num1")int num1, 
	 *                           		 @RequestParam("num2")int num2, ModelAndView mav)
	 *
	 * @brief 	폼에 num1, num2에 있는 값을 str1,str2에 문자열로 받아옴
	 *
	 * @author 	강석진
	 * @date 	2019-05-09
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	addObject를 이용한 계산식 처리 [2019-05-09; 강석진] \n
	 * 			
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1") int num1, 
							 @RequestParam("num2") int num2, ModelAndView mav) {
		
		mav.addObject("res1", num1 + " + " + num2 + " = " + (num1+num2));
		mav.addObject("res2", num1 + " - " + num2 + " = " + (num1-num2));
		mav.addObject("res3", num1 + " * " + num2 + " = " + (num1*num2));
		mav.addObject("res4", num1 + " / " + num2 + " = " + (num1/num2));
		
		mav.setViewName("index3");
		
		return mav;
	}
}