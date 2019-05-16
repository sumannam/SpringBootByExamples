package exam1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {
	
	/**
	 *
	 *	@fn			public ModelAndView index(ModelAndView mav)
	 *	@brief		초기 페이지 설정
	 *
	 *	@author		박종민
	 *	@date		2019-05-09
	 *
	 *	@param		mav	ModelAndView
	 *
	 *
	 * 	@remark		웹 페이지를 불러오기 위한 초기페이지 설정[2019-05-09; 박종민] \n
	 *				
	 *
	 */
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
            mav.setViewName("index");
            mav.addObject("msg","달러를 입력하세요");
            return mav;
    }
    
    /**
	 *
	 *	@fn			public ModelAndView send(@RequestParam int num, ModelAndView mav)
	 *	@brief		초기 페이지 설정
	 *
	 *	@author		박종민
	 *	@date		2019-05-09
	 *
	 *	@param		mav	ModelAndView
	 *
	 *
	 * 	@remark		달러환율을 구하기 위해 result값을 받는다 [2019-05-09; 박종민] \n
	 *				
	 *
	 */
    
 
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView send(@RequestParam int num
    						 , ModelAndView mav)
    {
    	int result = num*1172;
        mav.addObject("msg","result = " + result);
        mav.setViewName("index");
        return mav;
    }

}
