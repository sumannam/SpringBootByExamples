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
        mav.addObject("res","이름과 키, 몸무게를 입력하세요.");
		return mav;
	}

	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input box에서 weight(몸무게)와 height(키)의 입력값을 받아 몸무게/(키*키)
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-05-16
	 *
	 *	@param	resPlus = 덧셈
	 *  @param	res = 체질량지수(BMI)
	 *  
	 *	@remark 자신의 체중질량이 정상인지 알기 위해서 [2019-05-16; 권연준]
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send( @RequestParam(value="name",required=false)String name,
							  @RequestParam(value="height",required=false)double height,
							  @RequestParam(value="weight",required=false)double weight,
							  ModelAndView mav) {
		
		double res = 0;
		res = weight / ((height/100) * (height/100));
		
		if (res <= 18.5) {
			mav.addObject("res",name + "님의 체질량지수(BMI): " + res);
			mav.addObject("res2","저체중입니다.");
			mav.setViewName("index");
		} else if (res<25) {
			mav.addObject("res",name + "님의 체질량지수(BMI): " + res);
			mav.addObject("res2","정상입니다.");
			mav.setViewName("index");
		} else if (res<30) {
			mav.addObject("res",name + "님의 체질량지수(BMI): " + res);
			mav.addObject("res2","과체중입니다.");
			mav.setViewName("index");
		} else {
			mav.addObject("res",name + "님의 체질량지수(BMI): " + res);
			mav.addObject("res2","비만입니다.");
		}
		
		mav.setViewName("index");
		return mav;
	}
}
