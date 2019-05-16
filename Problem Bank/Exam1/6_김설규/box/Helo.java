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

@Controller
public class HeloController {
        
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("indexdemo");
                mav.addObject("res","달라(1172원가준) 환산이며 원하는 원을 입력");
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
	 *	@param		int			원
	 *  @param		double		달라 환율
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		환율이 처리된 값을 저장한 res 값울 mav에 저장
	 *
	 */
	
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num")int usd,
        						  ModelAndView mav) {

        		double krw = 1.172;
        		double res = krw * usd;
        		mav.addObject("res", res);
                mav.setViewName("indexdemo");
                return mav;
        }
}
}