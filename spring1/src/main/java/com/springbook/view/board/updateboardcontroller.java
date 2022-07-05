package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;


public class updateboardcontroller implements Controller{


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("글 수정 처리");
		
		
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String seq = request.getParameter("seq");
		System.out.print(seq);
		
		
		boardDAO DAO = new boardDAO();
		boardVO vo = new boardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		DAO.updateboard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getboardlist.do");
		return mav;
	}

}
