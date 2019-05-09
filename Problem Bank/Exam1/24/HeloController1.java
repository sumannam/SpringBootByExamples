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
	 * 	@fn	public ModelAndView send
	 *	@brief	url에서 숫자를 받아 환율 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 *
	 *	@param	
	 *	@remark 환율 결과 출력을 위해 res 선언 [2019-05-09; 한예나]
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