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
	 * 	@remark		웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 김성택] \n
	 *				
	 *
	 */
	
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("msg","사칙연산");
                
                return mav;
        }

		/**
		 *
		 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,ModelAndView mav)
		 *
		 *	@brief		폼에 num에 문자열로 받아옴
		 *
		 *	@author		김성택
		 *	@date		2019-05-09
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		결과를받아와서 값을저장
		 *				값을 계산후 출력 [2019-05-09; 김성택] \n
		 *
		 */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num1")String str1,
        						@RequestParam("num2")String str2,
        						@RequestParam("num3")String str3,
        						@RequestParam("num4")String str4,
        						@RequestParam("num5")String str5,
        						@RequestParam("num6")String str6,
        						@RequestParam("num7")String str7,
        						@RequestParam("num8")String str8,
        						ModelAndView mav) {
        	
        	int result = Integer.parseInt(str1);
        	int result2 = Integer.parseInt(str2);
        	int result3 = Integer.parseInt(str3);
        	int result4 = Integer.parseInt(str4);
        	int result5 = Integer.parseInt(str5);
        	int result6 = Integer.parseInt(str6);
        	int result7 = Integer.parseInt(str7);
        	int result8 = Integer.parseInt(str8);
        	
        	int plus = result + result2;
        	int minus = result3 + result4;
        	int	multiply = result5 + result6;
        	int division = result7 + result8;
        	
        	
            mav.addObject("msg1",plus);
            mav.addObject("msg2",minus);
            mav.addObject("msg3",multiply);
            mav.addObject("msg4",division);
            mav.setViewName("index");
            return mav;
        }
}