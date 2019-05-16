package com.yena.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
	 * 	@fn	public ModelAndView send(@RequestParam("num")String num, ModelAndView mav)
	 *	@brief	num의 숫자를 받아 나이 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-15
	 *
	 *	@param	int num HTML에서 입력받는 숫자 저장
	 *			ModelAndView mav ModelAndView 변수
	 *
	 * 	@return mav HTML에 처리할 값 저장
	 * 
	 *	@remark	계산 결과 출력을 위해 result 선언 [2019-05-15; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num")String num, 
							 ModelAndView mav) {
		
		int Num = Integer.parseInt(num);
		
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		int Year = calendar.get(Calendar.YEAR);

		int result = Year - Num + 1;
		
		String Result = String.valueOf(result);
		
		mav.addObject("res", "당신의 나이는  " + Result + "입니다.");
		mav.setViewName("index");
		return mav;
	}
}