package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController {
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
        mav.addObject("res","나이입력");
		return mav;
	}

	/**
	 * 	@fn			public ModelAndView send
	 *	@brief		input box에서 num1, num2를 받아 덧셈/뺄셈/곱셈/나눗셈 계산
	 *	@details
	 *
	 *	@author		권연준
	 *	@date		2019-05-09
	 *
	 *	@param		year 현재 년도를 가져옴
	 *  @param  	res 나이
	 *
	 *	@remark 	현재에 나이를 알기 위해서 [2019-05-09; 권연준]
	 */
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1",required=false)String str1,
		ModelAndView mav) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int num1 = Integer.parseInt(str1);
		int res = 0;
		
		res = year - num1;
		
		String res1 = String.valueOf(res);
		
		mav.addObject("res","나이는" + res1 + "입니다."); 
		mav.setViewName("index");
		
		return mav;
	}
}
