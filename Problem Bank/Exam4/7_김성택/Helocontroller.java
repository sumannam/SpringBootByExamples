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
                mav.addObject("msg","bmi 계산기");
                
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
		 *	@date		2019-05-016
		 *
		 *	@param		mav	ModelAndView
		 *
		 *
		 * 	@remark		결과를받아와서 값을저장
		 *				값을 계산후 출력 [2019-05-09; 김성택] \n
		 *
		 */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("height")String height,
        						@RequestParam("weight")String weight,
        						ModelAndView mav) {
        	
        	Double dheight = Double.parseDouble(height);
        	Double dweight = Double.parseDouble(weight);
        	
        	Double eresult = dweight/(dheight*dheight);
        	
        	String result = "";
        	String low = "저체중";	
        	String usually = "정상";
        	String over = "과체중";
        	String veryover = "비만";
        	if(eresult<=18.5) {
        		
        		result+=low; 
        		
        	}else if(eresult>18.5&&eresult<=18.5) {
        		
        		result+=usually;
        		
        	}else if(eresult>25.0&&eresult<=29.9) {
        		
        		result+=over;
        		
        	}else if(eresult<=30.0) {
        		
        		result+=veryover;
        	}
        	mav.addObject("res",result);
            mav.setViewName("index");
			return mav;
}
}