package com.kwackchaelim.springboot;

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
	public ModelAndView send(@RequestParam("student1")int stu1,
							 @RequestParam("student2")int stu2,
							 @RequestParam("student3")int stu3,
							 @RequestParam("student4")int stu4,
							 @RequestParam("student5")int stu5,
							 ModelAndView mav) {
		
		int[] array = {stu1, stu2 , stu3, stu4, stu5};
		
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		double avg = sum/ array.length;
		
		mav.addObject("res1", "학생 5명의 총합점수의 평균은 " + avg + "입니다.");
		mav.setViewName("index");
		
		return mav;
	}
}
