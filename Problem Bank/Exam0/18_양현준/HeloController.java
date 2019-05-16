package com.tuyano.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
*
*	@fn			public ModelAnView index (ModelAndView mav)
*	@brief		/초기 페이지 설정
*	@details
*
*	@author		양현준(tiskqmfls@gmail.com)
*	@date		2019-05-09
*
*	@param		mav ModelAndView [2019-05-09; 양현준]
*	@remark		index.html을 불러와 웹 페이지 화면 설정	[2019-05-09; 양현준]
*
*/

@Controller
public class HeloController {
        
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("res","입력 해주세요.");
                return mav;
        }
        
        
        /**
        *
        *	@fn			public ModelAnView send (ModelAndView mav)
        *	@brief		num1, num2 값을 str,str2 문자열로 받음
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-09
        *
        *	@param		mav ModelAndView [2019-05-09; 양현준]
        *	@remark 	결과를 출력하기 위한 res 선언; [2019-05-09; 양현준]			
        *				문자열을 정수로 변환 (Integer.parseInt) [2019-05-09; 양현준]
        */        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num1")String str,
        						 @RequestParam("num2")String str2, ModelAndView mav) 
        {
        		int res = Integer.parseInt(str) + Integer.parseInt(str2);
        		mav.addObject("res", res);
                mav.setViewName("index");
                return mav;
        }
}
