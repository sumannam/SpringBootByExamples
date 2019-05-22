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
	public ModelAndView send(@RequestParam("num1")int str, ModelAndView mav) {
		
		double May = (660 + (str * 88.5))*1.09;
		
		double Avg = 0;
		double sum = 0;
		double[] array = {20580, 15720, 32300, 25120, May};
		
		for(int i = 0; i < array.length; i++) {
				sum += array[i];
				Avg = sum/5;
		}
		
		mav.addObject("res", "5월 최종 사용 금액은 : " + May + "  2019년 평균 사용 금액은 : " + Avg);
		mav.setViewName("index");

		return mav;
	}
}