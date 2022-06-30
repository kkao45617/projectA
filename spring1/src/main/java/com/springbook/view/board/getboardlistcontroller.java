package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.boardVO;
import com.springbook.diz.board.impl.boardDAO;
import com.springbook.view.controller.controller;

public class getboardlistcontroller implements controller{

	@Override
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		boardVO vo = new boardVO();
		boardDAO dao = new boardDAO();
		List<boardVO> boardlist = dao.getboardlist(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardlist", boardlist);
		
		
		return "old/getboardlist";
	}
	
}
