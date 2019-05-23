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
		mav.addObject("msg","점수를 입력해주세요");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="a", required=false)int a,
		@RequestParam(value="b", required=false)int b,
		@RequestParam(value="c", required=false)int c,
		@RequestParam(value="d", required=false)int d,
		@RequestParam(value="e", required=false)int e,
		ModelAndView mav) {
		
		int sum=a+b+c+d+e;
		int avg = sum/5;
		
		mav.addObject("당신의 총점은"+sum);
		mav.addObject("당신의 평균는"+avg);
		return mav;
	}
}
