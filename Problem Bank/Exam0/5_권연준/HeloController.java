package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {		
	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		초기 페이지 설정
	 *
	 *	@author		권연준
	 *	@date		2019-05-09
	 *
	 *	@param		mav	ModelAndView
	 *
	 * 	@remark		초기페이지 설정[2019-05-09; 권연준]
	 *				
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
        mav.addObject("res","Form에 숫자를 입력하세요(더하기)");
		return mav;
	}
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,
	 *										 @RequestParam("num2")String str2, ModelAndView mav)
	 *	@brief		form에 num1, num2에 있는 값을 받아서 str1,str2에 넣음
	 *
	 *	@author		권연준
	 *	@date		2019-05-09
	 *
	 *	@param		mav	ModelAndView
	 *
	 * 	@remark		더하기를 결과를 보려고 res 선언함 [2019-05-09; 권연준] 
	 *				문자열을 정수로 변환하기 Integer.ParseInt[2019-05-09; 권연준]
	 *				정수를 문자열로 변환하지 않고 값 반환해줌 
	 *
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam(value="num1",required=false)String str1,
			@RequestParam(value="num2",required=false)String str2,
			ModelAndView mav) {
		int res = 0;
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		res = num1 + num2;
		mav.addObject("res",res); 
		mav.setViewName("index");
		return mav;
	}
	
	
}

