package com.smnam.springboot;

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController 
{
	 
		/**
		 * 	@fn		public ModelAndView index(ModelAndView mav)
		 *	@brief	초기 페이지 설정
		 *	@details
		 *
		 *	@author	권연준
		 *	@date	2019-05-16
		 
		 *	@param
		 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-16; 권연준]
		 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	HTML에서 num1~num12의 값을 받고 5월의 최종 사용금액과 배열을 이용해 2019년 평균 사용금액 계산
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-16
	 *
	 *	@param	int num1~num12      HTML에서 입력받는 숫자 저장
	 *	@param	double total  	       전체요금 = 기본요금 +(사용량*kw당 사용요금)
	 *	@param	double totalTax		최종사용요금 = 전체요금 * 세금 세금=9%
	 *	@param	double yearTotal	1년 총합 사용금액
	 *	@param	double yearAvg		1년 평균 사용금액
	 *
	 *	@remark	올해 평균 사용 요금을 구하기 위해서 [2019-05-16; 권연준]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")int num1, 
							 @RequestParam("num2")int num2,
							 @RequestParam("num3")int num3, 
							 @RequestParam("num4")int num4, 
							 @RequestParam("num5")int num5, 
							 @RequestParam("num5")int num6, 
							 @RequestParam("num5")int num7, 
							 @RequestParam("num5")int num8, 
							 @RequestParam("num5")int num9, 
							 @RequestParam("num5")int num10, 
							 @RequestParam("num5")int num11, 
							 @RequestParam("num5")int num12, 
							 ModelAndView mav) {
		
		int [] array = {num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12};
		double total = (660 + (array[4] * 88.5));
		double totalTax = total * 1.09;
		double yearTotal = 0;
		double yearAvg = 0;
		
		for (int i=0; i<array.length; i++) {
			yearTotal =  yearTotal + ((660 + ( array[i] * 88.5))*1.09);
		}
		yearAvg = yearTotal/array.length;
		
		mav.addObject("res", "5월 최종 사용금액 : " + totalTax + " 2019년 평균 사용금액 : " + yearAvg);
		mav.setViewName("index");
		return mav;
	}
}
