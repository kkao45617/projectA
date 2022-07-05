package com.springbook.view.user;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.diz.user.userVO;
import com.springbook.diz.user.impl.userDAO;

@Controller
public class logincontroller{

	
	@RequestMapping(value =  "/login.do", method=RequestMethod.POST)
	public String login(userVO vo, userDAO DAO, HttpSession sessoin){
		System.out.println("濡쒓렇�씤 泥섎━");
		userVO user = DAO.getuser(vo);
		if(DAO.getuser(vo)!=null) {
			sessoin.setAttribute("username",user.getName());
			return "getlistboard.do";
		}
		else return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do" , method = RequestMethod.GET)
	public String login(@ModelAttribute("user") userVO vo){
		System.out.println("로그인 화면 이동");
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
	}
}


