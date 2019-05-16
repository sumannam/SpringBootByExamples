package com.kwackchaelim.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HeloController1 {
	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num,ModelAndView mav) {
		
		String res="";
		
		int result = num*1172;
		
		res = String.valueOf(result);
		
		mav.setViewName("index");
		mav.addObject("res", "오늘의 환율은:"+ res);
		return mav;
	}
}
