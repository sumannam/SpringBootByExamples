package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController1 {
	/**
	 * 	@fn	public ModelAndView send
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-09
	 *
	 *	@param	
	 *	@remark 환율 결과를 위해 res 선언 [2019-05-09; 권연준]
	 */
	@RequestMapping("/{num}")
	public ModelAndView send(@PathVariable int num,
							 ModelAndView mav) {
					
		int	result = num * 1172;
			
		String res = String.valueOf(result);
		
		mav.addObject("res", "환율값 : " + res + "won");
		mav.setViewName("index");
		return mav;
	}
}
