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
            mav.addObject("msg","오늘의 환율은");
            return mav;
    }
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,ModelAndView mav)
	 *	@brief		환율을 계산하기 위한  변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		환율계산값을 출력하기위한 res 선언[2019-05-09; 양승호] \n
	 *  			정수 변환을 위한 Integer.paraseInt 선언[2019-05-09; 양승호] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("num1")String str1,
    						 ModelAndView mav) {
    						int res = 0;
    						int f = 1172;
    						res = Integer.parseInt(str1)*f;
            mav.addObject("msg",res);
            mav.setViewName("index");
            return mav;
    }
}