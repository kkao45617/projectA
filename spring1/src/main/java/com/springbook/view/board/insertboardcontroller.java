package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;
import com.springbook.view.controller.controller;

public class insertboardcontroller implements controller{

	@Override
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글등록 처리");
		

		String title=  request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		boardDAO DAO = new boardDAO();
		boardVO vo = new boardVO();
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		DAO.insertboard(vo);
		return "getboardlist";
	}

}
