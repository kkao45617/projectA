package com.springbook.biz.board;

import java.util.List;

public interface boardservice {
	void insertboard(boardVO vo);
	void updateboard(boardVO vo);
	void deleteboard(boardVO vo);
	boardVO getboard(boardVO vo);
	List<boardVO> getboardlist(boardVO vo);
}
