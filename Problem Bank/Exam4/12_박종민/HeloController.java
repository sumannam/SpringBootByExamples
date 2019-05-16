package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	/**
	 * @fn		public ModelAndView index(ModelAndView mav)
	 * @brief	BMI(체질량지수)구하기
	 * @details 함수 상세 설명
	 * 
	 * @author 	
	 * @Date
	 * 
	 *
	 * @remark 	BMI(체질량지수)구하기[2019-05-16; 박종민]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","몸무게와 키를 입력해주세요");
		return mav;
	}
	
	
	/**
	 * @fn		public ModelAndView index(ModelAndView mav)
	 * @brief	BMI(체질량지수)구하기
	 * @details 함수 상세 설명
	 * 
	 * @author 	user
	 * @Date
	 * 
	 * @param 	name
	 * @param 	meter
	 * @param 	kg
	 * @param 	mav
	 * 
	 * @return	mav 
	 * @remark 	BMI(체질량지수)구하기[2019-05-16; 박종민]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="name", required=false)String name,
		@RequestParam(value="meter", required=false)int meter,
		@RequestParam(value="kg", required=false)int kg,
		ModelAndView mav) {
		
		int bmi = meter*meter;
		int bmi2 = kg/bmi;
		
		if(bmi2<18.5) {
			mav.addObject("저체중입니다.");}
		else {mav.addObject("정상입니다.");}
		
		mav.addObject(name);
		mav.addObject(bmi2);
		
		return mav;
	}
}