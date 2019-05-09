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
		mav.addObject("msg","1$=1172원");
		return mav;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("$")String $,
							ModelAndView mav) {
		int won = Integer.parseInt($) * 1172;
		
		String res = String.valueOf(won);
		mav.addObject("msg","result = " + res);
		mav.setViewName("index");
		return mav;
		
		
	
	
		
		
		
	
	
	}
}