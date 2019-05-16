package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param	odd_sum : 홀수의 합
	 *	@remark 초기 페이지 설정을 위함 [2019-05-16; 윤상혁]
	 */

@Controller
public class HeloController{
	 
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
    		mav.setViewName("index");;
    		mav.addObject("msg", "점수를 입력하세요. ");
    		return mav;
    }
    
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	점수의 총점&평균 계산
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param	sum : 총점
	 *	@param	resavg : 평균
	 *	@remark 5개의 점수 총점&평균을 계산하기 위함 [2019-05-16; 윤상혁]
	 */
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("avg") int[] avg,
    							ModelAndView mav) {
    		int sum = 0;
    		for (int i=0; i<avg.length; i++) {
    			sum += avg[i];
    		}
    		int resavg = sum / avg.length;
    		
    		mav.addObject("res", "총점은 : " + sum);
    		mav.addObject("res1", "평균은 : " + resavg);
    		mav.setViewName("index");
    		return mav;
    }
    
}


