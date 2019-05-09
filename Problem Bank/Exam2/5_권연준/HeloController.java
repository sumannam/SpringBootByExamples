package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController {
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-09
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-09; 권연준]
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
        mav.addObject("res","숫자입력");
		return mav;
	}

	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input box에서 num1, num2를 받아 덧셈/뺄셈/곱셈/나눗셈 계산
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-09
	 *
	 *	@param	resPlus = 덧셈
	 *  @param	resMinus = 뺄셈
	 *  @param	resMultiply = 나눗셈
	 *  @param	resDivision = 곱셈
	 *	@remark 4칙연산 결과를 위해 res1~res4 선언 [2019-05-09; 권연준]
	 */
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1",required=false)String str1,
		@RequestParam(value="num2",required=false)String str2,
		ModelAndView mav) {
		
		int resPlus = 0;
		int resMinus = 0;
		int resMultiply = 0;
		int resDivision = 0;
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		resPlus = num1 + num2;
		resMinus = num1 - num2;
		resMultiply = num1 * num2;
		resDivision = num1/num2;
		
		String resPlus1 = String.valueOf(resPlus);
		String resMinus1 = String.valueOf(resMinus );
		String resMultiply1 = String.valueOf(resMultiply);
		String resDivision1 = String.valueOf(resDivision);
		
		mav.addObject("res1",num1 + "+" + num2 + "=" + resPlus1);
		mav.addObject("res2",num1 + "+" + num2 + "=" + resPlus1);
		mav.addObject("res3",num1 + "-" + num2 + "=" + resMinus1);
		mav.addObject("res4",num1 + "*" + num2 + "=" + resMultiply1);
		mav.addObject("res5",num1 + "/" + num2 + "=" + resDivision1); 
		mav.setViewName("index");
		
		return mav;
	}
}
