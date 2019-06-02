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
 * @brief 	키와 몸무게를 입력하면 BMI값이 나온다.
 * @author 	최지은
 * @date 	2019-05-16
 * @version 1
 * */

@Controller
public class HeloController {
	/**
	 * @brief 	index를 불러온다
	 * @param 	RequestMapping 
	 * @param 	RequestParam
	 * @param 	total
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("res");
		return mav;
	}
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1"
					  ,required=false)String num1,
		@RequestParam(value="num2"
		  			  ,required=false)float num2,
		@RequestParam(value="num3"
		  			  ,required=false)float num3
					  ,ModelAndView mav) {		
			
			float total = 0;
			String condition = "";
			
			total = num3/(num2*num2);
			
			if(total < 18.5) {
				condition = "저체중";
			}else {
				if(18.6 < total) {
					if(total < 24.9) {
						condition = "정상";
					}
				}else {
					if(25 < total) {
						if(total < 29.9) {
							condition = "과체중";
						}
					}else {
						if(30 < total) {
							condition = "비만";
					}	
				}
			}
		}
			
			mav.addObject("res1", total);
			mav.addObject("res2", condition);
			mav.setViewName("index5");
			return mav;
	}

}
