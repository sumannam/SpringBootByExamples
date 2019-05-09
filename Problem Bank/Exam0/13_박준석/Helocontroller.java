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
	 * @return mav 		setviewName으로 받은 index html
	 * 
	 * @remark get방식으로 사용자로부터 보여지는 프론트엔드 페이지를 반환해 처리 
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 
	 * @param str1		html로 부터 받은 num1 값
	 * @param str2		html로 부터 받은 num2 값
	 * @param mav		ModelAndView 클래스의 인스턴스
	 * @return			인스턴스 반환
	 * 
	 * @remark		매개변수로 받은 문자열 num1과 num2를 정수로 변환해 계산 후 처리
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="num1",required=false)String str1
							 ,@RequestParam(value="num2",required=false)String str2
							 , ModelAndView mav) {
		
		String res="";
		int num1 = Integer.parseInt(str1);		//문자열 정수로 변환
		int num2 = Integer.parseInt(str2);		//문자열 정수로 변환
		try {
			int result = num1 + num2;
			res = String.valueOf(result);		//결과값을 문자열로 변환
			
		} catch(NullPointerException e) {
			res += "null";
		}
		mav.addObject("msg", res);
		mav.setViewName("index");
		return mav;
	}
}
