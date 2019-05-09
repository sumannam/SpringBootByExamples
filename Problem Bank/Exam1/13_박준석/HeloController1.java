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
public class HeloController1 
{
	/**
	 * @fn 	  	ModelAndView index()
	 * @brief 	ModelAndView index 함수 정의
	 * 
	 * @author 	박준석
	 * @date	2019-05-09
	 * @param 	num		달러 값 
	 * @param 	won 	달러대비 원화 값	
	 * @param 	res 	환율적용 원화 값
	 * @return  mav 	index template 반환
	 */
	@RequestMapping(value="/{num}", method=RequestMethod.GET)
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		int res=0;
		final int won = 1172;	//값의 변경을 방지하기 위해 달러대비원화 값 상수화
		
		try{		
			res = num * won;
		}catch(NullPointerException e) {
			res = 0;
		}
		mav.addObject("msg", "exchange rate dollar to won : " + res+"won");
		mav.setViewName("index");
		return mav;
	}
}

