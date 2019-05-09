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
*	@date		2019-05-09
*
*	@param		mav ModelAndView [2019-05-09; 양현준]
*	@remark		index.html을 불러와 웹 페이지 초기 화면 설정	[2019-05-09; 양현준]
*
*/

@Controller
public class HeloController {
        
        @RequestMapping(value="/", method=RequestMethod.GET)
        public ModelAndView index(ModelAndView mav) {
                mav.setViewName("index");
                mav.addObject("res","값을 입력 해주세요.");
                return mav;
        }
        
        
        /**
        *
        *	@fn			public ModelAnView send (ModelAndView mav)
        *	@brief		num 값을 정수형 usd 로 받음
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-09
        *
        *	@param		mav ModelAndView [2019-05-09; 양현준]
        *	@remark 	결과를 출력하기 위한 res 선언; [2019-05-09; 양현준]			
        *				환율 계산을 위한 변수에 값을 저장 및 계산 한 값 저장 [2019-05-09; 양현준]
        */        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("num")int usd,
        						  ModelAndView mav) {

        		int krw = 1172;
        		int res = krw * usd;
        		mav.addObject("res", res);
                mav.setViewName("index");
                return mav;
        }
}

