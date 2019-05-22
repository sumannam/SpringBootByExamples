package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param	odd_sum : 홀수의 합
	 *	@remark 1부터 입력한 수 중에 홀수의 합을 계산 [2019-05-16; 윤상혁]
	 */

@Controller
public class HeloController{
	
    @RequestMapping("/{num}")
    public ModelAndView index(
    						 @PathVariable int num,
    						 ModelAndView mav) {
    		int odd_sum = 0;
    		for(int i=0; i<=num; i++) {
    			if(i%2==1) {
    				odd_sum += i;
    			}
    		}
    		
            mav.addObject("msg", "1부터 n까지 홀수의 합은 : " + odd_sum);
            mav.setViewName("index");
            return mav;
    }
}


