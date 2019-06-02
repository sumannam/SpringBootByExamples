package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class Helo
{
	
	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		초기페이지 설정
	 *	@details	
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *			
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		환율이 처리된 값을 저장한 res 값울 mav에 저장
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
	 *	@param		
	 *  @param		
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		사칙연산을 처리한 각 변수를  mav에 저장
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam(value="number1", 
							 required=false)int number1		//필수적 입력 처리
							 ,@RequestParam(value="number2", 
							 required=false)int number2
							 , ModelAndView mav) {
		
		int sum=0, multi=0, sub=0, division=0; //각각츼 사칙연사 결과값 초기화
		
		try {		//예외처리
			
			sum = number1+number2;
			multi = number1*number2;
			sub = number1-number2;
			division = number1/number2;
			
		} catch(Exception e) {	// 처리가 완료 될실 mav 저장
			return mav;
		}
		
		mav.addObject("sum", sum);
		mav.addObject("multi", multi);
		mav.addObject("sub", sub);
		mav.addObject("div", division);
		mav.setViewName("indexdemo");
		return mav;
	}
}
