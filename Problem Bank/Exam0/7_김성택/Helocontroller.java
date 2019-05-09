package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Helocontroller {

		/**
		 *
		 *	@fn			public ModelAndView index(ModelAndView mav)
		 *	@brief		초기 페이지 설정
		 *
		 *	@author		김성택
		 *	@date		2019-05-09
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09;김성택] 
		 *				
		 *
		 */
	
        @RequestMapping(value="/{msg}", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("msg","변환할환율");
                return mav;
        }

		/**
		 *
		 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,
		 *										 @RequestParam("num2")String str2, ModelAndView mav)
		 *
		 *	@brief		폼에 num1에 있는 값을 str1에 문자열로 받아옴
		 *
		 *	@author		김성택
		 *	@date		2019-05-09
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		 결과를 출력하기 위한 dresult 선언 [2019-05-09; 김성택] \n
		 *				
		 *
		 */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num1")String str1,
        						 
                        ModelAndView mav) {
        	int result = Integer.parseInt(str1);
        	int dresult = result/1000;
                mav.addObject("msg","result = " + dresult);
                mav.setViewName("index");
                return mav;
        }
}