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
            mav.addObject("msg","숫자를 입력해주세요");
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
	 *	@param		int			한계 값을 받아요!
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		홀수 만을 처리 한 값을 위해 int count 선언
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("number")int number,
    						 ModelAndView mav) {
		
		int count = 0;
		
		for(int i = 1; i<= number; i++) {
		if(i%2 == 1) {
			count = count + i;
		}
		}
		
		
    	String counts = String.valueOf(count);
  
    	mav.addObject("counts",counts);
    	mav.setViewName("indexdemo");
    	return mav;
    }
}