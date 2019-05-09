package com0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","please wait...");
		return mav;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String num1,
							 @RequestParam("num2")String num2,
							ModelAndView mav) {
		int num = Integer.parseInt(num1);
		int num0 = Integer.parseInt(num2);
		
		String res = String.valueOf(num+num0);
		mav.addObject("msg","result = " + res);
		mav.setViewName("index");
		return mav;
		
		
	
	
	
	
	}
}