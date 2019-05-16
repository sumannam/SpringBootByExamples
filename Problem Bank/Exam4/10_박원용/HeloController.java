
package com.wonyong.springboot;

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
	public ModelAndView send(@RequestParam("num1")String name,
			                 @RequestParam("num2")double weight,
			                 @RequestParam("num3")double height,ModelAndView mav) {
		
		
		double BMI = weight/(height*height);
		
		if(BMI<=18.5) {
			mav.addObject("res","당신은 저체중입니다");
		}
		
		else if(BMI>=18.5 && BMI<=24.9) {
			mav.addObject("res","당신은 정상 체중입니다");
		}
		
		else if(BMI>=25 && BMI<=29.9) {
			mav.addObject("res","당신은 정상 체중입니다");
		}
		
		else {
			mav.addObject("res","당신은 정상 체중입니다");
			
		}

		mav.addObject("res1", "당신의 BMI는 "+BMI);
		mav.setViewName("index");

		return mav;
	}
}