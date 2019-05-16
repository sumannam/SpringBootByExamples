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
	 * 
	 * @param	birth	사용자가 태어난 해
	 * @param 	year	당해 년도
	 * @return	mav		template 반환 값
	 */

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="birth", required=false)int birth, ModelAndView mav) {
		
		final int year = 2019;			//당해 년도는 값의 변경 방지를 위해 상수화
		int age = 0;		
		
		try {
			age = year - birth;		//당해 년도  - 사용자가 태어난 해 (나이 계산)
			
		} catch(Exception e) {
			return mav;
		}
		
		mav.addObject("res", "당신의 나이는 " + age + "세입니다.");
		mav.setViewName("index");
		return mav;
	}
}
