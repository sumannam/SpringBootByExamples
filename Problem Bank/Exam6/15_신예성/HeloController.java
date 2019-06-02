package com.shin.springboot;

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
	public ModelAndView send(@RequestParam("num1")int str1, @RequestParam("num2")int str2, @RequestParam("num3")int str3, @RequestParam("num4")int str4, @RequestParam("num5")int str5, ModelAndView mav) {
		
		int sum = 0;
		int Avg = 0;
		
		sum = str1 
			  + str2 
			  + str3 
			  + str4 
			  + str5;
		Avg = sum/5;
		
		mav.addObject("res", "점수의 총 합계는 : " + sum + "점수의 평균은 : " + Avg);
		mav.setViewName("index");

		return mav;
	}
}