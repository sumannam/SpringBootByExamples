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
	 *	@date	2019-05-09
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-09; 한예나]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input에서 num을 받아 환율 계산
	 *	@details
	 *
	 *	@author	한예나
	 *	@date	2019-05-09
	 *
	 *	@param	
	 *	@remark 환율 결과 출력을 위해 res 선언 [2019-05-09; 한예나]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num")String num,
							 ModelAndView mav) {
		
		int Num, result = 0;
		String res = "";
		
		try {
			Num = Integer.parseInt(num);
			
			result = Num*1172;
			
			res = String.valueOf(result);
			
		} catch(NullPointerException e) {
			res += "null";
		}
		
		mav.addObject("res", res);
		mav.setViewName("index");
		return mav;
	}
}