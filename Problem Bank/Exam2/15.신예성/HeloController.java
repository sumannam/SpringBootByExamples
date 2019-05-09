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
	public ModelAndView send(@RequestParam("num1")String str, @RequestParam("num2")String str1, ModelAndView mav) {
		int res1=0;
		int res2=0;
		int res3=0;
		int res4=0;
		
		int num1 = Integer.parseInt(str);
		int num2 = Integer.parseInt(str1);

		res1 = num1 + num2;
		res2 = num1 - num2;
		res3 = num1 * num2;
		res4 = num1 / num2;

		String res01 = String.valueOf(res1);
		String res02 = String.valueOf(res2);
		String res03 = String.valueOf(res3);
		String res04 = String.valueOf(res4);

		mav.addObject("res", "두자리 정수:" + num1 + num2);
		mav.addObject("res01",num1 + "+" + num2 + "=" + res01);
		mav.addObject("res02",num1 + "-" + num2 + "=" + res02);
		mav.addObject("res03",num1 + "*" + num2 + "=" + res03);
		mav.addObject("res04",num1 + "/" + num2 + "=" + res04);
		mav.setViewName("index");
		
		return mav;
	}
}

