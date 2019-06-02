package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	ì´ˆê¸° ˜ì´ì§€ ¤ì •
	 *	@details
	 *	
	 *	@author ¤ìƒ
	 *	@date	2019-05-16
	 *
	 *	@param	odd_sum : €˜ì˜ 
	 *	@remark ì´ˆê¸° ˜ì´ì§€ ¤ì •„í•¨ [2019-05-16; ¤ìƒ
	 */

@Controller
public class HeloController{
	 
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
    		mav.setViewName("index");;
    		mav.addObject("msg", "ìˆ˜ë¥…ë ¥˜ì„¸ ");
    		return mav;
    }
    
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	ìˆ˜ì´ì &‰ê·  ê³„ì‚°
	 *	@details
	 *	
	 *	@author ¤ìƒ
	 *	@date	2019-05-16
	 *
	 *	@param	sum : ì´ì 
	 *	@param	resavg : ‰ê· 
	 *	@remark 5ê°œì˜ ìˆ˜ ì´ì &‰ê· ê³„ì‚°˜ê¸° „í•¨ [2019-05-16; ¤ìƒ
	 */
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("avg") int[] avg,
    							ModelAndView mav) {
    		int sum = 0;
    		for (int i=0; i<avg.length; i++) {
    			sum += avg[i];
    		}
    		int resavg = sum / avg.length;
    		
    		mav.addObject("res", "ì´ì € : " + sum);
    		mav.addObject("res1", "‰ê· € : " + resavg);
    		mav.setViewName("index");
    		return mav;
    }
    
}


