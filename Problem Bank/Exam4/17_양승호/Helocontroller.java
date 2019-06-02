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
	 *	@fn			public ModelAndView send(@RequestParam("name")String name,@RequestParam("height")double height,@RequestParam("weight")double weight,ModelAndView mav)
	 *	@brief		BMI를 계산하기 위한  변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView
	 *  @remark		bmi 결과를 출력하기위한 bmi선언,[2019-05-16; 양승호] \n
	 *	@remark		체중상태 결과를 출력하기위한 res선언,[2019-05-16; 양승호] \n
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						@RequestParam("name")String name,
    						@RequestParam("height")double height,
    						@RequestParam("weight")double weight,
    						ModelAndView mav) {
    	double bmi = weight/(height*height);
    	String res = "";
    	
    	if(bmi < 18.5){
    		res = "당신은 저체중입니다";
    		mav.addObject("res",res);
    	}
    	if(18.6<bmi && bmi<24.9) {
    		res ="당신은 정상입니다";
    		mav.addObject("res",res);
    	}
    	if(25.0<bmi && bmi<29.9) {
    		res ="당신은 과체중입니다";
    		mav.addObject("res",res);
    	}
    	if(30<bmi) {
    		res ="당신은 비만입니다";
    		mav.addObject("res",res);
    	}
    
    	mav.addObject("res1",bmi);
    	
    	mav.setViewName("index");
    	return mav;
    }
}