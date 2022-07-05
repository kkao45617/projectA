package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;

public class getboardlistcontroller implements Controller{

	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글목록 검색 처리");
		
		boardVO vo = new boardVO();
		boardDAO dao = new boardDAO();
		List<boardVO> boardlist = dao.getboardlist(vo);
		
		
		//HttpSession session = request.getSession();
		//session.setAttribute("boardlist", boardlist);
		//return "old/getboardlist";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardlist",boardlist);
		mav.setViewName("getboardlist");
		
		return mav;
	}
	
}
