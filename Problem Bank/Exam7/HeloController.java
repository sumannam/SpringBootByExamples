
package com.wonyong.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HeloController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		
		
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("charge")int charge,ModelAndView mav) {
		
		double total_charge=0;
		double avg_charge=0;
		double MAY_total_charge=(660 + (charge*88.5))*1.09;
		double[] array = {20040,40200,37040,67120,MAY_total_charge};
		for(int i = 0; i<array.length; i++){ 
				total_charge = total_charge + array[i];
		}
		
		
		avg_charge = (total_charge)/array.length;
		
	    mav.addObject("res","5월최종사용금액="+MAY_total_charge);
	    mav.addObject("res1","2019년 평균 사용금액="+avg_charge);
		mav.setViewName("index");

		return mav;
	}
}
