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
	 *	@date	2019-05-22
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-22; 권연준]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	may의 값을 받아 배열을 이용하여 1~5월 총 사용금액을 계산하고 올해의 평균 사용 요금 계산
	 *	@details
	 *
	 *	@author 권연준
	 *	@date	2019-05-22
	 *
	 *	@param	may     HTML에서 입력받는 숫자 저장
	 *			total	5월 전체요금
	 *			tax		세금 9%
	 *
	 *	@remark	총합 결과 출력을 위해 sum 선언
	 *			평균 결과 출력을 위해 avg 선언 [2019-05-22; 권연준]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("may")int may,
							 ModelAndView mav) {
		
		double tax = total * 1.09;
		double total = 660 + (may * 88.5);
		double [] array = {20580, 15720, 32300, 25120, tax};
		int sum =0;
		double avg = 0;
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
		}
		avg = sum/array.length;
		
		mav.addObject("res", "5월 사용금액 : " + tax + " 2019년 평균 사용금액 : " + yearAvg);
		mav.setViewName("index");
		return mav;
	}
}
