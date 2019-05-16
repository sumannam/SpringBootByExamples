package com.jin.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * @brief	초기 페이지 설정
	 *
	 * @author	강석진
	 * @date 	2019-05-09
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 강석진] \n
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("bmi", "신장과 체중을 입력해주세요");
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView send(@RequestParam("tall") 	 int tall, 
							 		 @RequestParam("weight") double weight, 
							 		 ModelAndView mav)
	 *                              
	 * @brief	폼에 tall, weight에 있는 값을 받아옴
	 *
	 * @author 	강석진
	 * @date	2019-05-09
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark 	신장을 미터단위로 바꾸기 위한 tallcm 선언 및 결과값 출력을 위한 String 생성	[2019-05-09; 강석진] \n 
	 * 			bmi 계산식 계산 (소숫점 반올림을 위한 Math.round 사용) 				[2019-05-09; 강석진] \n 
	 * 			조건식을 사용하여 결과값을 result에 대입							[2019-05-09; 강석진] \n 
	 * 
	 *         
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("tall") int tall, 
							 @RequestParam("weight") double weight, ModelAndView mav) {
		
		double tallcm = tall / 100.0;
		double bmi = Math.round((weight / (tallcm*tallcm))*10)/10.0;
		
		String result = "";
		
		if (bmi <= 18.4) {
			result += "저체중";
		}
		else if (bmi >= 18.5 && bmi <= 24.9) {
			result += "정상";
		}
		else if (bmi >= 25 && bmi <= 29.9) {
			result += "과체중";
		}
		else if (bmi >= 30) {
			result += "비만";
		}
		else {
			result += "오류";
		}
		
		mav.addObject("bmi", "나의 체질량 지수(bmi) : " + bmi);
		mav.addObject("bmi2", "당신은  " + result + "입니다.");
		mav.setViewName("index");
		return mav;
	}
}