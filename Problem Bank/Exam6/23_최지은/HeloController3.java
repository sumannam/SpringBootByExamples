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
 * @brief 	1부터 n까지 입력받은 숫자의 홀수값을 더한다.
 * @author 	최지은
 * @date 	2019-05-16
 * @version 1
 * */

@Controller
public class HeloController3<DataObject> {
	/**
	 * @brief 	index를 불러온다
	 * @param 	RequestMapping 
	 * @param 	RequestParam
	 * @param 	total
	 * @param <Integer>
	 * @param	Average
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index3");
		mav.addObject("res");
		return mav;
	}
		
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="score1"
					  ,required=false)int score1,
		@RequestParam(value="score2"
		  			  ,required=false)int score2,
		@RequestParam(value="score3"
		  			  ,required=false)int score3,
		@RequestParam(value="score4"
		  			  ,required=false)int score4,
		@RequestParam(value="score5"
		  			  ,required=false)int score5
					  ,ModelAndView mav) {		
			
		int total = 0;
		int Average = 0;
		
		ArrayList<Integer> student  = new ArrayList<Integer>();
		student.add(score1);
		student.add(score2);
		student.add(score3);
		student.add(score4);
		student.add(score5);
		
		for(int i=0; i < student.size(); i++) {
			total += i;
			
		}
		Average = total/student.size();
					
		mav.addObject("total", total);
		mav.addObject("Average", Average);
		mav.setViewName("index3");
		return mav;
	}

}
