package com.tuyano.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
        
	/**
	*
	*	@fn			public ModelAnView index (ModelAndView mav)
	*	@brief		초기 화면 페이지 설정
	*	@details
	*
	*	@author		양현준(tiskqmfls@gmail.com)
	*	@date		2019-05-09
	*
	*	@param		mav ModelAndView [2019-05-09; 양현준]
	*	@remark		index.html을 불러와 웹 페이지 화면 설정	[2019-05-09; 양현준]
	*
	*/
	
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("res","값을 입력 해주세요.");
                return mav;
        }
       
        /**
        *
        *	@fn			public ModelAnView send (ModelAndView mav)
        *	@brief		num1과 num2를 number, number2으로 정수형으로 받음
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-09
        *
        *	@param		mav ModelAndView [2019-05-09; 양현준]
        *	@remark 	사칙연산 각 결과를 출력하기 위한 res 4개 선언 [2019-05-09; 양현준]			
        *				
        */    
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num1")int number,
        						 @RequestParam("num2")int number2, ModelAndView mav) 
        {
        		int res  = number + number2;
        		int res1 = number - number2;
        		int res2 = number * number2;
        		int res3 = number / number2;
        	
        		mav.addObject("res",  number + "+" + number2 + " =" + res);
        		mav.addObject("res1", number + "-" + number2 + " =" + res1);
        		mav.addObject("res2", number + "*" + number2 + " =" + res2);
        		mav.addObject("res3", number + "/" + number2 + " =" + res3);
        		
                mav.setViewName("index");
                
                return mav;
        }
}

