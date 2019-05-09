package com.ho.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helocontroller1 {
	/**
	 *
	 *	@fn			public String index(@PathVariable int num) {int res = 0; int f = 1172;
	 *	@brief		더하기 위한 값 변수 선언
	 *
	 *	@author		양승호
	 *	@date		2019-05-09
	 *
	 *	@param		RequestMapping
	 *  @remark		환율을 계산하기위한 res 선언[2019-05-09; 양승호] \n
	 *  			환율계산한것을 보여주기 위한 return 선언[2019-05-09; 양승호] \n
	 *
	 */
@RequestMapping("/{num}")
        public String index(@PathVariable int num) {
                int res = 0;
                int f = 1172;
                res = f*num;
                return "환율은: " + res;
        }
}