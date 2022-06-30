package com.springbook.view.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.diz.user.userVO;
import com.springbook.diz.user.impl.userDAO;
import com.springbook.view.controller.controller;

public class logincontroller implements controller{

	@Override
	public String handlerequest(HttpServletRequest request, HttpServletResponse response){
		System.out.println("로그인 처리");
		

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		userVO vo = new userVO();
		
		vo.setId(id);
		vo.setPassword(password);
		
		userDAO DAO = new userDAO();
		userVO user = DAO.getuser(vo);
		
		System.out.print(user);
		if(user !=null){
			
			System.out.println("로그인에 들어왔음");
			return "./getboardlist";
			
		}else {
			
			System.out.print("안들오옴 들어옴");
			return "old/login";
		}
	
	}
}


