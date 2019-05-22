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
*	@remark		index.html 초기 페이지 화면 설정	[2019-05-09; 양현준]
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
        *	@brief		BMI 지수 계산하기
        *	@details
        *
        *	@author		양현준(tiskqmfls@gmail.com)
        *	@date		2019-05-16
        *
        *	@param		mav ModelAndView [2019-05-16; 양현준]
        *	@remark		키와 몸무게를 받아서 BMI 지수 계산	[2019-05-16; 양현준]
        *   @remark		다중 if문을 사용하여 여러가지 값 계산 [2019-05-16; 양현준]
        */
        
        @RequestMapping(value="/", method=RequestMethod.POST)
        public ModelAndView send(@RequestParam("name")String str,
        						 @RequestParam("key")double key,
        						 @RequestParam("kg")double kg
        						 								,ModelAndView mav) 
        {
        	double abmi = kg / (key * key);
        	
        	if (abmi < 18.5) {
        		mav.addObject("res", "당신의 BMI 지수는 " + abmi + "입니다.");
        		mav.addObject("res1", "당신은 저체중입니다.");
        	}
        	else if (18.5 < abmi && abmi < 24.9) {
        		mav.addObject("res", "당신의 BMI 지수는" + abmi + "입니다.");
        		mav.addObject("res1", "당신은 정상체중입니다.");
        	}
        	else if (25.0 < abmi && abmi < 29.9) {
        		mav.addObject("res", "당신의 BMI 지수는" + abmi + "입니다.");
        		mav.addObject("res1", "당신은 과체중입니다.");
        	}
        	else if (30.0 < abmi) {
        		mav.addObject("res", "당신은 BMI 지수는" + abmi + "입니다.");
        		mav.addObject("res1", "당신은 비만입니다.");
        	}
        	   mav.addObject("res", abmi);
               mav.setViewName("index");
               
               return mav;
        }
}

