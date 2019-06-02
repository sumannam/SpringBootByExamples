package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
        mav.addObject("res","1부터1000까지의 홀수 합을 구하세요.");
		return mav;
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send( @RequestParam(value="",required=false)int odd,
							  ModelAndView mav) {
		odd=0;
		for(int i=1; i<=1000; i++) {
			if(i%2 == 1) {odd+=i;}
			}
		mav.addObject("msg", "1부터1000까지의 홀수 합은"+odd);
		return mav;
	}
}
