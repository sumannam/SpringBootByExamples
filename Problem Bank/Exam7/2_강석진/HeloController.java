package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * @brief	초기 페이지 설정
	 *
	 * @author	강석진
	 * @date 	2019-05-16
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-16; 강석진] \n
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("month", "5월 전기 사용량을 입력해주세요 (kw)");
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView send(@RequestParam("student") int[] student, ModelAndView mav)
	 *                              
	 * @brief	FORM에 있는 값을 정수 배열로 받아옴
	 *
	 * @author 	강석진
	 * @date	2019-05-16
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	반복분에 .length를 사용하여 배열의 길이만큼 반복문을 처리 	[2019-05-16; 강석진] \n 
	 *			(총점  / 학생수) 처리를 위해 .length 재이용			[2019-05-16; 강석진] \n 
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("used") int used, ModelAndView mav) {
		
		int[] month = { 20580, 15720, 32300, 25120, 0 };
		
		int total = 0;
		int average = 0;
		
		double charge = 660 + (used * 88.5);
		double tax = Math.round((charge * 1.06));
		
		month[4] = (int)tax;
		
		for(int i = 0; i < month.length; i++) {
			total += month[i];
		}
		
		average = total / month.length;

		mav.addObject("month", "5월 최종 사용금액 : " + month[4]);
		mav.addObject("average", "2019 평균 사용금액 : " + average);
		
		mav.setViewName("index");
		
		return mav;
	}
}