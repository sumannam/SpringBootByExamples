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
	 * 	@fn	public ModelAndView send
	 *	@brief	num의 값을 받아 1부터 홀수 저장
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-16
	 *
	 *	@param	int HTML에서 입력받는 숫자 저장
	 *			ModelAndView mav ModelAndView 변수
	 *
	 *	@remark	합계 결과 출력을 위해 sum 선언 [2019-05-16; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num")int num, 
							 ModelAndView mav) {
		
		int sum = 0;
		
		for (int i=0; i<=num; i++) {
			if(i%2==1) {
				sum += i;
			}
		}
		
		mav.addObject("res", "계산 결과 : " + sum);
		mav.setViewName("index");
		return mav;
	}
}