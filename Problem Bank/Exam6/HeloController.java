package com0;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam("num1")int num1,
			@RequestParam("num2")int num2,	
			@RequestParam("num3")int num3,
			@RequestParam("num4")int num4,
			@RequestParam("num5")int num5,ModelAndView mav) {
		
		int tot=0;
		
		double avg=0;

		int[] numbers = {num1,num2,num3,num4,num5};

		 for(int i = 0; i< numbers.length; i++){ 
			 
			 tot = tot + numbers[i];
		 }
		 
		 avg = tot/5;

	    mav.addObject("res", "입력한 값까지의 홀수합: "+tot+"평균:"+avg+"입니다");
		mav.setViewName("index");

		return mav;
	}
} 