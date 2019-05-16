package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","숫자를 입력해주세요.");
            return mav;           
}

    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("num1")String str1,
    						 @RequestParam("num2")String str2,
    						 ModelAndView mav) {
            int resadd = Integer.parseInt(str1) + Integer.parseInt(str2);
            int resmin = Integer.parseInt(str1) - Integer.parseInt(str2);
            int resmul = Integer.parseInt(str1) * Integer.parseInt(str2);
            int resdiv = Integer.parseInt(str1) / Integer.parseInt(str2);
            mav.addObject("msg", "두 자리 정수: " + str1 + str2 + "<br>" + str1 + " + " + str2 + " = " + resadd + "<br>" + str1 + " - " + str2 + " = " + resmin + "<br>" + str1 + " * " + str2 + " = " + resmul + "<br>" + str1 + " / " + str2 + " = " + resdiv);

            mav.setViewName("index");
            return mav;
    }
}