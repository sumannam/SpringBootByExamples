package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @brief 입력받은 값을 더한다. 
 * @author 최지은
 * @date 2019-05-09
 * @version 1
 * */

@Controller
public class HeloController {
	/**
	 * @brief index를 불러온다
	 * @param RequestMapping 
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("res");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1",required=false)String num1
		,@RequestParam(value="num2",required=false)int num2
		,ModelAndView mav) {
		
			int num = Integer.parseInt(num1,num2);
		
			String res = String.valueOf(num);
		
			mav.addObject("res", res);
			mav.setViewName("index");
			return mav;
	}

}
