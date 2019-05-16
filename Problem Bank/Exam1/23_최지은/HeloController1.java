package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController1 {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("HeloController2");
		mav.addObject("res");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num",required=false)String num1
		,ModelAndView mav) {
		
		String res = "";
		int num = 0;
		
		try {
			
			num += Integer.parseInt(num1);
		
			res += String.valueOf(num);
		
			mav.addObject("res", res);
			mav.setViewName("HeloController2");

			
		}catch(NullPointerException e) {
			res += "null";
		}
		
		return mav;
	}

}
