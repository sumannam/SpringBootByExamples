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
	 * 	@fn	public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 *
	 *	@param	
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	num1과 num2의 값을 받아 더함
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 *
	 *	@param	
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String num1, 
							 @RequestParam("num2")String num2, 
							 ModelAndView mav) {
		
		int Num1 = Integer.parseInt(num1);
		int Num2 = Integer.parseInt(num2);
		
		int res1 = Num1 + Num2;
		
		String res = String.valueOf(res1);
		
		mav.addObject("res", res);
		mav.setViewName("index");
		return mav;
	}
}