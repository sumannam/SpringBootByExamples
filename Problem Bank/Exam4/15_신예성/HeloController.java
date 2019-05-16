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
	public ModelAndView send(@RequestParam("num1")String name,@RequestParam("num2")double kg, @RequestParam("num3")double m, ModelAndView mav) {
		double bmi = kg/(m*m);
		
		if (bmi <= 18.5) {
			mav.addObject("res", "저체중입니다");
		}
		
		else if (18.5 < bmi && bmi <= 25) {
			mav.addObject("res","정상입니다");
		}
		
		else if (25 < bmi && bmi <= 30) {
			mav.addObject("res","과체중입니다");
		}
		
		else if (bmi > 30) {
			mav.addObject("res","비만입니다");
		}
		
		mav.addObject("res1", name + "님의 bmi는" + bmi + "입니다");
		mav.setViewName("index");

		return mav;
	}
}