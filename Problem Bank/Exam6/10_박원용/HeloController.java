
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
	public ModelAndView send(@RequestParam("num1")int num1,
			                 @RequestParam("num2")int num2,	
							 @RequestParam("num3")int num3,
							 @RequestParam("num4")int num4,
							 @RequestParam("num5")int num5,ModelAndView mav) {
		int sum=0;
		double avg=0;
		
		int[] array = {num1,num2,num3,num4,num5};
		
		for(int i = 0; i< array.length; i++){ 
			 sum = sum + array[i];
		}
		avg = sum/(double)5;
		
		mav.addObject("res", "당신이 입력한 값까지의 홀수합은 "+sum+"이고"+"평균은"+avg+"입니다");
		mav.setViewName("index");

		return mav;
	}
}