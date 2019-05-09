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
	/**
	 * @return	mav 	template 값 반환
	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 
	 * @param	num1	매개값 1
	 * @param 	num2	매개값 2
	 * @return	mav		template 값 반환
	 */

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="num1", required=false)int num1
							 ,@RequestParam(value="num2", required=false)int num2
							 , ModelAndView mav) {
		
		int sum=0, multi=0, sub=0, division=0;		//사칙연산 수행 변수
		
		try {
			sum = num1+num2;
			multi = num1*num2;
			sub = num1-num2;
			division = num1/num2;
			
		} catch(Exception e) {
			return mav;
		}
		
		mav.addObject("sum", sum);
		mav.addObject("multi", multi);
		mav.addObject("sub", sub);
		mav.addObject("div", division);
		mav.setViewName("index");
		return mav;
	}
}
