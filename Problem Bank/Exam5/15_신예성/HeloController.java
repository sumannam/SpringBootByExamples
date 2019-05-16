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
	public ModelAndView send(@RequestParam("num1")int str, ModelAndView mav) {
		int sum = 0;
				
		for(int i=1; i <= str; i++) {
			if(i%2 == 1){
				sum += i;
			}
		}
		
		mav.addObject("res", sum);
		mav.setViewName("index");

		return mav;
	}
}