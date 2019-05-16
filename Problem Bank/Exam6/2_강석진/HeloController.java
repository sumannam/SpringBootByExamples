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
		mav.addObject("msg", "점수를 입력해주세요");
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
	public ModelAndView send(@RequestParam("student") int[] student, ModelAndView mav) {
		
		int score_AMT = 0;
		
		for(int i = 0; i < student.length; i++) {
			score_AMT += student[i];
		}
		
		int score_AVG = score_AMT / student.length;

		mav.addObject("msg", "총점 : " + score_AMT);
		mav.addObject("msg1", "평균 : " + score_AVG);
		
		mav.setViewName("index");
		
		return mav;
	}
}