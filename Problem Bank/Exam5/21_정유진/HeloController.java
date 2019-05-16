package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	/**
	 *	@fn		public ModelAndView index(ModelAndView mav)
	 *	@brief		�� ������ �ʱ� ������ ����
	 *	@derails
	 *
	 *	@author		������
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView	
	 *
	 * 	@remark		�� �������� �ҷ����� ���� �ʱ� ������ ���� 	[2019-05-16; ������]	
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("res","N�� ���� �Է����ּ���.");
		return mav;
	}
	
	/**
	 *	@fn		public ModelAndView send(@RequestParam("num") int num,ModelAndView mav)
	 *	@brief		1���� N���� Ȧ���� �� ���ϱ�
	 *	@derails	
	 *
	 *	@author		������
	 *	@date		2019-05-16
	 *
	 *	@param		mav ModelAndView
	 *
	 * 	@remark		Ȧ�� �� ����� ���� result ���� [2019-05-16; ������]			
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
				@RequestParam("num") int num
				,ModelAndView mav) {
		
		int result = 0;
		
		for (int i=0; i <= num; i++) {
			if(i%2==1) {
				result += i;
			}
		}
		
		mav.addObject("res","1����" + num + "������ Ȧ�� ���� " + result + "�Դϴ�.");		
		mav.setViewName("index");
		return mav;
		
	}
}