package com.smnam.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController 
{
	@RequestMapping("/{id}")
	public ModelAndView index(@PathVariable int id,
					ModelAndView mav) {
			mav.setViewName("index");
			mav.addObject("id",id);
			mav.addObject("check",id >= 0);
			mav.addObject("trueVal","POSITIVE!");
			mav.addObject("falseVal","negative...");
			return mav;
	}
}
