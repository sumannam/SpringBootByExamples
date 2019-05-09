package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController1 {
	
	/**
	 *
	 * @fn 		public ModelAndView send(@PathVariable("usd") int usd, ModelAndView mav)
	 * 			
	 * @brief 	url에 입력된 값을 변수 usd에 선언
	 *
	 * @author 	강석진
	 * @date 	2019-05-09
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	현재 환율과 결과값을 저장하기 위한 변수 선언 [2019-05-09; 강석진] \n 
	 *			addObject를 사용해 FORM에 출력 [2019-05-09; 강석진] \n
	 *         
	 */
	@RequestMapping(value = "/{usd}")
	public ModelAndView send(@PathVariable("usd") int usd, ModelAndView mav) {
		
		int krw = 1172;
		int res = krw * usd;
		
		mav.addObject("value1", usd);
		mav.addObject("value2", res);
		mav.addObject("msg", "1 USD = " + krw + "원");
		mav.setViewName("index2");
		
		return mav;
	}
}