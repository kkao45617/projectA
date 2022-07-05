package com.springbook.view.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.diz.user.userVO;
import com.springbook.diz.user.impl.userDAO;


public class logincontroller implements Controller{

	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		userVO vo = new userVO();
		vo.setId(id);
		vo.setPassword(password);
		
		userDAO DAO = new userDAO();
		userVO user = DAO.getuser(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			mav.setViewName("redirect:getboardlist.do");
			//mav.setViewName("getboardlist.do");
		}else {
			mav.setViewName("redirect:login.jsp");
		}
		
		return mav;
	}
}


