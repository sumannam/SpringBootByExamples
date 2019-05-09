package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
        mav.addObject("res","숫자입력");
		return mav;
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam(value="num1",required=false)String str1,
			@RequestParam(value="num2",required=false)String str2,
			ModelAndView mav) {
		int resPlus = 0;
		int resMinus = 0;
		int resMultiply = 0;
		int resDivision = 0;
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		resPlus = num1 + num2;
		resMinus = num1 - num2;
		resMultiply = num1 * num2;
		resDivision = num1/num2;
		
		String resPlus1 = String.valueOf(resPlus);
		String resMinus1 = String.valueOf(resMinus );
		String resMultiply1 = String.valueOf(resMultiply);
		String resDivision1 = String.valueOf(resDivision);
		mav.addObject("res",resPlus1);
		mav.addObject("res",resMinus1);
		mav.addObject("res",resMultiply1);
		mav.addObject("res",resDivision1); 
		mav.setViewName("index");
		return mav;
	}
}
