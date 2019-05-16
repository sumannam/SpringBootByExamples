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
	 *	@brief	name, height, weight 값을 받고 height와 weight 값으로 BMI 수치 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-16
	 *
	 *	@param	String name HTML에서 입력받는 이름 저장
	 *			Double height HTML에서 입력받는 키 저장
	 *			Double weight HTML에서 입력받는 몸무게 저장
	 *			ModelAndView mav ModelAndView 변수
	 *
	 *	@remark	수치 계산 결과 출력을 위해 bmi 선언 
	 *			상태 결과 출력을 위해 result 선언 [2019-05-16; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("name")String name, 
							 @RequestParam("height")Double height, 
							 @RequestParam("weight")Double weight, 
							 ModelAndView mav) {
		
		double bmi = weight/(height*height); 
		String result = "";
		
		if (bmi<=18.5) {
			result += "저체중";
		} else if (18.5<bmi && bmi<=24.9) {
			result += "정상";
		} else if (24.9<bmi && bmi<=29.9) {
			result += "과체중";
		} else if (23.9<bmi) {
			result += "비만";
		}
		
		mav.addObject("res", name + " 님의 BMI 지수는 " + bmi + "이며 현재 상태는 " + result + "입니다.");
		mav.setViewName("index");
		return mav;
	}
}