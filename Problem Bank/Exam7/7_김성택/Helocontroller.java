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
        public ModelAndView send(@RequestParam("fee")String fee,
        						ModelAndView mav) {
        	
        	Double dfee = Double.parseDouble(fee);
        	dfee = dfee*88.5;
        	
        	int [] intArray = {20580,15720,32300,25120};
        	
        	double sum = 0;
        	
    		for (int i = 1; i < intArray.length ; i++) {

    			sum+=intArray[i];

    		}
    		
    		sum+=dfee;
    		double average = sum/5;
        	mav.addObject("dfee",dfee);
        	mav.addObject("average",average);
            mav.setViewName("index");
			return mav;
}
}
        