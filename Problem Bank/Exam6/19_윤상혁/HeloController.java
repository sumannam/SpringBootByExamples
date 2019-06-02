package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 �이지 �정
	 *	@details
	 *	
	 *	@author �상
	 *	@date	2019-05-16
	 *
	 *	@param	odd_sum : ��의 
	 *	@remark 초기 �이지 �정�함 [2019-05-16; �상
	 */

@Controller
public class HeloController{
	 
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
    		mav.setViewName("index");;
    		mav.addObject("msg", "�수륅력�세 ");
    		return mav;
    }
    
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	�수총점&�균 계산
	 *	@details
	 *	
	 *	@author �상
	 *	@date	2019-05-16
	 *
	 *	@param	sum : 총점
	 *	@param	resavg : �균
	 *	@remark 5개의 �수 총점&�균계산�기 �함 [2019-05-16; �상
	 */
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("avg") int[] avg,
    							ModelAndView mav) {
    		int sum = 0;
    		for (int i=0; i<avg.length; i++) {
    			sum += avg[i];
    		}
    		int resavg = sum / avg.length;
    		
    		mav.addObject("res", "총점� : " + sum);
    		mav.addObject("res1", "�균� : " + resavg);
    		mav.setViewName("index");
    		return mav;
    }
    
}


