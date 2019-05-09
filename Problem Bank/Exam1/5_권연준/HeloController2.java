package com.yunjun.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController2
{
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-09
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-09; 권연준]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input box에서 num을 받아 환율 계산
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-09
	 *
	 *	@param	
	 *	@remark 환율 결과를 위해 res 선언 [2019-05-09; 권연준]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num")String num,
							 ModelAndView mav) {
		
		int Num, result = 0;
		String res = "";
		mav.addObject("res", res);
		mav.setViewName("index");
		return mav;
	}
}