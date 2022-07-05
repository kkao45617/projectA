package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;

public class insertboardcontroller implements Controller{



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 등록 처리");
		

		String title=  request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		boardDAO DAO = new boardDAO();
		boardVO vo = new boardVO();
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		DAO.insertboard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getboardlist.do");
		return mav;
	}

}
