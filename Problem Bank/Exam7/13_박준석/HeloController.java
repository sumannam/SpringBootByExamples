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
	 * @param usage			사용요금
	 * @param mayUsage  	5월 사용량
	 * @param finalMayUsage 5월 최종사용량
	 * @return
	 */

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="usage", required=false)int usage
							,ModelAndView mav) {
		
		if(usage < 0) {
			mav.addObject("res", "올바른 값이 아닙니다.");
			mav.setViewName("index");
			return mav;
		}
		
		final int basicCharge = 660;			//기본요금
		final double kw = 88.5, tex = 0.09;	//kw간 사용 요금, 세금
		int mayUsage = 0, 
			finalMayUsage = 0, 
			averageCost = 0, 
			allCost = 0;
		
		mayUsage = (int) (basicCharge + (usage * kw));		//5월 사용량 계산
		finalMayUsage = (int) (mayUsage * tex);				//5월 최종 사용량 합산 값
		
		int[] charge = {20580, 15720, 32300, 25120 , finalMayUsage};	//1월~5월 사용량 요금배열 값
		
		for(int i=0; i<charge.length; ++i) 
			allCost += charge[i];				//총 사용금액
		
		averageCost = allCost/charge.length;	//2019년 평균사용금액
		
		mav.addObject("res", "5월 최종 사용금액 : " + finalMayUsage + "원 " +  "\t2019년 평균 사용금액 : " + averageCost + "원");
		mav.setViewName("index");
		return mav;
	}
}
