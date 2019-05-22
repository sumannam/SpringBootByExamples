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
        *	@brief		1부터 N까지 홀수의 합계 구하기
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-16
        *
        *	@param		mav ModelAndView [2019-05-16; 양현준]
        *	@remark		for문으로 시작을 하여 if 조건문에서 나머지가 1이되는 수를 더함	[2019-05-16; 양현준]
        *   @remark		N까지의 모든 홀수를 저장시키고 결과 출력 [2019-05-16; 양현준]
        */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("odd")int num,	ModelAndView mav) 
        {
        	int result = 0;
        
        	
        	for (int i = 0; i<num; i++) {
        		if (i % 2 == 1) {
        			result += i;
        		}
        	}
        		
        	   mav.addObject("res", "1부터 N까지의 합은 " + result);
               mav.setViewName("index");
               
               return mav;
        }
}

