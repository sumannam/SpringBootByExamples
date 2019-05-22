package com.ho.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Helocontroller {
	/**
	 *
	 * @fn public ModelAndView index(ModelAndView mav)
	 * @brief 초기페이지 설정
	 *
	 * @author 양승호
	 * @date 2019-05-16
	 *
	 * @param mav ModelAndView
	 * @remark 페이지를 보여주기 위한 것[2019-05-16; 양승호] \n
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "정수를 입력해주세요");
		return mav;
	}

	/**
	 *
	 * @fn public ModelAndView send(@RequestParam("electro")double electro,ModelAndView mav)
	 * @brief 5월 사용량을 알아보기위해 electro 선언
	 *
	 * @author 양승호
	 * @date 2019-05-16
	 *
	 * @param mav ModelAndView
	 * @remark 	전체요금을 계산하기 위해 full선언,[2019-05-16; 양승호] \n
	 * 			세금을 계산하기 위해 tax선언,[2019-05-16; 양승호] \n
	 *			최종 사용 요금을을 계산하기 위해 total선언,[2019-05-16; 양승호] \n
	 *			올해 평균 사용 요금을 구하기 위해 array배열선언,[2019-05-16; 양승호] \n
	 *			합계 및 평균계산을위해 sum 과 avg 선언,[2019-05-16; 양승호] \n
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("electro")double electro,
			ModelAndView mav) {
		
		double 	full = 660+(electro*88.5);
		double 	tax = full*0.09;
		double	total = full+tax;
		double[] array = {20580,15720,32300,25120,total};
		int   sum=0;
		
		for(int i =0; i<array.length;i++) {
			sum += array[i];
		}
		double avg = sum/array.length;
		

		
		mav.addObject("res","5월 최종 사용 금액 : "+total+"원 입니다.");
		mav.addObject("res1","2019년 평균 사용 금액은 : "+avg+"원 입니다.");
		mav.setViewName("index");
		return mav;
	}
}