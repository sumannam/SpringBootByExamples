
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
	public ModelAndView send(@RequestParam("num")int num, ModelAndView mav) {
		int sum=0;
		
		for(int i=0;i<=num;i++) {
			if(i%2!=0) {
				sum = sum + i;
			}
		}
		
		mav.addObject("res", "당신이 입력한 값까지의 홀수합은 "+sum);
		mav.setViewName("index");

		return mav;
	}
}