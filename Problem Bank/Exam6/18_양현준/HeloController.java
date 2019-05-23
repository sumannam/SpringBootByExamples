package com.tuyano.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
*
*	@fn			public ModelAnView index (ModelAndView mav)
*	@brief		웹 페이지 초기 화면 설정
*	@details
*
*	@author		양현준(tiskqmfls@gmail.com)
*	@date		2019-05-16
*
*	@param		mav ModelAndView [2019-05-16; 양현준]
*	@remark		index.html 초기 페이지 화면 설정	[2019-05-16; 양현준]
*
*/

@Controller
public class HeloController {
        
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
        	
                mav.setViewName("index");
                mav.addObject("res");
                
                return mav;
        }
        
        /**
        *
        *	@fn			public ModelAnView index (ModelAndView mav)
        *	@brief		5명의 총점 / 평균 구하기
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-16
        *
        *	@param		mav ModelAndView [2019-05-16; 양현준]
        *	@remark		배열을 저장하기위해 num 을 int[] num 으로 받아주었음	[2019-05-16; 양현준]
        *   
        */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num")int[] num,	ModelAndView mav) 
        {
        	int sum = 0;
        	int avg = 0;
        	
        	for (int i = 0; i <num.length; i++) {
        		sum += num.length;
        	}
        	
			avg = sum / num.length;
				
		    mav.addObject("total", "총점은 " + sum);
		    mav.addObject("average", "평균은 " + avg);
		    mav.setViewName("index");
		   
		    return mav;
        }
}

