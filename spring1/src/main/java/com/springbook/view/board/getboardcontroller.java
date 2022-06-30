package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;
import com.springbook.view.controller.controller;

public class getboardcontroller implements controller{

	@Override
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글상세 조회 처리");
		
		String seq= request.getParameter("seq");
		boardVO vo=new boardVO();
		vo.setSeq(Integer.parseInt(seq));
		boardDAO DAO = new boardDAO();
		boardVO board = DAO.getboard(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		
		return "getboard";
	}
	
}
