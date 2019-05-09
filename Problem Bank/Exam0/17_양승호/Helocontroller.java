package com.ho.springboot;

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
	 *	@brief		초기페이지 설정
	 *
	 *	@author		양승호
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		페이지를 보여주기 위한 것[2019-05-09; 양승호] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","숫자를 더해주세요");
            return mav;
    }
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("num1")String str1, @RequestParam("num2")String str2,ModelAndView mav)
	 *	@brief		더하기 위한 값 변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		덧셈결과값을 출력하기위한 result 선언[2019-05-09; 양승호] \n
	 *  			정수 변환을 위한 Integer.paraseInt 선언[2019-05-09; 양승호] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("num1")String str1,
    						 @RequestParam("num2")String str2,
    						 ModelAndView mav) {
            int res = Integer.parseInt(str1)+Integer.parseInt(str2);
            mav.addObject("msg",res);
            mav.setViewName("index");
            return mav;
    }
}