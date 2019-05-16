package com.smnam.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

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
	 *	@date	2019-05-16
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-05-16; 권연준]
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
        mav.addObject("res","숫자를 입력해주세요.");
		return mav;
	}

	/**
	 * 	@fn	public ModelAndView send
	 *	@brief		input box에서 num값 5개를 받아 배열로 선언한 후 for문을 돌려 합계와 평균 계산
	 *	@details
	 *
	 *	@author		권연준
	 *	@date		2019-05-16
	 *
	 *	@param  	num = html에서 숫자를 입력받은 값들
	 *	@param  	sum = 합계
	 *	@param  	avg = 평균
	 *  
	 *	@remark 	사용자의 시험점수를 입력하면 합계와 평균을 쉽게 구하기 위해서 [2019-05-16; 권연준]
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(Integer[] num, ModelAndView mav) throws Exception {
        int sum =0;
        double avg = 0;
		
		for (int i=0 ; i<num.length ; i++) {
			sum = sum + num[i];
		}
        avg = sum/num.length;
        
		mav.addObject("res","합계: " + sum +" 평균: " + avg); 
    	mav.setViewName("index");
		return mav;
	}
}
