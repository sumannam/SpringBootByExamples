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
	 *	@fn			public ModelAndView send(ModelAndView mav)
	 *	@brief
	 *	@details		
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *	@param		int			원
	 *  @param		double		달라 환율
	 *	@param		ModelAndView send  @PathVariable 변수
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		환율이 처리된 값을 저장한 res 값울 mav에 저장
	 *
	 */
	
	@RequestMapping(value="/{num}")
    public ModelAndView send (@PathVariable int num, ModelAndView mav) {

            double won = 1.172;
            double res = num * won;
            
            mav.setViewName("indexdemo");
            mav.addObject("res", res);
            return mav;
    }
}
