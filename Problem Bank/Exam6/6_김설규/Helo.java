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
	 *	@param		int				총합을 위해
	 *  @param		double			평균을 위해
	 *	@param		ModelAndView send  Integer[] num 배열
	 *		
	 *	@return		indexdemo에서 처리할 값 mav에 저장
	 *  @remark		총합과 평균값을 mav에 저장
	 *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(Integer[] num,
    						 ModelAndView mav){
		int result = 0;
    	double Average = 0;
    	
    	for (int i=0 ; i<num.length ; i++) {
    		result = result + num[i];
		}
    	
    	Average = result/num.length;
    	
    	String res = String.valueOf(result);
    	String avg = String.valueOf(Average);
    	
    	mav.addObject("res",res);
    	mav.addObject("avg",avg);
    	mav.setViewName("indexdemo");
    	return mav;
    }
}
