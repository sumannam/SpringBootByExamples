package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController3 {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index1");
		mav.addObject("res");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody ModelAndView send(
		@RequestParam(value="num1",required=false)int num1
		,@RequestParam(value="num2",required=false)int num2
		,ModelAndView mav) {
		
		String res = "";
		int num = 0;
		
		try {
			
			num += num1 + num2;
			
			num += num1 - num2;
			
			num +=  num1 * num2;
			
			num +=  num1 / num2;
			
			res += String.valueOf(num);
		
			mav.addObject("res", num);
			mav.setViewName("index");

			
		}catch(NullPointerException e) {
			res += "null";
		}
		
		return mav;
	}


}
