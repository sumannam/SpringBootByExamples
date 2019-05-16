package com.yena.springboot;

import org.springframework.web.bind.annotation.PathVariable;
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
	 * 	@fn			public ModelAndView send(@PathVariable int num, ModelAndView mav)
	 *	@brief		함수 설명: url에서 숫자를 받아 환율 계산
	 *	@details	함수 상세 설명
	 *
	 *	@author		한예나
	 *	@date		2019-05-09
	 *
	 *	@param		int 			num	HTML에서 입력받는 숫자 저장
	 *	@param		ModelAndView 	mav ModelAndView 변수
	 *
	 *	@return		mav	HTML에 처리할 값 저장
	 *
	 *	@remark 	환율 결과 출력을 위해 res 선언 [2019-05-09; 한예나]
	 */
	@RequestMapping("/{num}")
	public ModelAndView send(@PathVariable int num,
							 ModelAndView mav) {
					
		int	result = num*1172;
			
		String res = String.valueOf(result);
		
		mav.addObject("res", "오늘의 환율은 : " + res);
		mav.setViewName("index");
		return mav;
	}
}