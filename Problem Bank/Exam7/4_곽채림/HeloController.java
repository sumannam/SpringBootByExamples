package com.kwackchaelim.springboot;

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
	public ModelAndView send(@RequestParam("system")int str,ModelAndView mav) {
		
		double price = 660 + (str * 88.5);
		double total = price * 1.09;
		
			
		double[] array = {20580, 15720 , 32300, 25120, total};
			
		int sum = 0;

			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}

			double avg = sum/ array.length;
		
		mav.addObject("res", "5월사용량 ="+total);
		mav.addObject("res1", "2019년 평균사용 ="+ avg);
		mav.setViewName("index");
		
		return mav;
	}
}