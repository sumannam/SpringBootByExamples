package com.yena.springboot;

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
	 *	@author	한예나
	 *	@date	2019-05-16
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-16; 한예나]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	may_use의 값을 받아 5월의 전기 사용량을 계산하고 배열을 이용해 올해의 평균 사용 요금 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-16
	 *
	 *	@param	int may_use      HTML에서 입력받는 숫자 저장
	 *			ModelAndView mav ModelAndView 변수
	 *
	 *	@remark	총합 결과 출력을 위해 sum 선언
	 *			평균 결과 출력을 위해 avg 선언 [2019-05-16; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("may_use")int may_use,
							 ModelAndView mav) {

		double total = 660 + (may_use * 88.5);
		double last = total*1.09;
		
		double [] array = {20580, 15720, 32300, 25120, last};
		int sum = 0;
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
		}
		
		double avg = sum/array.length;
		
		mav.addObject("may_use", "5월 최종 사용 금액 : " + last);
		mav.addObject("avg", "2019년 평균 사용 금액 : " + avg);
		mav.setViewName("index");
		return mav;
	}
}