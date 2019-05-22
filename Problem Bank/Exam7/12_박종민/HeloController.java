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
		mav.addObject("res","5월 전기사용량을 입력하세요");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="a", required=false)int a,
		ModelAndView mav) {
		
		double b = 600+(a*88.5);
		double c = b*1.09;
		double avg = (20580+15720+32300+25120+ c)/5;
		
		mav.addObject("res","5월 최종 사용금액:" +c);
		mav.addObject("res"+"2019년 평균 사용금액:"+ avg);
		
		return mav;
		
	}
}