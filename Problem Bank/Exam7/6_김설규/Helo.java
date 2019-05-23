package com.example.demo;



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
	 *	@brief		초기페이지 설정
	 *	@details	
	 *
	 *	@author		김설규
	 *	@date		2019-05-16
	 *
	 *			
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		mav.setViewName("indexdemo");
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("indexdemo");
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
	 *	@param		int				기본요금
	 *  @param		double			최종금액,세금,5월금액,평균,kw 금액		
	 *		
	 *	@return		5월 금액계산 
	 *				세금 계산
	 *				12달치 최종 금액 평균액 - 세금
	 *  @remark		Maymonth 5월 최종 금액
	 *  			tax 세금
	 *				Average 배열에 11달 금액과 5월 금액 합산 tax 세금
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("number")int number,
		   ModelAndView mav) {

	int month [] = {21300,
	                11300,
	                35600,
	                74000,
	                11300,
	                35600,
	                74000,
	                11300,
	                35600,
	                74000,
	                54000};

int Default = 660;
double result = 0;
double kw = 88.5;
double Average = 0;
double Maymonth =0;
double tax = 0;

Maymonth += (number*kw)+Default;

for(int i=0 ; i<month.length ; i++) {
	result += month[i];
}
tax = (result+Maymonth)*0.09;
Average = (result+Maymonth/month.length+1)-tax;


String Maymonthsting = String.valueOf(Maymonth);
String Averagesting = String.valueOf(Average);

mav.addObject("Maymonthsting",Maymonthsting);
mav.addObject("Averagesting",Averagesting);
mav.setViewName("indexdemo");
return mav;
	}
}
