package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @fn 		ModelAndView index(ModelAndView mav) , ModelAndView send
 * @brief 	전기 사용량을 계산하는 프로그램
 * @author 	최지은
 * @date 	2019-05-16
 * @version 1
 * */

@Controller
public class HeloController4 {
	/**
	 * @brief 	index를 불러온다
	 * @param 	RequestMapping 
	 * @param 	RequestParam
	 * @param 	<Integer>
	 * @param 	total
	 * @param	Average
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index4");
		mav.addObject("res");
		return mav;
	}
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="score1"
					  ,required=false)int usage
					  ,ModelAndView mav) {		
			
			int total = 0;
			int april=0;
			double average = 0;
			
			ArrayList<Integer> total_usage  = new ArrayList<Integer>();
			total_usage.add(20580);
			total_usage.add(15720);
			total_usage.add(32300);
			total_usage.add(25120);
			total_usage.add(usage);
			
			april = total_usage.indexOf(3);
			
			for(int i=0; i < total_usage.size(); i++) {
				total += i;	
			}
			average = total/total_usage.size();
						
			mav.addObject("april", april);
			mav.addObject("average", average);
			mav.setViewName("index4");
			return mav;
	}

}
