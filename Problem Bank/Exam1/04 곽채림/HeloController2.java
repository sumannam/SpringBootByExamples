package com.kwackchaelim.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HeloController2 {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String str, ModelAndView mav) {
		int res=0;
		
		int num1 = Integer.parseInt(str);
		
		res = num1*1172;
		
		mav.addObject("res", "오늘의 환률 : "+res);
		mav.setViewName("index");

		return mav;
	}
}