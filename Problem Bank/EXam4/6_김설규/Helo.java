package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Helo
{
	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		초기페이지
	 *	@details		
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *	@param		
	 *	@param
	 *		
	 *	@return		값을 받을 페이지 설정
	 *  @remark		indexdemo에서 값을 받는다!
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("indexdemo");
            mav.addObject("msg","키와 몸무게를 입력해주세요");
            return mav;
    }
	
	/**
	 *
	 *	@fn			public ModelAndView send(ModelAndView mav)
	 *	@brief
	 *	@details		
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *	@param		double			키와 몸무게을 받아요!
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		bmi 처리를 위해 double 선언
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("name")String name,
    						 @RequestParam("weight")double weight,
    						 @RequestParam("height")double height,
    						 ModelAndView mav) {
		
		String bmiresult = "";
		
		double bmi = weight / (height*height)*1000;
    	
    	if(bmi <= 18.5) {
    		bmiresult = "저체중";
    	}else if(bmi<24.9 ){
    		bmiresult = "정상";
    	}else if(bmi<29.9) {
    		bmiresult = "과체중";
    	}else {
    		bmiresult = "비만";
    	}
    		
    	String res = String.valueOf(bmi);
    	
    	mav.addObject("name",name);
    	mav.addObject("res",res);
    	mav.addObject("bmiresult",bmiresult);
    	
    	
    	
    	

    	mav.setViewName("indexdemo");
    	return mav;
    }
}