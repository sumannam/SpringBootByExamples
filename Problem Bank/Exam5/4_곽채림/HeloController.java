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
	public ModelAndView send(@RequestParam("num")int str,ModelAndView mav) {
		int result = 0;
		
		for(int i=0; i<=str; i++) {
			if(i%2==1) {
				result += i;
			}
		}
		mav.addObject("res", "결과값 :" + result );
		mav.setViewName("index");
		
		return mav;
	}
}
