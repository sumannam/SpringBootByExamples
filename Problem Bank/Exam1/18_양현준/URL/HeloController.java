package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	/**
	*
	*	@fn			@RequestMapping ("/")
	*	@brief		URL을 이용한 계산
	*	@details
	*
	*	@author		양현준(tiskqmfls@gmail.com)
	*	@date		2019-05-09
	*
	*	@param		mav ModelAndView [2019-05-09; 양현준]
	*	@remark		URL에 값을 입력하여 계산하여 index에 출력	[2019-05-09; 양현준]
	*
	*/
@RequestMapping(value="/{num}")
        public ModelAndView send (@PathVariable int num, ModelAndView mav) {

                int won = 1172;
                int res = num * won;
                
                mav.setViewName("index");
                mav.addObject("res", res);
                return mav;
        }
}
