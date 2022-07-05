package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;


public class deleteboardconteroller implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 삭제 처리");
		
		String seq=request.getParameter("seq");
		boardVO vo = new boardVO();
		vo.setSeq(Integer.parseInt(seq));
		boardDAO DAO= new boardDAO();
		DAO.deleteboard(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getboardlist.do");
		return mav;
	}
	
}
