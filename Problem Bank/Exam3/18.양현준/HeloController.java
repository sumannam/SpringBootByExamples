package com.tuyano.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
*
*	@fn			public ModelAnView index (ModelAndView mav)
*	@brief		초기 화면 페이지 설정
*	@details
*
*	@author		양현준(tiskqmfls@gmail.com)
*	@date		2019-05-14
*
*	@param		mav ModelAndView [2019-05-014; 양현준]
*	@remark		index.html을 불러와 웹 페이지 초기 화면 설정	[2019-05-14; 양현준]
*
*/

@Controller
public class HeloController {
        
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("res","연도를 입력 해주세요.");
                return mav;
        }
           
        /**
        *
        *	@fn			public ModelAnView index (ModelAndView mav)
        *	@brief		생년월일로 나이를 계산하기 위한 변수 선언
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-14
        *
        *	@param		mav ModelAndView [2019-05-14; 양현준]
        *	@remark		나이를 계산하기 위해 현재 년도 변수 대입	[2019-05-14; 양현준]
        *				
        */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("year")int birthday, ModelAndView mav) 
        {
        		int year = 2019;
        	
        	
        		mav.addObject("res", (year-birthday+1));
                mav.setViewName("index");
                
                return mav;
        }
}

