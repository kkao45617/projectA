package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.springbook.view")
public class commonexceptionhandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handlearithmeticexception(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/arithmeticerror.jsp");
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlenullpointerexception(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/nullpointererror.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleexception(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
	
}
