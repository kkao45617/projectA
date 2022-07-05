package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;

public class getboardcontroller implements Controller{

	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글상세조회처리");
		
		String seq= request.getParameter("seq");
		boardVO vo=new boardVO();
		vo.setSeq(Integer.parseInt(seq));
		boardDAO DAO = new boardDAO();
		boardVO board = DAO.getboard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getboard");
		
		return mav;
	}
	
}
