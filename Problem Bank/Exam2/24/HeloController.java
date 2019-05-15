package com.yena.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController 
{
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-09; 한예나]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	num1과 num2의 값을 받아 사칙연산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 *
	 *	@param	int          num1, num2 HTML에서 입력받는 숫자 저장
	 *			ModelAndView mav ModelAndView 변수
	 *	@remark	덧셈 결과 출력을 위해 res1, ress2, res3, res4 선언 [2019-05-09; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String num1, 
							 @RequestParam("num2")String num2, 
							 ModelAndView mav) {
		
		int Num1 = Integer.parseInt(num1);
		int Num2 = Integer.parseInt(num2);
		
		int res1 = Num1 + Num2;
		int res2 = Num1 - Num2;
		int res3 = Num1 * Num2;
		int res4 = Num1 / Num2;
		
		String plusres = String.valueOf(res1);
		String minusres = String.valueOf(res2);
		String multires = String.valueOf(res3);
		String divres = String.valueOf(res4);
		
		mav.addObject("res1", "두자리 정수 : " + Num1 + " " + Num2);
		mav.addObject("res2", Num1 + "+" + Num2 + "=" + res1);
		mav.addObject("res3", Num1 + "-" + Num2 + "=" + res2);
		mav.addObject("res4", Num1 + "*" + Num2 + "=" + res3);
		mav.addObject("res5", Num1 + "/" + Num2 + "=" + res4);
		mav.setViewName("index");
		return mav;
	}
}