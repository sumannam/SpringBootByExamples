package com.kwackchaelim.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

/**
*
*	@fn			public class Controller
*	@brief		num1 과 num2의 값을 받아 더함
*	@details
*
*	@author		곽채림
*	@date		2019-05-09
*
*/
@Controller
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String str, @RequestParam("num2")String str1, ModelAndView mav) {
		int res1=0;
		
		int num1 = Integer.parseInt(str);
		int num2 = Integer.parseInt(str1);

		res1 = num1 + num2;

		String res = String.valueOf(res1);

		mav.addObject("res", res);
		mav.setViewName("index");

		return mav;
	}
}
