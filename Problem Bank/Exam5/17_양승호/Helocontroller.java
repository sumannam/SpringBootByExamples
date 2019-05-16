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
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView
	 *  @remark		페이지를 보여주기 위한 것[2019-05-16; 양승호] \n
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
	 *	@fn			public ModelAndView send(@RequestParam("num")int num,ModelAndView mav)
	 *	@brief		홀수합을 계산하기 위해 변수선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView
	 *  @remark		홀수 합을 계산하기 위해 sum선언,[2019-05-16; 양승호] \n
	 *  
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						@RequestParam("num")int num,
    						ModelAndView mav) {
    	int sum = 0;
    	for (int i =0; i<=num; i++) {
    		if(i%2==1) {
    		sum += i;
    	}
    }
    	
    	mav.addObject("res",sum);
    	
    	mav.setViewName("index");
    	return mav;
    }
}