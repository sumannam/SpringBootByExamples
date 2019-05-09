package com.yunjun.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HeloController {
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
        mav.addObject("res","�����Է�");
		return mav;
	}

	/**
	 * 	@fn	public ModelAndView send
	 *	@brief	input box���� num1, num2�� �޾� ����/����/����/������ ���
	 *	@details
	 *
	 *	@author	�ǿ���
	 *	@date	2019-05-09
	 *
	 *	@param	resPlus = ����
	 *  @param	resMinus = ����
	 *  @param	resMultiply = ������
	 *  @param	resDivision = ����
	 *	@remark 4Ģ���� ����� ���� res1~res4 ���� [2019-05-09; �ǿ���]
	 */
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1",required=false)String str1,
		@RequestParam(value="num2",required=false)String str2,
		ModelAndView mav) {
		
		int resPlus = 0;
		int resMinus = 0;
		int resMultiply = 0;
		int resDivision = 0;
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		resPlus = num1 + num2;
		resMinus = num1 - num2;
		resMultiply = num1 * num2;
		resDivision = num1/num2;
		
		String resPlus1 = String.valueOf(resPlus);
		String resMinus1 = String.valueOf(resMinus );
		String resMultiply1 = String.valueOf(resMultiply);
		String resDivision1 = String.valueOf(resDivision);
		
		mav.addObject("res1",num1 + "+" + num2 + "=" + resPlus1);
		mav.addObject("res2",num1 + "+" + num2 + "=" + resPlus1);
		mav.addObject("res3",num1 + "-" + num2 + "=" + resMinus1);
		mav.addObject("res4",num1 + "*" + num2 + "=" + resMultiply1);
		mav.addObject("res5",num1 + "/" + num2 + "=" + resDivision1); 
		mav.setViewName("index");
		
		return mav;
	}
}
