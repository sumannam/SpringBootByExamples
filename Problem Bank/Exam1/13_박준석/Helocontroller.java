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
	/**
	 * *
	 * @param 
	 * @return mav 		setviewName�로 받� index html
	 * 
	 * @remark get방식�로 �용�로부보여지�론�엔�이지�반환처리 
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 
	 * @param str1		html�부받� num1 �
	 * @param str2		html�부받� num2 �
	 * @param mav		ModelAndView �래�의 �스�스
	 * @return			�스�스 반환
	 * 
	 * @remark		매개변�로 받� 문자num1�num2륕수�변�해 계산 처리
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="num1",required=false)String str1
							 ,@RequestParam(value="num2",required=false)String str2
							 , ModelAndView mav) {
		
		String res="";
		int num1 = Integer.parseInt(str1);		//문자�수�변
		int num2 = Integer.parseInt(str2);		//문자�수�변
		try {
			int result = num1 + num2;
			res = String.valueOf(result);		//결과값을 문자�로 변
			
		} catch(NullPointerException e) {
			res += "null";
		}
		mav.addObject("msg", res);
		mav.setViewName("index");
		return mav;
	}
}
