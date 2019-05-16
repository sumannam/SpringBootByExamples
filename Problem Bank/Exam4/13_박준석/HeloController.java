package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController 
{
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * @fn 	  	send  		BMI 지수를 계산하는 함수  
	 * @author 	박준석
	 * 
	 * @param 	tall		키 값
	 * @param 	weight		몸무게 값
	 * 
	 * @return 	mav			템플릿 값 반환
	 */

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="tall", required=false)double tall
							 ,@RequestParam(value="weight", required=false)double weight
							 , ModelAndView mav) {
		
		
		double bmi = weight / (tall * tall); 		//BMI 지수 값 구하기
		
		
		if(bmi > 0 || bmi <= 18.5) {
			mav.addObject("res", "당신의 체중 상태는 저체중 입니다.");
		}
		else if (bmi > 18.5 || bmi <= 24.9) {
			mav.addObject("res", "당신의 체중 상태는 정상 입니다.");
		} 
		else if(bmi >= 25 || bmi <= 29.9) {
			mav.addObject("res", "당신의 체중 상태는 과체중 입니다.");
		}
		else if(bmi >= 30) {
			mav.addObject("res", "당신의 체중 상태는 비만 입니다.");
		}
		else {
			mav.addObject("입력 값이 적절하지 않습니다.");
		}
		
		
		mav.setViewName("index");
		return mav;
	}
}
