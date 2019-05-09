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
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		�ʱ������� ����
	 *
	 *	@author		���ȣ
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		�������� �����ֱ� ���� ��[2019-05-09; ���ȣ] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","������ ȯ����");
            return mav;
    }
	/**
	 *
	 *	@fn			public ModelAndView send(@RequestParam("num1")String str1,ModelAndView mav)
	 *	@brief		ȯ���� ����ϱ� ����  ���� ����
	 *
	 *	@author		���ȣ
	 *	@date		2019-05-09
	 *
	 *	@param		mav ModelAndView
	 *  @remark		ȯ����갪�� ����ϱ����� res ����[2019-05-09; ���ȣ] \n
	 *  			���� ��ȯ�� ���� Integer.paraseInt ����[2019-05-09; ���ȣ] \n
	 *
	 */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(
    						 @RequestParam("num1")String str1,
    						 ModelAndView mav) {
    						int res = 0;
    						int f = 1172;
    						res = Integer.parseInt(str1)*f;
            mav.addObject("msg",res);
            mav.setViewName("index");
            return mav;
    }
}