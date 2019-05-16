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
	 *	@date		2019-05-13
	 *
	 *	@param		mav ModelAndView
	 *  @remark		페이지를 보여주기 위한 것[2019-05-13; 양승호] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","년도를 입력해주세요");
            return mav;
    }
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("birth")int birth,ModelAndView mav)
	 *	@brief		나이를 계산하기 위한  변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-13
	 *
	 *	@param		mav ModelAndView
	 *  @remark		나이를 계산하기위한 year 선언[2019-05-13; 양승호] \n
	 *         		year-birth+1을 해서 현재 나이 계산[2019-05-13; 양승호] \n
     
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("birth")int birth,
    						 ModelAndView mav) {
    	int year = 2019;
    	
    
    	mav.addObject("msg",(year-birth+1)+"세 입니다.");
    	mav.setViewName("index");
    	return mav;
    }
}