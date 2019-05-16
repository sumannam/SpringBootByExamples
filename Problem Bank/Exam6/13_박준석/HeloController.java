package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController 
{
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * @fn	  public ModelAndView send(@RequestParam(value="subject", required=false)int []subject
									   ,ModelAndView mav)
								
	 * @brief 	input 태그에서 입력 값을 배열로 받아옴
	 * 
	 * @author 	박준석
	 * @date	[2019-05-16]
	 * 
	 * @param sum			총 합
	 * @param average		과목 평균 값
	 * @param subjectNumber	과목 갯 수
	 * @return
	 */
	

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="subject", required=false)int []subject
							,ModelAndView mav) {
		
		int sum = 0, average = 0, subjectNumber = subject.length;
		
		for(int i=0; i<subjectNumber; ++i) 
			sum += subject[i];
	
		average = sum/subjectNumber;
		
		mav.addObject("res", "다섯 과목의 평균 값은 " + average + " 입니다.");
		mav.setViewName("index");
		return mav;
	}
}
