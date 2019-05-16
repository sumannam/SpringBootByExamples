package com0;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController {
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
	
		return mav;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
			public ModelAndView send(@RequestParam("name")String name, 
			 @RequestParam("weight")Double weight, 
			 @RequestParam("inches")Double inches, 
					 ModelAndView mav) {	
		
	double bmi = weight/(inches*inches); 
	String res = "";

	
	
	if (bmi<=18.5) {
		res += "저체중";
	} else if (18.5<bmi && bmi<=24.9) {
		res += "정상";
	} else if (24.9<bmi && bmi<=29.9) {
		res += "과체중";
	} else if (23.9<bmi) {
		res += "비만";
	}
	mav.addObject("res", name + " BMI 지수 :" + bmi + " 현재 : " + res);
	
	mav.setViewName("index");
	
	return mav;
}
} 