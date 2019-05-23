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
	 *	@param	
	 *	@remark 초기 페이지 설정을 위함 [2019-05-16; 윤상혁]
	 */

@Controller
public class HeloController{
	 
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
    		mav.setViewName("index");
    		return mav;
    }
    
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	전기 사용 금액 계산
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param	
	 *	@remark 5월 최종 전기 사용 금액 & 2019년 평균 전기 사용금액 계산  [2019-05-16; 윤상혁]
	 */
    	@RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("pay")String pay,
        						ModelAndView mav) {
        	
        	Double pay = Double.parseInt(pay);
        	payment = pay*88.5;
        	
        	int [] Array = {20580,15720,32300,25120};
        	
        	double sum = 0;
        	
    		for (int i = 1; i < Array.length ; i++) {
    			sum += Array[i];
    		}
    		
    		sum += pay;
    		
    		double average = sum / 5;
        	mav.addObject("payment", pay);
        	mav.addObject("average", average);
            mav.setViewName("index");
			return mav;
    		
}


