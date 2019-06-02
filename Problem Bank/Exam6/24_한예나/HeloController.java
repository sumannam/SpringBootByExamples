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
	 *	@date	2019-05-16
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-16; 한예나]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	num1, num2, num3, num4, num5의 값을 받아 총점과 평균 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-16
	 *
	 *	@param	int num1, num2, num3, num4, num5 HTML에서 입력받는 숫자 저장
	 *			ModelAndView mav 				 ModelAndView 변수
	 *
	 *	@remark	총합 결과 출력을 위해 sum 선언
	 *			평균 결과 출력을 위해 avg 선언 [2019-05-16; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")int num1, 
							 @RequestParam("num2")int num2,
							 @RequestParam("num3")int num3, 
							 @RequestParam("num4")int num4, 
							 @RequestParam("num5")int num5, 
							 ModelAndView mav) {
		
		int [] array = {num1, num2, num3, num4, num5};
		int sum = 0;
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
		}
		
		double avg = sum/array.length;
		
		mav.addObject("res", "총점 : " + sum + " 평균 : " + avg);
		mav.setViewName("index");
		return mav;
	}
}