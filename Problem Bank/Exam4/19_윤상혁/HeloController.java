package com.sanghyuk.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	초기 페이지 설정
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param
	 *	@remark 웹 페이지를 불러오기 위한 초기 페이지 설정 [2019-05-16; 윤상혁]
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            return mav;           
}
    /**
	 * 	@fn		public ModelAndView send
	 *	@brief	input box에서 name, weight, height를 받아 num1,2,3으로 지정 및 BMI지수 계산
	 *	@details
	 *	
	 *	@author 윤상혁
	 *	@date	2019-05-16
	 *
	 *	@param	resBMI = BMI지수(체중/(키*키))
	 *	@param	resCON = 상태(저체중 or 정상 or 과체중 or 비만)
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("name")String num1,
    						 @RequestParam("weight")String num2,
    						 @RequestParam("height")String num3,
    						 ModelAndView mav) {
            int resBMI = Integer.parseInt(num2) / (Integer.parseInt(num3) * Integer.parseInt(num3) / 10000);
            String resCON = "";
            if (resBMI <= 18.5) {
            	resCON += "저체중";
            } else if (18.5 < resBMI && resBMI <= 24.9) {
            	resCON += "정상";
            } else if (24.9 < resBMI && resBMI <= 29.9) {
            	resCON += "과체중";
            } else if (29.9 < resBMI) {
            	resCON += "비만";
            }
            
            mav.addObject("msg", num1 + "님의 결과 " + "<br>" + "BMI : " + resBMI + "상태 : " + resCON);
            mav.setViewName("index");
            return mav;
    }
}


