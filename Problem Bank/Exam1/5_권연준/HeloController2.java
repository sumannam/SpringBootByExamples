package com.yunjun.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController2
{
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief	�ʱ� ������ ����
	 *	@details
	 *
	 *	@author	�ǿ���
	 *	@date	2019-05-09
	 
	 *	@param
	 *	@remark	�� �������� �ҷ����� ���� �ʱ������� ���� [2019-05-09; �ǿ���]
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
	        mav.setViewName("index");
	        return mav;
	}
	
	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input box���� num�� �޾� ȯ�� ���
	 *	@details
	 *
	 *	@author	�ǿ���
	 *	@date	2019-05-09
	 *
	 *	@param	
	 *	@remark ȯ�� ����� ���� res ���� [2019-05-09; �ǿ���]
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("num")String num,
							 ModelAndView mav) {
		
		int Num, result = 0;
		String res = "";
		mav.addObject("res", res);
		mav.setViewName("index");
		return mav;
	}
}