package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class Helo
{
	
	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		珥덇린�럹�씠吏� �꽕�젙
	 *	@details	
	 *
	 *	@author		源��꽕洹�
	 *	@date		2019-05-16
	 *
	 *			
	 *		
	 *	@return		indexdemo�뿉�꽌 泥섎━�븷 媛� mav�뿉 ���옣
	 *  @remark		result 媛� �엯�젰 諛쏄퀬 異쒕젰
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("indexdemo");
		mav.addObject("result");
		return mav;
	}
	
	
	/**
	 *
	 *	@fn			public ModelAndView send(ModelAndView mav)
	 *	@brief
	 *	@details		
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *	@param		int				num year total 나이와 년도 그리고 나이와 년도를 처리한 결과
	 *  @param		String			년도
	 *	@param		ModelAndView send  @RequestParam 변수
	 *		
	 *	@return		받은 나이와 가져온 년도 를 빼기 하여 태어난 생에 년도 mav 저장
	 *  @remark		total = num - year;
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
		@RequestParam(value="num1"
					  , required=false)int num1 //필수선언과 num1
					  , ModelAndView mav) 
	{
		SimpleDateFormat format = new SimpleDateFormat ("yyyy");
		Date time = new Date();
		
		String time1 = format.format(time);
		
		int num		= Integer.parseInt(time1); //정수 변환
		int year	= num1;
		int total	= 0;
		
		total = num - year;
		
		mav.addObject("result", total);
		mav.setViewName("indexdemo");
		return mav;
	}
}
