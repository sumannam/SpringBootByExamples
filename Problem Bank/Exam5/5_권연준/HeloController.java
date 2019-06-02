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
	 *	@brief		input box에서 num 입력값을 받아 for문을 돌려 홀수의 합계를 계산
	 *	@details
	 *
	 *	@author		권연준
	 *	@date		2019-05-16
	 *
	 *	@param  	num = html에서 숫자를 입력받은 값
	 *	@param  	res = 홀수의 합계
	 *  @param		if문을 사용하여 입력값이 0미만일 경우 0이상의 값을 입력하라고 출력
	 *  
	 *	@remark 	사용자가 숫자를 입력하면 홀수의 합계를 출력하기 위 [2019-05-16; 권연준]
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send( @RequestParam(value="num",required=false)int num,
							  ModelAndView mav) {
		int res = 0;
		int i = 1;
		
		mav.setViewName("index");
		
		if(num<0) {
			mav.addObject("res", "0 이상의 값을 입력해주세요." );
			return mav;
		} 
		
		for(i=1; i<=num; i++) {
			if(i%2==1) {
				res += i;
			}
		}
		mav.addObject("res", res );
 
		return mav;
	}
}
