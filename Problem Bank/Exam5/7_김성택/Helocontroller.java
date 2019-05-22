package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Helocontroller {

	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		초기 페이지 설정
	 *
	 *	@author		김성택
	 *	@date		2019-05-16
	 *
	 *	@param		mav	ModelAndView
	 *
	 *
	 * 	@remark		웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 김성택] \n
	 *				
	 *
	 */
	
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                
                return mav;
        }

		/**
		 *
		 *	@fn			public ModelAndView send(@RequestParam,ModelAndView mav)
		 *
		 *	@brief		폼에 문자열로 받아옴
		 *
		 *	@author		김성택
		 *
		 *	@date		2019-05-16
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		결과를받아와서 값을저장
		 *				값을 계산후 출력 [2019-05-16; 김성택] \n
		 *
		 */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num")String num,
        						ModelAndView mav) {
        	int j = Integer.parseInt(num);
        	int result = 0;
    		for (int i = 1; i <= j; i++) {
    			if (i % 2 == 1) { 
    				result+= i;
    			}
    		}
        	mav.addObject("result",result);
            mav.setViewName("index");
			return mav;
}
}
        