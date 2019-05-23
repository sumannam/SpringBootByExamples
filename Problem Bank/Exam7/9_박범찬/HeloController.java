package com0;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	// 기본요금:660원 / kw당 사용 요금 88.5원
	// 세금은 전체요금의 9%
	// 전체요금=기본요금+(사용량*kw당 사용요금)
	// 최종 사용요금=전체 요금*세금
	// 5월의 사용량:Inputbox로 입력
	// 올해 평균 사용 요금 구하기(배열 사용)
	// 1월:20,580원 / 2월:15,720원 / 3월:32,300원 /4월 25,120원
	// 화면출력
	// *5월 최종 사용금액
	// *2019년 평균 사용금액;
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("tot5")String tot5,
							 ModelAndView mav) {
		
		Double sum = Double.parseDouble(tot5);

		sum = sum*88.5;
		
		int[] Array = {20580, 15720, 32300, 25120};
		
		double res = 0;
		
		for (int i = 1; i < Array.length; i ++) {
			
			res+=Array[i];
		}
		
		res+=sum;
		double avg = res/5;
		mav.addObject("sum",sum);
		mav.addObject("avg",avg);
		mav.setViewName("index");
		return mav;
	}
}
		
		