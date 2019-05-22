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
	 * @fn	  send(@RequestParam(value="num", required=false)int num
							 , ModelAndView mav)	
	 * @brief 1~N 까지 홀수 값의 합
	 * 
	 * @author 	박준석
	 * @date	[2019-05-16]
	 * 
	 * @param num		최대 n값
	 * @param i			num까지 1씩 증가 하는 변수 값
	 * @param even		i 값을 나눌 짝수 값
	 * @param mav		템플릿 반환 값
	 * @return
	 */
	

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="num", required=false)int num
							 , ModelAndView mav) {
		
		
		final int even = 2;		// 나누는 값 상수화
		int sum = 0;
		
		for(int i=1; i<=num; ++i) {
			if(i % even == 1)
				sum += i;
		}
		
		mav.addObject("res", "1 ~ " + num + "까지의 홀수들의 총 합 " + sum);
		mav.setViewName("index");
		return mav;
	}
}
