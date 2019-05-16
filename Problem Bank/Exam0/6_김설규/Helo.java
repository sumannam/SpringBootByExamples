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
	 *	@param		int			더하기를 처리할 num1,num2를 받음
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		더하기가 처리된 값을 res에 옴긴 후 mav저장
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num1")String num1, 
							 @RequestParam("num2")String num2, 
							 ModelAndView mav) {
		
		int Num1 = Integer.parseInt(num1);
		int Num2 = Integer.parseInt(num2);
		
		int res1 = Num1 + Num2;
		
		String result = String.valueOf(res1);
		
		mav.addObject("result", result);
		mav.setViewName("indexdemo");
		return mav;
	}
}