package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	μ΄κΈ° μ΄μ§ €μ 
	 *	@details
	 *	
	 *	@author €μ
	 *	@date	2019-05-16
	 *
	 *	@param	odd_sum : μ 
	 *	@remark μ΄κΈ° μ΄μ§ €μ ν¨ [2019-05-16; €μ
	 */

@Controller
public class HeloController{
	 
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
    		mav.setViewName("index");;
    		mav.addObject("msg", "μλ₯λ ₯μΈ ");
    		return mav;
    }
    
	/**
	 * 	@fn		public ModelAndView send
	 *	@brief	μμ΄μ &κ·  κ³μ°
	 *	@details
	 *	
	 *	@author €μ
	 *	@date	2019-05-16
	 *
	 *	@param	sum : μ΄μ 
	 *	@param	resavg : κ· 
	 *	@remark 5κ°μ μ μ΄μ &κ· κ³μ°κΈ° ν¨ [2019-05-16; €μ
	 */
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam("avg") int[] avg,
    							ModelAndView mav) {
    		int sum = 0;
    		for (int i=0; i<avg.length; i++) {
    			sum += avg[i];
    		}
    		int resavg = sum / avg.length;
    		
    		mav.addObject("res", "μ΄μ  : " + sum);
    		mav.addObject("res1", "κ·  : " + resavg);
    		mav.setViewName("index");
    		return mav;
    }
    
}


