package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @fn 		ModelAndView index(ModelAndView mav) , ModelAndView send
 * @brief 	1부터 n까지 입력받은 숫자의 홀수값을 더한다.
 * @author 	최지은
 * @date 	2019-05-16
 * @version 1
 * */

@Controller
public class HeloController2 {
	/**
	 * @brief 	index를 불러온다
	 * @param 	RequestMapping 
	 * @param 	RequestParam
	 * @param 	total
	 * @param	number
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index2");
		mav.addObject("res");
		return mav;
	}
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1"
					  ,required=false)int number
					  ,ModelAndView mav) {		
			
			int total = 0;
			
			for(int i=0; i < number; i++) {
				if(number%2 != 0) {
					total += i;
				}
			}
						
			mav.addObject("res", total);
			mav.setViewName("index2");
			return mav;
	}


}
