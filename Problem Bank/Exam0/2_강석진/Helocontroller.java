package com.jin.springboot;

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
		 *	@author		강석진
		 *	@date		2019-05-09
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 강석진] \n
		 *				
		 *
		 */
	
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("msg","더하기 할 숫자를 입력하세요");
                return mav;
        }

		/**
		 *
		 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,
		 *										 @RequestParam("num2")String str2, ModelAndView mav)
		 *
		 *	@brief		폼에 num1, num2에 있는 값을 str1,str2에 문자열로 받아옴
		 *
		 *	@author		강석진
		 *	@date		2019-05-09
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		덧셈 결과를 출력하기 위한 result 선언 [2019-05-09; 강석진] \n
		 *				문자열을 정수로 변환하기 위한 Integer.ParseInt 사용 [2019-05-09; 강석진] \n
		 *
		 */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num1")String str1,
        						 @RequestParam("num2")String str2,
                        ModelAndView mav) {
        	int result = Integer.parseInt(str1) + Integer.parseInt(str2);
                mav.addObject("msg","result = " + result);
                mav.setViewName("index");
                return mav;
        }
}