package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;
import com.springbook.view.controller.controller;

public class updateboardcontroller implements controller{

	@Override
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글수정 처리");
		
		
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
		
		return "getboardlist";
	}

}
