package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * @brief 생년을 입력하면 나이가 계산되어 나옴
 * @author 최지은
 * @date 2019-05-10
 * @version 1
 * */

@Controller
public class HeloController4 {
	/**
	 * @brief index를 불러온다
	 * @param RequestMapping SimpleDateFormat
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index4");
		mav.addObject("res");
		return mav;
	}
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1"
					  , required=false)int num1
					  , ModelAndView mav) 
	{
		SimpleDateFormat format = new SimpleDateFormat ("yyyy");
		Date time = new Date();
		
		String time1 = format.format(time);
		
		int num		= Integer.parseInt(time1);
		int year	= num1;
		int total	= 0;
		
		total = num - year;
		
		mav.addObject("res", total);
		mav.setViewName("index4");
		return mav;
	}

}
