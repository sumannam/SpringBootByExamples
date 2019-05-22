package com.kwackchaelim.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;

@Controller
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("name")String name, @RequestParam("kg")double kg, @RequestParam("m")double m ,ModelAndView mav) {
		double bmi = kg/(m*m);
		
		if (bmi<=18.5){
			mav.addObject("res", name + "님의 비만도는 '저체중'입니다. ");
			}
			else if (18.5<bmi && bmi<=24.9){
				mav.addObject("res", name + "님의 비만도는 '정상'입니다. ");
			}
			else if (25.0<bmi && bmi<=29.9){
				mav.addObject("res", name + "님의 비만도는 '과체중'입니다. ");
			}
			else if (30.0<=bmi){
				mav.addObject("res", name +"님의 비만도는 '비만'입니다. ");
			}

		mav.addObject("res1", name +"님의 신체질량지수(BMI)는 " + bmi + "입니다.");
		mav.setViewName("index");
		
		return mav;
	}
}
