package com.smnam.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeloController 
{
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
			mav.setViewName("index");
			ArrayList<String[]> data = new ArrayList<String[]>();
			data.add(new String[]{"park","park@yamada","090-999-999"});
			data.add(new String[]{"lee","lee@flower","080-888-888"});
			data.add(new String[]{"choi","choi@happy","080-888-888"});
			mav.addObject("data",data);
			return mav;
	}
}
