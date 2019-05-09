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
            mav.addObject("msg","정수를 입력해주세요");
            return mav;
    }
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("num1")int str1,@RequestParam("num2")int num2,ModelAndView mav)
	 *	@brief		사칙연상을 계산하기 위한  변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		환율계산값을 출력하기위한 res1,res2,res3,res4 선언[2019-05-09; 양승호] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("num1")int num1,
    						 @RequestParam("num2")int num2,
    						 ModelAndView mav) {
    	int res1 = num1+num2;
    	int res2 = num1-num2;
    	int res3 = num1*num2;
    	int res4 = num1/num2;
    
    	mav.addObject("res1",num1+"+"+num2+"="+res1);
    	mav.addObject("res2",num1+"-"+num2+"="+res2);
    	mav.addObject("res3",num1+"x"+num2+"="+res3);
    	mav.addObject("res4",num1+"/"+num2+"="+res4);
    	mav.setViewName("index");
    	return mav;
    }
}