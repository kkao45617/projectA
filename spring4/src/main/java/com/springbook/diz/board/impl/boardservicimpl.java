package com.springbook.diz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springbook.diz.board.boardVO;
import com.springbook.diz.board.boardservice;
import com.springbook.diz.common.log4jadvice;
import com.springbook.diz.common.logadvice;

@Service("boardservice")
public class boardservicimpl implements boardservice {
	
	@Autowired
	private boardDAO boardDAO;
	//private boardDAOspring boardDAO;
	
	
	
	@Override
	public void insertboard(boardVO vo) {
	/*	if(vo.getSeq()==0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.\n");
		}*/
		boardDAO.insertboard(vo);
	}

	@Override
	public void updateboard(boardVO vo) {

		boardDAO.updateboard(vo);
	}

	@Override
	public void deleteboard(boardVO vo) {

		boardDAO.deleteboard(vo);
	}

	@Override
	public boardVO getboard(boardVO vo) {

		return boardDAO.getboard(vo);
	}

	@Override
	public List<boardVO> getboardlist(boardVO vo) {

		return boardDAO.getboardlist(vo);
	}

}
